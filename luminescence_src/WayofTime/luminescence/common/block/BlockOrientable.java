package WayofTime.luminescence.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import WayofTime.luminescence.Luminescence;
import WayofTime.luminescence.common.tileEntity.TEOrientable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOrientable extends BlockContainer
{    
    @SideOnly(Side.CLIENT)
    private static Icon[] fireIcons;

    public BlockOrientable(int id)
    {
        super(id, Material.rock);
        setHardness(2.0F);
        setResistance(5.0F);
        setCreativeTab(Luminescence.tabLuminescence);
        setUnlocalizedName("bloodSocket");
        //func_111022_d("AlchemicalWizardry:blocks");
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TEOrientable();
    }
    
    public Icon[] getIconsForMeta(int metadata)
    {
    	return this.fireIcons;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float what, float these, float are)
    {
        if (world.isRemote)
        {
            return false;
        }

        ForgeDirection sideClicked = ForgeDirection.getOrientation(side);
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        if (tile instanceof TEOrientable)
        {
        	TEOrientable newTile = (TEOrientable)tile;
        	if(player.isSneaking())
        	{
    			int nextSide = TEOrientable.getIntForForgeDirection(newTile.getInputDirection())+1;
    			
    			if(nextSide>5)
    			{
    				nextSide = 0;
    			}
    			if(ForgeDirection.getOrientation(nextSide)==newTile.getOutputDirection())
    			{
    				nextSide++;
    				if(nextSide>5)
    				{
    					nextSide = 0;
    				}
    			}
    			
    			newTile.setInputDirection(ForgeDirection.getOrientation(nextSide));
        	}else
        	{
    			int nextSide = TEOrientable.getIntForForgeDirection(newTile.getOutputDirection())+1;
    			
    			if(nextSide>5)
    			{
    				nextSide = 0;
    			}
    			if(ForgeDirection.getOrientation(nextSide)==newTile.getInputDirection())
    			{
    				nextSide++;
    				if(nextSide>5)
    				{
    					nextSide = 0;
    				}
    			}
    			
    			newTile.setOutputDirection(ForgeDirection.getOrientation(nextSide));
        	}
        }

        world.markBlockForUpdate(x, y, z);
        return true;
    }
    
    
    
    @Override
    public int damageDropped(int metadata)
    {
        return metadata;
    }
}
