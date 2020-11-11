package algorithms.sort.simple;

/**
 * Java 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr = new ArrayIns(maxSize);

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

        arr.insertionSort();

        arr.display();
    }

    static class ArrayIns {
        private long[] a;
        private int nElems;

        public ArrayIns(int max) {
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
         * 插入排序中的不变性
         * 在每趟结束时，在将temp位置的项插入后，比out 变量下标号小的数据项都是局部有序的。
         * 插入排序的效率
         * 在每第一趟排序中，他最多比较一次，第二趟最多比较两次，一次类推。最后一趟有N-1次。
         * 1+2+3+...+N-1 = N(N-1)/2 然而在每一趟排序发现插入点之前，平均只有全体数据项的一半真的进行比较，我们
         * 除以2得到 N(N-1)/4。复制的次数大致等于比较的次数。然而，一次复制与一次交换的时间耗费不同，所以相对于
         * 随机数据，这个算法比冒泡排序快一倍，比选择排序略快。
         * 所以对随机顺序的数据进行插入排序也需要O(N^2)的时间级。
         * 对于已经有序或者基本有序的数据来说，插入排序要好得多。当数据有序的时候，while 循环的条件总是假的，
         * 所以它变成了外层循环中的一个简单语句，执行N-1次。这种情况下，算法运行只需要O(N)时间。如果数据基本有序，
         * 插入排序几乎需要O(N)的时间。然而对于逆序排序的数据，每次的比较和移动都会执行，所以插入排序不会比冒泡排序
         * 快。
         *
         */
        public void insertionSort() {
            int out, in;
            for (out = 0; out < nElems; out++) {// out is dividing line
                long temp = a[out];             //remove marked item
                in = out;                       //start shifts at out
                while (in > 0 && a[in - 1] >= temp) { // until one is smaller
                    a[in] = a[in - 1];          // shift item right
                    --in;                       // go left one position
//                    display();
                }
                a[in] = temp;                   // insert marked item
                display(); //test code
            }// end insertion Sort
        }
    }
}
