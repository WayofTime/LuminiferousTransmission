package WayofTime.luminescence;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class LuminescenceConfiguration
{
    public static Configuration config;
    public static final String CATEGORY_GAMEPLAY = "gameplay";


    public static void init(File configFile)
    {

        config = new Configuration(configFile);

        try
        {

            config.load();

            Luminescence.blockInputMirrorBlockID = config.getBlock("inputMirror", 1500).getInt();
            Luminescence.blockMultiplexerFluidBlockID = config.getBlock("multiplexer", 1501).getInt();
            Luminescence.blockDemultiplexerFluidBlockID = config.getBlock("demultiplexer", 1502).getInt();

            
        } catch (Exception e)
        {

            FMLLog.log(Level.SEVERE, e, "Luminescence" + " has had a problem loading its configuration, go ask on the forums :p");

        } finally
        {
            config.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue)
    {

        config.load();
        if (config.getCategoryNames().contains(categoryName))
        {
            if (config.getCategory(categoryName).containsKey(propertyName))
            {
                config.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        config.save();
    }
}
