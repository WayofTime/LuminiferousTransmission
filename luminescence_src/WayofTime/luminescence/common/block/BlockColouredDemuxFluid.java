package WayofTime.luminescence.common.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import WayofTime.luminescence.Luminescence;
import WayofTime.luminescence.ModBlocks;
import WayofTime.luminescence.common.tileEntity.TEColouredDemultiplexerFluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockColouredDemuxFluid extends BlockOrientable 
{
	public BlockColouredDemuxFluid(int id) 
	{
		super(id);
		setUnlocalizedName("blockColouredDemuxFluid");
		this.setCreativeTab(Luminescence.tabLuminescence);
	}
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (this.blockID == ModBlocks.blockMultiplexerFluid.blockID)
        {
        	for(int i=0; i<1; i++)
        	{
        		par3List.add(new ItemStack(par1, 1, i));
        	}
        } else
        {
            super.getSubBlocks(par1, par2CreativeTabs, par3List);
        }
    }
	
	public TileEntity createTileEntity()
    { 
		return new TEColouredDemultiplexerFluid();
	}
}
