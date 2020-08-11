package review;

import java.util.Arrays;

public class permutationarray {
	static int[] numbersCopy;
	public int[] findnearestNumber(int[] array){
		int index = findTransferPoint(array);
		if(index==0){
			return null;
		}
		
		numbersCopy = Arrays.copyOf(array, array.length);
		exchange(numbersCopy,index);
		reverse(numbersCopy,index);
		return numbersCopy;
	}
	
	
	
	private int[] reverse(int[] array, int index) {
		// TODO Auto-generated method stub
		for(int i=index,j=array.length-1;i<j;i++,j--){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
		return array;
	}



	private int[] exchange(int[] array, int index) {
		// TODO Auto-generated method stub
		int head=array[index-1];
		for(int i=array.length-1;i>=index;i--){
			if(array[i]>head){
				array[index-1]=array[i];
				array[i]=head;
				break;
			}
		}
		
		return array;
	}



	private int findTransferPoint(int[] array) {
		// TODO Auto-generated method stub
		for(int i=array.length-1;i>0;i--){
			if(array[i]>array[i-1]){
				return i;
			}
		}
		
		return 0;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutationarray p = new permutationarray();
		//int[] array = {1,2,3,4,5};
		int[] array = {5,4,3,2,1};
		for(int i=0;i<1;i++){
			array = p.findnearestNumber(array);
			System.out.println(Arrays.toString(array));
		}
			
		
		
		
	}

}
