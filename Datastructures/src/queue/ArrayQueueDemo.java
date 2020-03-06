package queue;

//import jdk.nashorn.internal.parser.Scanner;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
//测试一下
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key=' ';//接受用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while(loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a：添加数据到队列");
            System.out.println("g：从队列取出数据");
            System.out.println("h：查看队列头的数据");
//            System.out.println("s:显示队列");
            key=scanner.next().charAt(0);
             switch (key){
                 case 's':
                     arrayQueue.showQueue();
                     break;
                 case 'a':
                     System.out.println("输出一个数");
                     int value=scanner.nextInt();
                     arrayQueue.addQueue(value);
                     arrayQueue.showQueue();
                     break;
                 case 'g'://取出数据
                     try {
                         int res=arrayQueue.getQueue();
                         System.out.printf("取出的数据是%d\n,",res);
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                     break;
                 case 'h'://查看队列头的数据
                     try {
                         System.out.println( arrayQueue.headQueue());
                     }catch (Exception e) {
                         System.out.println(e.getMessage());
                     }
                     break;
                 case 'e'://退出
                     scanner.close();
                     loop=false;
                     break;
                     default:
                         break;
             }
        }
        System.out.println("程序退出~~~时");
    }
}
//编写一个叫做ArrayQueue的类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int arr[];//该数据用于存放数据，模拟队列
    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=-1;//只想对队列头部，分析出front是指向队里的头的*前一个位置*
        rear=-1;//指向队列尾的数据（即就是队列最后的一个数据）
    }
    //判断队列是否满
    public boolean isFull() {
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int a){
        //判断队列不为空
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        //加入数据
        rear++;//让rear后移
        arr[rear]=a;//赋值
    }
    //获取队列的值
    public int getQueue(){
        if (isEmpty()){
            System.out.println("栈空了！");
//            return -1;这个不行，因为这样的话，只能返回-1
            throw new RuntimeException("队列空。");
        }
        front++;
        return arr[front];
    }
//显示队列的所有数据
public void showQueue(){
    if (isEmpty()){
        System.out.println("队列是空的。");
    }
    for (int i = 0; i <arr.length ; i++) {
        System.out.printf("arr[%d]=%d\n",i,arr[i]); //这个要学习一下。
        //标准化输出解决输出的值是空值的问题。
    }
}
//显示队列头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            System.out.println("队列空的，没有数据");
            throw new RuntimeException("队列是空的");
        }
        return arr[front+1];//因为队列头front永远指的是队列中的第一个数
    }
}