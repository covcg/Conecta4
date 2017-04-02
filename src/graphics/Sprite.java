package graphics;

public class Sprite {
	private final int width;
	private final int height;
	private int x;
	private int y;
	private final int[] pixels;

	public Sprite(final int width, final int height, final SpriteSheet sheet, final int x, final int y) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		for (int i = 0; i < height; i++) {
			System.arraycopy(sheet.getPixels(), (i + y) * sheet.getWidth() + x, this.pixels, i * width, width);
		}
		this.x = 0;
		this.y = 0;
	}

	public void move (int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void setPosition (int x, int y) {
		this.x = x;
		this.y = y;
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

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
