package net.eragon_skill.main;

import net.eragon_skill.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		
		ModItems.initClient(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}

}
