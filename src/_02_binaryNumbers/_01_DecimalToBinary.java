package _02_binaryNumbers;

// https://profound.academy/algorithms-data-structures/convert-decimal-numbers-into-binary-gq9r8BFO55NfmMUY4WXC

public class _01_DecimalToBinary {

	public static void main(String[] args) {
		int num = 13;
		StringBuilder resInReverse = new StringBuilder();

		while (num > 0) {
			resInReverse.append(num % 2);
			num = num / 2;
		}

		System.out.println(resInReverse.reverse().toString());
	}

}
