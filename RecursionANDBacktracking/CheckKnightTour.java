package RecursionANDBacktracking;

public class CheckKnightTour {

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        return helper(grid,0,0,0);
    }
    public boolean helper(int grid[][],int row,int col,int num){
        //base case
        int n=grid.length;
        int i,j;
        if(grid[row][col]==n*n-1) return true;

        //2 Up 1right
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j]==num+1) return helper(grid,i,j,num+1);

        //2 Up 1 left
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 down 1right
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 down 1 left
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 left 1up
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 left 1down
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 right 1up
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j]==num+1) return helper(grid,i,j,num+1);

                //2 rigt 1down
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j]==num+1) return helper(grid,i,j,num+1);
         


         return false;
    }
    
}
