package net.eragon_skill.items;

import java.util.Random;

import net.eragon_skill.libs.Names;
import net.eragon_skill.loottables.ModLootTableList;
import net.eragon_skill.main.References;
import net.eragon_skill.world.gen.DungeonGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DungeonSpawnStaff extends ModItem
{
	/**
	 * For now that's just a test item i'm using.
	 * It has different functions in most of versions.
	 * Right now it spawns a chest with castle loot table
	 * @author eragoneq
	 */
	public DungeonSpawnStaff() {
		super(Names.DUNGEON_SPAWN_STAFF);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);
	}

	@Override
 	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		Random rand = new Random();
		if(!worldIn.isRemote)
		{
			DungeonGen.loadStructure(playerIn.getPosition(), worldIn, "dungeoniumseahut", Mirror.NONE , Rotation.NONE);
			/*
			worldIn.setBlockState(playerIn.getPosition().north(), Blocks.CHEST.getDefaultState());
			TileEntity tile = worldIn.getTileEntity(playerIn.getPosition().north());
			if(tile instanceof TileEntityChest){
				((TileEntityChest) tile).setLootTable(ModLootTableList.MOD_CHEST_CASTLE, rand.nextLong());
			}
			*/
			
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
