#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int cases,L,U,R,D;
    cin>> cases;
    for(int i = 0; i < cases; ++i){
        L=0;
        U =0;
        R=0;
        D=0;
        string str;
        cin>>str;
        for(int j = 0 ; j < str.length(); ++j){
            if (str[j]==('L')) {
						++L;
					}
            else if (str[j]==('R')) {
						++R;
					}
            else if (str[j]==('U')) {
						++U;
                }
            else {
						++D;
                }
        }
        int substractLR = abs(L-R);
        int substractUD = abs(U-D);
        if(L>R){
            L-=substractLR;
        }
        else{
            R-=substractLR;
        }
        if(U>D){
            U-=substractUD;
        }
        else{
            D-=substractUD;
        }
        int tot = U+D+L+R;
        string s ="";
        if(U>0&&L>0 && D>0 && R>0){
            for(int j = 0 ; j < tot; ++j){
                        if(j < L) {
							s+="L";
						}
						else if (j<L+U) {
							s+="U";
						}
						else if(j<L+R+U) {
							s+="R";
						}
						else {
							s+="D";
						}
            }
            cout<<tot<<"\n"<<s<<"\n";
        }
        else if((U>=0 && D==0 &&(L>0 || R>0))||D>=0 && U==0 &&(L>0 || R>0)){
            cout<<2<<"\nLR\n";
        }
        else if((L>=0 && R==0 &&(U>0 || D>0))||R>=0 && L==0 &&(U>0 || D>0)){
            cout<<2<<"\nUD\n";
        }
        else if (U>=0 && R>=0 && D==0 && L==0 || D>=0 && R>=0 && D==0 && L==0|| U>=0 && L>=0 && D==0 && R==0||D>=0 && L>=0 && U==0 && R==0){
            cout<<0<<"\n\n";
        }
    }
    return 0;
}
