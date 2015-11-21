package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class FloatingBedrockBlocks extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int chunkOffsetX = chunk.getX() << 4;
		int chunkOffsetZ = chunk.getZ() << 4;
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				world.getBlockAt(chunkOffsetX + x, 64, chunkOffsetZ + z).setType(Material.BEDROCK);
			}
		}

	}

}
