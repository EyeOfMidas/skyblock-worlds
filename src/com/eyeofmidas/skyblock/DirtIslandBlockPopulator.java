package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;

public class DirtIslandBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		if (chunk.getX() == 0 && chunk.getZ() == 0) {
			this.createIsland(chunk, 64);
			chunk.getBlock(8, 64, 8).setType(Material.BEDROCK);
			return;
		}

		boolean canSpawn = random.nextFloat() < 0.1f;
		float quarterHeight = world.getMaxHeight() / 4;
		int height = (int) ((quarterHeight * 2) * random.nextFloat() + quarterHeight);
		if (canSpawn) {
			this.createIsland(chunk, height);
		}
	}

	private void createIsland(Chunk chunk, int height) {
		for (int x = 6; x < 11; x++) {
			for (int z = 6; z < 11; z++) {
				for (int y = height; y < height + 2; y++) {
					chunk.getBlock(x, y, z).setType(Material.DIRT);
				}
				chunk.getBlock(x, height + 2, z).setType(Material.GRASS);
			}
		}
		Block chestBlock = chunk.getBlock(8, height + 3, 8);
		chestBlock.setType(Material.CHEST);
		BlockState possibleChest = chestBlock.getState();
		if (possibleChest.getType().equals(Material.CHEST)) {
			Chest chest = (Chest) possibleChest;
			ChestPacker.addItem(chest, Material.ICE, 1);
			ChestPacker.addItem(chest, Material.LAVA_BUCKET, 1);
		}
	}

}
