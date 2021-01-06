def swapElements(array, x, y):
    temp = array[x]
    array[x] = array[y]
    array[y] = temp
    

def quickSort(array, low, high):
    print('quickSort!')
    if not array:
        return array
    if low >= high:
        return array
    
    middle = (low + high) / 2
    pivot = array[middle]
    
    i = low
    j = high
    
    print('i:'+str(i))
    print('j:'+str(j))
    print('pivot:'+str(pivot))
    while i <= j:
        elementI = array[i]
        while array[i] < pivot:
            print('elementI:'+str(elementI))
            i+=1
            elementI = array[i]
    
        print('here0')
        elementJ = array[j]
        while array[j] > pivot:
            print('elementJ:'+str(elementJ))
            print('j:'+str(j))
            j -= 1

        if i >= j:
            print('Swapping elements!')
            swapElements(array, i, j)
            i += 1
            j -= 1
        
    if low < j:
        print('quickSort low, j')
        quickSort(array, low, j)
    if high > i:
        print('quickSort i, high')
        quickSort(array, i, high)
        
        
array = [3,1,8,3,2]
print(array[0])
quickSort(array, 0, len(array)-1)
print('array:'+str(array))