package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class OreBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		boolean canSpawn = random.nextFloat() < 0.2f;
		float quarterHeight = world.getMaxHeight() / 4;
		int height = (int) (quarterHeight * random.nextFloat());
		if (canSpawn) {
			Material oreMaterial;
			if (random.nextInt(10) == 0) {
				oreMaterial = Material.DIAMOND_ORE;
				height = random.nextInt(15);
			} else if (random.nextInt(10) < 3) {
				oreMaterial = Material.IRON_ORE;
			} else if (random.nextInt(10) < 5) {
				oreMaterial = Material.REDSTONE_ORE;
			} else {
				oreMaterial = Material.STONE;
			}
			this.createIsland(chunk, height, oreMaterial);
		}

	}

	private void createIsland(Chunk chunk, int height, Material material) {
		for (int x = 6; x < 11; x++) {
			for (int z = 6; z < 11; z++) {
				for (int y = height; y < height + 3; y++) {
					chunk.getBlock(x, y, z).setType(Material.STONE);
				}
			}
		}
		for (int x = 7; x < 10; x++) {
			for (int z = 7; z < 10; z++) {
				for (int y = height; y < height + 2; y++) {
					chunk.getBlock(x, y, z).setType(material);
				}
			}
		}

	}

}
