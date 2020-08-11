package review;

import java.util.Arrays;

public class TestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSum ts = new TestSum();
		int[] array = {1,4,2,5,2,3,4,1};
		int[] array1 = ts.CreateArray();
		ts.Findtwodifferent(array1);
	}

	private void Findtwodifferent(int[] array) {
		// TODO Auto-generated method stub
		int Xor = 0;
		for(int i:array){
			Xor = i^Xor;
		}
		
		int seperator = 1;
		while((seperator&Xor)==0){
			seperator=seperator<<1;
		}
		
		int[] result = new int[2];
		for(int i:array){
			if((i&seperator)==0){
				result[0]^=i;
			}else{
				result[1]^=i;
			}
		}
		
		System.out.println(Arrays.toString(result));
	}

	private int[] CreateArray() {
		// TODO Auto-generated method stub
		int[] array = new int[20];
		int num = 0;
		int k = 1;
		while(num+1<array.length-2){
			array[num]=k;
			array[num+1]=k;
			num = num+2;
			k++;
		}
		
		int a = (int) (Math.random()*10+1);
		int b = a+1;
		
		
		array[array.length-1]=a;
		array[array.length-2]=b;
		
		System.out.println(Arrays.toString(array));
		System.out.println(a);
		System.out.println(b);
		return array;
	}

}
