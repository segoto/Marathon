#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int n,k;;
    cin>>n;
    for(int i = 0 ; i < n; ++i){
        cin>>k;
        int graph[2*k][2*k];
        int a,b,c;

        cin>>a>>b>>c;
        for(int j = 0 ; j < 2*k; ++j){
            graph[a-1][b-1] = c;
            graph[b-1][a-1] = c;
        }

    }
    return 0;
}
