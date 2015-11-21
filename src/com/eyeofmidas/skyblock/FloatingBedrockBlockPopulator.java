package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class FloatingBedrockBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		if (chunk.getX() == 0 && chunk.getZ() == 0) {
			chunk.getBlock(8, 64, 8).setType(Material.BEDROCK);
			return;
		}

		boolean canSpawn = random.nextFloat() < 0.1f;
		int height = (int) (world.getMaxHeight() * random.nextFloat());
		if (canSpawn) {
			chunk.getBlock(8, height, 8).setType(Material.BEDROCK);
		}
	}
}
