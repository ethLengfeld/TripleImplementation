# This problem was asked by Dropbox.
# What does the below code snippet print out? How can we fix the anonymous functions to behave as we'd expect?
functions = []
for i in range(10):
    functions.append(lambda: i)

for f in functions:
    print(f())

#     <function <lambda> at 0x7ff105fdebf8>
#     <function <lambda> at 0x7ff105ef10d0>
#     <function <lambda> at 0x7ff105ef1158>
#     <function <lambda> at 0x7ff105ef11e0>
#     <function <lambda> at 0x7ff105ef1268>
#     <function <lambda> at 0x7ff105ef12f0>
#     <function <lambda> at 0x7ff105ef1378>
#     <function <lambda> at 0x7ff105ef1400>
#     <function <lambda> at 0x7ff105ef1488>
#     <function <lambda> at 0x7ff105ef1510>