package 线程;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//package 线程;
//
////package 线程;//package 线程;
//////
//////import java.util.*;
//////
////////用扩展的方式生成多线程
//////public class TestThread extends Thread {
//////    public TestThread(String name){
//////        super(name);//这个是Thread类的一个构造函数,为新创建的多线程对象提供一个名字.
//////    }
//////
//////    /**
//////     *  Must achieve run method
//////     */
//////    public void run(){
//////        for (int i = 0; i <5 ; i++) {
//////            for(long k=0;k<100;k++){
//////                System.out.println(this.getName()+"  "+i);
//////            }
//////        }
//////    }
//////
//////    /**
//////     *  Test class
//////     * @param args
//////     */
//////    public static void main(String[] args) {
//////        Thread t1=new TestThread("liBai");
//////        Thread t2=new TestThread("quyuan");
//////        t1.start();
//////        t2.start();
//////    }
//////}
//////class Solution {
//////    public int[] maxSlidingWindow(int[] nums, int k) {
//////        int pre = 0, last = k;
//////        int max = nums[0];
//////        for (last = k; last >= 0; last--) {
//////            if (nums[last] > max) {
//////                max = nums[last];
//////            }
//////        }
//////        List<Integer> list = new ArrayList();
//////        for (last = k; last < nums.length; last++) {
//////            for (int i = k; i >= 0; i--) {
//////                if (nums[last - i] > max) {
//////                    max = nums[last];
//////                }
//////            }
//////            list.add(max);
//////        }
//////        int[] arr = new int[list.size()];
//////        Integer[] arr=list.toArray(new Integer[list.size()]);
//////        int i = 0;
//////        for (int a : list) {
//////            arr[i++] = a;
//////        }
//////        return arr;
//////    }
//////}
//////class Solution {
//////    public String removeOuterParentheses(String S) {
//////        Stack<Character> stack=new Stack();
//////        Stack<Character> stack2=new Stack();
//////        for(int i=0;i<S.length;i++){
//////            if(s.charAt(i)==')'){
//////                Character a=' ';
//////                while(!a=='('){
//////                    Character a=stack.pop();
//////                    stack2.push(a);
//////                }
//////            }
//////            stack.push(s.charAt(i));
//////        }
//////        String res="";
//////        for(Character b:stack2){
//////            res=res+b;
//////        }
//////        return res;
//////    }
//////}
//////class MaxQueue {
//////    Deque<Integer> queue=new LinkedList<>();
//////    Deque<Integer>  queue2=new ArrayDeque<>();
//////
//////    public void test(){
//////        queue.add(1);
//////        queue.pop();
//////        queue2.pop();
//////    }
//////
//////
////
//// interface man{
////        public void run();
////}
//// class people implements man{
////    @Override
////    public void run() {
////        System.out.println("人会跑");
////    }
////}
////class athlete implements man{
////    @Override
////    public void run() {
////        System.out.println("跑的飞快");
////    }
////}
////class test {
////    public static void main(String[] args) {
////        man people;
////        people=new people();
////        people.run();
////        man athlete = new athlete();
////        athlete.run();
////    }
////    }
////
////
////
////
////
////
////
////
////
////
//////
//////    LinkedList<Integer> queueMax;
//////    //QUEUE的方法较少,所以用LinkedList代替
//////    public MaxQueue() {
//////        queue=new LinkedList<>();//创建队列
//////        queueMax=new LinkedList<>();//创建最大的队列
//////    }
//////
//////    public int max_value() {
//////        if(queueMax.isEmpty()){
//////            return -1;
//////        }
//////        return queueMax.getFirst();
//////    }
//////
//////    public void push_back(int value) {
//////        queue.offer(value);
//////        while(value>queueMax.getLast()){
//////            queueMax.removeLast();
//////        }
//////        queueMax.offer(value);
//////
//////
//////    }
//////
//////    public int pop_front() {
//////        if(queue.isEmpty()){
//////            return -1;
//////        }
//////        return queue.removeFirst();
//////    }
//////}
//class man{
////    public int sage;
//    man(int age){
//        sage=age;
//    }
//    public void getAge(){
//        System.out.println(this.age);
//    }
//
//    public static void main(String[] args) {
//        man man = new man(12);
//        man.getAge();
//        man man1 = new man(15);
//        man1.getAge();
//
//    }
//}
class test {
    public static void run() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
//        iterator.remove();报错java.lang.IllegalStateException
        iterator.next();
        iterator.remove();//不报错,删掉了1
        System.out.println(list);//AbstractCollection类中实现的toString让list可以直接被打印出来
        while (iterator.hasNext()) {//迭代器,hasNext()集合是否为空
            Integer a = iterator.next();//可以用next访问每一个元素
            System.out.println(a);//2,3 ,3
        }
        for (int a : list) {//也可以使用foreach
            System.out.println(a);//2,3,3

        }
    }
    public static void main(String[] args) {

        run();
    }
}