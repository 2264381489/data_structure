package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("环形队列");
        //环形队列
        CircleArray arrayQueue = new CircleArray(4);//设置3，其队列的最大数字是3
        char key = ' ';//接受用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a：添加数据到队列");
            System.out.println("g：从队列取出数据");
            System.out.println("h：查看队列头的数据");
//            System.out.println("s:显示队列");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    arrayQueue.showQueue();
                    break;
                case 'g'://取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n,", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try {
                        System.out.println(arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~时");
    }
}
class CircleArray{
    private int maxSize;//表示数组的最大容量
    //front变量的含义做一个调整，front指向队列的第一个元素。也就是说arr【front】就是队列第一个元素，
    //初始值为0
    private int front;//队列头
    //rear变量的含义做一个调整，rear指向队列的最后一个元素的后一个位置。因为我希望空出一个空间作为约定。
    //一位有了这个空格就可以比较轻松地知道，空格前面的是rear后面的是front
    //初始值为0
    //不留这个位置（rear不指向队列最后一个元素后一个位置的话）的唯一结果就是rear和front会撞在一起，撞在一起的两个指针会导致front原先有的被覆盖掉。
    private int rear;//队列尾
    private int arr[];//该数据用于存放数据，模拟队列

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
//        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=0;
        rear=0;
    }
    //判断队列是否满
    //因为队满会让整个队列都站上。所以理论上rear+1的得数应该是0也就是front（注意这里的rear是数组的下标，不是地址。所以说rear加上必须存在的1就得到了整个的数量。）
    public boolean isFull() {
        return (rear+1)%maxSize==front;
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
        //直接将数据加入
        arr[rear]=a;//赋值
        //将rear后移，这里必须考虑取模
        rear=(rear+1)%maxSize;//加入rear到了这个数组的最后一位，此时rear+1在对他跟maxsize取余就直接让rear等于数组开头的值了。
        //加入说arr数组长5，front在3号位置（下标为2），rear的下标为4的时候，rear+1是5对他%maxsize，得出的数是0，这就用逻辑的思想来形成了一个圆环，
        // 而非在地址上进行什么操作。
    }
    //获取队列的值
    public int getQueue(){
        if (isEmpty()){
            System.out.println("栈空了！");
//            return -1;这个不行，因为这样的话，只能返回-1
            throw new RuntimeException("队列空。");
        }
      //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留在一个临时变量
        //2.front后移,考虑取模
        //3.将临时保存的变量返回
        int value=arr[front];
        front=(front+1)%maxSize;//对于front指针也是一样的，要是加的数量超过了maxSize就要靠取模来返回之前曾经走过的位置了
        return value;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的。");
        }
        //思路：从front开始遍历，遍历多少个元素。
        for (int i = front; i <front+size() ; i++) {
            //i是从front开始的，不断地加一有可能让他超过maxSize，所以取模就让她回道头部了。
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]); //这个要学习一下。
        }
    }
    //当前队列有效数据的个数
    public int size(){
        return  (rear+maxSize-front)%maxSize;//说白了就是rear-front的绝对值的一种表示形式。
        //rear=1
        //front=0
        //maxSize=3

    }
    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            System.out.println("队列空的，没有数据");
            throw new RuntimeException("队列是空的");
        }
        return arr[front];//因为队列头front永远指的是队列中的第一个数
    }

}