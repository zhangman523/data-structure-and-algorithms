package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java 栈应用。通过栈实现字符串逆序
 */
public class Reverse {
    private String input;
    private String output;

    public Reverse(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX stack = new StackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            stack.push(ch);
        }
        output = "";
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            output = output + ch;
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverse reverse = new Reverse(input);
            output = reverse.doRev();
            System.out.println("Reversed: " + output);
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
