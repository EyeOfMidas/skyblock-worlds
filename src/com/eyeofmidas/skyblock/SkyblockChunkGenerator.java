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
		this.blockPopulators.add(new DirtIslandBlockPopulator());
		this.blockPopulators.add(new SandIslandBlockPopulator());
		// this.blockPopulators.add(new FloatingBedrockBlockPopulator());
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
		return new Location(world, 10, 66, 10);
		// int posX = (random.nextInt(20) << 4) + 8;
		// int posZ = (random.nextInt(20) << 4) + 8;
		// int posY = world.getHighestBlockYAt(posX, posZ);
		// Location spawn = new Location(world, posX, posY, posZ);
		// while (posY == 0 && world.getBlockAt(posX, posY - 1, posZ).getType()
		// != Material.GRASS) {
		// posX = (random.nextInt(20) << 4) + 8;
		// posZ = (random.nextInt(20) << 4) + 8;
		// posY = world.getHighestBlockYAt(posX, posZ);
		// spawn = new Location(world, posX, posY, posZ);
		// }
		//
		// return spawn;
	}
}
