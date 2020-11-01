package sort.simple;

/**
 * Java 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);


        arr.display();

        arr.bubbleSort();

        arr.display();
    }

    static class ArrayBub {
        private long[] a;
        private int nElems;

        public ArrayBub(int max) {
            a = new long[max];
            nElems = 0;
        }

        public void insert(long value) {
            a[nElems] = value;
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println("");
        }

        /**
         * 认识不变性
         * 在许多算法中，有些条件在算法执行时是不变的。这些条件被称为不变性。认识不变性对理解算法是有用的；
         * 可以反复地检查不变性是否为真，如果不是的话就标记出错。
         * <p>
         * 在排序算法中，不变性是值out右边的所有数据项为有序。在算法的整个运行过程中这个条件始终为真。
         * (在第一趟排序前，尚未排序，因为out开始在数据项最右侧，没有数据项在out的右边)
         *
         * 冒泡排序的效率
         * 通过排序长度为10的数组可以看到，in 和in+1 在第一趟排序进行了9次比较，第二趟进行了8次排序，如此类推,
         * 直到最有一趟进行了一次比较。对于长度为10 的数组，就是 9+8+7+6+5+4+3+2+1=45
         * 一般来说，当数组中有N个数据项，则第一趟为N-1次比较，第二天为N-2次比较，如此类推。得出求和公式
         * (N-1)+(N-2)+(N-3)+...+1 = N(N-1)/2
         * 当N 为10 时，N(N-1)/2=10*9/2 =45
         * 算法约做了N^2/2次比较 由于常数不算在大O 表达式中，可以忽略2 。所以冒泡排序算法运行所需的时间是
         * O(N^2) 时间级别
         */
        public void bubbleSort() {
            int out, in;
            for (out = nElems - 1; out > 0; out--) {// outer loop (backward)
                for (in = 0; in < out; in++) {      // inner loop (forward)
                    if (a[in] > a[in + 1]) {
                        swap(in, in + 1);
                    }
                }
            }// end bubble sort
        }

        private void swap(int one, int two) {
            System.out.println("swap " + a[one] + " and " + a[two]); //test
            long temp = a[one];
            a[one] = a[two];
            a[two] = temp;
            display();//test
        }

    }
}
