package WayofTime.luminescence.common.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEFluidicLens extends TEOrientable implements ISingleLens
{
	public static final int maxDistance = 16;
	
	@Override
	public int recieveBeamFromSide(ForgeDirection forgeDirection, FluidStack fluid)
	{
		if(forgeDirection == this.getStandDirection())
		{
			return 0;
		}
		
		return 0;
	}
	
	public Vec3 getProjectedBlock(ForgeDirection side)
	{
		for(int i=1; i<=maxDistance;i++)
		{
			TileEntity tile = worldObj.getBlockTileEntity(xCoord + i*side.offsetX, yCoord + i*side.offsetY, zCoord + i*side.offsetZ);
			if(tile instanceof ISingleLens)
			{
				return worldObj.getWorldVec3Pool().getVecFromPool(xCoord + i*side.offsetX, yCoord + i*side.offsetY, zCoord + i*side.offsetZ);
			}
			
			Block block = Block.blocksList[worldObj.getBlockId(xCoord + i*side.offsetX, yCoord + i*side.offsetY, zCoord + i*side.offsetZ)];
			if(block !=null && block.isOpaqueCube())
			{
				return worldObj.getWorldVec3Pool().getVecFromPool(xCoord + i*side.offsetX, yCoord + i*side.offsetY, zCoord + i*side.offsetZ);
			}
		}
		
		return null;
	}
	
	public float getDistanceToNextTile(ForgeDirection side)
	{
		Vec3 block = this.getProjectedBlock(side);
		if(block != null)
		{
			return (float) Math.abs((xCoord-block.xCoord)+(yCoord-block.yCoord)+(zCoord-block.zCoord));
		}
		return maxDistance;
	}

	@Override
	public ForgeDirection getLensDirection() 
	{
		return this.getOutputDirection();
	}

	@Override
	public ForgeDirection getStandDirection() 
	{
		return this.getInputDirection();
	}
}
