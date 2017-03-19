package net.eragon_skill.items;

import java.util.Random;

import net.eragon_skill.libs.Names;
import net.eragon_skill.main.References;
import net.eragon_skill.world.gen.DungeonGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DungeonSpawnStaff extends Item
{
	String name = References.RESOURCE_PREFIX + Names.DUNGEON_SPAWN_STAFF;
	
	public DungeonSpawnStaff() {
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
 	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		Random rand = new Random();
		if(!worldIn.isRemote)
		{
			DungeonGen.loadStructure(playerIn.getPosition().add(1, 1, 1), worldIn, "dungeoniumCastle", Mirror.NONE, Rotation.NONE);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public String getUnlocalizedName() {
		return "item." + this.name;
	}
}
