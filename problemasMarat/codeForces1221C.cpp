#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int queries, c, m, x, d, ans;
    cin>> queries;
    for (int i = 0; i < queries; ++i){
        cin>> c>> m>> x;
        if (c > m){
            d = c - m;
            c -= d;
            x += d;
        }
        else{
            d = m - c;
            m -= d;
            x += d;
        }
        ans = min(c, min(m, x) );
        c -= ans;
        m -= ans;
        x -= ans;
        ans += ((c+m)/3);
        cout<<ans<<'\n';
    }
    return 0;
}
