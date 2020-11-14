package algorithms.sort.advance;

/**
 * 划分
 * 划分是快速排序的根本机制，但是划分本身也是一个有用的操作。
 * 划分算法的效率
 * 划分算法的运行时间为O(N)。
 */
public class Partition {

    static class ArrayPar {
        private long[] theArray;
        private int nElems;

        public ArrayPar(int max) {
            theArray = new long[max];
            nElems = 0;
        }

        public void insert(long value) {
            theArray[nElems++] = value;
        }

        public int size() {
            return nElems;
        }

        public void display() {
            System.out.print("A= ");
            for (int j = 0; j < nElems; j++) {
                System.out.print(theArray[j] + " ");
            }
            System.out.println();
        }

        public int partitionIt(int left, int right, long pivot) {
            int leftPart = left - 1;    //right of first elem
            int rightPart = right + 1;  //left to pivot
            while (true) {
                while (leftPart < right && theArray[++leftPart] < pivot) { //find bigger item
                    //nop
                }
                while (rightPart > left && theArray[--rightPart] > pivot) { //find smaller item
                    ;
                }

                if (leftPart > rightPart) {
                    break;
                } else {
                    swap(leftPart, rightPart);
                }
            }
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
        ArrayPar arr = new ArrayPar(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        System.out.println("Pivot is " + pivot);
        int size = arr.size();

        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        arr.display();
    }
}
