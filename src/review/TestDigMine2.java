package review;

import java.math.MathContext;
import java.util.Arrays;

public class TestDigMine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDigMine2 tdm = new TestDigMine2();
		int[] mine = {200,300,350,400,500};
		int[] people = {3,4,3,5,5};
		//int[] array = {4,7,6,5,3,2,8,1};
		// int[] array = {3,5,7,1,8,4,9};
		// int[] array ={2,3,4,7,1,8,9,10,12,13,1};
		// int[] array = { 1, 2, 3, 5, 4 };
		// int[] array = { 2, 3, 1,4, 5, 1 };
		// int[] array = { 4, 4, 6, 5, 3, 2, 8, 1 };
		// int[] array = { 90, 99, 95, 94, 95 };
		//int[] array = { 95, 94, 91, 98, 99, 90, 99, 93, 91, 92 };
		//System.out.println(tdm.GigMine(10,5,mine,people));
		//System.out.println(tdm.GigMine2(10, mine, people));
		System.out.println(tdm.GigMine3(10, mine, people));
		//tdm.BubbleSort(people);
	}

	private int GigMine3(int w, int[] mine, int[] people) {
		// TODO Auto-generated method stub
		int[] result = new int[w+1];
		for(int i=1;i<=mine.length;i++){
			for(int j=w;j>=1;j--){
				if(j>=people[i-1]){
					result[j] = Math.max(result[j-1], (result[j-people[i-1]]+mine[i-1]));
				}
			}
		}
		
		return result[w];
	}

	private int GigMine(int w, int n,int[] mine, int[] people) {
		// TODO Auto-generated method stub
		if(w==0||n==0){
			return 0;
		}
		
		if(w<people[n-1]){
			return GigMine(w,n-1,mine,people);
		}
		
		return Math.max(GigMine(w,n-1,mine,people), GigMine(w-people[n-1],n-1,mine,people)+mine[n-1]);
	}
	
	
	private int GigMine2(int w,int[] mine,int[] people){
		int[][] array = new int[mine.length+1][w+1];
		for(int i=1;i<=mine.length;i++){
			for(int j=1;j<=w;j++){
				if(j<people[i-1]){
					array[i][j]= array[i-1][j];
				}else{
					array[i][j]=Math.max(array[i-1][j], array[i-1][j-people[i-1]]+mine[i-1]);
				}
				
			}
		}
		
		return array[mine.length][w];
		
	}
	
	private void BubbleSort(int[] array){
		boolean ischange;
		int lastchange = array.length-1;
		int temp;
		int index;
		for(int i=0;i<array.length;i++){
			ischange = false;
			for(int j=0;j<lastchange;j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					ischange = true;
					index = j;
				}
				
				
			}
			index = lastchange;
			if(!ischange){
				break;
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
