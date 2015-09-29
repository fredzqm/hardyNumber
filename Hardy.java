package hardysTaxi;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Provides the static method hardySolutionsLessThan(N) which finds all "taxicab
 * numbers that are less than n. These are represented as TaxicabNumber objects,
 * which include the sum and two different ways of writing that as a sum of two
 * cubes.
 * 
 * @author Claude Anderson.
 * 
 */
public class Hardy {
	static long lastTime;
	static long populate;
	static long dump;

	/**
	 * Find the nth Hardy number (start counting with 1, not 0) and the numbers
	 * whose cubes demonstrate that it is a Hardy number.
	 * 
	 * @param n
	 * @return the nth Hardy number
	 */
	public static long nthHardyNumber(int n) {
		lastTime = System.currentTimeMillis(); // Give the user a little
		populate = 0;
		dump = 0;

		PriorityQueue<Long> list = new PriorityQueue<>();
		ArrayList<Integer> bva = new ArrayList<>();
		bva.add(0);
		int bm = 0, am, a, b, numCount = n;
		long bmcub, cubsum, preSum = -1, sum;
		while (true) {
			bm++;
			am = bva.size();
			bmcub = cube(bm);
			for (a = 0; a < am; a++) {
				b = bva.get(a);
				cubsum = cube(b) + cube(a);
				list.add(cubsum);
				b++;
				cubsum = cube(b) + cube(a);
				if (cubsum <= bmcub) {
					list.add(cubsum);
					b++;
				}
				bva.set(a, b);
			}
			cubsum = cube(am) * 2;
			if (cubsum <= bmcub) {
				list.add(cubsum);
				b = am + 1;
				cubsum = cube(b) + cube(am);
				if (cubsum <= bmcub) {
					list.add(cubsum);
					b++;
				}
				bva.add(b);
			}

			addTimePopulate();

			while (!list.isEmpty()) {
				sum = list.poll();
				if (sum == preSum) {
					if (numCount <= 1) {
						addTimeDump();
						return sum;
					}
					numCount--;
					while (preSum == list.peek())
						list.poll();
				} else {
					preSum = sum;
				}
			}
			addTimeDump();
		}
	}

	public static long cube(int i) {
		long b = i;
		return b * b * b;
	}

	private static void addTimePopulate() {
		long currentTime = (System.currentTimeMillis());
		populate += currentTime - lastTime;
		lastTime = currentTime;
	}

	private static void addTimeDump() {
		long currentTime = (System.currentTimeMillis());
		dump += currentTime - lastTime;
		lastTime = currentTime;
	}
}
