package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/5/2014 in IntelliJ
 */
class BUY1GET1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s = (br.readLine()).split("");
			Arrays.sort(s);
			int len = s.length;
			String s1 = "";
			for (int j = 0; j < len; j++) {
				s1 += s[j];
			}
			s1 = s1.trim();
			int len1 = s1.length();
			int cost = 0;
			int in1 = 0, in2 = s1.lastIndexOf(s1.charAt(in1));
			while (in2 <= (len1 - 1)) {
				if ((in2 - in1) % 2 == 0) {
					cost += ((in2 - in1) / 2) + 1;
				} else if ((in2 - in1) % 2 != 0) {
					cost += ((in2 - in1) / 2) + 1;
				}
				in1 = in2 + 1;
				if (in1 == len1) {
					break;
				} else {
					in2 = s1.lastIndexOf(s1.charAt(in1));
				}
			}
			System.out.println(cost);
		}
	}
}



        /*ANSWER MATCHES BUT NOT GETTING ACCEPTED

            {
            String[] s = (br.readLine()).split("");
            Arrays.sort(s);
            int len = s.length;
            int cost = 0;
            for(int j=0;j<len;j++)
                {
                if(j!=len-1&&(s[j].compareTo(s[j+1])==0))
                    {
                    cost++;
                    j++;
                    }
                else if(j!=len-1&&(s[j].compareTo(s[j+1])!=0))
                    {
                    cost++;
                    }
                else if(j==len-1)
                    {
                    cost++;
                    }
                }
            if(i!=t-1)
                {
                sb.append(cost + "\n");
                }
            else if(i==t-1)
                {
                sb.append(cost);
                }
            }
        System.out.println(sb);
        }
    }*/


