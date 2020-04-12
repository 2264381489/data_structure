package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompared {
    public static double time(String alg,Double[] a){
        Stopwatch timer=new Stopwatch();//用来记录时间的
        if(alg.equals("insertsort")) insertsort.sort(a);
        if(alg.equals("selectionsort")) selectionsort.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
        //生成T个长度为N的数组
        double total=0.0;
        Double[] a=new Double[N];
        for(int t=0;t<T;t++){
            //进行依次测试(生成一个数组并排序)
            for (int i = 0; i < N; i++) {
                a[i]=StdRandom.uniform();
             
            }
            total+=time(alg,a);
        }
        return total;
    }
    public static double timeRandomInput(String alg,Double[] a,int T){
        //生成T个长度为N的数组
        double total=0.0;
//        Double[] a=new Double[N];
//        for(int t=0;t<T;t++){
            //进行依次测试(生成一个数组并排序)
//            for (int i = 0; i < N; i++) {
//                a[i]=StdRandom.uniform();
//
//            }
            total+=time(alg,a);

        return total;
    }
    public static void main(String[] args){
        String alg1="insertsort";
        String alg2="selectionsort";
        Double[] arr1=new Double[]{6.0,5.0,4.0,3.0,2.0,1.0};
        int N=10;
        int T=3;
        double t1=timeRandomInput(alg1, arr1, T);//插入排序时间
        double t2=timeRandomInput(alg2, arr1, T);//选择排序时间
//        System.out.println(t1/t2);
        System.out.printf("For %d random Double\n %s is",N,alg1);
        System.out.printf("%.1f times faster than %s",t2/t1,alg2);
    }
}