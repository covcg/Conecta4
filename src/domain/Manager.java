package domain;

public class Manager {
	private final Board board;
	private final Player player;

	public Manager() {
		board = new Board(6,7);
		player = new Player();
	}

	public void processEvents(final boolean[] keys) {
		player.processEvents(keys);
	}

	public void update(double delta) {
		player.update(delta,this.board);
	}

	public Board getBoard() {
		return this.board;
	}
}
