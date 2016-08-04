#include <iostream>

int main() {
    int b[3];
    b[0] = 10;
    b[1] = 21;
    //std::cout <<  b << " " << b+1 << " " << b+2 << '\n';
    std::cout << *(b+1) << "\n";
    std::cout << *b + 1;
    return 0;
}