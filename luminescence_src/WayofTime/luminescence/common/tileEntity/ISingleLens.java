package WayofTime.luminescence.common.tileEntity;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public interface ISingleLens 
{
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid);
	
	public ForgeDirection getLensDirection();
	
	public ForgeDirection getStandDirection();
	
	public void setSingleBeamRenderTimeFromSide(int cooldown, ForgeDirection side);
}
