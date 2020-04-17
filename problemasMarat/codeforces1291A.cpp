#include <bits/stdc++.h>
#include <string>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t,n,act, temp;
    string num;
    string s;
    bool no = true;
    cin>>t;
    while(t--){
        cin>>n>>num;
        act = 0;
        s = "";
        while(n--){
             temp =  (num[n]-'0');
            if(temp % 2 == 1){
                act+= (num[n]%10);
                s = to_string((temp%10)) + s;
                if(act % 2 == 0){
                    cout<<s<<"\n";
                    no = false;
                    break;
                }
            }
        }
        if(no){
            cout<<-1<<"\n";
        }
        no = true;
    }
    return 0;
}
