package WayofTime.luminescence.common.tileEntity;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public interface IMultiLens extends ISingleLens
{
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid);
	
	public void setMultiBeamRenderTimeFromSide(int cooldown, ForgeDirection side);
	
	public int getMultiBeamRenderTime();
}
