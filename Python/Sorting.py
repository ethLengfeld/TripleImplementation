def swap (arr, x, y):
    temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp

def partition(arr, low, high):
    pivot = arr[high]
    i = (low - 1)
    
    for j in range(low, high):
        
        if arr[j] < pivot:
            i = i+1
            
            swap(arr, i, j)
    
    i = i + 1
    swap(arr, i, high)
    
    return i
    
def quickSort(arr, low, high):
    if low < high:
        
        pivot = partition(arr, low, high)
        
        quickSort(arr, low, pivot-1)
        quickSort(arr, pivot+1, high)
        
        
array = [3,1,8,3,2]
quickSort(array, 0, len(array)-1)
for i in range(len(array)):
    print("%d" %array[i])
print('array is:'+str(array))