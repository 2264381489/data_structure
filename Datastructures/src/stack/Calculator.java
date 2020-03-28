package stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面老式的思路,完成表达式的运算
        String expression = "3+2*6-2";
        //创建两个栈,数栈,一个符号栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch中
        //开始扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么然后做相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈中有操作符,就进行比较,,如果当前的操作符的优先级小于或等于栈中的操作符,就需要从数栈中pop出两个数
                    //在符号栈中pop出一个符号,进行运算,得到结果,入数栈,然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1=numberStack.pop();
                        num2=numberStack.pop();
                        oper=operStack.pop();
                        res=numberStack.cal(num1,num2,oper);
                        //把运算的结果如数栈
                        numberStack.push(res);
                        //然后将当前的操作运算符如符号栈
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符的优先级大于栈中的操作符,就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接进符号栈
                    operStack.push(ch);
                }
            }else {//如果是数直接入数栈
                numberStack.push(ch-48);//措了就减48
            }
            //index+1,并判断是否扫描到expression最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当前表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号,并运行.
        while(true){
            //如果符号栈为空,则计算到最后的结果,数栈中只有一个数组[结果]
            if (operStack.isEmpty()){
                break;
            }
            num1=numberStack.pop();
            num2=numberStack.pop();
            oper=operStack.pop();
            res=numberStack.cal(num1,num2,oper);
            numberStack.push(res);//入栈
        }

        System.out.printf("表达式%s=%d",expression,numberStack.pop());//数栈的最后一位是要求的答案
    }
}
    //先创建一个栈
    class ArrayStack2 {
        private int maxsize;//栈的大小
        private int[] stack;//数组,数组模拟栈,数据就放在数组
        private int top=-1;//栈顶

        //构造函数
        public ArrayStack2(int maxsize) {
            this.maxsize = maxsize;
            stack = new int[this.maxsize];
        }

        //增加一个方法,可以返回栈顶的值
        public int peek() {
            return stack[top];

        }

        //栈满
        public boolean isFull() {
            return top == maxsize - 1;
        }

        //栈空
        public boolean isEmpty() {
            return top == -1;
        }

        //入栈push
        public void push(int value) {
            if (isFull()) {
                System.out.println("栈满");
                return;
            }
            top++;
            stack[top] = value;
        }

        //出栈pop 将栈顶的数据返回
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空,没有数据");
            }
            //显示站的情况,遍历栈,需要从栈顶开始显示数据
            int value = stack[top];
            top--;
            return value;
        }

        //显示站的情况,[遍历栈]遍历时,需要从栈顶开始显示数据
        public void list() {
            if (isEmpty()) {
                System.out.println("没有数据");
                return;
            }
            //需要从栈顶开始显示数据
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d\n", i, stack[i]);
            }
        }

        //返回预算级的优先级,优先级使用数字表示,
        //数字越大,优先级越高
        public int priority(int oper) {
            if (oper == '*' || oper == '/') {
                return 1;
            } else if (oper == '+' || oper == '-') {
                return 0;
            } else {
                return -1;
            }
        }

        //判断是不是一个运算符
        public boolean isOper(char val) {
            return val == '+' || val == '-' || val == '*' || val == '/';
        }

        //计算方法
        public int cal(int num1, int num2, int oper) {
            int res = 0;
            switch (oper) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                default:
                    break;
            }
            return res;
        }
    }
