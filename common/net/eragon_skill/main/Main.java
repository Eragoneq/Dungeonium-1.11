package net.eragon_skill.main;

import java.util.Random;

import net.eragon_skill.world.gen.ModWorldGen;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid= References.MOD_ID, name= References.MOD_NAME, version= References.VERSION, dependencies= References.DEPENDENCIES)
public class Main 
{
	
	//vars
	public static Random random = new Random();
	
	@Instance(References.MOD_ID)
	public static Main instance;
	
	@SidedProxy(modId = References.MOD_ID, clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		ModWorldGen gen = new ModWorldGen();
		GameRegistry.registerWorldGenerator(gen, 10);
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		
		proxy.postInit(e);
	}
	
}
