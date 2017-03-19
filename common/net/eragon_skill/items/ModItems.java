package net.eragon_skill.items;

import net.eragon_skill.libs.Names;
import net.eragon_skill.main.References;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static DungeonSpawnStaff dungeonSpawnStaff;
	
	public static void init()
	{	
		dungeonSpawnStaff = new DungeonSpawnStaff();
		dungeonSpawnStaff.setRegistryName(new ResourceLocation(References.MOD_ID, Names.DUNGEON_SPAWN_STAFF));
		GameRegistry.register(dungeonSpawnStaff);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher){
		
		registerBasicModel(mesher, dungeonSpawnStaff, Names.DUNGEON_SPAWN_STAFF);
	}
	
	public static void registerBasicModel(ItemModelMesher mesher, Item item, String name){
		ModelResourceLocation model = new ModelResourceLocation(References.MOD_ID + name + "inventory");
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
