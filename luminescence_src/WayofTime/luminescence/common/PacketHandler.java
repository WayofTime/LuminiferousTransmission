package WayofTime.luminescence.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import WayofTime.luminescence.Luminescence;
import WayofTime.luminescence.common.tileEntity.TEOrientable;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        if (packet.channel.equals("particle"))
        {
            ByteArrayInputStream bin = new ByteArrayInputStream(packet.data);
            DataInputStream din = new DataInputStream(bin);
            Random rand = new Random();

            try
            {
                double x = din.readDouble();
                double y = din.readDouble();
                double z = din.readDouble();
                short particleType = din.readShort();
                World world = ((EntityPlayer) player).worldObj;

                if (particleType == 1)
                {
                    world.spawnParticle("mobSpell", x + 0.5D + rand.nextGaussian() / 8, y + 1.1D, z + 0.5D + rand.nextGaussian() / 8, 0.5117D, 0.0117D, 0.0117D);
                }

                if (particleType == 2)
                {
                    world.spawnParticle("reddust", x + 0.5D + rand.nextGaussian() / 8, y + 1.1D, z + 0.5D + rand.nextGaussian() / 8, 0.82D, 0.941D, 0.91D);
                }

                if (particleType == 3)
                {
                    world.spawnParticle("mobSpell", x + 0.5D + rand.nextGaussian() / 8, y + 1.1D, z + 0.5D + rand.nextGaussian() / 8, 1.0D, 0.371D, 0.371D);
                }

                if (particleType == 4)
                {
                    float f = (float) 1.0F;
                    float f1 = f * 0.6F + 0.4F;
                    float f2 = f * f * 0.7F - 0.5F;
                    float f3 = f * f * 0.6F - 0.7F;

                    for (int l = 0; l < 8; ++l)
                    {
                        world.spawnParticle("reddust", x + Math.random() - Math.random(), y + Math.random() - Math.random(), z + Math.random() - Math.random(), f1, f2, f3);
                    }
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } else if (packet.channel.equals("CustomParticle"))
        {
            ByteArrayInputStream bin = new ByteArrayInputStream(packet.data);
            DataInputStream din = new DataInputStream(bin);
            Random rand = new Random();

            try
            {
                World world = ((EntityPlayer) player).worldObj;
                int size = din.readInt();
                String str = "";

                for (int i = 0; i < size; i++)
                {
                    str = str + din.readChar();
                }

                double x = din.readDouble();
                double y = din.readDouble();
                double z = din.readDouble();
                double xVel = din.readDouble();
                double yVel = din.readDouble();
                double zVel = din.readDouble();
                world.spawnParticle(str, x, y, z, xVel, yVel, zVel);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }else if (packet.channel.equals("TEOrientor"))
        {
            ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
            int x = dat.readInt();
            int y = dat.readInt();
            int z = dat.readInt();
            World world = Luminescence.proxy.getClientWorld();
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

            if (tileEntity instanceof TEOrientable)
            {
                TEOrientable tileEntityOrientable = (TEOrientable) tileEntity;
                tileEntityOrientable.setInputDirection(ForgeDirection.getOrientation(dat.readInt()));
                tileEntityOrientable.setOutputDirection(ForgeDirection.getOrientation(dat.readInt()));
                world.markBlockForRenderUpdate(x, y, z);
            }
        }else if (packet.channel.equals("SetPlayerVel"))
        {
            ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
            double xVel = dat.readDouble();
            double yVel = dat.readDouble();
            double zVel = dat.readDouble();
            ((EntityPlayer) player).setVelocity(xVel, yVel, zVel);
        } else if (packet.channel.equals("SetPlayerPos"))
        {
            ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
            double xVel = dat.readDouble();
            double yVel = dat.readDouble();
            double zVel = dat.readDouble();
            ((EntityPlayer) player).setPosition(xVel, yVel, zVel);
        }
    }

    public static Packet getCustomParticlePacket(String str, double x, double y, double z, double xVel, double yVel, double zVel)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        DataOutputStream dos = new DataOutputStream(bos);

        try
        {
            dos.writeInt(str.length());
            dos.writeChars(str);
            dos.writeDouble(x);
            dos.writeDouble(y);
            dos.writeDouble(z);
            dos.writeDouble(xVel);
            dos.writeDouble(yVel);
            dos.writeDouble(zVel);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.channel = "CustomParticle";
        pkt.data = bos.toByteArray();
        pkt.length = bos.size();
        pkt.isChunkDataPacket = false;
        return pkt;
    }

    public static Packet getPlayerVelocitySettingPacket(double xVel, double yVel, double zVel)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        DataOutputStream dos = new DataOutputStream(bos);

        try
        {
            dos.writeDouble(xVel);
            dos.writeDouble(yVel);
            dos.writeDouble(zVel);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.channel = "SetPlayerVel";
        pkt.data = bos.toByteArray();
        pkt.length = bos.size();
        pkt.isChunkDataPacket = false;
        return pkt;
    }

    public static Packet getPlayerPositionSettingPacket(double xVel, double yVel, double zVel)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        DataOutputStream dos = new DataOutputStream(bos);

        try
        {
            dos.writeDouble(xVel);
            dos.writeDouble(yVel);
            dos.writeDouble(zVel);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.channel = "SetPlayerPos";
        pkt.data = bos.toByteArray();
        pkt.length = bos.size();
        pkt.isChunkDataPacket = false;
        return pkt;
    }

    public static Packet getBlockOrientationPacket(TEOrientable tileEntity)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        DataOutputStream dos = new DataOutputStream(bos);

        try
        {
            dos.writeInt(tileEntity.xCoord);
            dos.writeInt(tileEntity.yCoord);
            dos.writeInt(tileEntity.zCoord);
            dos.writeInt(tileEntity.getIntForForgeDirection(tileEntity.getInputDirection()));
            dos.writeInt(tileEntity.getIntForForgeDirection(tileEntity.getOutputDirection()));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.channel = "TEOrientor";
        pkt.data = bos.toByteArray();
        pkt.length = bos.size();
        pkt.isChunkDataPacket = true;
        return pkt;
    }
}
