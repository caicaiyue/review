package review;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RedPackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedPackTest rpt = new RedPackTest();
		rpt.setPacket(100, 10);
		rpt.setPacket2(100, 10);
	}

	private void setPacket(int money, int people) {
		// TODO Auto-generated method stub
		int[] redpack = new int[people];
		Random random = new Random();
		int leftmoney = money;
		int leftpeople = people;
		for (int i = 0; i < people - 1; i++) {
			int number = random.nextInt(leftmoney / leftpeople * 2 - 1) + 1;
			redpack[i] = number;
			leftmoney = leftmoney - number;
			leftpeople--;
		}

		redpack[people - 1] = leftmoney;

		System.out.println(Arrays.toString(redpack));
	}

	private void setPacket2(int money, int people) {
		List<Integer> redpacket = new LinkedList();
		int leftmoney = money;
		Random random = new Random();
		int num = 0;
		while (redpacket.size() < people - 1) {
			if(leftmoney>1){
				num = random.nextInt(money) + 1;
				if (redpacket.contains(num)) {
					continue;
				}

				redpacket.add(num);
			}
			
		}

		Collections.sort(redpacket);

		System.out.println(redpacket.toString());

		List<Integer> redresult = new LinkedList();
		/*int count = 0;
		for (int i = 0; i < people; i++) {
			if (i < redpacket.size()) {
				if (i == 0) {
					redresult[i] = redpacket.get(i);
				} else {
					redresult[i] = redpacket.get(i) - redpacket.get(i - 1);
				}
			} else {
				redresult[i] = money - redpacket.get(i - 1);
			}
		}*/
		
		Iterator<Integer> it = redpacket.iterator();
		int left=0;
		while(it.hasNext()){
			int count = it.next();
			redresult.add(count-left);
			left = count;
		}

		redresult.add(money-left);
		System.out.println(redresult);
	}

}
