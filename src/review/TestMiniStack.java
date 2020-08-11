package review;

import java.util.Stack;

public class TestMiniStack {
	private static Stack<Integer> stackA;
	private static Stack<Integer> stackB;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		stackA = new Stack();
		stackB = new Stack();
		TestMiniStack tms = new TestMiniStack();
		tms.intoStack(4);
		tms.intoStack(9);
		tms.intoStack(7);
		tms.intoStack(3);
		tms.intoStack(8);
		tms.intoStack(5);
		System.out.println(tms.GetMini());
		tms.outofstack();
		tms.outofstack();
		tms.outofstack();
		tms.outofstack();
		System.out.println(tms.GetMini());
	}

	private  void intoStack(int data) {
		// TODO Auto-generated method stub
		int mini;
		if(stackA.isEmpty()){
			stackA.add(data);
			stackB.add(data);
		}else{
			mini = stackB.peek();
			if(data<mini){
				stackB.add(data);
			}
				stackA.add(data);
		}
	}
	
	private int outofstack(){
		int temp = stackA.pop();
		if(temp==stackB.peek()){
			stackB.pop();
		}
		
		return temp;
	}
	
	private int GetMini() throws Exception{
		if(stackA.isEmpty()){
			throw new Exception("stack is empty");
		}
		return stackB.peek();
	}

}
