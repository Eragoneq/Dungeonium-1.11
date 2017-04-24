package net.eragon_skill.world.gen;


import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import net.eragon_skill.main.References;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

public class DungeonGen{
	
	public static final String PILLAR = "dungeoniumpillar";
	public static final String CASTLE = "dungeoniumcastle";
	public static final String SEAHUT = "dunegoniumseahut";
	
	public static ArrayList<BlockPos> dungeonCoords = new ArrayList<BlockPos>();
	public static ArrayList<String> dungeonNames = new ArrayList<String>();
	
	public static void loadStructure(BlockPos pos, World world, String name, Mirror mir, Rotation rot) {
		WorldServer worldserver = (WorldServer) world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		ResourceLocation loc = new ResourceLocation(References.MOD_ID, name);
		Template template = templatemanager.getTemplate(minecraftserver, loc);

		if (template != null) {
			IBlockState iblockstate = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(mir)
					.setRotation(rot).setIgnoreEntities(false).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);

			template.addBlocksToWorldChunk(world, pos.add(0, 0, 0), placementsettings);
		}
	}
	
	public static boolean checkTerrain(World world, BlockPos pos, int[] size, Block[] block, double integrity, boolean checkDistance){
		
		int block_count = size[0]*size[1]*size[2];
		int block_integrity = block_count;
		if(checkDistance){
			if(!dungeonCoords.isEmpty()){
				for(BlockPos dungeons : dungeonCoords){
					if(dungeons.getDistance(pos.getX(), pos.getY(), pos.getZ())<300){
						return false;
					}
				}
			}
		}
		for (int x = 0; x <= size[0]; ++x){
			for (int z = 0; z <= size[2]; ++z){
				for (int y = 0; y <= size[1]; ++y){
					if(y==0){
						if(!Arrays.asList(block).contains(world.getBlockState(pos.add(x, y, z)).getBlock())){
							block_integrity--;
						}
					}else{
						if(!world.getBlockState(pos.add(x, y, z)).getBlock().isReplaceable(world, pos.add(x, y, z))){
							block_integrity--;
						}
					}
				}
			}
		}
		if(block_integrity<(block_count*integrity)){
			return false;
		}else{
			return true;
		}
		
	}
	
	public static void registerNames(){
		DungeonGen.dungeonNames.add(PILLAR);
		DungeonGen.dungeonNames.add(CASTLE);
		DungeonGen.dungeonNames.add(SEAHUT);
	}
}
