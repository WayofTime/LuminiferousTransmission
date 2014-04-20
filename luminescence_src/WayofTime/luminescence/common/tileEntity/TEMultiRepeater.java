package WayofTime.luminescence.common.tileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEMultiRepeater extends TEFluidicLensMulti
{
	public int[] colourArray = new int[16];
	
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		if(side == this.getStandDirection() || side == this.getLensDirection())
		{
			return 0;
		}
		
		this.setColourTimer(channel, 5);
		
		Vec3 nextBlock = this.getProjectedBlock(getLensDirection());
		if(nextBlock != null)
		{
			TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
			if(nextTile instanceof IMultiLens)
			{
				return ((IMultiLens) nextTile).recieveChannelFromSide(channel, getLensDirection().getOpposite(), fluid);
			}
		}
		
		return 0;
	}
	
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		return 0;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		for(int i=0; i<16; i++)
		{
			if(colourArray[i] >0)
			{
				colourArray[i]--;
			}
		}
	}
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        for(int i=0; i<16; i++)
        {
        	par1NBTTagCompound.setInteger("colourArray" + i, colourArray[i]);
        }  
    }
	
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        for(int i=0; i<16; i++)
        {
            colourArray[i] = par1NBTTagCompound.getInteger("colourArray" + i);
        }
    }
	
	@Override
	public ForgeDirection getInputDirection()
	{
		return ForgeDirection.UNKNOWN;
	}
	
	@Override
	public ForgeDirection getStandDirection()
	{
		return ForgeDirection.UNKNOWN;
	}
	
	public int[] getColourArray()
	{
		return this.colourArray;
	}
	
	public void setColourTimer(int channel, int time)
	{
		if(channel<16 && channel>=0)
		{
			this.colourArray[channel] = time;
		}
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
	{
		return TileEntity.INFINITE_EXTENT_AABB;
	}
}
