#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
    string s1, s2;
    cin >> s1 >> s2;

    int n1 = s1.size();
    int n2 = s2.size();

    int** dp = new int*[n1 + 1];
    int** prev = new int*[n1 + 1];
    int i, j;

    for(i = 0; i <= n1; i++){
        dp[i] = new int[n2 + 1];
        prev[i] = new int[n2 + 1];
    }

    for(i = 0; i <= n1; i++){
        for(j = 0; j <= n2; j++){
            prev[i][j] = 0;
        }
    }

    for(i = 0; i <= n1; i++){
        for(j = 0;j <= n2; j++){

            if(i == 0 || j == 0)
                dp[i][j] = 0;

            else if(s1[i - 1] == s2[j - 1]){
                dp[i][j] = dp[i - 1][j - 1] + 1;
                prev[i][j] = 1;
            }

            else if(dp[i - 1][j] >= dp[i][j - 1]){
                dp[i][j] = dp[i - 1][j];
                prev[i][j] = 2;
            }

            else{
                dp[i][j] = dp[i][j - 1];
                prev[i][j] = 3;
            }

        }
    }

    cout << dp[n1][n2] << endl;

    string lcs;
    i = n1;
    j = n2;

    while(dp[i][j] != 0){

        if(prev[i][j] == 1){
            lcs += s1[i - 1];
            i--;
            j--;
        }

        else if(prev[i][j] == 2){
            i--;
        }

        else{
            j--;
        }

    }

    reverse(lcs.begin(), lcs.end());
    cout << lcs << endl;

    for(i = 0; i <= n1; i++){
        delete[] dp[i];
        delete[] prev[i];
    }

    delete[] dp;
    delete[] prev;

    return 0;
}
