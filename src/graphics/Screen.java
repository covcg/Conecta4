package graphics;

public class Screen {
	private final int width;
	private final int height;
	private final int[] pixels;

	public Screen(final int width, final int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
	}

	public void clean() {
		int len = pixels.length;
		if (len > 0){
			pixels[0] = 0xff000000;
		}
		for (int i = 1; i < len; i += i) {
			System.arraycopy(pixels, 0, pixels, i, ((len - i) < i) ? (len - i) : i);
		}
	}

	public void draw(final Sprite sprite) {
		final int[] src = sprite.getPixels();
		final int sWidth = sprite.getWidth();
		final int sHeight = sprite.getHeight();
		final int x = sprite.getX();
		final int y = sprite.getY();
		final int sizeX = x < 0 ? sWidth - x : (x + sWidth > this.width ? this.width - x : sWidth);
		final int sizeY = y < 0 ? sHeight - y : (y + sHeight > this.height ? this.height - y : sHeight);
		if (sizeX > 0 && sizeY > 0) {
			for (int i = 0; i < sizeY; i++) {
				for (int j = 0; j < sizeX; j++) {
					if (src[i * sWidth + j] - 0x88000000 >= 0x00000000 && src[i * sWidth + j] != 0x00000000) this.pixels[(i + y) * this.width + x + j] = src[i * sWidth + j];
				}
			}
		}
	}
	
	public int [] getPixels() {
		return this.pixels;
	}
}
