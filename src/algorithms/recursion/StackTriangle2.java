package algorithms.recursion;

import java.io.IOException;

import static dataStructure.link.InterIterator.getInt;

public class StackTriangle2 {

    static class StackX {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new int[maxSize];
            top = -1;
        }


        public void push(int p) {
            stackArray[++top] = p;
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
    }

    static int theNumber;
    static int theAnswer;
    static StackX theStack;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();

        stackTriangle();

        System.out.println("Triangle = " + theAnswer);
    }

    public static void stackTriangle() {
        theStack = new StackX(10000);

        theAnswer = 0;      //initialize answer
        while (theNumber > 0) {     //until n is 1
            theStack.push(theNumber);       //push value
            --theNumber;                    //decrement value
        }
        while (!theStack.isEmpty()) {       //until stack empty
            int newN = theStack.pop();      //pop value
            theAnswer += newN;              //add to answer
        }
    }
}
