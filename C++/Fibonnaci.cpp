#include <iostream>

int fib(int n) {
    if (n == 0) {
        return 0;
    }
    if (n == 1 || n == 2) {
        return 1;
    }

    int f1 = 1;
	int f2 = 1;
	int value = f1 + f2;
	for (int i = 2; i < n; i++) {
		value = f1 + f2;
		f1 = f2;
		f2 = value;
	}
    return value;
}

int main() {
    std::cout << "Calling Fibonnaci method!" << std::endl;
    int term = 6;
	int value = fib(term);
    if (value == 8) {
        std::cout << "Value of term " << term << " in Fibonnaci sequence is " << value << std::endl;
    }
}
