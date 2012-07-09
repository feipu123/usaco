/*
ID: czpcxfz1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.regex.*;

public class t1986 {
	public static void t1986main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder reg = new StringBuilder();
		reg.append(in.readLine());
		
		String sent;
		Pattern pattern = Pattern.compile(reg.toString());
		Matcher matcher;
		while (in.ready()) {
			sent = in.readLine();
			matcher = pattern.matcher(sent);
			if (matcher.find()) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		System.exit(0);
	}
}
