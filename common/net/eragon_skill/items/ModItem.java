package net.eragon_skill.items;

import javax.annotation.Nonnull;

import net.eragon_skill.main.References;
import net.eragon_skill.registers.IModelRegister;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ModItem extends Item implements IModelRegister{

	public ModItem(String name) {
		if(shouldRegister())
			GameRegistry.register(this, new ResourceLocation(References.MOD_ID, name));
		setUnlocalizedName(name);
	}

	protected boolean shouldRegister() {
		return true;
	}

	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
		return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item\\.", "item." + References.RESOURCE_PREFIX);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
