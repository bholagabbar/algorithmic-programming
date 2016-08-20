/*input
4 6
1 2
1 4
1 2
3 3
1 3
1 3
*/

#include <iostream>

int main() {
    int b[2][3];
    int cnt = 1;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            b[i][j] = cnt++;
        }
    }
    std::cout << b << " " << *b << "\n";
    std::cout << b+1 << " " << **b + 1 << '\n';
    std::cout <<  b << " " << b+1 << " " << (*b+2) << '\n';
    std::cout << *(b+1)+2 << " " << *(b+2) << " " << &b[1][2];
    return 0;
}