#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int t,n;
    cin>>t;
    for(int c = 1; c<=t; ++c){
        vector<pii> ans;
        cin>>n;
        int rows = min(30,n);
        vector<bool> pascal;
        pascal.resize(rows,0);
        n-=rows;
        for(int i = rows-1; i>=0;--i){
            if(n>=(1<<i)-1){
                pascal[i] = 1;
                n-=(1<<i)-1;
            }
        }
        rows+=n;
        pascal.resize(rows,0);
        bool dir = 1; //1 right. 0 left
        for(int i = 0; i < rows;++i){
            if(pascal[i]){
                if(dir){
                    for(int j = 0; j <=i; ++j){
                        ans.push_back({i+1,j+1});
                    }
                }
                else{
                    for(int j = i; j>=0; --j){
                        ans.push_back({i+1,j+1});
                    }
                }
                dir^=1;
            }
            else{
                if(dir){
                    ans.push_back({i+1,1});
                }
                else{
                    ans.push_back({i+1,i+1});
                }
            }
        }
        cout<<"Case #"<<c<<":\n";
        for(int i = 0 ; i < ans.size();++i){
            cout<<ans[i].first<<" "<<ans[i].second<<"\n";
        }
    }
    return 0;
}
