package String;

class String1 {
   static char[] buf1=new char[]{1,2,3,4};
//   static String string=new String(buf1,0,3);

    public static void main(String[] args) {
       char[] buf1=new char[]{'1','2','3','4'};
        char[] buf2=new char[]{1,2,3,4};//为啥不写冒号出不来
        System.out.println(buf2);//这就说得通了,因为String的本质是一个char数组.
        String string=new String(buf1,0,3);
        String string1=new String(buf2,0,3);
        byte[] bytes=string1.getBytes();
//        System.out.println(bytes.toString());
        for (byte a:bytes
             ) {
            System.out.println(a);
        }
        char[] bute=string.toCharArray();

//        System.out.println(string);
        for (char a:bute
        ) {
            System.out.println(a);
        }
        String replace=string.replace("1","2");
        System.out.println(replace);
        string=string.substring(0,1);
        System.out.println(string);
        String sTRING="HELLOWORLD";
        System.out.println(sTRING.toLowerCase().toUpperCase());
        System.out.println(sTRING.contains("H"));
        String.valueOf(10);


//        System.out.println(bute);
    }
//    public String1(char[] buf1, int i, int i1) {
//    }
}
