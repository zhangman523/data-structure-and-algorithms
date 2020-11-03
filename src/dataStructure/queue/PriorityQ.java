package dataStructure.queue;

/**
 * Java 数组实现的优先队列
 * 在数据量很少或不关心速度的情况先可以用数组实现。如果数据量很大或者速度很重要。采用堆是最好的选择
 * 优先队列的效率，插入操作需要O(N) ,而删除操作则需要O(1)。
 */
public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    /**
     * 插入是应先判断是否已满。优先队列不像队列那样必须有front 和rear 字段，它的front 总是nItem-1，rear 总是0。
     *
     * @param item
     */
    public void insert(long item) {
        int j;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(5);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(20);
        priorityQ.insert(40);
        while (!priorityQ.isEmpty()) {
            long item = priorityQ.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
