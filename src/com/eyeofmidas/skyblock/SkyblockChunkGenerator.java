package com.eyeofmidas.skyblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class SkyblockChunkGenerator extends ChunkGenerator {

	private ArrayList<BlockPopulator> blockPopulators;

	public SkyblockChunkGenerator() {
		this.blockPopulators = new ArrayList<BlockPopulator>();
		this.blockPopulators.add(new FloatingBedrockBlocks());
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return this.blockPopulators;
	}

	@Override
	public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
		ChunkData data = createChunkData(world);
		return data;
	}

	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0.5, world.getHighestBlockYAt(0, 0), 0.5);
	}
}
