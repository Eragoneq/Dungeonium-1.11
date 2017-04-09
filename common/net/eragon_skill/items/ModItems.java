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
	
	public static DungeonSpawnStaff dungeon_spawn_staff;
	
	public static void init()
	{	
		dungeon_spawn_staff = new DungeonSpawnStaff();
	}
}
