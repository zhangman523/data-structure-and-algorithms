package dataStructure.queue;

/**
 * Java 实现的队列
 *
 * 队列的效率 和栈一样 插入数据和移除数据的时间复杂都都是O(1)
 * 双端队列
 *
 *  双端队列就是一个两端都是结尾的队列。队列的每一端都可以插入数据和移除数据项。这些方法可以
 *  叫做insertLeft() 和insertRight() ,以及removeLeft()和removeRight()。
 *  如果严格禁止调用insertLeft() 和以及removeLeft() 方法(或者禁用右端操作)，双端队列功能就和栈一样。
 *  禁止调用insertLeft() 和removeRight()方法(或者相反的另一对方法),它的功能就和队列一样了。
 */
public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;//队头
        rear = -1;//队尾
        nItems = 0;
    }

    public void insert(long j) {//put item at rear of queue
        if (rear == maxSize - 1) { //deal with wraparound
            rear = -1;
        }
        queArray[++rear] = j; //increment rear and insert
        nItems++;             //one more item
    }

    public long remove() { //take item from front of queue
        long temp = queArray[front++];  //get value and incr front
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }


    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);


        while (!queue.isEmpty()) {
            long n = queue.remove();
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
