#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    int T,r,c;
    cin>>T;
    for(int t = 1 ; t <= T; ++t){
        cin>>r>>c;
        int matrix[r][c];
        int resp = 0;
        int total = 0;
        for(int i = 0 ; i < r; ++i){
            for(int j = 0 ; j < c; ++j){
                int s_ij;
                cin>>s_ij;
                total+=s_ij;

                matrix[i][j] = s_ij;
            }
        }

        bool termino = true;
        while(termino){
                resp+=total;
        vector<pii> eliminados;
        for(int i = 0; i < r; i++){
        for(int j = 0; j < c;j++){
            if(matrix[i][j]==0){
                continue;
            }
            double sum = 0.0;
            double neighbors = 0.0;
            if(i>0 && i < r-1 && j>0 && j <c-1){
                bool right_down = 1;
                bool left_up = 1;
                for(int act_col = j+1, act_col2 = j-1; act_col<c &&act_col2>=0 && (right_down || left_up); act_col++, act_col2--){
                        if(matrix[i][act_col]!=0 && right_down){
                            sum+=matrix[i][act_col];
                            neighbors+=1;
                            right_down = 0;
                        }
                        if(matrix[i][act_col2]!=0 && left_up){
                            sum+=matrix[i][act_col2];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                right_down = 1;
                left_up = 1;
                for(int act_row = i+1, act_row2 = i-1; act_row<r &&act_row2>=0 && (right_down||left_up); act_row++, act_row2--){
                        if(matrix[act_row][j]!=0 && right_down){
                            sum+=matrix[act_row][j];
                            neighbors+=1;
                            right_down = 0;
                        }
                        if(matrix[act_row2][j]!=0 && left_up){
                            sum+=matrix[act_row2][j];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }
                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if(i == 0 && j>0 && j<c-1){
                bool right_down = 1;
                bool left_up = 1;
                for(int act_col = j+1, act_col2 = j-1; act_col<c &&act_col2>=0 && (right_down || left_up); act_col++, act_col2--){
                        if(matrix[i][act_col]!=0 && right_down){
                            sum+=matrix[i][act_col];
                            neighbors+=1;
                            right_down = 0;
                        }
                        if(matrix[i][act_col2]!=0 && left_up){
                            sum+=matrix[i][act_col2];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                right_down = 1;
                left_up = 1;
                for(int act_row = i+1; act_row<r && right_down; act_row++){
                        if(matrix[act_row][j]!=0 && right_down){
                            sum+=matrix[act_row][j];
                            neighbors+=1;
                            right_down = 0;
                        }
                }


                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if (i== r-1 && j>0 && j<c-1){
                bool right_down = 1;
                bool left_up = 1;

                for(int act_col = j+1, act_col2 = j-1; act_col<c &&act_col2>=0 && (right_down || left_up); act_col++, act_col2--){
                        if(matrix[i][act_col]!=0 && right_down){
                            sum+=matrix[i][act_col];
                            neighbors+=1;
                            right_down = 0;
                        }
                        if(matrix[i][act_col2]!=0 && left_up){
                            sum+=matrix[i][act_col2];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                right_down = 1;
                left_up = 1;
                for(int act_row = i-1; act_row<r && left_up; act_row--){
                        if(matrix[act_row][j]!=0 && left_up){
                            sum+=matrix[act_row][j];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }
                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if(j==0 && i > 0  && i < r-1){
                bool right_down = 1;
                bool left_up = 1;
                for(int act_row = i+1, act_row2 = i-1; act_row<r &&act_row2>=0 && (right_down||left_up); act_row++, act_row2--){
                    if(matrix[act_row][j]!=0 && right_down){
                        sum+=matrix[act_row][j];
                        neighbors+=1;
                        right_down = 0;
                    }
                    if(matrix[act_row2][j]!=0 && left_up){
                        sum+=matrix[act_row2][j];
                        neighbors+=1;
                        left_up = 0;
                    }
                }
                right_down = 1;
                for(int act_col = j+1; act_col<c && right_down ; act_col++){
                        if(matrix[i][act_col]!=0 && right_down){
                            sum+=matrix[i][act_col];
                            neighbors+=1;
                            right_down = 0;
                        }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if (j == c-1 && i > 0 && i < r-1){
                bool right_down = 1;
                bool left_up = 1;
                for(int act_row = i+1, act_row2 = i-1; act_row<r &&act_row2>=0 && (right_down||left_up); act_row++, act_row2--){
                    if(matrix[act_row][j]!=0 && right_down){
                        sum+=matrix[act_row][j];
                        neighbors+=1;
                        right_down = 0;
                    }
                    if(matrix[act_row2][j]!=0 && left_up){
                        sum+=matrix[act_row2][j];
                        neighbors+=1;
                        left_up = 0;
                    }
                }
                left_up = 1;
                for(int act_col2 = j-1; act_col2<c && left_up ; act_col2--){
                        if(matrix[i][act_col2]!=0 && left_up){
                            sum+=matrix[i][act_col2];
                            neighbors+=1;
                            left_up = 0;
                        }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if( i==0 && j==0){
                for(int act_col = j+1; act_col < c; act_col++){
                    if(matrix[i][act_col]!=0){
                        sum+=matrix[i][act_col];
                        neighbors += 1;
                        break;
                    }
                }
                for(int act_row = i + 1; act_row < r; act_row++){
                    if(matrix[act_row][j]!=0){
                        sum+= matrix[act_row][j];
                        neighbors += 1;
                        break;
                    }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }


                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if(i == 0 && j== c-1){
                for(int act_row = i + 1; act_row<r; act_row++){
                    if(matrix[act_row][j]!= 0){
                        sum += matrix[act_row][j];
                        neighbors += 1;
                        break;
                    }
                }
                for(int act_col = j -1; act_col>=0; act_col--){
                    if(matrix[i][act_col]!=0){
                        sum+=matrix[i][act_col];
                        neighbors += 1;
                        break;
                    }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else if(j == 0 && i == r-1){
                for(int act_row = i - 1; act_row>=0; act_row--){
                    if(matrix[act_row][j]!= 0){
                        sum += matrix[act_row][j];
                        neighbors += 1;
                        break;
                    }
                }
                for(int act_col = j +1; act_col<c; act_col++){
                    if(matrix[i][act_col]!=0){
                        sum+=matrix[i][act_col];
                        neighbors += 1;
                        break;
                    }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
            else{
                for(int act_row = i-1; act_row>=0; act_row--){
                    if(matrix[act_row][j]!= 0){
                        sum += matrix[act_row][j];
                        neighbors += 1;
                        break;
                    }
                }
                for(int act_col = j -1; act_col>=0; act_col--){
                    if(matrix[i][act_col]!=0){
                        sum+=matrix[i][act_col];
                        neighbors += 1;
                        break;
                    }
                }
                if(neighbors>0){
                    sum/=neighbors;
                }

                if(matrix[i][j]<sum){
                    eliminados.push_back({i,j});
                    total-=matrix[i][j];
                }
            }
        }
    }
    for(int i = 0 ; i < eliminados.size(); i++){
            //cout<<eliminados[i].first<<" "<<eliminados[i].second<<" pareja\n";
        matrix[eliminados[i].first][eliminados[i].second] = 0;
    }
        if(eliminados.size()==0){
                termino = false;
            break;
        }
        }
        cout<<"Case #"<<t<<": "<<resp<<"\n";

    }
    return 0;
}
