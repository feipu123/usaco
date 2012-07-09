/*
ID: czpcxfz1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal {
	public static boolean check(int x, int base) {
		int[] num = new int[50];
		int n = 0;
		while (x > 0) {
			num[n] = x % base;
			x = x / base;
			++n;
		}
		for (int i = 0; i < n / 2; ++i) 
			if (num[i] != num[n-i-1]) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"dualpal.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
		++s;
		while (n > 0) {
			int cou = 0;
			for (int i = 2; i <= 10; ++i) {
				if (check(s, i)) ++cou;
				if (cou >= 2) break;
			}
			if (cou >= 2) {
				out.println(s);
				--n;
			}
			++s;
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
