package 平安果手机动态规划HW;

import java.util.Scanner;

public class Solution {
    /**
     * 给定一个M行N列的矩阵（M*N个格子），每个格子中放着一定数量的平安果。
     * 你从左上角的各自开始，只能向下或者向右走，目的地是右下角的格子。
     * 每走过一个格子，就把格子上的平安果都收集起来。求你最多能收集到多少平安果。
     *
     * 自顶向下：如果遇到子问题还未求解，那么就先求解子问题。
    * */
    public static  void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] array=new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                array[i][j]=scanner.nextInt();
            }
        }
        System.out.println(dp(m-1,n-1,array));
    }
    public static int dp(int m,int n,int apple[][]) {
        if (m == 0 && n == 0)
            return apple[0][0];
        else if (m == 0)
        {
            return apple[m][n] + dp(m, n - 1, apple);
        }
        else if (n == 0)
        {
            return apple[m][n] + dp(m - 1, n, apple);
        }
        return max(apple[m][n] + dp(m,n-1,apple),apple[m][n] + dp(m-1,n,apple));
    }
    public static int max(int m,int n){
        return m-n>0?m:n;
    }

}
