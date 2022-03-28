package com.lang.springboot.test;

import java.util.Scanner;

public class 递归 {
    public static void main(String[] args) {
        final int N=110;
        boolean[][] st=new boolean[N][N];//表示是否已经存在数字
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//输入两个数字
        int[][] arr = new int[N][N];//初始化一个数组

        int[] dx={0,1,0,-1};//x的改变量
        int[] dy={1,0,-1,0};//y的改变量
        int x=0,y=0,d=0;
        for(int i=1;i<=(n*m);i++){
            int nx=x+dx[d],ny=y+dy[d];//初始化坐标（0,0）
            if(nx<0||nx>=n||ny<0||ny>=m||st[nx][ny]){//判断是否撞墙和改位置是否已经存在数字
                d=(d+1)%4;//四种方向的选择
                nx=x+dx[d];
                ny=y+dy[d];//移动之后的坐标
            }
            arr[x][y]=i;
            st[x][y]=true;//标记改位置已被占用
            x=nx;
            y=ny;//移动后的坐标值，赋给x和y
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");//打印排好序的数组
            }
            System.out.println();
        }
    }
}
