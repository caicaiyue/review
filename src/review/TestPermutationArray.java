package review;

import java.util.Arrays;

public class TestPermutationArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPermutationArray tpa = new TestPermutationArray();
		int[] array = {1,2,3,5,4};
		//int[] array = {1,2,5,4,3};
		//int[] array = {5,4,3,2,1};
		for(int i=0;i<20;i++){
			array = tpa.PermutationArray(array);
			System.out.println(Arrays.toString(array));
		}
		
	}

	private int[] PermutationArray(int[] array) {
		// TODO Auto-generated method stub
		int index = findChangeIndex(array);
		if(index==0){
			return array;
		}
		int[] newarray = Arrays.copyOf(array, array.length);
		newarray = exchange(newarray,index);
		newarray = sorted(newarray,index);
		return newarray;
	}

	private int[] sorted(int[] array,int index) {
		// TODO Auto-generated method stub
		for(int i=index;i<array.length;i++){
			for(int j=array.length-1;j>i;j--)
			if(array[j]<array[j-1]){
				int temp = array[j];
				array[j]= array[j-1];
				array[j-1] =temp;
			}
		}
		
		return array;
	}

	private int[] exchange(int[] array, int index) {
		// TODO Auto-generated method stub
		int head = array[index-1];
		for(int i=array.length-1;i>=index;i--){
			if(array[i]>head){
				int temp = array[i];
				array[index-1] = array[i];
				array[i] = head;
				break;
			}
		}
		return array;
	}

	private int findChangeIndex(int[] array) {
		// TODO Auto-generated method stub
		for(int i=array.length-1;i>0;i--){
			if(array[i]>array[i-1]){
				return i;
			}
		}
		
		return 0;
	}

}
