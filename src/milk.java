/*
ID: czpcxfz1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

public class milk {
	public static class milksort implements Comparator{
		public int compare(Object o1, Object o2) {
		    return toInt(o1) - toInt(o2);
		  }
		private int toInt(Object o) {
		    int[] str = (int[]) o;
		    return str[0];
		  }
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken()), 
				m = Integer.parseInt(st.nextToken());
		int[][] mi = new int[5000][2];
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(f.readLine());
			//mi[i] = new int[2];
			mi[i][0] = Integer.parseInt(st.nextToken());
			mi[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(mi, 0, m, new milksort());
		int co = 0, sum = 0;
		while (n > 0) {
			if (mi[co][1] >= n) {
				sum += mi[co][0] * n;
				break;
			}
			else {
				sum += mi[co][0] * mi[co][1];
				n -= mi[co][1];
			}
			++co;
			
		}
		out.println(sum);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
