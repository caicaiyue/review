package review;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.*;



public class TestSort {

	// 冒泡法
	public void BubbleSort(int[] array) {
		Boolean isChange;
		int searchborder = array.length - 1;
		int lastchange = 0;
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			isChange = false;
			for (int j = 0; j < searchborder; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isChange = true;
					lastchange = j;
				}
			}

			searchborder = lastchange;

			if (!isChange) {
				break;
			}
		}
	}

	// 鸡尾酒排序
	public void CockTailSort(int[] array) {
		Boolean isChange;
		int temp = 0;
		for (int i = 0; i < array.length / 2; i++) {
			isChange = false;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isChange = true;
				}
			}

			if (!isChange) {
				break;
			}

			isChange = false;

			for (int j = array.length - 1 - i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					isChange = true;
				}
			}

			if (!isChange) {
				break;
			}

		}

	}

	// 快速排序，递归，单边指针
	public void QuickSort(int[] array, int startindex, int endindex) {
		if (startindex >= endindex) {
			return;
		}

		int pivotindex = partition(array, startindex, endindex);
		QuickSort(array, startindex, pivotindex - 1);
		QuickSort(array, pivotindex + 1, endindex);
	}

	// 快速排序，非递归，单边循环
	public void QuickSort1(int[] array, int startindex, int endindex) {
		Stack<Map<String, Integer>> quickstack = new Stack<Map<String, Integer>>();
		Map<String, Integer> sortedmap = new HashMap<String, Integer>();
		sortedmap.put("startindex", startindex);
		sortedmap.put("endindex", endindex);
		quickstack.push(sortedmap);

		while (!quickstack.isEmpty()) {
			sortedmap = quickstack.pop();
			int begin = sortedmap.get("startindex");
			int end = sortedmap.get("endindex");

			if (begin >= end) {
				continue;
			}

			int pivotindex = partition(array, begin, end);
			Map<String, Integer> rightmap = new HashMap<String, Integer>();
			rightmap.put("startindex", pivotindex + 1);
			rightmap.put("endindex", end);
			quickstack.push(rightmap);
			Map<String, Integer> leftmap = new HashMap<String, Integer>();
			leftmap.put("startindex", begin);
			leftmap.put("endindex", pivotindex - 1);
			quickstack.push(leftmap);

		}

	}

	private int partition(int[] array, int startindex, int endindex) {
		// TODO Auto-generated method stub
		int mark = startindex;
		int pivot = array[mark];
		int index = startindex + 1;
		int temp = 0;
		while (index <= endindex) {
			while (pivot < array[index] && index < endindex) {
				index++;
			}

			if (array[index] < pivot) {
				mark++;
				temp = array[mark];
				array[mark] = array[index];
				array[index] = temp;
			}

			index++;
		}

		if (pivot > array[mark]) {
			array[startindex] = array[mark];
			array[mark] = pivot;
		}

		return mark;
	}

	// 双边的快速排序
	public void quickSort2(int[] array, int startindex, int endindex) {
		if (startindex >= endindex) {
			return;
		}

		int pivot = doublepartition(array, startindex, endindex);
		quickSort2(array, startindex, pivot - 1);
		quickSort2(array, pivot + 1, endindex);
	}

	private int doublepartition(int[] array, int startindex, int endindex) {
		// TODO Auto-generated method stub
		int left = startindex;
		int right = endindex;
		int pivot = array[startindex];
		int temp = 0;
		while (left < right) {
			while (array[right] >= pivot && right > left) {
				right--;
			}

			while (array[left] <= pivot && left < right) {
				left++;
			}

			if (array[left] > array[right]) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}

		}

		array[startindex] = array[right];
		array[right] = pivot;

		return right;
	}

	public int[] countSort(int[] array) {
		if (array.length <= 0) {
			return array;
		} else {
			int mini = array[0];
			int max = array[0];

			for (int i : array) {
				if (i < mini) {
					mini = i;
				}

				if (i > max) {
					max = i;
				}
			}

			int[] countarray = new int[max - mini + 1];
			for (int i : array) {
				int num = i - mini;
				countarray[num]++;
			}

			// System.out.println(Arrays.toString(countarray));

			for (int i = 1; i < countarray.length; i++) {
				countarray[i] = countarray[i] + countarray[i - 1];
			}

			int[] sortedarray = new int[array.length];
			for (int i : array) {
				sortedarray[countarray[i - mini] - 1] = i;
				countarray[i - mini]--;
			}

			return sortedarray;
		}

	}

	public double[] BucketSort(double[] array){
		if(array.length<=0){
			return array;
		}
		
		double mini = array[0];
		double max = array[0];
		for(double d:array){
			if(d<mini){
				mini = d;
			}
			
			if(d>max){
				max = d;
			}
		}
		
		ArrayList<LinkedList<Double>> bucketlist = new ArrayList<LinkedList<Double>>();
		for(int i=0;i<array.length;i++){
			bucketlist.add(new LinkedList());
		}
		
		for(double d:array){
			int num = (int) ((d-mini)*(array.length-1)/(max-mini));
			bucketlist.get(num).add(d);
		}
		
		for(LinkedList list:bucketlist){
			Collections.sort(list);
		}
		
		double[] sortedarray = new double[array.length];
		int count =0;
		
		
		for(LinkedList<Double> list:bucketlist){
			//for(int i=0;i<list.size();i++){
			//	sortedarray[count++]=list.get(i);
			//}
			
			java.util.Iterator<Double> iter = list.iterator();
			while(iter.hasNext()){
				sortedarray[count++]=iter.next();
			}
			
		}
		
		 
	
		
		//System.out.println(Arrays.toString(sortedarray));
		return sortedarray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSort ts = new TestSort();
		// int[] array = {4,7,6,5,3,2,8,1};
		// int[] array = {3,5,7,1,8,4,9};
		// int[] array ={2,3,4,7,1,8,9,10,12,13,1};
		// int[] array = { 1, 2, 3, 5, 4 };
		// int[] array = { 2, 3, 1,4, 5, 1 };
		// int[] array = { 4, 4, 6, 5, 3, 2, 8, 1 };
		// int[] array = { 90, 99, 95, 94, 95 };
		// int[] array = { 95, 94, 91, 98, 99, 90, 99, 93, 91, 92 };
		// double[] array = {4.5,0.84,3.25,2.18,0.5};
		double[] array = { 4.12, 1.212, 6.421, 0.0023, 1.5, 3.11, 3.0, 2.123, 8.122, 4.12, 10.09 };
		// ts.BubbleSort(array);
		// ts.CockTailSort(array);
		// ts.QuickSort(array, 0, array.length-1);
		// ts.QuickSort1(array, 0, array.length-1);
		// ts.quickSort2(array, 0, array.length - 1);
		System.out.println(Arrays.toString(ts.BucketSort(array)));
		

		LinkedList<Double> list = new LinkedList();
		list.add(0.15);
		list.add(1.8);
		list.add(5.7);
		Iterator<Double> it = list.iterator();
//不行的话 写java.util.Iterator<double> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("*****");
		float a = -1.0f/0.0f;
		System.out.println(a);
	}

}
