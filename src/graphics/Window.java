package graphics;

import controllers.Keyboard;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Window extends Canvas {
	private final JFrame window;
	private final Screen screen;
	private final BufferedImage image;
	private final int[] toDisplay;
	BufferStrategy strategy;
	private final Keyboard keyboard;

	public Window(int width, int height) {
		keyboard = new Keyboard();
		this.addKeyListener(keyboard);
		window = new JFrame("Conect 4");
		window.setMinimumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		screen = new Screen(width, height);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		toDisplay = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		strategy = this.getBufferStrategy();
	}

	public void clear() {
		this.requestFocus();
		screen.clean();
	}

	public void display () {
		strategy = this.getBufferStrategy();
		if (strategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		System.arraycopy(screen.getPixels(), 0, toDisplay, 0, toDisplay.length);
		Graphics g = this.strategy.getDrawGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		this.strategy.show();
	}

	public void draw(final Sprite sprite) {
		screen.draw(sprite);
	}
	
	public boolean [] getEvents() {
		return this.keyboard.getKeys();
	}

	public void setTitle(final String string) {
		window.setTitle(string);
	}
}
