package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java 通过栈 求后缀表达式
 */
public class Infix {

    static class StackX {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new char[maxSize];
            top = -1;
        }

        public void push(char i) {
            stackArray[++top] = i;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize;
        }

        public char peekN(int n) {
            return stackArray[n];
        }

        public int size() {
            return top + 1;
        }

        public void displayStack(String s) {
            System.out.print(s);
            System.out.print("Stack (bottom -->top :");
            for (int j = 0; j < size(); j++) {
                System.out.print(peekN(j) + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 中缀转换为后缀
     */
    static class InToPost {     //infix to postifx conversion
        private StackX stackX;
        private String input;
        private String output = "";

        public InToPost(String in) {
            input = in;
            int stackSize = input.length();
            stackX = new StackX(stackSize);
        }

        public String doTrans() { //do translation postfix
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                stackX.displayStack("For " + ch + " "); //*diagnostic*
                switch (ch) {
                    case '+':               //it's + or -
                    case '-':
                        getOper(ch, 1);  //go pop operators
                        break;             // (precedence 1)
                    case '*':              // it's * or /
                    case '/':
                        getOper(ch, 2);  //go pop operators
                        break;             // (precedence 2)
                    case '(':              //it's a left paren
                        stackX.push(ch);   // push it
                        break;
                    case ')':               //it's a right paren
                        gotParen(ch);       // go pop operators
                        break;
                    default:                // must be an operand
                        output = output + ch; //write it to output
                        break;
                }
            }
            while (!stackX.isEmpty()) {
                stackX.displayStack("while ");
                output = output + stackX.pop();
            }
            stackX.displayStack("End  ");
            return output;
        }


        private void getOper(char opThis, int prec1) {
            while (!stackX.isEmpty()) {
                char opTop = stackX.pop();
                if (opTop == '(') {  //if it's a '('
                    stackX.push(opTop); //restore '('
                    break;
                } else {
                    int prec2;      //precedence of new op
                    if (opTop == '+' || opTop == '-') { //find new op prec
                        prec2 = 1;
                    } else {
                        prec2 = 2;
                    }
                    if (prec2 < prec1) {    //if prec of new op less than prec of old
                        stackX.push(opTop); //save newly-popped op
                        break;
                    } else {                //prec of new not less than prec of old
                        output = output + opTop;
                    }

                }
            }
            stackX.push(opThis);
        }

        private void gotParen(char ch) {
            while (!stackX.isEmpty()) {
                char chx = stackX.pop();
                if (chx == '(') {   //if popped '('
                    break;          // we're done
                } else {            // if popped operator
                    output = output + chx;  //output it
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix :");

            input = getString();
            if (input.equals("")) {
                break;
            }

            InToPost theTrans = new InToPost(input);

            output = theTrans.doTrans();
            System.out.println("Postfix is  " + output + "\n");
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
