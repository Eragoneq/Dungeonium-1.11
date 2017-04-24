package net.eragon_skill.blocks;

import net.eragon_skill.handlers.ModelHandler;
import net.eragon_skill.libs.Names;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OvergrownLamp extends ModBlock{

	public OvergrownLamp() {
		super(Material.REDSTONE_LIGHT, Names.OVERGROWN_LAMP);
		setLightLevel(0.8F);
		setHardness(0.3F);
		setResistance(1.5F);
		setSoundType(SoundType.GLASS);
	}

	
}
