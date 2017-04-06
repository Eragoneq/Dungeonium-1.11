package net.eragon_skill.loottables;

import java.util.Set;

import com.google.common.collect.Sets;

import net.eragon_skill.main.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class ModLootTableList {
	public static final ResourceLocation MOD_CHEST_CASTLE = LootTableList.register(new ResourceLocation(References.MOD_ID, "chests/castle_chests"));
	public static final ResourceLocation MOD_CHEST_PILLAR = LootTableList.register(new ResourceLocation(References.MOD_ID, "chests/pillar_chest"));
}
