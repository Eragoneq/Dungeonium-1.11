package net.eragon_skill.main;

import net.eragon_skill.items.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	
	public void init(FMLInitializationEvent e)
	{
		ModItems.init();
		
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
}
