#include <iostream>

int main() {

    char operation;
    float num1;
    std::cout << "Welcome to the C++ calculator!" << std::endl << "Enter your first number: ";
    std::cin >> num1;

    float num2;
    std::cout << "Second number: ";
    std::cin >> num2;

    std::cout << "Enter operation you would like to perform (+,-,*,/): ";
    std::cin >> operation;

    switch(operation) {
        case '+':
            std::cout << num1 << "+" << num2 << "=" << num1+num2;
            break;
        case '-':
            std::cout << num1 << "-" << num2 << "=" << num1-num2;
            break;
        case '*':
            std::cout << num1 << "*" << num2 << "=" << num1*num2;
            break;
        case '/':
            std::cout << num1 << "/" << num2 << "=" << num1/num2;
            break;
    }

}