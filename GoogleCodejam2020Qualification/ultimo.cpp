#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int t;
    cin>>t;
    for(int i = 1; i <=t; i++){
        int n,k;
        cin>>n>>k;
        vector<array<int, n>> totalSums;
        int initial[n];
        memset(initial, 1, sizeof(initial));
        initial[n-1] = k-n+1;
        totalSums.push_back(initial);
        int i = 1;
        bool termino = 1;
        while(termino){
            if(n-i-1>=0){
                if(initial[n-i]-1 >= initial[n-i-1]+1){
                    initial[n-i]-=1;
                    initial[n-i-1]+=1;
                    totalSums.push_back(initial);
                }
                else{
                    i++;
                }
            }
            else{
                termino = 0;
            }
        }
        for(int j = 0; j < totalSums.size();j++){
            string s = "";
            for(int l = 0 ; l < 4; l++){
                s+= totalSums[j][k]+" ";
            }
            cout<<s<<"\n";
        }

    }
    return 0;
}
