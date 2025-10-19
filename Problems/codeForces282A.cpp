#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int numberOfQueries;
    int response = 0;
    string command;
    cin >> numberOfQueries;
    while(numberOfQueries > 0) {
      cin>> command;
      if(command.find("++") != string::npos) {
        response++;
      } else {
        response--;
      }
      numberOfQueries--;
    }
    cout << response;
    return 0;
}
