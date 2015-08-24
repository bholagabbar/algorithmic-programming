    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    class PERMUT2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cnt = 0;
            String[] ans = new String[100000];
            int cnta = 0;
            int no = Integer.parseInt(br.readLine());
            while (no != 0) {
                int[] n = new int[no];
                int[] in = new int[no];
                int flag = 1, i = -1;
                cnt = 0;
                String sk = br.readLine();
                StringBuilder bl = new StringBuilder(sk);
                bl.insert((sk.length()), ' ');
                String s2 = String.valueOf(bl);
                String s1 = "";
                for (int k = 0; k < s2.length(); k++) {
                    if (s2.charAt(k) != ' ') {
                        s1 += s2.charAt(k);
                    } else if ((s2.charAt(k) == ' ')) {
                        s1 = s1.trim();
                        i++;
                        int r = Integer.parseInt(s1);
                        n[i] = r;
                        cnt++;
                        in[n[i] - 1] = cnt;
                        s1 = "";
                    }
                }
                /*for(int k=0;k<no;k++) {

                    System.out.println(n[k]+"\t"+in[k]);
                }*/
                for (int k = 0; k < no; k++) {

                    if (n[k] != in[k]) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    ans[cnta] = "ambiguous";
                    cnta++;

                } else {
                    ans[cnta] = "not ambiguous";
                    cnta++;
                }
                no = Integer.parseInt(br.readLine());
            }

            for(int i = 0;i<cnta;i++)
            {
                System.out.println(ans[i]);
            }
        }
    }
