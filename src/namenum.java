/*
ID: czpcxfz1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"namenum.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		String line = st.nextToken();
		int n = line.length();
		int[] ll = new int[13];
		int[] key = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0, 0, 0};
		int[] ch = {1, 1, 1, 931, 1497, 1918, 2670, 3355, 4025, 4381, 4618};
		int cou = 0, cccc;
		for (int i = 0; i < n; ++i) 
			ll[i] = line.charAt(i) - '0';
		f = new BufferedReader(new FileReader("dict.txt"));
		boolean flag;
		for (int i = 1; i < ch[ll[0]]; ++i) f.readLine();
		cccc = ch[ll[0]]-1;
		while (f.ready()) {
			++cccc;
			if (cccc == ch[ll[0]+1]) break;
			st = new StringTokenizer(f.readLine());
			line = st.nextToken();
			//out.println(line);
			if (line.length() != n) {continue;}
			flag = true;
			for (int i = 0; i < n; ++i)
				if (key[line.charAt(i) - 'A'] != ll[i]) {
					flag = false;
					break;
				}
			if (flag) {
				out.println(line);
				++cou;
			}
		}
		if (cou == 0) out.println("NONE");
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
