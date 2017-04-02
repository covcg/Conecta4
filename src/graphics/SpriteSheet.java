package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class SpriteSheet {
	private final int[] pixels;
	private final int width;
	private final int height;

	public SpriteSheet(final String route, final int width, final int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[this.width*this.height];
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(route));
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException ex) {
			Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int [] getPixels() {
		return this.pixels;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
