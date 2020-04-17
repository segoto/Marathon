#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int n,goal;
    cin>>n>>goal;
    n--;
    int arr[n];
    for(int i = 0 ; i < n; ++i){
        cin>>arr[i];
    }
    goal--;
    int visit[n];
    memset(visit, 0, sizeof(visit));
    int i =0;
    while(i<=n-1){
        visit[i] = 1;
        i+=arr[i];
    }
    if(visit[goal]){
        cout<<"YES";
    }
    else{
        cout<<"NO";
    }
    return 0;
}
