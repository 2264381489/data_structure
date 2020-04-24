package 线程;
//实现runable的方式来开启多线程
public class Runnablelmpl implements Runnable {
    private String name;

    /**
     * 构造函数
     */
    public  Runnablelmpl(String name){
        this.name=name;
    }

    /**
     * run()函数
     */
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            for(long k=0;k<100;k++){
                System.out.println(name+"  "+i);
            }
        }
    }

    public static void main(String[] args) {
        Runnablelmpl ri1=new Runnablelmpl("李白");
        Runnablelmpl ri2=new Runnablelmpl("quYuan");
        Thread t1=new Thread(ri1);//实现Ruannable的多线程必须如此启动
        Thread t2=new Thread(ri2);
        t1.start();
        t2.start();
    }
}
