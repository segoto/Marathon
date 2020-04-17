#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int castles, portals, warriors;
    cin>>castles>>portals>>warriors;
    int warriorsEarned[castles];

    int utilities[castle];
    int howManyINeed[castle];
    for(int i = 0; i < castles; ++i){
        cin>>howManyINeed[i]>>warriorsEarned[i]>>utilities[i];
    }
    int portalsU[portals];
    int portalsV[portals];
    for(int i = 0 ; i < portals; ++i){
        cin>>portalsU[i]>>portalsV[i];
    }
    int sum = warriors;

    for(int i = 1; i < castles;++i){
        if(sum<howManyINeed[i]){
            cout<<-1;
            return 0;
        }
        sum+=warriorsEarned[i];
    }
    if(howManyINeed[castles-1] == sum){
            vector<int> portalsFromLast;
            for(int i = 0 ; i < portals; ++i){
                if(portalsU[i]==castles){
                    portalsFromLast.push_back(i);
                }
            }

    }

    return 0;
}
