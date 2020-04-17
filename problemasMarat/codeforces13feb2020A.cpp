#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    int t, tam;
    cin>>t;
    string a,b,c;
    bool yes = 1;
    while(t--){
        cin>>a>>b>>c;
        tam = a.length();
        yes = 1;
        for(int i = 0 ; i < tam; ++i){
            if(a[i]!=b[i] && (b[i]!= c[i] && a[i]!= c[i])){
                cout<<"NO\n";
                yes = 0;
                break;
            }
            else if(a[i]==b[i] && a[i]!=c[i]){
                cout<<"NO\n";
                yes = 0;
                break;
            }
        }
        if(yes){
            cout<<"YES\n";
        }

    }

    return 0;
}
