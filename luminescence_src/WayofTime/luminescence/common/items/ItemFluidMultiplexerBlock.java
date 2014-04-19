package WayofTime.luminescence.common.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFluidMultiplexerBlock extends ItemBlock

{
    public ItemFluidMultiplexerBlock(int par1)
    {
        super(par1);
        setHasSubtypes(true);
        this.setUnlocalizedName("itemColouredMuxFluid");
    }

    public String getUnlocalizedName(ItemStack itemstack)

    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
            case 0:
            {
                name = "white";
                break;
            }

            case 1:
            {
                name = "orange";
                break;
            }

            case 2:
                name = "repeaterAssembly";
                break;

            default:
                name = "broken";
        }

        return getUnlocalizedName() + "." + name;
    }

    public int getMetadata(int par1)
    {
        return par1;
    }
}
