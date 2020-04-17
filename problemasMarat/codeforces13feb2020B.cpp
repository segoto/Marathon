#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int t, l,counterminus1;
    cin>>t;
    while(t--){
        cin>>l;
        int arr[l];
        counterminus1 =0;
        for(int i = 0 ; i < l; ++i){
            cin>>arr[i];
            if(arr[i]<0){
                counterminus1++;
            }
        }
        if(counterminus1==l){
            cout<<"0 0\n";
        }
        else if(l-counterminus1 == 1){
            for(int i = 0 ; i < l; ++i){
                if(arr[i]!=-1){
                    cout<<"0 "<<arr[i]<<"\n";
                    break;
                }
            }
        }
        else{
            int minimum = 1000000001;
            int maximum = -1;
            for(int i = 1; i < l-1 ; i++){
                if((arr[i-1] == -1||arr[i+1]==-1) && arr[i]!=-1 && arr[i]<minimum){
                    minimum = arr[i];
                }
                if((arr[i-1] == -1||arr[i+1]==-1) && arr[i]!=-1 && arr[i]>maximum){
                    maximum = arr[i];
                }
            }
            if(arr[0]!=-1 && arr[1]==-1){
                if(arr[0]<minimum){
                    minimum = arr[0];
                }
                if(arr[0]>maximum){
                    maximum = arr[0];
                }
            }
            if(arr[l-1]!=-1 && arr[l-2]==-1){
                if(arr[l-1]<minimum){
                    minimum = arr[l-1];
                }
                if(arr[l-1]>maximum){
                    maximum = arr[l-1];
                }
            }
            int f,s;
            int num = (maximum+minimum)/2;
            int dif =0;
            for(int i = 0; i < l-1; ++i){
                f = arr[i];
                s = arr[i+1];
                if(f ==-1){
                    f= num;
                }
                if(s == -1){
                    s =num;
                }
                if(dif<abs(f-s)){
                    dif = abs(f-s);
                }
            }
            cout<<dif<<" "<<num<<"\n";
        }
    }
    return 0;
}
