#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio();
    cin.tie(NULL);
    int n;
    cin>>n;
    pair<int, int> queen;
    pair<int, int> king;
    pair<int,int> goal;
    cin>>queen.first>>queen.second;
    cin>>king.first>>king.second;
    cin>>goal.first>>goal.second;
    if((king.first<queen.first && goal.first>queen.first) || (king.second<queen.second && goal.second>queen.second)){
        cout<<"NO\n";
    }
    else if((king.first>queen.first && goal.first<queen.first) || (king.second>queen.second && goal.second<queen.second)){
        cout<<"NO\n";
    }
    else if(goal.first == queen.first || goal.second == queen.second || abs(goal.first - queen.first) == abs(goal.second - queen.second)){
        cout<<"NO\n";
    }
    else{
        cout<<"YES\n";
    }
    return 0;
}
