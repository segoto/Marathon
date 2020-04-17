#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int n,m;
    cin>>n>>m;
    int dp[n][m];
    int aux[n][m];
    dp[0][0] = 1;
    aux[0][0] = 1;
    for(int j = 1; j < m; ++j){
        dp[0][j] = 1;
        aux[0][j] = 1;
    }
    int modal = 1000000007;
    for(int i = 1; i < n; ++i){
        dp[i][0] = i+1 + dp[i-1][0];
        aux[i][0] = aux[i-1][0] + dp[i][0];
    }
    for(int i = 1; i < n; ++i){
        for(int j = 1; j < m; ++j){
            dp[i][j] = aux[i][j-1]+dp[i-1][j];
            dp[i][j] %= modal;
            aux[i][j] = aux[i-1][j] + dp[i][j];
            aux[i][j] %= modal;
        }
    }
    cout<<dp[n-1][m-1];
    return 0;
}
