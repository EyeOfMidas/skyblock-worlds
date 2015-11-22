package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;

public class SandIslandBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		if (chunk.getX() == 2 && chunk.getZ() == 0) {
			this.createIsland(chunk, 64);
			return;
		}

		int centerX = (chunk.getX() << 4) + 8;
		int centerZ = (chunk.getZ() << 4) + 8;
		boolean isOccupied = world.getHighestBlockYAt(centerX, centerZ) > 0;
		boolean canSpawn = random.nextFloat() < 0.08f && !isOccupied;
		float quarterHeight = world.getMaxHeight() / 4;
		int height = (int) ((quarterHeight * 2) * random.nextFloat() + quarterHeight);
		if (canSpawn) {
			this.createIsland(chunk, height);
		}
	}

	private void createIsland(Chunk chunk, int height) {
		for (int x = 6; x < 11; x++) {
			for (int z = 6; z < 11; z++) {
				for (int y = height + 1; y < height + 3; y++) {
					chunk.getBlock(x, y, z).setType(Material.SAND);
				}
				chunk.getBlock(x, height, z).setType(Material.SANDSTONE);
			}
		}
		Block chestBlock = chunk.getBlock(8, height + 3, 8);
		chestBlock.setType(Material.CHEST);
		BlockState possibleChest = chestBlock.getState();
		if (possibleChest.getType().equals(Material.CHEST)) {
			Chest chest = (Chest) possibleChest;
			ChestPacker.addItem(chest, Material.OBSIDIAN, 10);
			ChestPacker.addItem(chest, Material.MELON, 1);
			ChestPacker.addItem(chest, Material.PUMPKIN_SEEDS, 1);
		}
	}

}
