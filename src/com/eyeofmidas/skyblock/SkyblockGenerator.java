package com.eyeofmidas.skyblock;

import java.util.logging.Logger;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockGenerator extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pluginDescriptionFile;

	@Override
	public void onEnable() {
		pluginDescriptionFile = getDescription();
		log.info("[SkyblockGenerator] " + pluginDescriptionFile.getFullName() + " enabled");
	}

	@Override
	public void onDisable() {
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String uid) {
		log.info("Got id " + uid);
		return new SkyblockChunkGenerator();
	}

}