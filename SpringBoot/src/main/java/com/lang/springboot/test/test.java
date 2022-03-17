package com.lang.springboot.test;

import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class test {

    static int N=6;
    static int R=3;

    static int[] a=new int[]{1,2,3,4,5,6};
    static int[] b=new int[R];

    public static void main(String[] args) {
        array(N,R);
        System.out.println();
    }
    static void array(int m, int n){
        int i,j;
        for (i=n;i<=m;i++){
            b[n-1]=i-1;
            if (n>1){
                array(i-1,n-1);
            }else {
                for (j=0;j<=R-1;j++){
                    System.out.print(a[b[j]]+"  ");
                }
                System.out.println();
            }
        }
    }

}
