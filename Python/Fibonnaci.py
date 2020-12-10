def fib(n):
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    f1 = 1
    f2 = 1
    value = f1 + f2
    for i in range(2,n):
        value = f1 + f2
        f1 = f2
        f2 = value
    return value
    

def testFib():
    if(fib(3) == 2):
        print("3rd term in Fibonacci is 3")
    if(fib(7) == 13):
        print("7th term in Fibonacci is 13")
    
testFib()