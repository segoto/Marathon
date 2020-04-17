#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int r,h;
    cin>>r>>h;
    int ans = (h/r);
    h-=(r*ans);
    ans*=2;
    if(4LL*h*h>= 3LL*r*r){
        ans+=3;
    }
    else if(2LL*h>=r){
        ans+=2;
    }
    else{
        ++ans;
    }
    cout<<ans;
    return 0;
}
