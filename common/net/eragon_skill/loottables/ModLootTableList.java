package net.eragon_skill.loottables;

import java.util.Set;

import com.google.common.collect.Sets;

import net.eragon_skill.main.References;
import net.minecraft.util.ResourceLocation;

public class ModLootTableList {
	private static final Set<ResourceLocation> LOOT_TABLES = Sets.<ResourceLocation>newHashSet();
	public static final ResourceLocation CHEST_CASTLE = register("chests/castle_chests");
	public static final ResourceLocation CHEST_PILLAR = register("chests/pillar_chest");
	
	private static ResourceLocation register(String id)
    {
        return new ResourceLocation(References.MOD_ID, id);
    }
}
