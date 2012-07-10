/*
ID: czpcxfz1
LANG: JAVA
TASK: calfflac
*/
import java.io.*;
import java.util.*;
import java.lang.Character;


class calfflac {
	public static char[] ch;
	public static int len;
	public static int back(int x) {
		--x;
		while (x >= 0 && !Character.isLetter(ch[x])) --x;
		return x;
	}
	public static int forth(int x) {
		++x;
		while (x < len && !Character.isLetter(ch[x])) ++x;
		return x;
	}
  public static void main(String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("calfflac.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
    ch = new char[21000];
    len = f.read(ch, 0, 21000);
    int bestlen = 0, bestpos = 21000, bestposq = 0;
    //String best;
    int p = 0, q = 0, pp = 0, qq = 0, l = 0;
    for (int i = 0; i < len; ++i) {
    	if (!Character.isLetter(ch[i])) continue;
    	p = i;
    	q = i;
    	l = 1;
    	pp = back(i);
    	qq = forth(i);
    	while (pp >= 0 && qq < len) {
    		if (Character.toLowerCase(ch[pp])!= Character.toLowerCase(ch[qq])) break;
    		p = pp;
    		q = qq;
    		pp = back(pp);
    		qq = forth(qq);
    		l += 2;
    	}
    	if (l > bestlen || (l == bestlen && p < bestpos)) {
    		bestlen = l;
    		bestpos = p;
    		bestposq = q;
    	}
    }
    for (int i = 0; i < len - 1; ++i) {
    	if (!Character.isLetter(ch[i])) continue;    	
    	p = i + 1;
    	q = i;
    	l = 0;
    	pp = back(i + 1);
    	qq = forth(i);
    	if (Character.toLowerCase(ch[pp]) != Character.toLowerCase(ch[qq])) continue;
    	while (pp >= 0 && qq < len) {
    		if (Character.toLowerCase(ch[pp])!= Character.toLowerCase(ch[qq])) break;
    		p = pp;
    		q = qq;
    		pp = back(pp);
    		qq = forth(qq);
    		l += 2;
    	}
    	if (l > bestlen || (l == bestlen && p < bestpos)) {
    		bestlen = l;
    		bestpos = p;
    		bestposq = q;
    	}
    }
    out.println(bestlen);
    out.println(new String(ch, bestpos, bestposq - bestpos + 1));
     //StringTokenizer st = new StringTokenizer(f.readLine());
    //String ori = st.nextToken(), best;
    //int bestlen = 1;
    //for (int i = 1; i < ori.length() - 1; ++i) {
    	
    //}
    //for (int i = 0; i < ori.length() - 1; ++i) {
    	
    //}
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}
