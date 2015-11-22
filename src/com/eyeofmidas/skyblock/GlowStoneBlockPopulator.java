package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class GlowStoneBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		boolean canSpawn = random.nextFloat() < 0.4f && (chunk.getX() != 0 && chunk.getZ() != 0);
		int height = (int) (world.getMaxHeight() * random.nextFloat());
		if (canSpawn) {
			for (int x = 6; x < 11; x++) {
				for (int z = 6; z < 11; z++) {
					for (int y = height; y < height + 3; y++) {
						chunk.getBlock(x, y, z).setType(Material.GLOWSTONE);
					}
				}
			}
		}

	}

}
