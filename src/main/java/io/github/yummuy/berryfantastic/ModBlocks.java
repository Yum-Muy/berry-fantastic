package io.github.yummuy.berryfantastic;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {
	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, Item.Properties itemSettings, boolean isBlockItem) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(settings.setId(blockKey));
		if (isBlockItem) {
			ResourceKey<Item> itemKey = keyOfItem(name);
			BlockItem blockItem = new BlockItem(block, itemSettings);
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}
		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}


	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BerryFantastic.ID, name));
	}
	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BerryFantastic.ID, name));
	}

	public static final Block SWEET_BERRY_PIE_BLOCK = register(
		"sweet_berry_pie",
		PieBlock::new,
		BlockBehaviour.Properties.of()
			.forceSolidOn()
			.strength(0.5F)
			.sound(SoundType.WOOL)
			.pushReaction(PushReaction.DESTROY),
		new Item.Properties()
			.setId(keyOfItem("sweet_berry_pie"))
			.stacksTo(1)
			.useBlockDescriptionPrefix(),
		true
	);
	public static final Block GLOW_BERRY_PIE_BLOCK = register(
		"glow_berry_pie",
		PieBlock::new,
		BlockBehaviour.Properties.of()
			.forceSolidOn()
			.strength(0.5F)
			.sound(SoundType.WOOL)
			.pushReaction(PushReaction.DESTROY),
		new Item.Properties()
			.setId(keyOfItem("glow_berry_pie"))
			.stacksTo(1)
			.useBlockDescriptionPrefix(),
		true
	);


	public static void initialize() {
		BerryFantastic.LOGGER.info("[Berry Fantastic]: These are my blocks cro...");
		BerryFantastic.LOGGER.info("cro: caw caw");
	}







}

