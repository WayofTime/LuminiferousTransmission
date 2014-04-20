package WayofTime.luminescence.common;

public class ColourHelper 
{
	public static int getHexColourForMeta(int meta)
	{
		switch(meta)
		{
		case 0:
			return 0xDDDDDD;
		case 1:
			return 0xDB7D3E;
		case 2:
			return 0xB350BC;
		case 3:
			return 0x6b8ac9;
		case 4:
			return 0xb1a627;
		case 5:
			return 0x41ae38;
		case 6:
			return 0xd08499;
		case 7:
			return 0x404040;
		case 8:
			return 0x9aa1a1;
		case 9:
			return 0x2e6e89;
		case 10:
			return 0x7e3db5;
		case 11:
			return 0x2e388d;
		case 12:
			return 0x4f321f;
		case 13:
			return 0x35461b;
		case 14:
			return 0x963430;
		case 15:
			return 0x191616;
		}
		return 0xDDDDDD;
	}
}
