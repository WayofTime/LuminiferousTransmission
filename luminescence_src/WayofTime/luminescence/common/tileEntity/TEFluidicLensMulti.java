package WayofTime.luminescence.common.tileEntity;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEFluidicLensMulti extends TEFluidicLens implements IMultiLens
{
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		return 0;
	}
}
