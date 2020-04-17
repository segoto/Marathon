#include <bits/stdc++.h>
using namespace std;
bool compareEdges(vector<int> a, vector<int> b){
    return a[2]<b[2];
}
bool noCycleInGraph(vector <int>  graph[], vector<int> edge){
    if(graph[edge[0]-1].size()== 0)
        return true;
    for(int i = 0 ; i < graph[edge[0]-1].size(); i++){
        if(edge[1] == graph[edge[0]-1][i]){
            return false;
        }
    }
    return true;
}
void addToGraph(vector<int> graph[], vector<int> edge){
    int tam1 = graph[edge[1]-1].size();
    for(int i = 0 ; i < graph[edge[0]-1].size(); i++){
        graph[graph[edge[0]-1][i]-1].push_back(edge[1]);
        graph[edge[1]-1].push_back(graph[edge[0]-1][i]);
    }
    for(int i = 0 ; i < tam1; i++){

    }
    graph[edge[0]-1].push_back(edge[1]);
    graph[edge[1]-1].push_back(edge[0]);
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin>> n;
    for(int i = 0 ; i < n; i++){
        int cities, roads;
        cin>>cities>>roads;
        vector<vector<int> > edges;
        for(int j = 0 ; j < roads; j++){
            int a,b,cost;
            cin>>a>>b>>cost;
            vector<int> edge;
            edge.push_back(a);
            edge.push_back(b);
            edge.push_back(cost);
            edges.push_back(edge);
        }
        sort(edges.begin(),edges.end(), compareEdges);

        int ranges;
        cin>>ranges;
        vector<vector<int> > lowHigh;

        for(int k = 0 ; k < ranges; k++){
            int l,h;
            cin>>l>>h;
            vector<int> range;
            range.push_back(l);
            range.push_back(h);
            lowHigh.push_back(range);
        }

        int sum = 0;
        for(int m = 0; m <ranges; m++){

            vector <int> graph[cities];
            int low = lowHigh[m][0] - sum;

            int high = lowHigh[m][1] - sum;
            sum = 0;
            for(int s = 0; s < roads; s++){
                int cost =edges[s][2];
                if(noCycleInGraph(graph,edges[s])&& (low<=cost && high>=cost)){
                    cout<< s<<"    "<<edges[s][0]<<"   "<<edges[s][1]<<"\n";
                    sum += cost;
                    addToGraph(graph,edges[s]);
                }
            }
            cout<<sum<<endl;
        }
    }
    return 0;
}
