import java.util.*;
public class waterflood {

    public static void main(String[] args) {
        // Input: 2D
    Scanner input = new Scanner(System.in);

    int tot_row = input.nextInt(); 
    int tot_col = input.nextInt();

    int[][] mat = new int[tot_row][tot_col];

    int row,col;

    for(row=0;row<tot_row;row++){
        for(col=0;col<tot_col;col++){
            mat[row][col] = input.nextInt();
        }
    }

    int start_row = input.nextInt();
    int start_col = input.nextInt();

    int[][] res = new int[tot_row][tot_col];
    for(row=0;row<tot_row;row++){
        for(col=0;col<tot_col;col++){
            res[row][col] = -1;
        }
    }

    int[][] queue = new int[100][2];
    int front=0,rear=0;

    queue[rear][0]=start_row;
    queue[rear][1]=start_col;
    rear++;
    res[start_row][start_col]=0;
    int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};

    int rows = queue[front][0];
    int cols = queue[front][1];
    front++;


    for(int itr=0;itr<4;itr++){
        int new_row = rows + dir[itr][0];
        int new_col = cols + dir[itr][1];

        if(new_row<0 || new_row>=tot_row || new_col<0 || new_col>=tot_col){
            continue;
        }
        if(res[new_row][new_col] == -1 && mat[new_row][new_col] <= mat[rows][cols]){
            res[new_row][new_col] = res[rows][cols] + 1;
            queue[rear][0] = new_row;
            queue[rear][1] = new_col;
            rear++;
        }
            
    }

    for(row=0;row<tot_row;row++){
        for(col=0;col<tot_col;col++){
            System.out.println(res[row][col]+" ");
        }
    }



}
}