package WayofTime.luminescence;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.oredict.OreDictionary;
import WayofTime.luminescence.common.CommonProxy;
import WayofTime.luminescence.common.PacketHandler;
import WayofTime.luminescence.common.items.ItemFluidDemultiplexerBlock;
import WayofTime.luminescence.common.items.ItemFluidMultiplexerBlock;
import WayofTime.luminescence.common.items.ItemInputMirrorBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Luminescence", name = "Luminescence", version = "v0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"BloodAltar", "particle", "SetLifeEssence", "GetLifeEssence", "Ritual", "GetAltarEssence", "TESocket", "TEWritingTable", "CustomParticle", "SetPlayerVel", "SetPlayerPos", "TEPedestal", "TEPlinth", "TETeleposer", "InfiniteLPPath", "TEOrientor"}, packetHandler = PacketHandler.class)

public class Luminescence
{
	public static int blockInputMirrorBlockID;
	public static int blockMultiplexerFluidBlockID;
	public static int blockDemultiplexerFluidBlockID;
	
    public static CreativeTabs tabLuminescence = new CreativeTabs("tabLuminescence")
    {
        public ItemStack getIconItemStack()
        {
            return new ItemStack(Item.appleGold, 1, 0);
        }
    };


    public static void registerRenderInformation()
    {
    }

    

    public static void registerRenderThings()
    {
    }

    

    @Instance("Luminescence")
    public static Luminescence instance;

    @SidedProxy(clientSide = "WayofTime.luminescence.client.ClientProxy", serverSide = "WayofTime.luminescence.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LuminescenceConfiguration.init(new File(event.getModConfigurationDirectory(), "Luminescence.cfg"));

        //Custom config stuff goes here


        Potion[] potionTypes = null;

        for (Field f : Potion.class.getDeclaredFields())
        {
            f.setAccessible(true);

            try
            {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
                {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                    potionTypes = (Potion[]) f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            } catch (Exception e)
            {
                System.err.println("Severe error, please report this to the mod author:");
                System.err.println(e);
            }
        }

        //MinecraftForge.EVENT_BUS.register(new AlchemicalWizardryEventHooks());
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int craftingConstant = OreDictionary.WILDCARD_VALUE;

        ModItems.init();
        ModBlocks.init();

        proxy.registerRenderers();
        proxy.registerEntities(); 
        proxy.registerTileEntities();
        
        GameRegistry.registerBlock(ModBlocks.blockInputMirror, ItemInputMirrorBlock.class, "Luminescence" + (ModBlocks.blockInputMirror.getUnlocalizedName()));
        GameRegistry.registerBlock(ModBlocks.blockMultiplexerFluid, ItemFluidMultiplexerBlock.class, "Luminescence" + (ModBlocks.blockMultiplexerFluid.getUnlocalizedName()));
        GameRegistry.registerBlock(ModBlocks.blockDemultiplexerFluid, ItemFluidDemultiplexerBlock.class, "Luminescence" + (ModBlocks.blockDemultiplexerFluid.getUnlocalizedName()));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
