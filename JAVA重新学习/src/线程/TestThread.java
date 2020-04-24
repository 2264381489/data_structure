package 线程;
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
