package com.eyeofmidas.skyblock;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Logger log = Logger.getLogger("Minecraft");
		log.info("[SkyblockGenerator] " + "captured player respawn event");
		Player player = event.getPlayer();
		World world = event.getRespawnLocation().getWorld();
		if (player.getBedSpawnLocation() != null) {
			event.setRespawnLocation(player.getBedSpawnLocation());
			return;
		}

		// TODO: pick random valid spot
		Location randomLocation = this.getValidSpawnLocation(world);
		event.setRespawnLocation(randomLocation);
		player.setBedSpawnLocation(randomLocation);
	}

	private Location getValidSpawnLocation(World world) {
		// TODO Auto-generated method stub
		return new Location(world, 8, 66, 8);
	}
}
