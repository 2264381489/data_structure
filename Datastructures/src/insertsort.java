import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class insertsort
{//算法模板
    private static void sort(Comparable[] a) {
        //算法填充区
       int N=a.length;
       for (int i = 1; i <N; i++) {
           //将a[i]插入到a[i-1],a[i-2],a[i-3]....之中
           for (int j = i; j>0&&less(a[j], a[j-1]); j--) {
               exch(a, j, j-1);
           }
       }
       
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
    // selectionsort  sortDemo=new selectionsort();
    sort(a);
    assert isSorted(a);//断言,要是失败了终止程序
    show(a);
}
  
}