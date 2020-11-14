package algorithms.recursion;

import java.io.IOException;

import static dataStructure.link.InterIterator.getInt;

/**
 * 消除递归
 * 有一些算法趋向于用递归的方法，另一些算法则不是。正如前面已经看到的那样，递归的triangle() 和factorial()方法
 * 可以用一个简单的循环来实现，那样效率更高。但是，各种分治算法，比如归并排序的归底函数，能很好的工作。
 * <p>
 * 一个算法作为一个递归的方法通常从概念上很容易理解，但是，实际应用中证明递归算法的效率不太高。
 * 在种情况下，把递归的算法转换成非递归的算法非常有用。这种转换经常会用到栈。
 * <p>
 * 递归和栈
 * 递归和栈之间有一种紧密的联系。事实上，大部分的编译器都是使用栈来实现递归的。
 * 正如我们曾经提到过，当调用一个方法的时候，编译器会把这个方法的所有参数及返回地址（这个方法返回
 * 时控制到达的地方）都压入栈，然后把控制转移给这个方法。当方法返回的时候，这些值退栈。参数消失，并且控制
 * 权重新返回到地址处。
 * <p>
 * Java 通过栈来模拟递归实现triangle
 */
public class StackTriangle {

    static class Params {
        public int n;
        public int returnAddress;

        public Params(int nn, int ra) {
            n = nn;
            returnAddress = ra;
        }
    }

    static class StackX {
        private int maxSize;
        private Params[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new Params[maxSize];
            top = -1;
        }

        public void push(Params p) {
            stackArray[++top] = p;
        }

        public Params pop() {
            return stackArray[top--];
        }

        public Params peek() {
            return stackArray[top];
        }
    }

    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();

        recTriangle();

        System.out.println("Triangle= " + theAnswer);
    }

    /**
     * 把递归程序转换成了使用栈的程序。这表明对于任意一个递归算法都可能作出这种转换，实际上这就是一个例子。
     * 实践中，人们往往从一开始就重新思考基于栈的算法，而不是从递归算法转化，这个做更为实用。
     *
     */
    public static void recTriangle() {
        theStack = new StackX(10000);
        codePart = 1;
        while (!step()){  //call step() until it's tue
        }
    }

    public static boolean step() {
        switch (codePart) {
            case 1:                 //initial call
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            case 2:                 //method entry
                theseParams = theStack.peek();
                if (theseParams.n == 1) {
                    theAnswer = 1;
                    codePart = 5; //exit
                } else {
                    codePart = 3;
                }
                break;
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2; //go enter method
                break;
            case 4:           //calculation
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress;// 4 or 6
                theStack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }
}
