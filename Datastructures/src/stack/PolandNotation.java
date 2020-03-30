package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转换成后缀表达式
        //1.1+((2+3)x4)-5=>123+4*+5-
        //2.因为直接对str进行操作,不方便,因此先将中缀表达式对应的List
        //即"1+((2+3)x4)-5"=>ArrayList[1,+,(,(,2,+,3,),x,4,),-5]
        //3.将得到的中缀表达式转换为后缀表达式
        //ArrayList[1,+,(,(,2,+,3,),x,4,),-5] =>ArrayList[1 2 3 + 4 * + 5 -]
        //方法:将得到的中缀表达式对应的list=>后缀表达式对应的List
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpression = toInfixExpression(expression);
        System.out.println("中缀表达式对应的list"+infixExpression);//
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpression);
        System.out.println("后缀表达式对应的list"+suffixExpressionList);
        /*
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
    */
    }
    //ArrayList[1,+,(,(,2,+,3,),x,4,),-5] =>ArrayList[1 2 3 + 4 * + 5 -]
    //方法:将得到的中缀表达式对应的list=>后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //因为s2在整个转换的过程中,没有pop操作,而且后面我们还要逆序输出
        //因此比较麻烦,在这里我们就不用Stack<Sting>直接使用List<String>  s2
        List<String> s2 = new ArrayList<>();//存储中间结果的栈s2
        //遍历ls
        for (String item : ls) {
            //如果是一个数,就加入到栈s2
            if (item.matches("\\d+")) {
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号,则依次弹出s1栈的运算符,并压入s2,直到遇到左括号为止,此时将这一对括号丢弃
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//!将( 弹出,,消除小括号
            }else {
                //当item的优先级小于等于栈顶运算符的,将s1栈顶的运算符弹出并加入到s2中,再次转到()与s1中新的栈顶运算符相互比较
                //问题:我们缺少一个比较优先级高地的方法.
                while (s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
//将s1中的剩余的运算符依次弹出并加入s2
        while(s1.size()!=0) {
            s2.add(s1.pop());
        }
        return s2;
    }
    //方法将中缀表达式转换成对应的List
    public static List<String> toInfixExpression(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;//这个是一个指针,用于遍历中缀表达是字符串
        String str;//对多位数的拼接
        char c;//每遍历到一个字符,就放入c
        do {
            //如果是一个非数组,我需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                //如果是一个数,需要考虑多位数
                str = "";//先将str之后曾"
                while (i < s.length() && (c = s.charAt(i)) >= 48 &&(c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }//为了应对多位数
                ls.add(str);
            }
        } while (i < s.length()) ;
            return ls;//返回
    }
    //将一个逆波兰表达式i依次将数据和运算符放入到ArrayList中;

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
//编写一个类Operation可一个返回一个运算符对应的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=1;
    private static int DIV=1;
//写一个方法,返回对应的优先级数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
                default:
                    System.out.println("不存在该运算");
                    break;
        }
        return result;
    }


}
