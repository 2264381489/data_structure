package sort;
public class shellsort
{//算法模板
   public static void sort(Comparable[] a) {
        //算法填充区
       int N=a.length;
       int h=1;
       while(h < N/3)  h=3*h+1;//1,4,13,40为了保证在应对大规模算法的时候可以自动增加跨度
       while( h >= 1)
       {
           for (int i = h; i < N; i++) {
               //下面要注意,跨度长度和很重要
           for (int j = i; j>=h&&less(a[j], a[j-h]); j-=h) {
               exch(a, j, j-h);
               
           }
           }
           h=h/3;
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