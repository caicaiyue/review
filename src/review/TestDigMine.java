package review;

public class TestDigMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 10;
		int[] p = { 5, 5, 3, 4, 3 };
		int[] g = { 400, 500, 200, 300, 350 };
		TestDigMine tdm = new TestDigMine();
		// int bestGoldMining = tdm.getBestGoldMiningV1(w,g.length,p,g);
		//int bestGoldMining = tdm.getBestGoldMiningV2(w, p, g);
		int bestGoldMining = tdm.getBestGoldMiningV3(w, p, g);
		System.out.println(bestGoldMining);
	}

	private int getBestGoldMiningV3(int w, int[] p, int[] g) {
		// TODO Auto-generated method stub
		int[] result = new int[w+1];
		for(int i=1;i<=g.length;i++){
			for(int j=w;j>0;j--){
				if(j>=p[i-1]){
					result[j]=Math.max(result[j], result[j-p[i-1]]+g[i-1]);
				}
			}
		}
		return result[w];
	}

	private int getBestGoldMiningV2(int w, int[] p, int[] g) {
		// TODO Auto-generated method stub
		int[][] result = new int[g.length+1][w+1];
		for(int i=1;i<=g.length;i++){
			for(int j=1;j<=w;j++){
				if(j<p[i-1]){
					result[i][j]=result[i-1][j];
				}else{
					result[i][j]=Math.max(result[i-1][j], result[i-1][j-p[i-1]]+g[i-1]);
				}
			}
		}
		return result[g.length][w];
	}

	// µÝ¹éÕÒ
	private int getBestGoldMiningV1(int w, int n, int[] p, int[] g) {
		// TODO Auto-generated method stub
		if (w == 0 || n == 0) {
			return 0;
		}

		if (w < p[n - 1]) {
			return getBestGoldMiningV1(w, n - 1, p, g);
		}

		return Math.max(getBestGoldMiningV1(w, n - 1, p, g), getBestGoldMiningV1(w - p[n - 1], n - 1, p, g) + g[n - 1]);
	}

}
