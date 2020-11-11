package algorithms.search;

/**
 * java 递归实现的二分查找
 * 递归实现的二分查找和非递归查找有同样大O效率：O(logN)。
 * 递归的二分查找更为简洁，但是速度可能更慢一点。
 */
public class BinarySearch {
    static class OrderArray {
        private long[] a;
        private int nElems;

        public OrderArray(int max) {
            a = new long[max];
            nElems = 0;
        }

        public int size() {
            return nElems;
        }

        public int find(long searchKey) {
            return recFind(searchKey, 0, nElems - 1);
        }

        private int recFind(long searchKey, int lowerBound, int upperBound) {
            int curIn;
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;                  //found it
            } else if (lowerBound > upperBound) {
                return nElems;                 // can't find it
            } else {
                if (a[curIn] < searchKey) {
                    return recFind(searchKey, curIn + 1, upperBound);
                } else {
                    return recFind(searchKey, lowerBound, curIn - 1);
                }
            }
        }


        public void insert(long value) {
            int j;
            for (j = 0; j < nElems; j++) {  // find where is goes
                if (a[j] > value) {         // linear algorithms.search
                    break;
                }
            }
            for (int k = nElems; k > j; k--) {  // move bigger ones up
                a[k] = a[k - 1];
            }
            a[j] = value;       //insert it
            nElems++;           // increment size
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        OrderArray array = new OrderArray(maxSize);
        array.insert(72);
        array.insert(90);
        array.insert(45);
        array.insert(126);
        array.insert(54);
        array.insert(99);
        array.insert(144);
        array.insert(27);
        array.insert(135);
        array.insert(81);
        array.insert(18);
        array.insert(108);
        array.insert(9);
        array.insert(117);
        array.insert(63);
        array.insert(36);

        array.display();
        int searchKey = 27;

        if (array.find(searchKey) != array.size()) {
            System.out.println("found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
    }
}
