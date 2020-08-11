package review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestRedPacket {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedPacket trp = new TestRedPacket();
		List list = trp.dividRedPackage(100,5);
		System.out.println(list);
		trp.LineCut(100, 5);
	}
	
	public List dividRedPackage(Integer totalAmount,Integer totalPeopleNum){
		List<Integer> amountlist = new ArrayList<Integer>();
		Integer restAmount = totalAmount;
		Integer restPeople = totalPeopleNum;
		Random r = new Random();
		for(int i=0;i<totalPeopleNum-1;i++){
			int amount = r.nextInt((restAmount/restPeople*2-1))+1;
			restAmount = restAmount-amount;
			restPeople--;
			amountlist.add(amount);
		}
		amountlist.add(restAmount);
		return amountlist;
		
	}
	
	public void LineCut(Integer totalAmount,Integer totalPeopleNum){
		if(totalAmount<1||totalPeopleNum<1||totalAmount<totalPeopleNum){
			return;
		}
		
		List result = new ArrayList();
		List team = new ArrayList();
		Random r = new Random();
		while(team.size()<totalPeopleNum-1){
			int randommoney = r.nextInt(totalAmount)+1;
			if(!team.contains(randommoney)){
				team.add(randommoney);
			}
		}
		
		Collections.sort(team);
		System.out.println(team);
		
		int left = 0;
		Iterator<Integer> it = team.iterator();
		/*for(int i=0;i<team.size();i++){
			result.add((int)team.get(i)-left);
			left = (int) team.get(i);
		}
		
		result.add(totalAmount-left);*/
		
		while(it.hasNext()){
			int num = it.next();
			result.add(num-left);
			left = num;
		}
		result.add(totalAmount-left);
		
		System.out.println(result);
	}
	
	public void printList(List<Integer> list){
		//for(Integer i:list){
		//	System.out.println(i);
		//}
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
