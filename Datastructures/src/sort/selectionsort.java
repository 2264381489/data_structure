package sort;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;
//选择排序
//选择排序的核心在于不断地进行比较.
//将
//0  1  2  3  4  5  6  7  8  9  10
//S  O  R  T  E  X  A  M  P  L  E
//  A<->S 这个是ASCII码相比的,所以A最小
//A  S  R  T  E  X  O  M  P  L  E
//   <->  与 R  T  E  X  O  M  P  L  E中最小的(O)进行交换
// A  E  R  T  S  X  O  M  P  L  E
//
// A  E  E  T  S  X  R  M  P  O  L
// A  E  E  L  S  X  T  R  P  O  M
// A  E  E  L  M  X  T  S  R  P  O
// A  E  E  L  M  O  X  T  S  R  P
// A  E  E  L  M  O  P  X  T  S  R
// A  E  E  L  M  O  P  R  X  T  S
// A  E  E  L  M  O  P  R  S  X  T
// A  E  E  L  M  O  P  R  S  T  X
// A  E  E  L  M  O  P  R  S  T  X
public class selectionsort
{//算法模板
   public static void sort(Comparable[] a) {
        //算法填充区
        int N=a.length;
        for (int i = 0; i <N; i++) {
            //将a[i]和a[i+1...N]中最小的一个交换
            int min=i;

            for (int j = i+1; j < N; j++) {
                // System.out.print(i+" ");

                // System.out.println();
                if (less(a[j], a[min])) min = j;
            }
                exch(a, i, min);

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
    String[] a={"E","A","S","Y","Q","E","S","T","I","O","N"};
       Double[] arr1=new Double[]{6.0,5.0,4.0,3.0,2.0,1.0};
    // selectionsort  sortDemo=new selectionsort();
    sort(arr1);
//    assert isSorted(a);//断言,要是失败了终止程序
    show(arr1);
}
  
}