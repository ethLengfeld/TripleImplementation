#include <iostream>

using namespace std;

void swap(int *x, int *y) {
	int temp = *x;
	*x = *y;
	*y = temp;
}

int partition(int array[], int low, int high) {
	int pivot = array[high];
	int i = low - 1;

	for (int j = low; j < high; j++) {
		if (array[j] <= pivot) {
			i++;
			swap(&array[i], &array[j]);
		}
	}
	swap(&array[i+1], &array[high]);
	return (i + 1);
}

void quickSort(int array[], int low, int high) {
	if (low < high) {
		int pivot = partition(array, low, high);

		quickSort(array, low, pivot-1);

		quickSort(array, pivot + 1, high);
	}
}

void printArray(int array[], int sizeOfArray) {
	for(int i = 0; i < sizeOfArray; i++) {
		cout << array[i] << " ";
	}
}
int main() {
	int array [5] = { 3, 2, 8, 6, 2};
	int sizeOfArr = sizeof(array);
	cout << "Size of array is " << sizeOfArr;
	quickSort(array, 0, sizeof(array)-1);

	printArray(array, sizeOfArr);
	
	return 0;
}
