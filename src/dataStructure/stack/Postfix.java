package dataStructure.stack;

import java.io.IOException;

import static dataStructure.stack.Infix.getString;

/**
 * java 实现 后缀表达式的求值 (个位数的中缀表达式)
 */
public class Postfix {
    static class StackX {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int i) {
            stackArray[++top] = i;
        }

        public int pop() {
            return stackArray[top--];
        }

        public int peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize;
        }

        public int peekN(int n) {
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

    static class ParsePost {
        private StackX stackX;
        private String input;

        public ParsePost(String in) {
            input = in;
        }

        public int doParse() {
            stackX = new StackX(20); //make new stack
            char ch;
            int j;
            int num1, num2, interAns;

            for (j = 0; j < input.length(); j++) { //for each char,
                ch = input.charAt(j);
                stackX.displayStack(" " + ch + " ");
                if (ch >= '0' && ch <= '9') {   //if it's a number
                    stackX.push((int) (ch - '0'));  //push it
                } else {
                    num2 = stackX.pop();
                    num1 = stackX.pop();

                    switch (ch) {
                        case '+':
                            interAns = num1 + num2;
                            break;
                        case '-':
                            interAns = num1 - num2;
                            break;

                        case '*':
                            interAns = num1 * num2;
                            break;
                        case '/':
                            interAns = num1 / num2;
                            break;
                        default:
                            interAns = 0;
                    }
                    stackX.push(interAns); //push result;
                }
            }
            interAns = stackX.pop();
            return interAns;
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
            System.out.print("Enter postfix:");
            input = getString();
            if (input.equals("")) {
                return;
            }
            ParsePost parsePost = new ParsePost(input);
            output = parsePost.doParse();
            System.out.println("Evaluates to :" + output);
        }
    }
}
