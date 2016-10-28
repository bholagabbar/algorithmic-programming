package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 11/21/2014 in IntelliJ
 */
class CIELAB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] nos = n.split(" ");
		int a = Integer.parseInt(nos[0]);
		int b = Integer.parseInt(nos[1]);
		StringBuffer sb = new StringBuffer();
		String ans1 = Integer.toString(a - b);
		int fd = ans1.length();
		if (fd == Integer.parseInt(ans1.substring(ans1.length() - 1, ans1.length()))) {
			fd = ans1.length() + 1;
		}
		if (ans1.length() > 1) {
			sb.append(ans1.substring(0, ans1.length() - 1) + fd);
		} else {
			sb.append(fd);
		}
		System.out.println(sb);
		
	}
}
/*
*FENIL'S SOLUTION WITH 0.08 secs less runtime*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

          class CIELAB_FENIL
              {
              public static void main(String[] args) throws IOException
                  {
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  String n=br.readLine();
                  String[]nos=n.split(" ");
                  int a= Integer.parseInt(nos[0]);
                  int b= Integer.parseInt(nos[1]);
                  int ans=a-b;
                  if(ans%10==9)
                      {
                      System.out.println(ans-1);
                      }
                  else
                      {
                      System.out.println(ans+1);
                      }
                  }
              }
 */