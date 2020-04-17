#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin>>n;
    int data[n];
    vector<int> graph[n];
    for(int i = 0 ; i < n ; ++i){
        graph[i].push_back(i);
        cin>>data[i];
        if(i+data[i] < n){
            graph[i].push_back(i+data[i]);
        }

        if(i-data[i]>= 0){
            graph[i].push_back(i-data[i]);
        }
    }
    bool visited[n];
    for(int i = 0; i < n; ++i){

    }

    return 0;
}
