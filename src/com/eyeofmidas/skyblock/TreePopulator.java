package com.eyeofmidas.skyblock;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
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
		int randomX = random.nextInt(6) + 6;
		int randomZ = random.nextInt(6) + 6;
		int y = world.getHighestBlockYAt(chunkX + randomX, chunkZ + randomZ);

		Biome biome = world.getBiome(chunkX + randomX, chunkZ + randomZ);
		switch (biome) {
		case BEACH:
		case BIRCH_FOREST:
		case BIRCH_FOREST_HILLS:
		case BIRCH_FOREST_HILLS_MOUNTAINS:
		case BIRCH_FOREST_MOUNTAINS:
		case COLD_BEACH:
		case COLD_TAIGA:
		case COLD_TAIGA_HILLS:
		case COLD_TAIGA_MOUNTAINS:
		case DEEP_OCEAN:
		case DESERT:
		case DESERT_HILLS:
		case DESERT_MOUNTAINS:
		case EXTREME_HILLS:
		case EXTREME_HILLS_MOUNTAINS:
		case EXTREME_HILLS_PLUS:
		case EXTREME_HILLS_PLUS_MOUNTAINS:
		case FLOWER_FOREST:
		case FOREST:
		case FOREST_HILLS:
		case FROZEN_OCEAN:
		case FROZEN_RIVER:
		case HELL:
		case ICE_MOUNTAINS:
		case ICE_PLAINS:
		case ICE_PLAINS_SPIKES:
		case JUNGLE:
		case JUNGLE_EDGE:
		case JUNGLE_EDGE_MOUNTAINS:
		case JUNGLE_HILLS:
		case JUNGLE_MOUNTAINS:
		case MEGA_SPRUCE_TAIGA:
		case MEGA_SPRUCE_TAIGA_HILLS:
		case MEGA_TAIGA:
		case MEGA_TAIGA_HILLS:
		case MESA:
		case MESA_BRYCE:
		case MESA_PLATEAU:
		case MESA_PLATEAU_FOREST:
		case MESA_PLATEAU_FOREST_MOUNTAINS:
		case MESA_PLATEAU_MOUNTAINS:
		case MUSHROOM_ISLAND:
		case MUSHROOM_SHORE:
		case OCEAN:
		case PLAINS:
		case RIVER:
		case ROOFED_FOREST:
		case ROOFED_FOREST_MOUNTAINS:
		case SAVANNA:
		case SAVANNA_MOUNTAINS:
		case SAVANNA_PLATEAU:
		case SAVANNA_PLATEAU_MOUNTAINS:
		case SKY:
		case SMALL_MOUNTAINS:
		case STONE_BEACH:
		case SUNFLOWER_PLAINS:
		case SWAMPLAND:
		case SWAMPLAND_MOUNTAINS:
		case TAIGA:
		case TAIGA_HILLS:
		case TAIGA_MOUNTAINS:
		default:
//			Block plantBlock = chunk.getBlock(randomX, y, randomZ);
//			plantBlock.setType(Material.SAPLING);
			break;

		}

		if (chunk.getBlock(randomX, y - 1, randomZ).getType().equals(Material.GRASS)) {
			chunk.getBlock(randomX, y, randomZ).setType(Material.SAPLING);
		} else if (chunk.getBlock(randomX, y - 1, randomZ).getType().equals(Material.SAND)) {
			chunk.getBlock(randomX, y, randomZ).setType(Material.CACTUS);
		}
	}

}