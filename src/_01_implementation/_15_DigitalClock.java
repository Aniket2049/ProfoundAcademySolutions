package _01_implementation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
You have a digital clock that lits up some segments to display the current 
time. Each digit is displayed as a collection of several lit-up and dimmed 
segments. For instance, the number O lits up all the segments on the edges, 
leaving the middle dimmed. The number 8, on the other hand, lits up all the 
segments. The number 1, lits only the rightmost segments, leaving the rest 
dimmed. You know the current time in hours and minutes (hh:mm). You're 
interested in when will your clock display exactly k lit-up segments (excluding
the middle dots). In case such configuration is not possible, i.e there will 
never be k lit segments on the clock then output "Impossible".

Input
The input contains two lines. The first line is the time (hh:mm) format. The 
next line contains an integer k (5 <= k <= 30)

Output
The program should output the hour and minute of when is the closest time the 
clock will have k segments lit up.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|11:11			|11:12			|
|11				|				|
+---------------+---------------+
|08:03			|08:04			|
|23				|				|
+---------------+---------------+
|10:30			|Impossible		|
|29				|				|
+---------------+---------------+
*/

public class _15_DigitalClock {

	public static int countSegments(String time, Map<Integer, Integer> segmentsMap) {
		return segmentsMap.get(time.charAt(0) - '0') + segmentsMap.get(time.charAt(1) - '0')
				+ segmentsMap.get(time.charAt(3) - '0') + segmentsMap.get(time.charAt(4) - '0');
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String timeAsStr = input.nextLine();
		int k = input.nextInt();

		input.close();

		// ----- INPUT READ -----

		boolean isValidated = false;

		HashMap<Integer, Integer> digitsToSegments = new HashMap<Integer, Integer>();
		digitsToSegments.put(0, 6);
		digitsToSegments.put(1, 2);
		digitsToSegments.put(2, 5);
		digitsToSegments.put(3, 5);
		digitsToSegments.put(4, 4);
		digitsToSegments.put(5, 5);
		digitsToSegments.put(6, 6);
		digitsToSegments.put(7, 3);
		digitsToSegments.put(8, 7);
		digitsToSegments.put(9, 6);
		if (timeAsStr.indexOf(':') < 2) {
			timeAsStr = "0" + timeAsStr;
		} 
		if (timeAsStr.indexOf(':') == 2 && timeAsStr.length() < 5) {
			String h = timeAsStr.split(":")[0];
			String m = timeAsStr.split(":")[1];
			if (m.length() == 1) {
				timeAsStr = h + ":0" + m;
			}
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime timeObj = LocalTime.parse(timeAsStr);
		LocalTime tempTimeObj = LocalTime.parse(timeAsStr);

		int counter = 0;
		while (counter < 1440) {
			String newTimeAsStrArr = tempTimeObj.format(formatter);
			int sum = countSegments(newTimeAsStrArr, digitsToSegments);

			if (sum == k) {
				System.out.println(tempTimeObj.toString());
				isValidated = true;
				break;
			}
			tempTimeObj = tempTimeObj.plusMinutes(1);
			counter++;
		}

		if (!isValidated)
			System.out.println("Impossible");

	}

}
