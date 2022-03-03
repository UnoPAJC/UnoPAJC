package unibs.pajc.uno.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Stefano Valloncini
 */
public class RobotoFont
{
	public static Font robotoFont;
	public static Font robotoFont2;

	private static String FONTS_SDIR = "res/fonts";

	public static void initializeFont()
	{
		try
		{
			robotoFont = Font.createFont(Font.PLAIN, new File(FONTS_SDIR + "/Roboto/Roboto-MediumItalic.ttf"))
					.deriveFont(45f);

			robotoFont2 = Font.createFont(Font.PLAIN, new File(FONTS_SDIR + "/Roboto/Roboto-LightItalic.ttf"))
					.deriveFont(20f);
			// robotoFont = Font.createFont(Font.PLAIN, new
			// File("res/fonts/Roboto/.otf")).deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(robotoFont);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (FontFormatException e)
		{
			e.printStackTrace();
		}
	}
}
