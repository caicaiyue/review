package review;

import java.util.Stack;

//用两个栈实现队列
public class TestStackQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	//两个栈，实现进队列
	public void intostackqueue(int data){
		s1.push(data);
	}
	
	public Integer outstackqueue(){
		if(s2.isEmpty()){
			if(s1.isEmpty()){
				//System.out.println("队列已经空了，不能出队了");
				return null;
			}else{
				transfer();
			}
		}
		
		return s2.pop();
	}
	
	private void transfer() {
		// TODO Auto-generated method stub
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStackQueue tsq = new TestStackQueue();
		tsq.intostackqueue(1);
		tsq.intostackqueue(2);
		tsq.intostackqueue(3);
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		tsq.intostackqueue(4);
		System.out.println(tsq.outstackqueue());
		tsq.intostackqueue(5);
		tsq.intostackqueue(6);
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
	}

}
