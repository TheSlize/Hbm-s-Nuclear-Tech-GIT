package com.hbm.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class WorldConfig {

	public static int uraniumSpawn = 6;
	public static int thoriumSpawn = 7;
	public static int titaniumSpawn = 8;
	public static int sulfurSpawn = 5;
	public static int aluminiumSpawn = 7;
	public static int copperSpawn = 12;
	public static int fluoriteSpawn = 6;
	public static int niterSpawn = 6;
	public static int tungstenSpawn = 10;
	public static int leadSpawn = 6;
	public static int berylliumSpawn = 6;
	public static int ligniteSpawn = 2;
	public static int asbestosSpawn = 4;
	
	public static int radioStructure = 500;
	public static int antennaStructure = 250;
	public static int atomStructure = 500;
	public static int vertibirdStructure = 500;
	public static int dungeonStructure = 64;
	public static int relayStructure = 500;
	public static int satelliteStructure = 500;
	public static int bunkerStructure = 1000;
	public static int siloStructure = 1000;
	public static int factoryStructure = 1000;
	public static int dudStructure = 500;
	public static int spaceshipStructure = 1000;
	public static int barrelStructure = 5000;
	public static int geyserWater = 3000;
	public static int geyserChlorine = 3000;
	public static int geyserVapor = 500;
	public static int meteorStructure = 15000;
	public static int capsuleStructure = 100;
	public static int broadcaster = 5000;
	public static int minefreq = 64;
	public static int radfreq = 5000;
	public static int vaultfreq = 2500;
	
	public static int meteorStrikeChance = 20 * 60 * 180;
	public static int meteorShowerChance = 20 * 60 * 5;
	public static int meteorShowerDuration = 6000;
	
	public static void loadFromConfig(Configuration config) {
		final String CATEGORY_OREGEN = "02_ores";
		uraniumSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.00_uraniumSpawnrate", "Ammount of uranium ore veins per chunk", 7);
        titaniumSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.01_titaniumSpawnrate", "Ammount of titanium ore veins per chunk", 8);
        sulfurSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.02_sulfurSpawnrate", "Ammount of sulfur ore veins per chunk", 5);
        aluminiumSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.03_aluminiumSpawnrate", "Ammount of aluminium ore veins per chunk", 7);
        copperSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.04_copperSpawnrate", "Ammount of copper ore veins per chunk", 12);
        fluoriteSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.05_fluoriteSpawnrate", "Ammount of fluorite ore veins per chunk", 6);
        niterSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.06_niterSpawnrate", "Ammount of niter ore veins per chunk", 6);
        tungstenSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.07_tungstenSpawnrate", "Ammount of tungsten ore veins per chunk", 10);
        leadSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.08_leadSpawnrate", "Ammount of lead ore veins per chunk", 6);
        berylliumSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.09_berylliumSpawnrate", "Ammount of beryllium ore veins per chunk", 6);
        thoriumSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.10_thoriumSpawnrate", "Ammount of thorium ore veins per chunk", 7);
        ligniteSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.11_ligniteSpawnrate", "Ammount of lignite ore veins per chunk", 2);
        asbestosSpawn = CommonConfig.createConfigInt(config, CATEGORY_OREGEN, "2.12_asbestosSpawnRate", "Ammount of asbestos ore veins per chunk", 2);
        
        final String CATEGORY_DUNGEON = "04_dungeons";
		Property propRadio = config.get(CATEGORY_DUNGEON, "4.00_radioSpawn", 500);
		propRadio.setComment("Spawn radio station on every nTH chunk");
		radioStructure = propRadio.getInt();
		Property propAntenna = config.get(CATEGORY_DUNGEON, "4.01_antennaSpawn", 250);
		propAntenna.setComment("Spawn antenna on every nTH chunk");
		antennaStructure = propAntenna.getInt();
		Property propAtom = config.get(CATEGORY_DUNGEON, "4.02_atomSpawn", 500);
		propAtom.setComment("Spawn power plant on every nTH chunk");
		atomStructure = propAtom.getInt();
		Property propVertibird = config.get(CATEGORY_DUNGEON, "4.03_vertibirdSpawn", 500);
		propVertibird.setComment("Spawn vertibird on every nTH chunk");
		vertibirdStructure = propVertibird.getInt();
		Property propDungeon = config.get(CATEGORY_DUNGEON, "4.04_dungeonSpawn", 64);
		propDungeon.setComment("Spawn library dungeon on every nTH chunk");
		dungeonStructure = propDungeon.getInt();
		Property propRelay = config.get(CATEGORY_DUNGEON, "4.05_relaySpawn", 500);
		propRelay.setComment("Spawn relay on every nTH chunk");
		relayStructure = propRelay.getInt();
		Property propSatellite = config.get(CATEGORY_DUNGEON, "4.06_satelliteSpawn", 500);
		propSatellite.setComment("Spawn satellite dish on every nTH chunk");
		satelliteStructure = propSatellite.getInt();
		Property propBunker = config.get(CATEGORY_DUNGEON, "4.07_bunkerSpawn", 1000);
		propBunker.setComment("Spawn bunker on every nTH chunk");
		bunkerStructure = propBunker.getInt();
		Property propSilo = config.get(CATEGORY_DUNGEON, "4.08_siloSpawn", 1000);
		propSilo.setComment("Spawn missile silo on every nTH chunk");
		siloStructure = propSilo.getInt();
		Property propFactory = config.get(CATEGORY_DUNGEON, "4.09_factorySpawn", 1000);
		propFactory.setComment("Spawn factory on every nTH chunk");
		factoryStructure = propFactory.getInt();
		Property propDud = config.get(CATEGORY_DUNGEON, "4.10_dudSpawn", 500);
		propDud.setComment("Spawn dud on every nTH chunk");
		dudStructure = propDud.getInt();
		Property propSpaceship = config.get(CATEGORY_DUNGEON, "4.11_spaceshipSpawn", 1000);
		propSpaceship.setComment("Spawn spaceship on every nTH chunk");
		spaceshipStructure = propSpaceship.getInt();
		Property propBarrel = config.get(CATEGORY_DUNGEON, "4.12_barrelSpawn", 5000);
		propBarrel.setComment("Spawn waste tank on every nTH chunk");
		barrelStructure = propBarrel.getInt();
		Property propBroadcaster = config.get(CATEGORY_DUNGEON, "4.13_broadcasterSpawn", 5000);
		propBroadcaster.setComment("Spawn corrupt broadcaster on every nTH chunk");
		broadcaster = propBroadcaster.getInt();
		Property propMines = config.get(CATEGORY_DUNGEON, "4.14_landmineSpawn", 64);
		propMines.setComment("Spawn AP landmine on every nTH chunk");
		minefreq = propMines.getInt();
		Property propRad = config.get(CATEGORY_DUNGEON, "4.15_radHotsoptSpawn", 5000);
		propRad.setComment("Spawn radiation hotspot on every nTH chunk");
		radfreq = propRad.getInt();
		Property propVault = config.get(CATEGORY_DUNGEON, "4.16_vaultSpawn", 2500);
		propVault.setComment("Spawn locked safe on every nTH chunk");
		vaultfreq = propVault.getInt();
		Property pGW = config.get(CATEGORY_DUNGEON, "4.17_geyserWaterSpawn", 3000);
		pGW.setComment("Spawn water geyser on every nTH chunk");
		geyserWater = pGW.getInt();
		Property pGC = config.get(CATEGORY_DUNGEON, "4.18_geyserChlorineSpawn", 3000);
		pGC.setComment("Spawn poison geyser on every nTH chunk");
		geyserChlorine = pGC.getInt();
		Property pGV = config.get(CATEGORY_DUNGEON, "4.19_geyserVaporSpawn", 500);
		pGV.setComment("Spawn vapor geyser on every nTH chunk");
		geyserVapor = pGV.getInt();
		meteorStructure = CommonConfig.createConfigInt(config, CATEGORY_DUNGEON, "meteorStructure", "Spawn meteor dungeon on every nTH chunk", 15000);
		capsuleStructure = CommonConfig.createConfigInt(config, CATEGORY_DUNGEON, "4.21_capsuleSpawn", "Spawn landing capsule on every nTH chunk", 100);
		
		final String CATEGORY_METEOR = "05_meteors";
		Property propMeteorStrikeChance = config.get(CATEGORY_METEOR, "5.00_meteorStrikeChance", 20 * 60 * 60 * 5);
		propMeteorStrikeChance.setComment("The probability of a meteor spawning (an average of once every nTH ticks)");
		meteorStrikeChance = propMeteorStrikeChance.getInt();
		Property propMeteorShowerChance = config.get(CATEGORY_METEOR, "5.01_meteorShowerChance", 20 * 60 * 15);
		propMeteorShowerChance.setComment("The probability of a meteor spawning during meteor shower (an average of once every nTH ticks)");
		meteorShowerChance = propMeteorShowerChance.getInt();
		Property propMeteorShowerDuration = config.get(CATEGORY_METEOR, "5.02_meteorShowerDuration", 20 * 60 * 30);
		propMeteorShowerDuration.setComment("Max duration of meteor shower in ticks");
		meteorShowerDuration = propMeteorShowerDuration.getInt();
		
		radioStructure = CommonConfig.setDef(radioStructure, 1000);
		antennaStructure = CommonConfig.setDef(antennaStructure, 1000);
		atomStructure = CommonConfig.setDef(atomStructure, 1000);
		vertibirdStructure = CommonConfig.setDef(vertibirdStructure, 1000);
		dungeonStructure = CommonConfig.setDef(dungeonStructure, 1000);
		relayStructure = CommonConfig.setDef(relayStructure, 1000);
		satelliteStructure = CommonConfig.setDef(satelliteStructure, 1000);
		bunkerStructure = CommonConfig.setDef(bunkerStructure, 1000);
		siloStructure = CommonConfig.setDef(siloStructure, 1000);
		factoryStructure = CommonConfig.setDef(factoryStructure, 1000);
		dudStructure = CommonConfig.setDef(dudStructure, 1000);
		spaceshipStructure = CommonConfig.setDef(spaceshipStructure, 1000);
		barrelStructure = CommonConfig.setDef(barrelStructure, 1000);
		geyserWater = CommonConfig.setDef(geyserWater, 1000);
		geyserChlorine = CommonConfig.setDef(geyserChlorine, 1000);
		geyserVapor = CommonConfig.setDef(geyserVapor, 1000);
		broadcaster = CommonConfig.setDef(broadcaster, 1000);
		minefreq = CommonConfig.setDef(minefreq, 1000);
		radfreq = CommonConfig.setDef(radfreq, 1000);
		vaultfreq = CommonConfig.setDef(vaultfreq, 1000);
		meteorStrikeChance = CommonConfig.setDef(meteorStrikeChance, 1000);
		meteorShowerChance = CommonConfig.setDef(meteorShowerChance, 1000);
		capsuleStructure = CommonConfig.setDef(capsuleStructure, 100);
		meteorStructure = CommonConfig.setDef(meteorStructure, 15000);
	}

}
