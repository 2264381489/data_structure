package 线程;

import java.util.ArrayList;
import java.util.List;

//用扩展的方式生成多线程
public class TestThread extends Thread {
    public TestThread(String name){
        super(name);//这个是Thread类的一个构造函数,为新创建的多线程对象提供一个名字.
    }

    /**
     *  Must achieve run method
     */
    public void run(){
        for (int i = 0; i <5 ; i++) {
            for(long k=0;k<100;k++){
                System.out.println(this.getName()+"  "+i);
            }
        }
    }

    /**
     *  Test class
     * @param args
     */
    public static void main(String[] args) {
        Thread t1=new TestThread("liBai");
        Thread t2=new TestThread("quyuan");
        t1.start();
        t2.start();
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int pre = 0, last = k;
        int max = nums[0];
        for (last = k; last >= 0; last--) {
            if (nums[last] > max) {
                max = nums[last];
            }
        }
        List<Integer> list = new ArrayList();
        for (last = k; last < nums.length; last++) {
            for (int i = k; i >= 0; i--) {
                if (nums[last - i] > max) {
                    max = nums[last];
                }
            }
            list.add(max);
        }
        int[] arr = new int[list.size()];
        Integer[] arr=list.toArray(new Integer[list.size()]);
        int i = 0;
        for (int a : list) {
            arr[i++] = a;
        }
        return arr;
    }
}