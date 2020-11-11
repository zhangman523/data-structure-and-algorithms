package dataStructure.link;

/**
 * java 链表
 * 链条的效率
 * 在表头插入和删除数据速度很快。仅需要改变一两个引用值，所以花费O(1)的时间
 */
public class LinkList {
    private Link first; //ref to link on list

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first; //newLink --> old first
        first = newLink;
    }

    public Link deleteFirst() {  //delete first item
        if (isEmpty()) return null;
        Link temp = first;      //(assumes list not empty;
        first = first.next;     //save reference to link
        return temp;            // return deleted link
    }

    public Link find(int key) {     //find link with given key
        if (isEmpty()) return null; // assume not-empty list
        Link current = first;       // start at 'first'
        while (current.iData != key) {  //while not match ,
            if (current.next == null) {// if end of it
                return null;
            } else {                    // not end of list
                current = current.next; //go to next link
            }
        }
        return current;                 // found it
    }

    public Link delete(int key) { //delete link with given key
        if (isEmpty()) return null;
        Link current = first;       //algorithms.search for link
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;    //don't find it
            } else {
                previous = current;     //go to next link
                current = current.next;
            }
        }   //fount it
        if (current == first) {     //if first link
            first = first.next;     // change first
        } else {                    // otherwise
            previous.next = current.next;   //bypass it
        }
        return current;
    }

    public void displayList() {
        System.out.println("List (first-->last)");
        Link current = first;       //start at beginning of list
        while (current != null) { //until end of list;
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

//        while (!theList.isEmpty()) {
//            Link aLink = theList.deleteFirst();
//            System.out.print("Delete  ");
//            aLink.displayLink();
//            System.out.println();
//        }

        Link f = theList.find(4);//find item
        if (f != null) {
            System.out.println("Found link with key :" + f.iData);
        } else {
            System.out.println("Can't find link");
        }
        Link d = theList.delete(66);

        if (d != null) {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }
        theList.displayList();
    }


    static class Link {
        public int iData;
        public double dData;
        public Link next;

        public Link(int iData, double dData) {
            this.iData = iData;
            this.dData = dData;
        }

        public void displayLink() {
            System.out.print("   " + iData + ", " + dData);
        }
    }
}
