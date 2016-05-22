/*input
3
ababab ab
aaaaa bbb
aafafaasf aaf
*/
//Shreyans Sheth [bholagabbar]
 
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define PB push_back
#define MP make_pair
#define N 1000001
#define F first
#define S second
#define endl '\n'
 
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
 
const ll modPrime = 1e9 + 7;
const ll base = 257;
ll storedPowers[N];
 
void calculatePowers() {
	storedPowers[0] = 1;
    for (int i = 0; i < N; i++) {
    	storedPowers[i+1] = (base * storedPowers[i]) % modPrime;
    }
}

ll getStringHash(string s) {
	ll hashValue = 0;
    for (int i = 0; i < s.size(); i++) {
    	hashValue = hashValue * base + s[i];
    	hashValue %= modPrime;
    }
    return hashValue;
}
 
int main() {
	boostIO;
	calculatePowers();
	int tc;
	cin >> tc;
	while (tc--) {
		string text, pattern;
		cin >> text >> pattern;
		int textLen = text.size(), patternLen = pattern.size();
		ll basePower = storedPowers[patternLen];
		ll patternHash = getStringHash(pattern);
		ll currTextHash = getStringHash(text.substr(0, patternLen));
		vector<int> occurences;
		for (int i = patternLen; i <= textLen; i++) {
			if (patternHash == currTextHash) {
				occurences.PB(i - patternLen + 1);
			}
			if (i < textLen) {
				currTextHash = (currTextHash * base + text[i]) % modPrime;
				currTextHash -= (text[i - patternLen] * basePower) % modPrime;
				currTextHash = currTextHash < 0 ? currTextHash + modPrime : currTextHash;
			}
		}
		if (occurences.size() > 0) {
			cout << occurences.size() << endl;
			for (int i : occurences) {
				cout << i << " ";
			}
		} else {
			cout << "Not Found";
		}
		cout << endl << endl;
	}
	return 0;
}