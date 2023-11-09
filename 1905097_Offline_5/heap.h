#include<iostream>
#include<cassert>
#include<vector>
using namespace std;

class Heap{
private:
    int* heap;
    int maxsize;
    int n;

    void siftdown(int pos){
        while (!isLeaf(pos)){
            int l = leftchild(pos);
            int r = rightchild(pos);
            if(r < n && heap[l] < heap[r])
                l = r;
            if (heap[pos] > heap[l])
                return;
            swap(heap[pos], heap[l]);
            pos = l;
        }
    }

    bool isLeaf(int pos) const{
        return (pos >= n / 2) && (pos < n);
    }

    int leftchild(int pos) const{
        return 2*pos + 1;
    }

    int rightchild(int pos) const{
        return 2*pos + 2;
    }

    int parent(int pos) const{
        return (pos - 1)/2;
    }

    void buildHeap(){
        for (int i = n/2 - 1; i >= 0; i--)
            siftdown(i);
    }

public:

    Heap(int max){
        heap = new int[max];
        n = 0;
        maxsize = max;
    }

    Heap(vector<int> numbers){
        maxsize = numbers.size();
        n = numbers.size();
        heap = new int[maxsize];
        for(int i = 0; i < numbers.size(); i++){
            heap[i] = numbers[i];
        }
        buildHeap();
    }

    ~Heap(){
        delete heap;
    }

    int size() const{
        return n;
    }

    void insert(int it){
        assert(n < maxsize);
        int curr = n++;
        heap[curr] = it;

        while (curr != 0 && heap[curr] > heap[parent(curr)]){
            swap(heap[curr], heap[parent(curr)]);
            curr = parent(curr);
        }
    }

    int getMax(){
        if(n == 0)
          return NULL;
        return heap[0];
    }

    int deleteKey(){
        assert (n > 0);
        swap(heap[0], heap[--n]);
        if (n != 0)
            siftdown(0);
        return heap[n];
    }

};

void heapsort(vector<int>&numbers){
    Heap h(numbers);
    for(int i = 0; i < numbers.size(); i++){
        numbers[i] = h.deleteKey();
    }
}
