/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import domain.Board;

/**
 *
 * @author mevalram
 */
public class GameBoard {
	private final SpriteSheet spritesheet;
	private final Sprite redToken;
	private final Sprite blueToken;
	private final Sprite cellSprite;
	private final Sprite sprite1;
	private final Sprite sprite2;
	private final Sprite sprite3;
	private final Sprite sprite4;
	private final Sprite sprite5;
	private final Sprite sprite6;
	private final Sprite sprite7;
	private final Sprite wonSprite;

	public GameBoard() {
		spritesheet = new SpriteSheet("asdf.png",128,256);
		redToken = new Sprite(64,64,spritesheet,0,0);
		blueToken = new Sprite(64,64,spritesheet,64,0);
		cellSprite = new Sprite(64,64,spritesheet,0,64);
		sprite1 = new Sprite(32,32,spritesheet,0,128);
		sprite2 = new Sprite(32,32,spritesheet,32,128);
		sprite3 = new Sprite(32,32,spritesheet,0,160);
		sprite4 = new Sprite(32,32,spritesheet,32,160);
		sprite5 = new Sprite(32,32,spritesheet,64,128);
		sprite6 = new Sprite(32,32,spritesheet,96,128);
		sprite7 = new Sprite(32,32,spritesheet,64,160);
		wonSprite = new Sprite(128,64,spritesheet,0,192);
		sprite1.move(16, 16);
		sprite2.move(80, 16);
		sprite3.move(144, 16);
		sprite4.move(208, 16);
		sprite5.move(272, 16);
		sprite6.move(334, 16);
		sprite7.move(398, 16);
		wonSprite.move(162, 250);
	}

	public void render(Window window, final Board board) {
		final int fils = board.getFils();
		final int cols = board.getCols();
		final int[] cells = board.getCells();
		final boolean win = board.getWinner()[0];
		window.draw(sprite1);
		window.draw(sprite2);
		window.draw(sprite3);
		window.draw(sprite4);
		window.draw(sprite5);
		window.draw(sprite6);
		window.draw(sprite7);
		for (int i = 0; i < fils * cols; i++) {
			int fil = i % fils;
			int col = i / fils;
			if (cells[i] == 1) {
				redToken.setPosition(col * 64, (fils - fil - 1) * 64 + 64);
				window.draw(redToken);
			} else if (cells[i] == 2) {
				blueToken.setPosition(col * 64, (fils - fil - 1) * 64 + 64);
				window.draw(blueToken);
			}
			cellSprite.setPosition(col * 64, (fils - fil - 1) * 64 + 64);
			window.draw(cellSprite);
		}
		if (win) {
			if (board.getWinner()[1]) {
				blueToken.setPosition(194, 180);
				window.draw(blueToken);
			} else {
				redToken.setPosition(194, 180);
				window.draw(redToken);
			}
			window.draw(wonSprite);
		}
	}
}
