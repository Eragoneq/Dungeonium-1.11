package net.eragon_skill.world.gen;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import net.eragon_skill.loottables.ModLootTableList;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class WorldGenCastle extends WorldGenerator{

	private int[] size = {9, 7, 9};
	private Block[] allowedBlocks = {Blocks.GRASS, Blocks.SAND, Blocks.STAINED_HARDENED_CLAY, Blocks.STONE, Blocks.SANDSTONE, Blocks.DIRT};
	public static String name = DungeonGen.CASTLE;
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		while(worldIn.isAirBlock(pos) && pos.getY() > 2){
			pos = pos.down();
		}
		if(DungeonGen.checkTerrain(worldIn, pos, size, allowedBlocks, 0.99)){
			DungeonGen.loadStructure(pos, worldIn, name, Mirror.NONE, Rotation.NONE);
			DungeonGen.dungeonCoords.add(pos);
			/*
			TileEntity tile = worldIn.getTileEntity(pos.add(5, 1, 7));
			if(tile instanceof TileEntityChest){
				((TileEntityChest) tile).setLootTable(ModLootTableList.CHEST_CASTLE, rand.nextLong());
			}else{
				System.out.println("No chest here");
			}
			tile = worldIn.getTileEntity(pos.add(5, 1, 2));
			if(tile instanceof TileEntityChest){
				((TileEntityChest) tile).setLootTable(ModLootTableList.CHEST_CASTLE, rand.nextLong());
			}else{
				System.out.println("No chest here");
			}
			*/
			return true;
		}else{
			return false;
		}
	}
}
	