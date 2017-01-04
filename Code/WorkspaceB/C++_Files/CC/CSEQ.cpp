#include <stdio.h>
using namespace std;

/* This function calculates power of p in n! */
long countFact(long n, long p) {
    long k = 0;
    while (n >= p) {
        k += n / p;
        n /= p;
    }
    return k;
}

/* This function calculates (a^b)%MOD */
long long pow(long a, long b, long MOD) {
    long long x = 1, y = a;
    while (b > 0) {
        if (b % 2 == 1) {
            x = (x * y);
            if (x > MOD) x %= MOD;
        }
        y = (y * y);
        if (y > MOD) y %= MOD;
        b /= 2;
    }
    return x;
}

/* Using Euler's Theorem */
long long InverseEuler(long n, long MOD) {
    return pow(n, MOD - 2, MOD);
}

long long factMOD(long n, long MOD) {
    long long res = 1;
    while (n > 0) {
        for (int i = 2, m = n % MOD; i <= m; i++)
            res = (res * i) % MOD;
        if ((n /= MOD) % 2 > 0)
            res = MOD - res;
    }
    return res;
}
long long C(long n, long r, long MOD) {
    if (countFact(n, MOD) > countFact(r, MOD) + countFact(n - r, MOD))
        return 0;

    return (factMOD(n, MOD) *
            ((InverseEuler(factMOD(r, MOD), MOD) *
              InverseEuler(factMOD(n - r, MOD), MOD)) % MOD)) % MOD;
}

int main() {
    int t;
    long p = 1000000 + 3;
    scanf("%d", &t);
    while (t--) {
        long long n, a, b;
        scanf("%ld%ld%ld", &n, &a, &b);
        long long ans = (C(n + (b - a + 1), (b - a + 1), p) - 1) + p; //as ans can go -ve
        printf("%lld\n", (ans % p));
    }
}