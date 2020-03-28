package stack;
//栈的思路分析
//1.使用数组来模拟栈
//2.定义一个top表示栈顶,初始化为-1
//3.入栈的操作,当有数据加入栈时,top++;
//3.出栈的操作top--

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //先创建一个ArrayStack对象->表示栈
        ArrayStack arrayStack = new ArrayStack(4);
        String key="";
        boolean loop=true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出");
            System.out.println("push:添加数据到栈(入栈)");
            System.out.println("pop:表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res=arrayStack.pop();
                        System.out.printf("出栈的数据是%d\n",res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序退出");
    }
}
class ArrayStack{
    private int maxsize;//栈的大小
    private int [] stack;//数组,数组模拟栈,数据就放在数组
    private int top;//栈顶
//构造函数
    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }
    //栈满
    public boolean isFull(){
        return top==maxsize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈push
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈pop 将栈顶的数据返回
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        //显示站的情况,遍历栈,需要从栈顶开始显示数据
        int value=stack[top];
        top--;
        return value;
    }
    //显示站的情况,[遍历栈]遍历时,需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}