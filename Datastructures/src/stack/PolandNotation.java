package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)x5-6 => 3 4 + 5 x 6-
        //为了方便我们用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路:
        // 1.先将3 4 + 5 * 6 -放到一个ArrayList中
        //2.将ArrayList传递给一个方法,配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList" + rpnList);
        int res=calculate(rpnList);
        System.out.println("计算机结果是"+res);
    }

    //将一个逆波兰表达式i依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将参数分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
//完成对逆波兰表达式的运算,

    /**
     * 1.从左至右扫描,将3和4压入堆栈
     * 2.遇到+运算符,因此弹出4和3,计算出4+3的值,将7入栈
     * 3.将5入栈
     * 4.接下来是x运算符,因此弹出5和7,计算出5*7=35,将35入栈
     * 5.将6入栈
     * 6.最后是-运算符,计算出35-6的值,即29,由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建一个栈,只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : ls) {
//这里使用一个正则表达式来取出数
            if (item.matches("\\d+")) {
                //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数,并运算,在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1/ num2;
                }else {
                    throw new RuntimeException("运算符有误!");


                }
                //把res入栈
                stack.push(res+"");
            }


        }
        return Integer.parseInt(stack.pop());

    }


}
