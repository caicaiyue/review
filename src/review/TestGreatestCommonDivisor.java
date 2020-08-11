package review;

public class TestGreatestCommonDivisor {

	// 穷举法求最大公约数
	private int getGreatestCommonDivisor1(int a, int b) {
		int small = a <= b ? a : b;
		int big = a >= b ? a : b;
		if (big % small == 0) {
			return small;
		} else {
			for (int i = (big / 2); i > 1; i--) {
				if (small % i == 0 && big % i == 0) {
					return i;
				}
			}
		}

		return 1;
	}

	private int getGreatestCommonDivisor2(int a, int b) {
		if (a == b) {
			return a;
		}

		if ((a & 1) == 0 && (b & 1) == 0) {
			return getGreatestCommonDivisor2(a >> 1, b >> 1) << 1;
		} else if ((a & 1) == 0 || (b & 1) != 0) {
			return getGreatestCommonDivisor2(a >> 1, b);
		} else if ((a & 1) != 0 || (b & 1) == 0) {
			return getGreatestCommonDivisor2(a, b >> 1);
		} else {
			int big = a >= b ? a : b;
			int small = a <= b ? a : b;
			return getGreatestCommonDivisor2(big - small, small);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGreatestCommonDivisor tgcd = new TestGreatestCommonDivisor();
		// System.out.println(tgcd.getGreatestCommonDivisor1(6, 27));
		System.out.println(tgcd.getGreatestCommonDivisor1(25, 5));
		System.out.println(tgcd.getGreatestCommonDivisor1(100, 80));
		System.out.println(tgcd.getGreatestCommonDivisor1(27, 14));

	}

}
