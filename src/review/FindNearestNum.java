package review;

import java.util.Arrays;

public class FindNearestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNearestNum fnn = new FindNearestNum();
		System.out.println(fnn.findNearestNumber("52413"));
	}

	private String findNearestNumber(String string) {
		// TODO Auto-generated method stub
		int[] array = new int[string.length()];
		for (int i = 0; i < string.length(); i++) {
			array[i] = string.charAt(i) - '0';
		}

		int index = array.length - 1;
		for (int i = array.length - 1; i > 0; i--) {
			if (array[i] > array[i - 1]) {
				index = i;
				break;
			}
		}

		if (index == 0) {
			System.out.println("输入已经为最大值");
			return string;
		}

		int temp;
		for (int i = array.length - 1; i >= index; i--) {
			if (array[i] > array[index - 1]) {
				temp = array[index - 1];
				array[index - 1] = array[i];
				array[i] = temp;
				break;
			}
		}

		for (int i = array.length - 1; i >= index; i--) {
			boolean ischange =false;
			for (int j = index; j < i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					ischange = true;
				}
			}
			
			if(!ischange){
				break;
			}

		}

		String returnstring = Arrays.toString(array);
		return returnstring;

	}

}
