/*
ID: czpcxfz1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void ride_main(String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    String a = st.nextToken();
    st = new StringTokenizer(f.readLine());
    String b = st.nextToken();
    int aa = 1;
    int bb = 1;
    for (int i = 0; i < a.length(); ++i) 
    	aa = (aa * (a.charAt(i) - 'A' + 1)) % 47;
    for (int i = 0; i < b.length(); ++i)
    	bb = (bb * (b.charAt(i) - 'A' + 1)) % 47;
    
    if (aa == bb) out.println("GO");
    else out.println("STAY");
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}
