package graphics;

import controllers.Clock;
import domain.Manager;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
import controllers.Keyboard;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
//*/

public class Game /*extends Canvas*/ implements Runnable {
	//*
	private final Window window;
	/*/
	private final JFrame window;
	private final Screen screen;
	private final BufferedImage image;
	private final int[] toDisplay;
	private final Keyboard keyboard;
	//*/
	private Thread thread;
	private volatile boolean working = false;
	private final double TPF = 1000000000.0 / 30.0;
	private int ups;
	private int fps;
	private final GameBoard gameBoard;
	private final Manager manager;

	public Game(/*final int width, final int height*/) {
		/*
		keyboard = new Keyboard();
		this.addKeyListener(keyboard);
		window = new JFrame("Conect 4");
		window.setMinimumSize(new Dimension(width,height));
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
		/*/
		window = new Window(448,470);
		manager = new Manager();
		gameBoard = new GameBoard();
		//*/
	}

	public synchronized void start() {
		working = true;
		thread = new Thread(this, "Graphics");
		thread.start();
	}

	public synchronized void stop() {
		working = false;
		try {
			thread.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE,
			null, ex);
		}
	}

	private void processEvents() {
		manager.processEvents(this.window.getEvents());
	}

	private void update(double delta) {
		manager.update(delta);
		this.ups++;
	}

	private void render() {
		this.fps++;
		/*
		BufferStrategy strategy = this.getBufferStrategy();
		if (strategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		// Clean Screen
		screen.clean();

		// Drawing Screen
		gameBoard.render(screen, manager.getBoard());

		// Display Screen
		System.arraycopy(screen.getPixels(), 0, toDisplay, 0, toDisplay.length);
		Graphics g = strategy.getDrawGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();

		strategy.show();
		/*/
		window.clear();
		gameBoard.render(window, manager.getBoard());
		window.display();
		//*/
	}

	@Override
	public void run() {
		Clock clock1 = new Clock();
		Clock clock2 = new Clock();
		double tslu;
		while (working) {
			//requestFocus();
			processEvents();
			tslu = clock1.restart();
			while (tslu > this.TPF) {
				tslu -= this.TPF;
				update(this.TPF);
			}
			update(tslu);
			render();
			if (clock2.getEnlapsedTime() > 1.0) {
				window.setTitle("Conect 4 | ups: " + this.ups + ", fps: " + this.fps);
				this.ups = 0;
				this.fps = 0;
				clock2.restart();
			}
		}
	}
}
