# SkyblockWorld #
A Minecraft Spigot server plugin for generating skyblock-esque maps.

## How to use ##
Put the SkyblockGenerator.jar in your bukkit plugins folder.

In your bukkit.yml config, add the following lines:
```
worlds:
  world:
    generator: SkyblockGenerator:normal
  world_nether:
    generator: SkyblockGenerator:nether
  world_the_end:
    generator: SkyblockGenerator:the_end
```

replace 'world' with your world name (in server.properties, this is the level-name)

Also, it's suggested you disable spawn protection in your server.properties file.
```
spawn-protection=0
```

##Upcoming features##
* Command to randomize spawn location (in case your skyblock is broken)
* First Join placed on a random island (instead of dying)
* Skyblocks with mineable materials in them (iron, diamond, etc) for progression
* Large skyblocks (spanning multiple chunks)
