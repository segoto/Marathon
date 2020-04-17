#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    set<char> notDamaged;
    int n, notDa;
    cin>> n >> notDa;
    string str;
    cin>>str;
    char s;
    for(int i = 0 ; i < notDa; ++i){
        cin>>s;
        notDamaged.insert(s);
    }
    long long ans = 0;
    long long contiguous = 0;
    for(int i = 0; i < n; ++i ){

        if(notDamaged.find(str[i])!= notDamaged.end()){

            ++contiguous;
        }
        else{
            ans +=((contiguous*(contiguous+1))/2);
            contiguous = 0;
        }
    }
    ans+= ((contiguous*(contiguous+1))/2);
    cout<<ans;
    return 0;
}
