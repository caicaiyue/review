package review;

import java.util.Stack;

public class GetMini {
	Stack<Integer> mainstack = new Stack();
	Stack ministack = new Stack();
	
	public void insertinto(int data){
		mainstack.push(data);
		if(ministack.empty()||data<(Integer)ministack.peek()){
			ministack.push(data);
		}
	}
	
	public Integer pop(){
		if(ministack.peek().equals(mainstack.peek())){
			ministack.pop();
		}
		return mainstack.pop();
	}
	
	public int getMin(){
		if(ministack.empty()){
			System.out.println("栈为空，无最小值");
		}
		
		return (int) ministack.peek();
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMini gm = new GetMini();
		gm.insertinto(4);
		gm.insertinto(9);
		gm.insertinto(7);
		gm.insertinto(3);
		gm.insertinto(8);
		gm.insertinto(5);
		System.out.println(gm.getMin());
		gm.pop();
		gm.pop();
		gm.pop();
		System.out.println(gm.getMin());
		gm.insertinto(1);
		gm.pop();
		gm.pop();
		gm.pop();
		gm.pop();
		System.out.println(gm.getMin());
	}

}
