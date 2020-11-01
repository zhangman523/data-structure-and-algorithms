package dataStructure.stack;

/**
 * Java 数组实现的栈
 */
public class Stack {


    public static void main(String[] args) {
        StackX stack = new StackX(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()){
            long value = stack.pop();
            System.out.print(value +" ");
        }
        System.out.println();
    }

    static class StackX {
        private int maxSize;
        private long[] stackArray;
        private int top;

        public StackX(int maxSize) {
            this.maxSize = maxSize;
            stackArray = new long[maxSize];
            top = -1;
        }

        public void push(long i) {
            stackArray[++top] = i;
        }

        public long pop() {
            return stackArray[top--];
        }

        public long peek() {
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
