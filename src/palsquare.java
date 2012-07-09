/*
ID: czpcxfz1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare {
	public static int base, n1 = 0, n2 = 0;
	public static int[] a = new int[30], b = new int[30];
	public static boolean check(int x) {
		int xx = x * x, or = x;
		n1 = 0;
		n2 = 0;
		while (xx > 0) {
			a[n1] = xx % base;
			xx = xx / base;
			++n1;
		}
		for (int i = 0; i < n1 / 2; ++i) 
			if (a[i] != a[n1 - i - 1]) return false;
		while (x > 0) {
			b[n2] = x % base;
			x = x / base;
			++n2;
		}	
		return true;
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"palsquare.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		base = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 300; ++i) 
			if (check(i)) {
				for (int j = n2 - 1; j >= 0; --j) {
					if (b[j] <= 9 && b[j] >= 0)
						out.print(b[j]);
					else 
						out.print((char)(b[j]-10+'A'));
				}
				out.print(" ");
				for (int j = n1 - 1; j >= 0; --j) {
					if (a[j] <= 9 && a[j] >= 0)
						out.print(a[j]);
					else
						out.print((char)(a[j]-10+'A'));
				}
				out.println();
			}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
