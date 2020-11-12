package algorithms.recursion;

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

    class StackX {
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

    // TODO: 2020/11/12  待实现 
}
