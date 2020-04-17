#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int ties, scarves, vests, jackets, e, f;
    cin>>ties>>scarves>>vests>> jackets>>e>>f;
    int tipoA = min(ties, jackets);
    int tipoB = min(scarves, min(vests, jackets));

        if(e>f){
            jackets-=tipoA;
            int mult = min(jackets, tipoB);
            cout<< tipoA*e+f*mult;
        }
        else{
            jackets-=tipoB;
            int mult = min(jackets, tipoA);
            cout<<tipoB*f+e*mult;
        }



    return 0;
}
