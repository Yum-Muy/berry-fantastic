package io.github.yummuy.berryfantastic;


import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerryFantastic implements ModInitializer {
	public static final String ID = "berry_fantastic";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Berry Fantastic]: Hello vro...");
		LOGGER.info("Vro: yo..");
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockStateProperties.initialize();
	}
}
