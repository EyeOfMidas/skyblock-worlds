package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class SandIslandBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		boolean canSpawn = random.nextFloat() < 0.08f;
		int height = (int) (world.getMaxHeight() * random.nextFloat());
		if (canSpawn) {
			for (int x = 6; x < 10; x++) {
				for (int z = 6; z < 10; z++) {
					for (int y = height + 1; y < height + 3; y++) {
						chunk.getBlock(x, y, z).setType(Material.SAND);
					}
					chunk.getBlock(x, height, z).setType(Material.SANDSTONE);
				}
			}
		}
	}

}
