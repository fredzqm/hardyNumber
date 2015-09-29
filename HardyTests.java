package hardysTaxi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Claude Anderson, points and ordering revised by Matt Boutell.
 * 
 *         When the tests are run for grading purposes, we will set Eclipse's
 *         heap memory to 1024 megabytes (in Program Files\Eclipse\eclipse.ini,
 *         and run these tests giving the jre 900 Megabytes of heap space (set
 *         this in Run Configurations). The leading zeros on the test names are
 *         used in conjunction with FixMethodOrder to present the tests in
 *         ascending order. (The order of tests in Java 7 is nondeterministic)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardyTests {

	private static int points = 0;
	private static boolean previousSuccess = true;

	/**
	 * Run a single test of nthHardyNumber. If a previous test failed or timed
	 * out, this one would almost certainly do the same, so it is not run. The
	 * global variable previousSuccess is used to keep track of this. Assumes
	 * that tests are run sequentially. There could be problems if tests are run
	 * concurrently.
	 * 
	 * @param nth
	 *            We are finding the nth Hardy number
	 * @param correctSum
	 *            This is what the answer should be
	 * @param pointsForCorrectNumber
	 *            Points awarded for getting the correct answer
	 * @param pointsForTime
	 *            Points awarded for getting the answer in less than a minute.
	 */
	private static void runOneTest(int nth, long correctSum,
			int pointsForCorrectNumber, int pointsForTime) {
		assertTrue(previousSuccess);
		// if false, don't waste time trying this one.
		previousSuccess = false;
		// If anything fails here, don't run more tests.
		System.gc();
		// run garbage collector to your timed test starts with as much
		// available memory as it can.
		long startTime = System.currentTimeMillis();
		// Give the user a little more info.
		long num = Hardy.nthHardyNumber(nth);
		double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
		boolean correct = (num == correctSum);
		System.out
				.printf("n = %10d  result: %23d   %8b\n"
						+ "elapsed time:%10f   Dumping Time:%10f   Populating Time:%10f\n",
						nth, num, correct, elapsedTime, Hardy.dump / 1000.0,
						Hardy.populate / 1000.0);

		assertEquals(correctSum, num);
		points += pointsForCorrectNumber;
		// assertTrue(elapsedTime <= 80);
		points += pointsForTime;
		System.out.printf("Points so far: %d-%d\n", points, (points + 16));
		previousSuccess = true; // This one worked; try the next one.
	}

	@Test
	public void testHardyNumber_0000001() {
		runOneTest(1, 1729L, 2, 2);
	}

	@Test
	public void testHardyNumber_0000002() {
		runOneTest(2, 4104L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000005() {
		runOneTest(5, 32832L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000010() {
		runOneTest(10, 65728L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000020() {
		runOneTest(20, 262656L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000040() {
		runOneTest(40, 920673L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000080() {
		runOneTest(80, 3375008L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000160() {
		runOneTest(160, 10811017L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000320() {
		runOneTest(320, 42549416L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0000640() {
		runOneTest(640, 166560193L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0001000() {
		runOneTest(1000, 416318561L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0002000() {
		runOneTest(2000, 1671816384L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0004000() {
		runOneTest(4000, 7103146447L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0006000() {
		runOneTest(6000, 16541054656L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0008000() {
		runOneTest(8000, 30225888875L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0010000() {
		runOneTest(10000, 48538460952L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0012000() {
		runOneTest(12000, 72125011153L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0014000() {
		runOneTest(14000, 100547229384L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0016000() {
		runOneTest(16000, 133882383096L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0018000() {
		runOneTest(18000, 172921387464L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0020000() {
		runOneTest(20000, 216264806875L, 2, 2);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0025000() {
		runOneTest(25000, 349961119928L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0030000() {
		runOneTest(30000, 520890296211L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0040000() {
		runOneTest(40000, 976889700163L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0060000() {
		runOneTest(60000, 2389857538048L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0090000() {
		runOneTest(90000, 5858794561158L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0120000() {
		runOneTest(120000, 11149741127168L, 1, 1);
	}

	@Test(timeout = 90000)
	public void testHardyNumber_0150000() {
		runOneTest(150000, 18362449483541L, 1, 1);
	}

	@Test(timeout = 150000)
	public void testHardyNumber_0200000() {
		runOneTest(200000, 35059220195419L, 1, 1);
	}

	// added myself ---------------------------------------------------------
	@Test(timeout = 200000)
	public void testHardyNumber_0300000() {
		runOneTest(300000, 87566615553635L, 1, 1);
	}

	@Test(timeout = 400000)
	public void testHardyNumber_0500000() {
		runOneTest(500000, 280196391751731L, 1, 1);
	}

	@Test(timeout = 700000)
	public void testHardyNumber_0700000() {
		runOneTest(700000, 604965422789784L, 1, 1);
	}

	@Test(timeout = 3000000)
	public void testHardyNumber_1000000() {
		runOneTest(1000000, 1376426637022528L, 1, 1);
	}

	@AfterClass
	public static void summary() {
		System.out.println("Total Points: " + points);
		System.out
				.println("You will lose at least 20% of these points if you did not follow\n"
						+ "the \"no fixed limits or fixed-sized arrays\" guidelines.");
		System.out
				.println("When we test your code for grading, we may use some \n"
						+ "different numbers (including larger ones), but the tests will have the same form.");
	}

}
