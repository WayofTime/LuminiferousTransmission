package WayofTime.luminescence.common.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEFluidicLens extends TEOrientable implements ISingleLens
{
	public static final int maxDistance = 16;
	public int beamRenderTime = 0;
	
	@Override
	public int recieveBeamFromSide(ForgeDirection forgeDirection, FluidStack fluid)
	{
		if(forgeDirection == this.getStandDirection())
		{
			return 0;
		}
		
		return 0;
	}
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        beamRenderTime = par1NBTTagCompound.getInteger("beamRenderTime");
    }
	
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("beamRenderTime", beamRenderTime);
    }
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		if(this.beamRenderTime>0)
		{
			beamRenderTime--;
		}
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
	
	public float getDistanceAndSetBeamRender(ForgeDirection side, int cooldown)
	{
		Vec3 block = this.getProjectedBlock(side);
		if(block != null)
		{
			TileEntity tile = worldObj.getBlockTileEntity((int)block.xCoord, (int)block.yCoord, (int)block.zCoord);
			if(tile instanceof TEFluidicLens)
			{
				((TEFluidicLens) tile).setBeamRenderTimeFromSide(cooldown, side.getOpposite());
			}
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
	
	public int getBeamRenderTime()
	{
		return this.beamRenderTime;
	}
	
	public void setBeamRenderTimeFromSide(int time, ForgeDirection side)
	{
		if(side == this.getLensDirection() || side == this.getStandDirection())
		{
			return ;
		}
		
		this.beamRenderTime = time;
	}
}
