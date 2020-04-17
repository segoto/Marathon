#include <bits/sdtc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string str;
    cin>>str;
    int n;
    cin>>n;
    string arr[n];
    int a,b;
    for(int i = 0 ; i < n; ++i){
        cin>>a>>b;
        arr[i] = str.substr(a-1,b-1);
    }

    return 0;
}
