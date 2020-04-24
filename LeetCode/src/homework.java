/**
 * Created by 22643 on 2020/4/16.
 */
//public class homework {
//    private int[] arr=new int[]{40,50,10,30,20};
//    public int[] reverse(int[] arr){
//
//        for (int i = arr.length; i >=0 ; i--) {
//
//        }
//    }
//}


        class student1{
            private String name;
            student1(String name){
                this.name=name;
            }
            public void lean(){
                System.out.println(name+"具有学习能力");
            }
        }
        class  middleSchoolStudent extends student1{
            private String name;//覆盖父类的成员变量
          middleSchoolStudent(String name){
              super(name);
              this.name="小黄";//给name一个值,为什么给子类中的覆盖父类的成员变量一个值.从父类继承的方法返回的值没有被覆盖
          }
          public void showName(){
              System.out.println(name);//调用后输出 小黄
          }
        }
class homework1{

    public static void main(String[] args) {
        middleSchoolStudent middleSchoolStudent = new middleSchoolStudent("JHON");
        middleSchoolStudent.showName();//输出小黄
        middleSchoolStudent.lean();//输出JHON 具有学习能力

    }
}
   //