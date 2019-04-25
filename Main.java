import java.util.Scanner;

public class Main {

	static boolean[][] vis = new boolean[10][10];
	static int moves;
	static int[] dr = new int[8];
	static int[] dc = new int[8];
	static int row;
	static int col;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		row = in.nextInt() - 1;
		col = in.nextInt() - 1;
		moves = in.nextInt();
		intit();
		solve(row, col, moves);
		
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(!vis[i][j])
					continue;
				ans++;
			}
		}
		System.out.println(ans);
		in.close();
	}
	
	public static void solve(int row, int col, int reste) {
		if(reste == 0)
			return;
		
		for (int i = 0; i < 8; i++) {
			row += dr[i];
			col += dc[i];
			if((col >= 0 && col <= 9) && (row >= 0 && row <= 9)) {
				solve(row, col, reste - 1);
				if(reste == 1)
					vis[row][col] = true;
			}
			row -= dr[i];
			col -= dc[i];
		}
		
	}
	
	public static void intit() {
		dr[0] = 1;
		dr[1] = 1;
		dr[2] = -1;
		dr[3] = -1;
		dr[4] = 2;
		dr[5] = 2;
		dr[6] = -2;
		dr[7] = -2;
		
		dc[0] = 2;
		dc[1] = -2;
		dc[2] = 2;
		dc[3] = -2;
		dc[4] = -1;
		dc[5] = 1;
		dc[6] = -1;
		dc[7] = 1;
	}
}
