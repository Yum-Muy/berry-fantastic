package io.github.yummuy.berryfantastic;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static io.github.yummuy.berryfantastic.BerryFantastic.LOGGER;
import static io.github.yummuy.berryfantastic.ModBlocks.GLOW_BERRY_PIE_BLOCK;
import static io.github.yummuy.berryfantastic.ModBlocks.SWEET_BERRY_PIE_BLOCK;

public class ModItems {
	public static <T extends Item> T register (String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		//creates key
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BerryFantastic.ID, name));
		T item = itemFactory.apply(settings.setId(itemKey));//creates instance
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);//registers
		return item;
	}

	public static final ResourceKey<CreativeModeTab> BF_CREATIVE_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(BerryFantastic.ID, "bf_creative_tab")
	);
	public static final CreativeModeTab BF_CREATIVE_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(SWEET_BERRY_PIE_BLOCK.asItem()))
		.title(Component.translatable("creativeTab.berry_fantastic"))
		.displayItems((params, output) -> {
			output.accept(SWEET_BERRY_PIE_BLOCK.asItem());
			output.accept(GLOW_BERRY_PIE_BLOCK.asItem());
		})
		.build();

	public static void initialize(){
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BF_CREATIVE_TAB_KEY, BF_CREATIVE_TAB);

		LOGGER.info("[Berry Fantastic]: fire item registering vro..");
		LOGGER.info("vro: i know...");
	}
}
