package sort;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class insertsort
{//算法模板
    public static void sort(Comparable[] a) {
        //算法升级版
        int N=a.length;
        int min1=0;
        for (int i = 0; i <N ; i++) {
            if (less(a[i],a[min1])){
                min1=i;
            }
        }
        exch(a,0,min1);//让最小的数到最左边去,保证a[0]无论在a[1]为任何书时都比其小.
        for (int i = 1; i <N ; i++) {
            for (int j = i;less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }

        //-------------------------
//       int N=a.length;
//       for (int i = 1; i <N; i++) {
//           //将a[i]插入到a[i-1],a[i-2],a[i-3]....之中
//           for (int j = i; j>0&&less(a[j], a[j-1]); j--) {
//               exch(a, j, j-1);
//           }
//       }
       
    }
    private static boolean less(Comparable v,Comparable w)//可以这么写,似乎是向上转型的一种
    {   return v.compareTo(w)<0; }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }//用来交换
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" "+" ");
            // System.out.println();
        }
    }//展示数组
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])){return false;}
        }
        return true;
    }//验证
   public static void main(String args[]) {
    // Scanner scan = new Scanner(System.in);
    String[] a={"S","O","R","T","E","X","A","M","P","L","E"};
       Double[] arr1=new Double[]{6.0,5.0,4.0,3.0,2.0,1.0};
    // selectionsort  sortDemo=new selectionsort();
    sort(arr1);
//    assert isSorted(a);//断言,要是失败了终止程序
    show(arr1);
}
  
}