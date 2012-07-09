/*
ID: czpcxfz1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads {
	public static void beads_main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken()), ans = 0, now;
		st = new StringTokenizer(f.readLine());
		String bead = st.nextToken();
		bead = bead + bead;
		char col;
		for (int i = 0; i < n; ++i) {
			int j;
			col = 'w';
			for (j = i; j < i + n; ++j) {
				if (col != 'w' && bead.charAt(j) != 'w' && col != bead.charAt(j))
					break;
				if (bead.charAt(j) != 'w')
					col = bead.charAt(j);
			}
			now = j - i;
			col = 'w';
			for (j = i + n - 1; j >= i; --j) {
				if (col != 'w' && bead.charAt(j) != 'w' && col != bead.charAt(j))
					break;
				if (bead.charAt(j) != 'w')
					col = bead.charAt(j);
			}
			now += i + n - 1 - j;
			if (now > n) {
				ans = n;
				break;
			}
			if (now > ans)
				ans = now;
		}
		out.println(ans);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
