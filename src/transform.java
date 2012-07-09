/*
ID: czpcxfz1
LANG: JAVA
TASK: transform
 */
import java.io.*;
import java.util.*;

public class transform {
	static int n;
	static String[] ss = new String[25];

	static int check() {
		boolean f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+j].charAt(n - i-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 1;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+n-i-1].charAt(n - j-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 2;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+n-j-1].charAt(i)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 3;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+i].charAt(n - j-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 4;
		}

//
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+j].charAt(n-(n - i-1)-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 5;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+n-i-1].charAt(n-(n - j-1)-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 5;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+n-j-1].charAt(n-i-1)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 5;
		}
		
		f = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				if (ss[i].charAt(j) != ss[n+i].charAt(j)) {
					f = true;
					break;
				}
			if (f)
				break;
		}
		if (!f) {
			return 6;
		}
				
		return 7;
	}

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"transform.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n + n; ++i) {
			ss[i] = f.readLine();
		}
		out.println(check());
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
