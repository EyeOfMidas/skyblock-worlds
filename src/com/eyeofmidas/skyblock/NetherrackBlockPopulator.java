package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;

public class NetherrackBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {

		if (chunk.getX() == 0 && chunk.getZ() == 0) {
			for (int x = 6; x < 12; x++) {
				for (int z = 6; z < 12; z++) {
					for (int y = 64; y < 66; y++) {
						chunk.getBlock(x, y, z).setType(Material.NETHERRACK);
					}
					chunk.getBlock(x, 66, z).setType(Material.SOUL_SAND);
				}
			}
			Block chestBlock = chunk.getBlock(8, 67, 8);
			chestBlock.setType(Material.CHEST);
			BlockState possibleChest = chestBlock.getState();
			if (possibleChest.getType().equals(Material.CHEST)) {
				Chest chest = (Chest) possibleChest;
				ChestPacker.addItem(chest, Material.SAPLING, 1, 2);
				ChestPacker.addItem(chest, Material.SUGAR_CANE, 1);
				ChestPacker.addItem(chest, Material.ICE, 1);
			}
			return;
		}

		boolean canSpawn = random.nextFloat() < 0.9f;
		int height = (int) (world.getMaxHeight() * random.nextFloat());
		if (canSpawn) {
			for (int x = 6; x < 10; x++) {
				for (int z = 6; z < 10; z++) {
					for (int y = height; y < height + 2; y++) {
						chunk.getBlock(x, y, z).setType(Material.NETHERRACK);
					}
					chunk.getBlock(x, height + 2, z).setType(Material.SOUL_SAND);
				}
			}
			Block chestBlock = chunk.getBlock(8, height + 3, 8);
			chestBlock.setType(Material.CHEST);
			BlockState possibleChest = chestBlock.getState();
			if (possibleChest.getType().equals(Material.CHEST)) {
				Chest chest = (Chest) possibleChest;
				ChestPacker.addItem(chest, Material.SAPLING, 1, 2);
				ChestPacker.addItem(chest, Material.SUGAR_CANE, 1);
				ChestPacker.addItem(chest, Material.ICE, 1);
			}
		}
	}

}
