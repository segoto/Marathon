#include <bits/stdc++.h>
using namespace std;
int main ()
{
    string n[4];
     n[0]= "10110101110101010001";
    n[1]= "10110101110101010001";

    reverse(n[1].begin(), n[1].end());
    for (int i=0;i<n[1].size();i++)
    {
        if (n[1][i]=='1')
        {
            n[2].push_back('0');
        }else
            n[2].push_back('1');
        if (n[0][i]=='1')
        {
            n[3].push_back('0');
        }else
            n[3].push_back('1');
    }
    int estoy=1;
    int a= rand() % 4 ;
    int k;
    while(true)
    {
        cin>>k;
        if (k==-1)
            cout<<n[a]<<endl;

        if (estoy % 10 == 1)
        {
              a= rand() % 4 ;
             cout<<"CAMBIO "<<n[a]<<endl;
        }
        cout<<n[a][k-1]<<endl;
        estoy++;
    }

}
