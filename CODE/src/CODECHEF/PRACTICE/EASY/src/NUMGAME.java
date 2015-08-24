    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    class NUMGAME
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine());
            String[] ans = new String[10000];
            int cnt2 = 0;
            for (int i = 0; i < tc; i++)
            {
                int cnt = 0;
                long md=0;
                long n = Long.parseLong(br.readLine());
                    if ((n % 2 != 0))
                    {
                        System.out.println("BOB");

                    } else if ((n % 2 == 0))
                    {
                        System.out.println("ALICE");

                    }

                }
            }
    }

