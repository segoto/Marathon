#include <bits/stdc++.h>

using namespace std;
#define ll long long
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int n;
    cin>>n;
    int arr[n];
    for(int i = 0; i < n; ++i){
        cin>>arr[i];
    }
    int counter = 1;
    ll resp = 0;
    int act = arr[0];
    for(int i = 1 ; i < n; ++i){
        if(act == arr[i]){
            counter++;
        }
        else{
            resp+=(1LL*counter*(counter+1))/2;
            counter = 1;
            act = arr[i];
        }
        if(i==n-1){
            resp+=(1LL*counter*(counter+1))/2;
        }
    }
    if(resp == 0){
        resp = 1;
    }
    cout<<resp;
    return 0;
}
