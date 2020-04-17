#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, goals1, goals2, ties, greatestOverCome, tempOverCome, actualGoal;

    goals1 = 0;
    goals2 =0;
    ties = 1;
    greatestOverCome = 0;
    tempOverCome = 0;
    cin>>n;
    int wasWinning[n+1];
    int scored[n+1];
    wasWinning[0] = 0;
    scored[0] = 0;
    for(int i = 0 ; i < n; ++i){
        cin>>actualGoal;
        if(actualGoal == 1){
            if(scored[i]== 1 && wasWinning[i+1-tempOverCome]!=actualGoal){
                tempOverCome++;
            }
            else{
                tempOverCome = 1;
            }
            scored[i+1] = 1;
            goals1++;
        }
        else{
            if(scored[i]==2 && wasWinning[i+1-tempOverCome] !=actualGoal){
                tempOverCome++;
            }
            else{
                tempOverCome = 1;
            }
            scored[i+1] = 2;
            goals2++;
        }
        if(goals1==goals2){
            wasWinning[i+1] = 0;
            ties++;
        }
        else if(goals1>goals2){
            wasWinning[i+1] = 1;
        }
        else{
            wasWinning[i+1] = 2;
        }
        if(tempOverCome > greatestOverCome && wasWinning[i-tempOverCome+1] != actualGoal &&wasWinning[i+1]==actualGoal){

            greatestOverCome = tempOverCome;
        }

    }
    cout<<goals1<<" "<<goals2<<"\n"<<ties<<"\n"<<greatestOverCome;

    return 0;
}
