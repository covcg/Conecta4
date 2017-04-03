/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author mevalram
 */
public class Token {
	public boolean type;
	public int left, right, bottom, slashUp, slashDown, dSlashUp, dSlashDown;
	
	public Token(
		final boolean type,
		int left,
		int right,
		int bottom,
		int slashUp,
		int slashDown,
		int dSlashUp,
		int dSlashDown
	) {
		this.type = type;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.slashUp = slashUp;
		this.slashDown = slashDown;
		this.dSlashUp = dSlashUp;
		this.dSlashDown = dSlashDown;
	}
	
	public boolean getType() {
		return this.type;
	}
}
