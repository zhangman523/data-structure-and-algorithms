package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java 栈实现分隔符匹配
 * 栈通常用于某种类型的文本串。通常，文本串是计算机语言写的代码行。
 * 而解析他们的程序就是编译器。
 * 栈的效率
 * StackX 类中实现的栈，数据项入栈和出栈的时间复杂度都为常数O(1)
 */
public class Brackets {

    private String input;

    public Brackets(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX stack = new StackX(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + j);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + j);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }


    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.print("Enter a string: ");
            input = getString();
            if (input.equals("")) {
                break;
            }
            Brackets reverse = new Brackets(input);
            reverse.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    static class StackX {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public StackX(int maxSize) {
            this.maxSize = maxSize;
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
            return (top == -1);
        }

        public boolean isFull() {
            return (top == maxSize - 1);
        }
    }
}
