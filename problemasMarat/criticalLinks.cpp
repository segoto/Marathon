#include <bits/stdc++.h>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin>>n;
    int numeros[n];
    int dp[n];
    map<int,int> mapita;
    int asociacion[n];
    for(int i = 0 ; i < n; i++){
        cin>>numeros[i];
    }


    int maximum = -1;
    int posMaximo = -1;
    for(int i = 0; i < n; i++){
            vector<int> nuevo;
        if(mapita.find(numeros[i]-1)!=mapita.end()){
            int ultimoIndex = mapita[numeros[i]-1]-1;
            dp[i] = dp[ultimoIndex] + 1;
            asociacion[i] = ultimoIndex;

        }
        else{
            dp[i] = 1;
            asociacion[i] =-1;
        }
        mapita[numeros[i]] = i+1;
        if(maximum < dp[i]){
            maximum = dp[i];
            posMaximo = i;
        }
    }
    int numerito = numeros[posMaximo];
    int k = posMaximo;
    vector<int> resp;
    while(k!=-1){
         resp.push_back(k+1);
        k = asociacion[k];

    }

    cout<<maximum<<endl;
    for(int i = resp.size()-1 ; i >=0; i--){
        cout<<resp[i]<<" ";
    }

    return 0;
}
