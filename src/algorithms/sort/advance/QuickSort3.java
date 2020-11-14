package algorithms.sort.advance;

/**
 * Java 递归实现的快速排序
 * 利用三项数据取中划分的快速排序算法。算法和QuickSort2类似。
 * 使用插入排序来处理小于10个数据项的子数组。
 *  快速排序的效率
 *  快速排序的时间复杂度为 O(N*logN)
 */
public class QuickSort3 {
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
            int size = right - left + 1;
            if (size < 10) {
                insertionSort(left, right);
            } else {
                long median = medianOf3(left, right);
                int partition = partitionIt(left, right, median);
                recQuicklySort(left, partition - 1);
                recQuicklySort(partition + 1, right);
            }
        }

        private void insertionSort(int left, int right) {
            int in,out;
            for (out=left+1;out<=right;out++){
                long temp = theArray[out];
                in = out;
                while (in > 0 && theArray[in - 1] >= temp) { // until one is smaller
                    theArray[in] = theArray[in - 1];          // shift item right
                    --in;                       // go left one position
//                    display();
                }
                theArray[in] = temp;
            }
        }

        public long medianOf3(int left, int right) {
            int center = (left + right) / 2;
            //order left & center
            if (theArray[left] > theArray[center]) {
                swap(left, center);
            }
            //order left & right
            if (theArray[left] > theArray[right]) {
                swap(left, right);
            }
            //order center & right
            if (theArray[center] > theArray[right]) {
                swap(center, right);
            }
            swap(center, right - 1);   //put pivot on right
            return theArray[right - 1]; //return median value
        }

        public int partitionIt(int left, int right, long pivot) {
            int leftPart = left;    //right of first elem
            int rightPart = right - 1;  //left to pivot
            while (true) {
                while (theArray[++leftPart] < pivot) { //find bigger item
                    //nop
                }
                while (theArray[--rightPart] > pivot) { //find smaller item
                    //nop
                }

                if (leftPart >= rightPart) {
                    break;
                } else {
                    swap(leftPart, rightPart);
                }
            }
            swap(leftPart, right - 1);
            return leftPart;
        }

        private void swap(int dex1, int dex2) {
            long temp;
            temp = theArray[dex1];
            theArray[dex1] = theArray[dex2];
            theArray[dex2] = temp;
        }

        public void manualSort(int left, int right) {
            int size = right - left + 1;
            if (size <= 1) {    //not sort necessary
                return;
            }

            if (size == 2) {    //2 - sort left and right
                if (theArray[left] > theArray[right]) {
                    swap(left, right);
                    return;
                }
            } else {        //3 - sort left center & right
                if (theArray[left] > theArray[right - 1]) {
                    swap(left, right - 1);
                }
                if (theArray[left] > theArray[right]) {
                    swap(left, right);
                }
                if (theArray[right - 1] > theArray[right]) {
                    swap(right - 1, right);
                }
            }
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
