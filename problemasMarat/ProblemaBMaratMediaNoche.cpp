#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin>>n;
    string str1;
    string str2;
    for(int i = 0; i < n; ++i){
        cin>>str1>>str2;
        int minimumLength;
        if(str1.size()<=str2.size()){
            minimumLength = str1.size();
        }
        else{
            minimumLength = str2.size();
        }
        int swaps = 0;
        if(str2.compare(str1)>0){
            cout<<str1<<"\n";
        }
        else {
            bool puedo = false;
            for(int j = 0; j<minimumLength; ++j){
                char aComparar = str2[j];
                for(int k = j ; k < minimumLength; ++k){
                    if(aComparar>str1[k]){
                        char temp = str1[j];
                        str1[j] = str1[k];
                        str1[k] = temp;
                        puedo = true;
                        break;
                    }
                }
                if(puedo){
                    break;
                }
            }
            if(puedo && str2.compare(str1)>0){
                cout<<str1<<"\n";
            }
            else{

                cout<<"---\n";
            }
        }





    }
    return 0;
}
