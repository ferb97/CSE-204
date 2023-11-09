#include<iostream>
#include<algorithm>
using namespace std;
int main()
{

    int N, K;
    scanf("%d%d", &N, &K);

    int *price = new int[N];
    for(int i = 0; i < N; i++){
        cin >> price[i];
    }
    sort(price, price + N);

    long long minimumcost = 0;
    int multiplier = 1, temp = 0;

    for(int i = N - 1; i >= 0; i--){

        temp++;
        minimumcost += price[i] * multiplier;

        if(temp == K){
           temp = 0;
           multiplier++;
        }
    }

    cout << minimumcost << endl;
    delete price;

    return 0;
}
