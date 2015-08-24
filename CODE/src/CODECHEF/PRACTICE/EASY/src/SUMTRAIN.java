import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SUMTRAIN {
    public static void main(String[] args) throws IOException

    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nu = Integer.parseInt(br.readLine());
        int k,i,j,cnt1=0;
        int [] fa =new int[nu];
        for (int l = 0; l < nu; l++)
        {
            int no = Integer.parseInt(br.readLine());
            int[][] a = new int[no][no];
            for (k = 0; k < no; k++)
            {
            String st=br.readLine();
                    String st1[]=st.split(" ");
                for(int r=0;r<st1.length;r++)
                {
                    a[k][r]=Integer.parseInt(st1[r]);
                }

            }

            for (i = 1; i < no; i++) {
                for (j = 0; j <= i; j++) {
                    if (j == 0) {
                        a[i][j] += a[i - 1][0];
                    } else if (j == i) {
                        a[i][j] += a[i - 1][i - 1];
                    } else {
                        int temp1, temp2, max = 0;
                        temp1 = a[i - 1][j - 1];
                        temp2 = a[i - 1][j];
                        if (temp1 > temp2) {
                            max = temp1;
                        } else {
                            max = temp2;
                        }
                        a[i][j] += max;
                    }
                }
            }
            int max2 = 0;
            for (j = 0; j < no; j++) {
                if ((a[no - 1][j]) > max2) {
                    max2 = a[no - 1][j];
                }
            }
            fa[cnt1]=max2;
            max2=0;
            cnt1++;
        }
        StringBuilder sb =new StringBuilder();
        for (int y :fa )
        {
            sb.append(y + "\n");
        }
        System.out.println(sb);

    }
}


