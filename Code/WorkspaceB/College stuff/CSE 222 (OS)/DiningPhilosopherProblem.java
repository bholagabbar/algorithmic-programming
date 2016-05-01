package MISC.OS;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherProblem {
	// Makes the code more readable.
	public static class ChopStick {
		// Make sure only one philosopher can have me at any time.
		Lock up = new ReentrantLock();
		// Who I am.
		private final int id;
		
		public ChopStick(int id) {
			this.id = id;
		}
		
		public boolean pickUp(Philosopher who, String where) throws InterruptedException {
			if (up.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(who + " picked up " + where + " " + this);
				return true;
			}
			return false;
		}
		
		public void putDown(Philosopher who, String name) {
			up.unlock();
			System.out.println(who + " put down " + name + " " + this);
		}
		
		@Override
		public String toString() {
			return "Chopstick-" + id;
		}
	}
	
	// One philosoper.
	public static class Philosopher implements Runnable {
		// Which one I am.
		private final int id;
		// The chopsticks on either side of me.
		private final ChopStick leftChopStick;
		private final ChopStick rightChopStick;
		// Am I full?
		volatile boolean isTummyFull = false;
		// To randomize eat/Think time
		private Random randomGenerator = new Random();
		// Number of times I was able to eat.
		private int noOfTurnsToEat = 0;
			
		public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
			this.id = id;
			this.leftChopStick = leftChopStick;
			this.rightChopStick = rightChopStick;
		}
		
		@Override
		public void run() {
			
			try {
				while (!isTummyFull) {
					// Think for a bit.
					think();
					// Make the mechanism obvious.
					if (leftChopStick.pickUp(this, "left")) {
						if (rightChopStick.pickUp(this, "right")) {
							// Eat some.
							eat();
							// Finished.
							rightChopStick.putDown(this, "right");
						}
						// Finished.
						leftChopStick.putDown(this, "left");
					}
				}
			} catch (Exception e) {
				// Catch the exception outside the loop.
				e.printStackTrace();
			}
		}
		
		private void think() throws InterruptedException {
			System.out.println(this + " is thinking");
			Thread.sleep(randomGenerator.nextInt(1000));
		}
		
		private void eat() throws InterruptedException {
			System.out.println(this + " is eating");
			noOfTurnsToEat++;
			Thread.sleep(randomGenerator.nextInt(1000));
		}
		
		// Accessors at the end.
		public int getNoOfTurnsToEat() {
			return noOfTurnsToEat;
		}
		
		@Override
		public String toString() {
			return "Philosopher-" + id;
		}
	}
	// How many to test with.
	private static final int NO_OF_PHILOSOPHER = 5;
	//private static final int SIMULATION_MILLIS = 1000 * 60 * 8;
	private static final int SIMULATION_MILLIS = 1000 * 5;
	
	public static void main(String args[]) throws InterruptedException {
		ExecutorService executorService = null;
		
		Philosopher[] philosophers = null;
		try {
			
			philosophers = new Philosopher[NO_OF_PHILOSOPHER];
			
			//As many forks as Philosophers
			ChopStick[] chopSticks = new ChopStick[NO_OF_PHILOSOPHER];
			// Cannot do this as it will fill the whole array with the SAME chopstick.
			//Arrays.fill(chopSticks, new ReentrantLock());
			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				chopSticks[i] = new ChopStick(i);
			}
			
			executorService = Executors.newFixedThreadPool(NO_OF_PHILOSOPHER);
			
			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % NO_OF_PHILOSOPHER]);
				executorService.execute(philosophers[i]);
			}
			// Main thread sleeps till time of simulation
			Thread.sleep(SIMULATION_MILLIS);
			// Stop all philosophers.
			for (Philosopher philosopher : philosophers) {
				philosopher.isTummyFull = true;
			}
			
		} finally {
			// Close everything down.
			executorService.shutdown();
			
			// Wait for all thread to finish
			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}
			
			// Time for check
			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + " => No of Turns to Eat ="
						+ philosopher.getNoOfTurnsToEat());
			}
		}
	}
}