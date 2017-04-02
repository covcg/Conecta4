package controllers;

public class Clock {
	private long init;

	public Clock() {
		init = System.nanoTime();
	}

	public double restart() {
		return (double)(-init + (init = System.nanoTime())) / 1000000000.0;
	}

	public double getEnlapsedTime() {
		return (double)(-init + System.nanoTime()) / 1000000000.0;
	}
}
