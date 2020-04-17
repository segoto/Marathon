#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin>>n;
    string str;
    for(int i = 0 ; i < n; ++i){
        cin>>str;
        if(str[str.size()-1]=='u'){
            cout<<"JAPANESE\n";
        }
        else if(str[str.size()-1]=='o'){
            cout<<"FILIPINO\n";
        }
        else{
            cout<<"KOREAN\n";
        }
    }
    return 0;
}
