package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

/**
 * BlockPopulator that adds trees based on the biome.
 * 
 * @author heldplayer
 */
public class TreePopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int chunkX = chunk.getX() << 4;
		int chunkZ = chunk.getZ() << 4;
		// int randomX = random.nextInt(16);
		// int randomZ = random.nextInt(16);
		int randomX = 6;
		int randomZ = 6;
		int y = world.getHighestBlockYAt(chunkX + randomX, chunkZ + randomZ);
		if (chunk.getBlock(randomX, y - 1, randomZ).getType().equals(Material.GRASS)) {
			chunk.getBlock(randomX, y, randomZ).setType(Material.SAPLING);
		} else if (chunk.getBlock(randomX, y - 1, randomZ).getType().equals(Material.SAND)) {
			chunk.getBlock(randomX, y, randomZ).setType(Material.CACTUS);
		}
	}

}