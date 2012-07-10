/*
ID: czpcxfz1
LANG: JAVA
TASK: packrec
*/
import java.io.*;
import java.util.*;

public class packrec {
	public static int[][] rec = new int[4][2];
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		for (int i = 0; i < 4; ++i) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			rec[i][0] = Integer.parseInt(st.nextToken());
			rec[i][1] = Integer.parseInt(st.nextToken());
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
