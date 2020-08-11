package review;

import java.util.Stack;

public class TestStackQueue2 {
	private static Stack<Integer> A;
	private static Stack<Integer> B;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStackQueue2 tsq = new TestStackQueue2();
		A = new Stack<Integer>();
		B = new Stack<Integer>();
		tsq.intoqueue(3);
		tsq.intoqueue(5);
		tsq.intoqueue(1);
		System.out.println(tsq.dequeue());
		tsq.intoqueue(4);
		tsq.intoqueue(9);
		System.out.println(tsq.dequeue());
		System.out.println(tsq.dequeue());
		System.out.println(tsq.dequeue());
		System.out.println(tsq.dequeue());
		tsq.intoqueue(10);
		System.out.println(tsq.dequeue());
		System.out.println(tsq.dequeue());
	}

	private void intoqueue(int data) {
		// TODO Auto-generated method stub
		A.push(data);
	}

	private int dequeue(){
		int temp =0;
		if(!B.isEmpty()){
			temp = B.pop();
		}else{
			if(A.isEmpty()){
				System.out.println("队列已经空了，不能执行出队操作了");
			}else{
				while(!A.isEmpty()){
					temp = A.pop();
					B.push(temp);
				}
				
				temp = B.pop();
			}
		}
		
		
		return temp;
	}
}
