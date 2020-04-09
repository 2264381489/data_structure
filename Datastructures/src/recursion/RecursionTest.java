package recursion;

/**
 * Created by 22643 on 2020/4/8.
 */
public class RecursionTest {
    public static void main(String[] args) {
         //通过打印问题，理解递归
//        test(4);
        //递归调用机制
        int a=factorial(2);
        System.out.println(a+"的階乘");
    }
    //打印問題
    public static void test(int n){
        if (n>2){
            test(n-1);//不加else234
        }else {//加else 2
            System.out.println("n="+n);
        }
    //階乘問題
    }
    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
    //递归调用规则:
    //1.当程序执行到一个方法时,就会开辟一个独立的空间(栈)
    //2.每个空间的数据(局部变量),是独立的.


    //递归支持的重要的规则
    //1)执行一个方法时,就创建一个新的受保护的独立空间
    //2)方法的局部变量是独立的,不会相互影响,比如n变量
    //3)如果方法中使用的是引用类型变量(比如数组),就会共享该引用类型的数据
    //4)递归必须向退出递归的条件逼近,否则就是无限递归,出现StackOverflowError
    //5)当一个方法执行完毕,或者遇到return就会返回,遵守谁调用,就将结果返回给谁,同时当方法执行完毕或者返回的时候,该方法就执行完毕

}
