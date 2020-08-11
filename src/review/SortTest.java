package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
	
public class SortTest {
	boolean isUp = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTest st = new SortTest();
		//int[] array = {4,7,6,5,3,2,8,1};
		//int[] array = {1,2,4,5,2,3,9,6,7,8};
		int[] array = {7,5,6,8,9,1,3,2,4};
		// int[] array = {3,5,7,1,8,4,9};
		// int[] array ={2,3,4,7,1,8,9,10,12,13,1};
		// int[] array = { 1, 2, 3, 5, 4 };
		 //int[] array = { 2, 3, 1,4, 5, 1 };
		//int[] array = { 4, 4, 6, 5, 3, 2, 8, 1 };
		 //int[] array = { 90, 99, 95, 94, 95 };
		//int[] array = { 95, 94, 91, 98, 99, 90, 99, 93, 91, 92 };
		// double[] array = {4.5,0.84,3.25,2.18,0.5};
		//double[] array = { 4.12, 1.212, 6.421, 0.0023, 1.5, 3.11, 3.0, 2.123, 8.122, 4.12, 10.09 };
		//st.BubbleSort(array);
		//st.QuickSort(array,0,array.length-1);
		//st.QuickSortDouble(array, 0, array.length-1);
		//System.out.println(Arrays.toString(st.CountSort(array)));
		//st.bucketSort(array);
		st.dumpSort(array);
		//System.out.println(Arrays.toString(array));
	}


	private void dumpSort(int[] array) {
		// TODO Auto-generated method stub
		for(int i=(array.length-2)/2;i>=0;i--){
			goDown(array,i,array.length-1);
		}
		
		int end = array.length-1;
		while(end>0){
			int temp = array[0];
			array[0]= array[end];
			array[end]=temp;
			end--;
			array = goDown(array,0,end);
			
		}
		
		System.out.println(Arrays.toString(array));
	}

	private  int[] goUp(int[] array,int start,int end){
		int childindex = end;
		int parentindex = (childindex-1)/2;
		int temp = 0;
		while(childindex>start){
			if(array[childindex]<array[parentindex]){
				temp = array[childindex];
				array[childindex]=array[parentindex];
				array[parentindex]=temp;
				isUp = true;
			}
			
			childindex = parentindex;
			parentindex =  (childindex-1)/2;
		}
		
		return array;
	}
	
	private int[] goDown(int[] array,int start,int end){
		int parentindex = start;
		int childindex = parentindex*2+1;
		int temp = array[start];
		while(childindex<=end){
			if(childindex+1<=end&&array[childindex+1]<array[childindex]){
				childindex = childindex+1;
			}
			
			if(temp<array[childindex]){
				break;
			}
			
			array[parentindex]=array[childindex];
			parentindex = childindex;
			childindex = parentindex*2+1;
		}
		
		array[parentindex]=temp;
		return array;
	}

	private void bucketSort(double[] array) {
		// TODO Auto-generated method stub
		double mini = array[0];
		double max = array[0];
		for(double d:array){
			if(d>max){
				max = d;
			}
			
			if(d<mini){
				mini = d;
			}
		}
		
		double distinct = max - mini;
		
		List<LinkedList<Double>> bucketlist = new ArrayList<LinkedList<Double>>();
		
		for(int i=0;i<array.length;i++){
			bucketlist.add(new LinkedList<Double>());
		}
		
		for(double d:array){
			int count = (int)((d-mini)*(array.length-1)/distinct);
			bucketlist.get(count).add(d);
		}
		
		for(int i=0;i<bucketlist.size();i++){
			Collections.sort(bucketlist.get(i));
		}
		
		double[] returnarray = new double[array.length];
		int count = 0;
	    for(LinkedList<Double> list:bucketlist){
	    	for(double d:list){
	    		returnarray[count++]=d;
	    	}
	    }
	    
	    System.out.println(Arrays.toString(returnarray));
	
	}


	private int[] CountSort(int[] array) {
		// TODO Auto-generated method stub
		int mini = array[0];
		int max = array[0];
		for(int i:array){
			if(i>max){
				max = i;
			}
			
			if(i<mini){
				mini = i;
			}
		}
		
		int distinct = max- mini;
		int[] countarray = new int[distinct+1];
		for(int i:array){
			int temp = i-mini;
			++countarray[temp];
		}
		
		
		
		for(int i=1;i<countarray.length;i++){
			countarray[i]=countarray[i-1]+countarray[i];
		}
		
		int[] returnarray = new int[array.length];
		for(int i:array){
			int temp = i-mini;
			returnarray[--countarray[temp]]=i;
		}
		
		return returnarray;
	}


	private void QuickSortDouble(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end){
			return;
		}
		int pivotindex = Partiton(array,start,end);
		QuickSortDouble(array,start,pivotindex-1);
		QuickSortDouble(array,pivotindex+1,end);
	}

	private int Partiton(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = array[start];
		int left = start;
		int right = end;
		int temp = 0;
		while(right>left){
			while(right>start&&array[right]>=pivot){
				right--;
			}
			
			while(left<right&&array[left]<=pivot){
				left++;
			}
			
			if(right<=left||right>end||left<start){
				break;
			}
			
			temp = array[right];
			array[right] = array[left];
			array[left] = temp;
			
		}
		
		array[start]=array[left];
		array[left]= pivot;
		return left;
	}

	private void QuickSort(int[] array,int start,int end) {
		// TODO Auto-generated method stub
		if(start>=end){
			return;
		}
		int pivot = getIndex(array,start,end);
		QuickSort(array,start,pivot-1);
		QuickSort(array,pivot+1,end);
	}
	
	
	
	private int getIndex(int[] array, int start,int end){
		int pivot = array[start];
		int mark = start;
		int index = start+1;
		int temp = 0;
		while(index<=end){
			while(index<=end&&array[index]>pivot){
				index++;
			}
			
			if(index>end){
				break;
			}
			
			if(pivot>array[index]){
				temp = array[index];
				array[index]=array[++mark];
				array[mark]=temp;
			}
			
			index++;
		}
		
		array[start]=array[mark];
		array[mark]=pivot;
		return mark;
		
	}

	private void BubbleSort(int[] array) {
		// TODO Auto-generated method stub
		boolean isChange = false;
		int temp = 0;
		int lastchange = 0;
		int setborder = array.length-1;
		for(int i=0;i<array.length;i++){
				for(int j=0;j<setborder;j++){
					if(array[j]>array[j+1]){
						temp = array[j];
						array[j]=array[j+1];
						array[j+1]=temp;
						lastchange = j;
						isChange = true;
					}		
				
				}
				setborder = lastchange;
			
			if(!isChange){
				break;
			}
			
			
		}
		System.out.println(Arrays.toString(array));
	}

}
