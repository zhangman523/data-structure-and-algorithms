package algorithms.sort.advance;

/**
 * Java 递归实现的快速排序
 * 如果排序的数据是有序或者逆序时。在这种情况下划分所带来的好处就没有了。算法的执行效率降低到O(N^2)
 */
public class QuickSort1 {
    static class ArrayIns {
        private long[] theArray;
        private int nElems;

        public ArrayIns(int max) {
            theArray = new long[max];
            nElems = 0;
        }

        public void insert(long value) {
            theArray[nElems++] = value;
        }

        public void display() {
            System.out.print("A= ");
            for (int j = 0; j < nElems; j++) {
                System.out.print(theArray[j] + " ");
            }
            System.out.println();
        }

        public void quicklySort() {
            recQuicklySort(0, nElems - 1);
        }

        public void recQuicklySort(int left, int right) {
            if (right - left <= 0) {
                return;
            } else {
                long pivot = theArray[right];
                int partition = partitionIt(left, right, pivot);
                display();
                recQuicklySort(left, partition - 1);
                recQuicklySort(partition + 1, right);
                display();
            }
        }

        public int partitionIt(int left, int right, long pivot) {
            int leftPart = left - 1;    //right of first elem
            int rightPart = right ;  //left to pivot
            while (true) {
                while (leftPart < right && theArray[++leftPart] < pivot) { //find bigger item
                    //nop
                }
                while (rightPart > left && theArray[--rightPart] > pivot) { //find smaller item
                    ;
                }

                if (leftPart >= rightPart) {
                    break;
                } else {
                    swap(leftPart, rightPart);
                }
            }
            swap(leftPart, right);
            return leftPart;
        }

        private void swap(int dex1, int dex2) {
            long temp;
            temp = theArray[dex1];
            theArray[dex1] = theArray[dex2];
            theArray[dex2] = temp;
        }

    }

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        arr.quicklySort();
        arr.display();
    }
}
