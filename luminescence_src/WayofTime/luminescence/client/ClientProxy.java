package WayofTime.luminescence.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import WayofTime.luminescence.ModBlocks;
import WayofTime.luminescence.client.helper.ShaderHelper;
import WayofTime.luminescence.client.renderer.block.RenderInputMirrorBlock;
import WayofTime.luminescence.client.renderer.block.RenderMultiRepeaterLensBlock;
import WayofTime.luminescence.client.renderer.block.RenderMuxFluidBlock;
import WayofTime.luminescence.client.renderer.block.RenderOutputMirrorBlock;
import WayofTime.luminescence.client.renderer.block.RenderRepeaterLensBlock;
import WayofTime.luminescence.client.renderer.block.itemRender.TEBasicLensItemRenderer;
import WayofTime.luminescence.client.renderer.block.itemRender.TEMuxFluidBlockItemRenderer;
import WayofTime.luminescence.common.CommonProxy;
import WayofTime.luminescence.common.tileEntity.TEColouredMultiplexerFluid;
import WayofTime.luminescence.common.tileEntity.TEInputMirror;
import WayofTime.luminescence.common.tileEntity.TEMultiRepeater;
import WayofTime.luminescence.common.tileEntity.TEOutputMirror;
import WayofTime.luminescence.common.tileEntity.TESingleRepeater;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	public static Minecraft mc;
    public static int renderPass;
    public static int altarRenderType;

    @Override
    public void registerRenderers()
    {
    	ClientRegistry.bindTileEntitySpecialRenderer(TEInputMirror.class, new RenderInputMirrorBlock());
    	ClientRegistry.bindTileEntitySpecialRenderer(TEOutputMirror.class, new RenderOutputMirrorBlock());
    	ClientRegistry.bindTileEntitySpecialRenderer(TESingleRepeater.class, new RenderRepeaterLensBlock());
    	ClientRegistry.bindTileEntitySpecialRenderer(TEMultiRepeater.class, new RenderMultiRepeaterLensBlock());
    	ClientRegistry.bindTileEntitySpecialRenderer(TEColouredMultiplexerFluid.class, new RenderMuxFluidBlock());
    	
    	MinecraftForgeClient.registerItemRenderer(ModBlocks.blockInputMirror.blockID, new TEBasicLensItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(ModBlocks.blockMultiplexerFluid.blockID, new TEMuxFluidBlockItemRenderer());
    	
    	ShaderHelper.initShaders();
    }

    @Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }

    @Override
    public void InitRendering()
    {

    }
}
