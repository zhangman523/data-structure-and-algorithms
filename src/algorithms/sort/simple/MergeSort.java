package algorithms.sort.simple;

/**
 * Java 递归实现的归并排序
 * 归并排序的效率只要O(N*logN) 比冒泡，插入和选择排序快的多(O(N^2))
 * <p>
 * 归并排序的缺点是它需要在存储器中有另一个大小等于被排序的数据项目的数组。
 * 如果初始数组几乎占满整个存储器，那么归并排序将不能工作,但是如果有足够的空间，归并排序会是一个很好的选择。
 * 归并排序的中心是归并两个已经有序的数组
 */
public class MergeSort {
    static class DArray {
        private long[] theArray;
        private int nElems;

        public DArray(int max) {
            theArray = new long[max];
            nElems = 0;
        }

        public void insert(long value) {
            theArray[nElems] = value;
            nElems++;
        }

        public void dispaly() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(theArray[j] + " ");
            }
            System.out.println();
        }

        public void mergeSort() {        //called by main()
            long[] workSpace = new long[nElems];
            recMergeSort(workSpace, 0, nElems - 1);
        }

        private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
            if (lowerBound == upperBound) {     //if rang is 1,
                return;                         //no use sorting
            } else {
                int mid = (lowerBound + upperBound) / 2;    //find midpoint
                recMergeSort(workSpace, lowerBound, mid);   //sort low half
                recMergeSort(workSpace, mid + 1, upperBound);//sort high half
                merge(workSpace, lowerBound, mid + 1, upperBound);      //merge them
            }
        }

        private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
            int j = 0;            //workspace index
            int lowerBound = lowPtr;
            int mid = highPtr - 1;
            int n = upperBound - lowerBound + 1;

            while (lowPtr <= mid && highPtr <= upperBound) {
                if (theArray[lowPtr] < theArray[highPtr]) {
                    workSpace[j++] = theArray[lowPtr++];
                } else {
                    workSpace[j++] = theArray[highPtr++];
                }
            }
            while (lowPtr <= mid) {
                workSpace[j++] = theArray[lowPtr++];
            }
            while (highPtr <= upperBound) {
                workSpace[j++] = theArray[highPtr++];
            }
            for (j = 0; j < n; j++) {
                theArray[lowerBound + j] = workSpace[j];
            }
        }
    }

    public static void main(String[] args){
        int maxSize = 100;
        DArray arr = new DArray(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(30);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.dispaly();
        arr.mergeSort();
        arr.dispaly();

    }
}
