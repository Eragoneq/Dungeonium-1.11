package net.eragon_skill.blocks;

import java.util.ArrayList;

import net.eragon_skill.libs.Names;
import net.eragon_skill.main.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static OvergrownLamp dungeonium_lamp;
	
	public static void init(){
		dungeonium_lamp = new OvergrownLamp();
	}
}
