package net.eragon_skill.blocks;

import net.eragon_skill.handlers.ModelHandler;
import net.eragon_skill.items.ItemModBlock;
import net.eragon_skill.main.References;
import net.eragon_skill.registers.IModelRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModBlocks and other register handling stuff are used from Botania mod.
 * https://github.com/Vazkii/Botania
 */
public abstract class ModBlock extends Block implements IModelRegister{

	public ModBlock(Material materialIn, String name) {
		super(materialIn);
		setUnlocalizedName(name);
		setDefaultState(pickDefaultState());
		setRegistryName(new ResourceLocation(References.MOD_ID, name));
		GameRegistry.register(this);
		registerItemForm();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		if(Item.getItemFromBlock(this) != Items.AIR)
			ModelHandler.registerBlockToState(this, 0, getDefaultState());
	}
	
	protected IBlockState pickDefaultState() {
		return blockState.getBaseState();
	}
	
	public void registerItemForm() {
		GameRegistry.register(new ItemModBlock(this) , getRegistryName());
	}
	
	
}
