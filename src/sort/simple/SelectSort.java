package sort.simple;

/**
 * Java 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr = new ArraySel(maxSize);

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

        arr.selectionSort();

        arr.display();
    }

    static class ArraySel {
        private long[] a;
        private int nElems;

        public ArraySel(int max) {
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
         * 不变性
         * 在选择排序中，小于或等于out的位置的数据都是有序的。
         * 选择排序的效率
         * 选择排序和冒泡排序执行了相同次数的比较 N(N-1)/2。对于10个数据 比较了45次，但是10个数据只需要少于10次交换。
         * 对于100个数据项需要4950次比较，但是进行了不到100次交换。当N值很大时，比较的次数时主要的，
         * 所以选择排序和冒泡排序一样运行了O(N^2)时间。但是选择排序无疑更快，因为它进行的交换次数少的多，特别是如果
         * 交换时间级比比较的时间大得多时。选择排序实际上是相当快的。
         */
        public void selectionSort() {
            int out, in, min;
            for (out = 0; out < nElems - 1; out++) {// outer loop
                min = out;
                for (in = out + 1; in < nElems; in++) {      // inner loop (forward)
                    if (a[in] < a[min]) {
                        min = in;
                    }
                }
                swap(out, min);
            }// end selection Sort
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
