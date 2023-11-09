#include<iostream>
#include<cstdlib>
#include<time.h>
#include<random>
#include<chrono>
#include<algorithm>
#include<fstream>

using namespace std;
using namespace std::chrono;


void mergesegments(int arr[], int const l, int const m, int const r){
    int const n1 = m - l + 1;
    int const n2 = r - m;

    int *leftarr = new int[n1];
    int *rightarr = new int[n2];

    for(int i = 0; i < n1; i++){
        leftarr[i] = arr[l + i];
    }

    for(int i = 0; i < n2; i++){
        rightarr[i] = arr[m + 1 + i];
    }

    int l1 = 0, r1 = 0, index = l;
    while(index <= r){
        if((l1 < n1) && (leftarr[l1] <= rightarr[r1] || r1 >= n2)){
            arr[index] = leftarr[l1];
            l1++;
        }
        else{
            arr[index] = rightarr[r1];
            r1++;
        }
        index++;
    }

    delete leftarr;
    delete rightarr;
}


void mergesort(int arr[], int const l, int const r){
    if(l >= r)
      return;
    int m = l + (r - l)/2;
    mergesort(arr, l, m);
    mergesort(arr, m + 1, r);
    mergesegments(arr, l, m, r);
}


int _partition(int arr[], int l, int r){
    int pivot = arr[r];
    int index = l;

    for(int j = l; j <= r-1; j++){
        if(arr[j] < pivot){
           swap(arr[index], arr[j]);
           index++;
        }
    }

    swap(arr[index], arr[r]);
    return index;
}


void quicksort(int arr[], int l, int r){
    if(l >= r)
       return;
    int index = _partition(arr, l, r);
    quicksort(arr, l, index - 1);
    quicksort(arr, index + 1, r);
}


int _randomizedpartition(int arr[], int l, int r){
    srand(time(NULL));
    int random = l + rand() % (r - l);
    swap(arr[random], arr[r]);
    return _partition(arr, l, r);
}


void randomizedquicksort(int arr[], int l, int r){
    if(l >= r)
       return;
    int index = _randomizedpartition(arr, l, r);
    randomizedquicksort(arr, l, index - 1);
    randomizedquicksort(arr, index + 1, r);
}


void insertionsort(int arr[], int n){
    for(int i = 1; i < n; i++){
        int temp = arr[i];
        int j = i - 1;

        while(j >= 0 && arr[j] > temp){
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }
}


double mergesorttime(int mergesortarr[], int n){
    double time1;
    high_resolution_clock::time_point starttime, endtime;

    starttime = high_resolution_clock::now();
    mergesort(mergesortarr, 0, n - 1);
    endtime = high_resolution_clock::now();

    time1 = duration_cast<milliseconds>(endtime - starttime).count();
    return time1;
}


double quicksorttime(int quicksortarr[], int n){
    double time1;
    high_resolution_clock::time_point starttime, endtime;

    starttime = high_resolution_clock::now();
    quicksort(quicksortarr, 0, n - 1);
    endtime = high_resolution_clock::now();

    time1 = duration_cast<milliseconds>(endtime - starttime).count();
    return time1;
}


double randomizedquicksorttime(int randomizedquicksortarr[], int n){
    double time1;
    high_resolution_clock::time_point starttime, endtime;

    starttime = high_resolution_clock::now();
    randomizedquicksort(randomizedquicksortarr, 0, n - 1);
    endtime = high_resolution_clock::now();

    time1 = duration_cast<milliseconds>(endtime - starttime).count();
	return time1;
}


double insertionsorttime(int insertionsortarr[], int n){
    double time1;
    high_resolution_clock::time_point starttime, endtime;

    starttime = high_resolution_clock::now();
    insertionsort(insertionsortarr, n);
    endtime = high_resolution_clock::now();

    time1 = duration_cast<milliseconds>(endtime - starttime).count();
    return time1;
}


double stlsorttime(int stlsortarr[], int n){
    double time1;
    high_resolution_clock::time_point starttime, endtime;

    starttime = high_resolution_clock::now();
    sort(stlsortarr, stlsortarr + n);
    endtime = high_resolution_clock::now();

    time1 = duration_cast<milliseconds>(endtime - starttime).count();
    return time1;
}


int main()
{
      int n_values[] = {5, 10, 100, 1000, 10000, 100000};
      ofstream myfile("Divide and conquer.txt");
      myfile<<",Time required in ms,,,,,,"<<endl;
      myfile<<"n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Input,STL sort() function"<<endl;

      for(int i = 0; i < 6; i++){

         double time[7];
         for(int j = 0; j < 7; j++){
            time[j] = 0.0;
         }
         int n = n_values[i];

         for(int k = 0; k < 20; k++){
            srand(10 + k);

            int *mergesortarr = new int[n];
            int *quicksortarr = new int[n];
            int *randomizedquicksortarr = new int[n];
            int *insertionsortarr = new int[n];
            int *stlsortarr = new int[n];

            for(int j = 0; j < n; j++){
                int temp = rand();
                mergesortarr[j] = temp;
                quicksortarr[j] = temp;
                randomizedquicksortarr[j] = temp;
                insertionsortarr[j] = temp;
                stlsortarr[j] = temp;
            }

		    time[0] += mergesorttime(mergesortarr, n);
		    time[1] += quicksorttime(quicksortarr, n);
		    time[2] += randomizedquicksorttime(randomizedquicksortarr, n);
		    time[3] += insertionsorttime(insertionsortarr, n);
		    time[4] += quicksorttime(quicksortarr, n);
		    time[5] += randomizedquicksorttime(randomizedquicksortarr, n);
		    time[6] += stlsorttime(stlsortarr, n);

		    delete mergesortarr;
		    delete quicksortarr;
		    delete randomizedquicksortarr;
		    delete insertionsortarr;
		    delete stlsortarr;
         }

         myfile<<n;
         for(int j = 0; j < 7; j++){
            time[j] /= 20.0;
            myfile<<","<<time[j];
         }

         myfile<<endl;

      }
      return 0;
}

