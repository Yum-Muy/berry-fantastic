package io.github.yummuy.berryfantastic;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import static io.github.yummuy.berryfantastic.BerryFantastic.LOGGER;

public class ModBlockStateProperties {
	public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);



	public static void initialize(){
		BerryFantastic.LOGGER.info("[Berry Fantastic]: singular custom block state property class go");
		BerryFantastic.LOGGER.info("cro: what the hellie");
	}
}
