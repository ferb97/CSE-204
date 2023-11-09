#include<iostream>
using namespace std;
int main()
{
    int n;
    cin >> n;

    int **arr = new int*[n];
    for(int i = 0; i < n; i++){
        arr[i] = new int[n];
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
        }
    }

    int len = 1 << n;
    int* dp = new int[len];

    dp[0]=0;
    for(int i = 1; i < len; i++){
        dp[i] = 1000007;
    }

    for(int i = 1; i < len; i++){
        for(int j = 0; j < n; j++){

            int b = 1 << j;

            if(i & b){
                int cost = arr[j][j];
                int c = i ^ b;

                for(int k = 0; k < n; k++){

                    int d = 1 << k;
                    if(c & d){
                        cost += arr[j][k];
                    }

                }

                dp[i] = min(dp[i], dp[c] + cost);
            }
        }
    }

    cout << dp[len - 1] << endl;

    for(int i = 0; i < n; i++){
        delete[] arr[i];
    }

    delete[] arr;
    delete[] dp;

    return 0;
}
