package WayofTime.luminescence.common.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEFluidicLensMulti extends TEFluidicLens implements IMultiLens
{
	public int multiBeamRenderTime = 0;
	
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		return 0;
	}
	
	@Override
	public void setMultiBeamRenderTimeFromSide(int time, ForgeDirection side)
	{
		if(side == this.getLensDirection() || side == this.getStandDirection())
		{
			return ;
		}
		
		this.multiBeamRenderTime = time;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if(this.multiBeamRenderTime>0)
		{
			multiBeamRenderTime--;
		}
	}
	
	public int getMultiBeamRenderTime()
	{
		return multiBeamRenderTime;
	}
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("multiBeamRenderTime", multiBeamRenderTime);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        multiBeamRenderTime = par1NBTTagCompound.getInteger("multiBeamRenderTime");
    }
}
