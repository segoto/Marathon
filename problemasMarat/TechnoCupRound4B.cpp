#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t, n;
    cin>>t;

    for(int i = 0 ; i < t; ++i){
        int ans = 0;
        cin>>n;
        set<int> a;
        vector<int> realA;
        for(int j = 0 ; j < n; ++j){
            int ai;
            cin>>ai;
            if(a.find(ai)== a.end()){
                    realA.push_back(ai);
                    a.insert(ai);

            }
        }
        sort(realA.begin(), realA.end());

        for(int k = realA.size()-1; k>=0; --k ){
            if(realA.at(k)%2 == 1){
                continue;
            }
            else if((realA.at(k)/2) % 2 == 1){
                ans+=1;
            }
            else{
                int ai = realA.at(k)/2;
                bool estaOImpar = false;
                while (!estaOImpar){
                    ans++;
                    if((ai) % 2 == 1 || a.find(ai)!= a.end()){
                        estaOImpar = true;
                    }

                    ai = ai/2;
                }
            }
        }
        cout<<ans<<"\n";
    }
    return 0;
}
