/*
ID: czpcxfz1
LANG: JAVA
TASK: gift1
 */
import java.io.*;
import java.util.*;

public class gift1 {
	static String[] name;
	static int n;

	private static int findp(String x) {
		for (int i = 0; i < n; ++i) {
			if (x.equals(name[i]))
				return i;
		}
		return 0;
	}

	public static void gift1_main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster

		String xxx;
		int[] money, receive, friend;
		int peo, peo2;
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		name = new String[n];
		money = new int[n];
		receive = new int[n];
		friend = new int[n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(f.readLine());
			name[i] = st.nextToken();
		}
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(f.readLine());
			xxx = st.nextToken();
			peo = findp(xxx);
			st = new StringTokenizer(f.readLine());
			money[peo] = Integer.parseInt(st.nextToken());
			friend[peo] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < friend[peo]; ++j) {
				st = new StringTokenizer(f.readLine());
				xxx = st.nextToken();
				peo2 = findp(xxx);
				receive[peo2] += money[peo] / friend[peo];
			}
		}
		for (int i = 0; i < n; ++i)
			if (friend[i] > 0) {
				out.println(name[i]
						+ " "
						+ (receive[i] - money[i] / friend[i]
								* friend[i]));
			} else
				out.println(name[i] + " " + receive[i]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
