package algorithms.sort.advance;

/**
 * Java 希尔排序
 * 希尔排序是基于插入排序的，希尔排序通过加大插入排序中元素之间的间隔，并在这些有间隔的元素中进行插入排序。
 * 从而使数据项能够最大跨度的移动。当这些数据项排过一趟序后，希尔算法减小数据项的间隔再进行排序。
 * 以此类推。
 *
 * 希尔排序的效率
 * 迄今为止，除了一些特殊的情况，还没有人能够从理论上分析希尔排序的效率。
 * 有各种各样的基于试验的评估，估计它的时间级从O(N^3/2)到  O(N^7/6)。
 *
 */
public class ShellSort {


    static class ArraySh {
        private long[] theArray;
        private int nElems;

        public ArraySh(int max) {
            theArray = new long[max];
            nElems = 0;
        }

        public void insert(int value) {
            theArray[nElems++] = value;
        }

        public void display() {
            System.out.print("A=");
            for (int j = 0; j < nElems; j++) {
                System.out.print(theArray[j] + " ");
            }
            System.out.println();
        }

        public void shellSort() {
            int inner, outer;
            long temp;
            int h = 1;
            while (h <= nElems / 3) {
                h = h * 3 + 1;
            }
            while (h > 0) {
                for (outer = h; outer < nElems; outer++) {
                    temp = theArray[outer];
                    inner = outer;

                    while (inner > h - 1 && theArray[inner - h] >= temp) {
                        theArray[inner] = theArray[inner - h];
                        inner -= h;
                    }
                    theArray[inner] = temp;
                }
                h = (h - 1) / 3;
            }
        }

    }

    public static void main(String[] args) {
        ArraySh theArray = new ArraySh(100);
        theArray.insert(77);
        theArray.insert(99);
        theArray.insert(44);
        theArray.insert(55);
        theArray.insert(22);
        theArray.insert(88);
        theArray.insert(11);
        theArray.insert(00);
        theArray.insert(66);
        theArray.insert(33);

        theArray.display();
        theArray.shellSort();
        theArray.display();
    }
}
