package net.eragon_skill.world.gen;

import java.util.Random;

import net.eragon_skill.loottables.ModLootTableList;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPillar extends WorldGenerator{

	private int[] size = {5, 9, 5};
	private Block[] allowedBlocks = {Blocks.GRASS, Blocks.SAND, Blocks.STAINED_HARDENED_CLAY, Blocks.STONE, Blocks.SANDSTONE, Blocks.DIRT};
	public static String name = DungeonGen.PILLAR;
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		while(worldIn.isAirBlock(pos) && pos.getY() > 2){
			pos = pos.down();
		}
		if(DungeonGen.checkTerrain(worldIn, pos, size, allowedBlocks, 0.95, true)){
			DungeonGen.loadStructure(pos.add(0, 1, 0), worldIn, name, Mirror.NONE, Rotation.NONE);
			DungeonGen.dungeonCoords.add(pos);
			TileEntity tile = worldIn.getTileEntity(pos.add(2, 1, 2));
			if(tile instanceof TileEntityChest){
				((TileEntityChest) tile).setLootTable(ModLootTableList.MOD_CHEST_PILLAR, rand.nextLong());
			}
			return true;
		}else{
			return false;
		}
	}

}
