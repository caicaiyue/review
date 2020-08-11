package review;

import java.util.List;

public class FindMap {
	public static final int[][] maze = {
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}
	};
	
	static class Grid{
		public int x;
		public int y;
		public int f;
		public int g;
		public int h;
		public Grid parent;
		public Grid(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	private static boolean containGrid(List<Grid> grids,int x,int y){
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grid startGrid = new Grid(2,1);
		
	}

}
