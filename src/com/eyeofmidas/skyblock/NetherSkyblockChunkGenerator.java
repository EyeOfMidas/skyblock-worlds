package com.eyeofmidas.skyblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class NetherSkyblockChunkGenerator extends ChunkGenerator {
	private ArrayList<BlockPopulator> blockPopulators;

	public NetherSkyblockChunkGenerator() {
		this.blockPopulators = new ArrayList<BlockPopulator>();
		this.blockPopulators.add(new NetherrackBlockPopulator());
		this.blockPopulators.add(new GlowStoneBlockPopulator());
		this.blockPopulators.add(new TreePopulator());
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return this.blockPopulators;
	}

	@Override
	public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
		return createChunkData(world);
	}

	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 8, 66, 8);
	}
}
