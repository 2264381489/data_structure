package String;

public class clone implements Cloneable{
    @Override
    protected clone clone() throws CloneNotSupportedException {
        return (clone)super.clone();
    }
}
class low implements Cloneable{
    int[] arr=new int[10];

    public low() {
        for (int i = 0; i <10 ; i++) {
            arr[i]=-1;
        }
    }

    public int getArr(int i) {
        return arr[i];
    }

    public void setArr(int i,int arr) {
       this.arr[i] = arr;
    }


//    protected low clone() throws CloneNotSupportedException {
//        return (low) super.clone();
//    }


    @Override
    protected low clone() throws CloneNotSupportedException {
        low clone =(low) super.clone();
        clone.arr=new int[10];
        for (int i = 0; i <10 ; i++) {
            clone.arr[i]=this.arr[i];
        }
        return clone;
    }
}
class test{
    public static void main(String[] args) throws CloneNotSupportedException {
       low low = new low();
        low clone1 = low.clone();
       low.setArr(1,19);
        int arr = clone1.getArr(1);
        System.out.println(arr);
    }
}
