package dataStructure.link;

/**
 * Java 链表实现的队列
 */
public class LinkQueue {
    private FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insertLast(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    static class Link {
        public long dData;      //data item
        public Link next;       //next link in list

        public Link(long dData) {
            this.dData = dData;
        }

        public void displayLink() {      // display ourself
            System.out.print(dData + " ");
        }
    }

    static class FirstLastList {
        private Link first;         //ref to first item
        private Link last;          //ref to last item

        public FirstLastList() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {  // true if no links
            return first == null;
        }

        public void insertLast(long dd) {       //insert at end of list
            Link newLink = new Link(dd);        // make new link
            if (isEmpty()) {                    // if empty list
                first = newLink;                // first --> newLink
            } else {
                last.next = newLink;            // old last --> newLink
            }
            last = newLink;                     // newLink <-- last
        }

        public long deleteFirst() {              // delete first link
            if (isEmpty()) return 0;
            long temp = first.dData;
            if (first.next == null) {            // if only one item
                last = null;                     // null <--last;
            }
            first = first.next;                 // first --> old next
            return temp;
        }

        public void displayList() {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(20);
        linkQueue.insert(40);

        linkQueue.displayQueue();

        linkQueue.insert(60);
        linkQueue.insert(80);

        linkQueue.displayQueue();

        linkQueue.remove();
        linkQueue.remove();

        linkQueue.displayQueue();
    }
}
