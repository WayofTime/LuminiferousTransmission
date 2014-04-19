package WayofTime.luminescence.common.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEInputMirror extends TEFluidicLens
{
	public static final int drainRate = 50;
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		if(side == this.getStandDirection())
		{
			return 0;
		}
		
		return 0;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		ForgeDirection stand = this.getStandDirection();
		
		TileEntity tile = worldObj.getBlockTileEntity(xCoord+stand.offsetX, yCoord+stand.offsetY, zCoord+stand.offsetZ);
		if(tile instanceof IFluidHandler)
		{
			IFluidHandler fluidTile = (IFluidHandler)tile;
			FluidStack stack = fluidTile.drain(stand.getOpposite(), drainRate, false);

			Vec3 nextBlock = this.getProjectedBlock(getLensDirection());

			if(nextBlock != null)
			{
				TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);

				if(nextTile instanceof TEFluidicLens)
				{
					
					int fluidDrained = ((TEFluidicLens) nextTile).recieveBeamFromSide(this.getLensDirection().getOpposite(), stack);
					if(fluidDrained>0)
					{
						fluidTile.drain(stand.getOpposite(), fluidDrained, true);
						this.sendParticleBeam(this.getLensDirection());
					}
				}
			}
		}
	}
	
	public void sendParticleBeam(ForgeDirection direction)
	{
		
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
	{
		return TileEntity.INFINITE_EXTENT_AABB;
	}
}
