package CODECHEF.PRACTICE.EASY.src;

import java.util.Scanner;

/**
 * Created by Shreyans on 12/2/2014 in IntelliJ
 */
class RECIPE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int y = 0; y < n; y++) {
				a[y] = sc.nextInt();
			}
			int n1[] = pfact(a[0]);
			int cnt = 0;
			while (n1[cnt] != 0) {
				cnt++;
			}
			int pi = 0;
			while (pi < cnt) {
				int flag = 1;
				for (int k = 0; k < n; k++) {
					if (a[k] % n1[pi] != 0) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					for (int l = 0; l < n; l++) {
						a[l] = a[l] / n1[pi];
					}
				} else {
					pi++;
				}
			}
			
			for (int k = 0; k < n; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println("\n");
		}
	}
	
	private static int[] pfact(int n2) {
		int[] pf = new int[n2];
		int cnt = 0;
		int t = n2;
		for (int i = 2; i <= t / 2; i++) {
			if (n2 % i == 0) {
				pf[cnt] = i;
				cnt++;
				while (n2 % i == 0) {
					n2 = n2 / i;
				}
			}
			if (n2 == 1) {
				break;
			}
		}
		if (n2 > 1) {
			pf[cnt] = n2;
		}
		return (pf);
	}
}


    /* FASTER BUFFERED READER ONE NOT GETTING ACCEPTED (NZEC)
    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
    class progtest
        {
        public static void main(String[] args)
            {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try
                {
                int t = Integer.parseInt(br.readLine());
                for (int i = 0; i < t; i++)
                    {
                    String s=br.readLine();
                    int n = s.charAt(0)-48;
                    int[] a = new int[n];
                    String s1[]=s.split(" ");
                    int cn=0;
                    for (int y = 1; y < s1.length; y++)
                        {
                        a[cn]= Integer.parseInt(s1[y]);
                        cn++;
                        }
                    int n1[] = pfact(a[0]);
                    int cnt = 0;
                    while (n1[cnt] != 0)
                        {
                        cnt++;
                        }
                    int pi = 0;
                    while (pi < cnt)
                        {
                        int flag = 1;
                        for (int k = 0; k < n; k++)
                            {
                            if (a[k] % n1[pi] != 0)
                                {
                                flag = 0;
                                break;
                                }
                            }
                        if (flag == 1)
                            {
                            for (int l = 0; l < n; l++)
                                {
                                a[l] = a[l] / n1[pi];
                                }
                            } else
                            {
                            pi++;
                            }
                        }

                    for (int k = 0; k < n; k++)
                        {
                        System.out.print(a[k] + " ");
                        }
                    System.out.println("\n");
                    }

                } catch (NumberFormatException e) {

            } catch (IOException e) {

            }

            }
        private static int[] pfact(int n2)
            {
            int[] pf=new int[n2];
            int cnt=0;
            int t=n2;
            for(int i=2;i<=t/2;i++)
                {
                if (n2 % i == 0)
                    {
                    pf[cnt] = i;
                    cnt++;
                    while (n2 % i == 0)
                        {
                        n2=n2/i;
                        }
                    }
                if(n2==1)
                    {
                    break;
                    }
                }
            if(n2>1)
                {
                pf[cnt] = n2;
                }
            return(pf);
            }
        }
*/