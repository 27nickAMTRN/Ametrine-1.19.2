package net.nick.ametrine;

import net.fabricmc.api.ModInitializer;
import net.nick.ametrine.block.ModBlocks;
import net.nick.ametrine.entity.ModEntities;
import net.nick.ametrine.item.ModItems;
import net.nick.ametrine.particle.ModParticleTypes;
import net.nick.ametrine.registry.ModSounds;
import net.nick.ametrine.statuseffect.ModEffects;
import net.nick.ametrine.world.feature.ModConfiguredFeatures;
import net.nick.ametrine.world.gen.ModOreGeneration;
import net.nick.ametrine.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ametrine implements ModInitializer {
	public static final String MOD_ID = "ametrine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();
		ModWorldGen.generateWorldGen();
		ModOreGeneration.generateOres();

		ModParticleTypes.registerParticles();
		ModEffects.registerEffects();
		ModEntities.registerModEntites();
		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
