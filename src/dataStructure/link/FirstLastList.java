package dataStructure.link;

/**
 * Java 实现的双端链表
 */
public class FirstLastList {
    private Link first;         //ref to first link
    private Link last;          // ref to last link

    public FirstLastList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {        //if empty list,
            last = newLink;     // newLink <-- last
        }
        newLink.next = first;   //newLink -->old first
        first = newLink;        //first -->newLink
    }

    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public long deleteFirst() {      //delete first link
        long temp = first.dData;
        if (first.next == null) {   //if only one item
            last = null;            //last -->null
        }
        first = first.next;         //first -->old next
        return temp;
    }

    public void displayList() {
        System.out.println("List (first-->last):");
        Link current = first;       //start at beginning of list
        while (current != null) { //until end of list;
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        FirstLastList lastList = new FirstLastList();

        lastList.insertFirst(22);
        lastList.insertFirst(44);
        lastList.insertFirst(66);

        lastList.insertLast(11);
        lastList.insertLast(33);
        lastList.insertLast(55);

        lastList.displayList();

        lastList.deleteFirst();
        lastList.deleteFirst();
        lastList.displayList();
    }

    static class Link {
        public long dData;
        public Link next;

        public Link(long dData) {
            this.dData = dData;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }

}
