package sort;//package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class bubbleSort1 {


    public static void main(String[] args) {
        int[] arr=new int[8];
        for (int i = 0; i <arr.length ; i++) {
            Random random=new Random();
            arr[i]=(int)(Math.random()*8000);
        }
        Date dateStart=new Date();//开始的时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(dateStart);
        System.out.println("排序前的时间是=" + date1Str);
        sort(arr);
        Date dateEnd=new Date();//结束的时间
        String date2Str = simpleDateFormat.format(dateEnd);
        System.out.println("排序前的时间是=" + date2Str);
    }

public static void sort(int[] arr){
  boolean flag=false;
    for (int i = 0; i <arr.length -1; i++) {
        int temp=0;
        for (int j = 0; j <arr.length-1-i ; j++) {
            if (arr[j+1]<arr[j]){
                flag=true;
                temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
        }
        System.out.println("第" + (i + 1) + "趟排序后的数组");
        System.out.println(Arrays.toString(arr));
        if (!flag){
            break;
        }else{
            flag=false;
        }
    }
}

}
