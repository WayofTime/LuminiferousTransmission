package WayofTime.luminescence.common.tileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEColouredMultiplexerFluid extends TEFluidicLensMulti
{
	public int[] multiDirBeamRenderTime = new int[6];
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		return 0;
	}
	
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		Vec3 nextBlock = this.getProjectedBlock(side.getOpposite());
		if(nextBlock != null)
		{
			int meta = this.getBlockMetadata();
			
			TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
			if(nextTile instanceof IMultiLens)
			{
				return ((IMultiLens) nextTile).recieveChannelFromSide(this.getChannelForMeta(meta), side, fluid);
			}
		}
		
		return 0;
	}
	
	public int getChannelForMeta(int meta)
	{
		return meta;
	}
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        for(int i=0; i<6; i++)
        {
            par1NBTTagCompound.setInteger("multiBeamArray" + i, multiDirBeamRenderTime[i]);
        }
    }
	
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        for(int i=0; i<6; i++)
        {
        	multiDirBeamRenderTime[i] = par1NBTTagCompound.getInteger("multiBeamArray" + i);
        }
    }
	
	@Override
	public void setSingleBeamRenderTimeFromSide(int time, ForgeDirection side)
	{
		int num = side.getOpposite().ordinal();
		
		if(num<6 && num>=0)
		{
			multiDirBeamRenderTime[num] = time;
		}
	}
	
	public int getRenderTimeForSide(ForgeDirection side)
	{
		int num = side.ordinal();
		
		if(num<6 && num>=0)
		{
			return this.multiDirBeamRenderTime[num];
		}
		
		return 0;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		for(int i=0;i<6;i++)
		{
			if(multiDirBeamRenderTime[i]>0)
			{
				multiDirBeamRenderTime[i]--;
			}
		}
	}
	
	@Override
	public ForgeDirection getInputDirection()
	{
		return ForgeDirection.UNKNOWN;
	}
	
	@Override
	public ForgeDirection getOutputDirection()
	{
		return ForgeDirection.UNKNOWN;
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
	{
		return TileEntity.INFINITE_EXTENT_AABB;
	}
}
