#include <bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i  = 0 ; i < n; ++i){
            cin>>arr[i];
        }
        int maxDif = 0;
        for(int i = 1; i < n; ++i){
            int dif = arr[i-1]-arr[i];
            if(dif>0){
                arr[i] = arr[i-1];
                if(dif>maxDif){

                    maxDif = dif;
                }
            }
        }

        int countPos = 0;
        while(maxDif){
            maxDif>>=1;

            countPos++;
        }
        cout<<countPos<<endl;
    }
    return 0;
}
