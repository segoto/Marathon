#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int n, sx,sy;
    cin>>n>>sx>>sy;
    int cix,ciy;
    int unoDos = 0;
    int dosTres = 0;
    int tresCuatro = 0;
    int cuatroUno = 0;
    for(int i = 0 ; i < n; ++i){
        cin>>cix>>ciy;
        cix-=sx;
        ciy-=sy;

        if(cix==0 && ciy>0){
            unoDos++;
        }
        else if(cix==0 && ciy<0){
            tresCuatro++;
        }
        else if(ciy==0 && cix<0){
            dosTres++;

        }
        else if(ciy==0 && cix>0){
            cuatroUno++;
        }
        else if(cix<0 && ciy<0){
            tresCuatro++;
            dosTres++;
        }
        else if(cix<0 && ciy>0){
            unoDos++;
            dosTres++;
        }
        else if(cix>0 && ciy>0){
            unoDos++;
            cuatroUno++;
        }
        else if(cix>0 && ciy<0){

            tresCuatro++;
            cuatroUno++;
        }
    }

    if(max(unoDos, max(dosTres, max(tresCuatro,cuatroUno)))==unoDos){
        cout<<unoDos<<"\n"<<sx<<" "<<sy+1;
    }
    else if(max(unoDos, max(dosTres, max(tresCuatro,cuatroUno)))==dosTres){
        cout<<dosTres<<"\n"<<sx-1<<" "<<sy;
    }
    else if(max(unoDos, max(dosTres, max(tresCuatro,cuatroUno)))==tresCuatro){
        cout<<tresCuatro<<"\n"<<sx<<" "<<sy-1;
    }
    else{
        cout<<cuatroUno<<"\n"<<sx+1<<" "<<sy;
    }
    return 0;
}
