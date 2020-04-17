#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int a = 11;
    int b = 111;
    int c = 1111;
    int d = 11111;
    int e = 111111;
    int f = 1111111;
    int g = 11111111;
    int h = 111111111;
    int n, q, ans,add;
    cin>> n;

    for(int i = 0 ; i < n; ++i){
        cin>> q;
        ans=0;
        add = q/10;
        if(add == 0){
                cout<<q;
        }
        else if(add>0 && add<=10){
            ans+=9;
            add = q/a;
            ans+=add;
            cout<<ans;
        }
        else if(add>10 && add<=100){
            ans+=18;
            add = q/b;
            ans+=add;
            cout<<ans;
        }
        else if(add>100 && add<=1000){
            ans+=27;
            add= q/c;
            ans+=add;
            cout<<ans;
        }
        else if(add>1000 && add<=10000){
            ans+=36;
            add = q/d;
            ans+=add;
            cout<<ans;
        }
        else if(add>10000&& add<=100000){
            ans+=45;
            add = q/e;
            ans+=add;
            cout<<ans;
        }
        else if(add>100000 && add<=1000000){
            ans+=54;
            add = q/f;
            ans+=add;
            cout<<ans;
        }
        else if(add>1000000 && add<=10000000){
            ans+=63;
            add = q/g;
            ans+=add;
            cout<<ans;
        }
        else{
            ans+=72;
            add = q/h;
            ans+=add;
            cout<<ans;
        }
        cout<<"\n";

    }
    return 0;

}
