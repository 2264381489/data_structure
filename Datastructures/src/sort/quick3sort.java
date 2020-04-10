package sort;

import edu.princeton.cs.algs4.StdRandom;
//三向算法.
/**
 * Created by 22643 on 2020/4/10.
 */
public class quick3sort {
    public static void sort(Comparable[] a) {
        //算法填充区
        StdRandom.shuffle(a);//打乱数组顺序,为的是消除输入数组原有的顺序
        sort( a,0,a.length-1);//进行排序
    }
    private static void sort(Comparable[] a,int lo,int hi){
     if (hi<lo)return;
     int lt=lo,i=lo+1,gt=hi;
     Comparable v=a[lo];
     while(i<=gt){
         /**
          * compareTo
          * 如果参数字符串等于此字符串，则返回值 0；
          * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
          * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
          */
         int cmp=a[i].compareTo(v);
         if (cmp<0)exch(a,lt++,i++);//将小于v点的放到左边
         else if (cmp>0)exch(a,i,gt--);//将大于v点的放到右边
         else  i++;//等于的话就放在这里
     }
     sort(a,lo,lt-1);
     sort(a,gt+1,hi);
    }

    //模板区域
    private static int partition(Comparable[] a,int lo,int hi){
        //将数组划分成a[lo...i-1] ,a[i],a[i+1....hi]
        int i=lo,  j=hi+1;
        Comparable v=a[i];//切分元素
        while(true) {
            while (less(a[++i], v)) if (i == hi) break;//他的功能是从左往右,找到第一个比切分元素大的元素
            while (less(v,a[--j])) if (j==lo)break;//他的功能是从右往左找比切分元素小的数.
            //这两个都是找到,就把指针停在那里,一动不动.
            if (i>=j)break;//跳出大循环
            exch(a,i,j);
        }
        exch(a,lo,j);//v=a[j]放入正确的位置
        return j;
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
        String[] a={"R","B","W","W","R","W","B","R","R","W","B","R"};
        // selectionsort  sortDemo=new selectionsort();
        sort(a);
        assert isSorted(a);//断言,要是失败了终止程序
        show(a);
    }
}
