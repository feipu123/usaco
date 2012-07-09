/*
ID: czpcxfz1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;
import java.lang.Math;

public class MCS {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		//BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"mcs.txt")));
		double[][] poi = new double[100][100];
		double[] len = new double[10000];
		double x;
		int n = 0;
		int[] count = new int[10000];
		Random rd=new Random();
		for (int i = 0; i < 100; ++i) {
			x=0;
			for (int j = 0; j < 3; ++j) {
				poi[i][j] = rd.nextGaussian();
				x+=poi[i][j]*poi[i][j];
			}
			x=Math.sqrt(x);
			for (int j = 0; j < 3; ++j) {
				poi[i][j] = poi[i][j] / x;
			}
		}
		for (int i = 0; i < 100; ++i)
			for (int j = i+1; j < 100; ++j) { 
				len[n] = 0;
				for (int k = 0; k < 3; ++k) {
					len[n] += (poi[i][k]-poi[j][k])*(poi[i][k]-poi[j][k]);
				}
				len[n] = Math.sqrt(len[n]);
				++count[(int)(len[n]*10)];
				++n;
			}
		for (int i = 0; i < 40; ++i) 
			out.println(i*0.1+" "+count[i]);
			
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
