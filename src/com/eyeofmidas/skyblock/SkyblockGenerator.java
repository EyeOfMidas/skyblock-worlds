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
		log.info("[SkyblockGenerator] Got id " + uid);
		if (uid.equals("normal")) {
			return new SkyblockChunkGenerator();
		}
		if (uid.equals("nether")) {
			return new NetherSkyblockChunkGenerator();
		}
		// if (uid.equals("the_end")) {
		// return new EndSkyblockChunkGenerator();
		// }

		return super.getDefaultWorldGenerator(worldName, uid);
	}

}
