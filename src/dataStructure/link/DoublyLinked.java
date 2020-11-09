package dataStructure.link;

/**
 * Java 实现的双向链表
 */
public class DoublyLinked {
    static class Link {
        public long dData;
        public Link next;
        public Link previous;

        public Link(long dData) {
            this.dData = dData;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }

    static class DoublyLinkedList {
        private Link first;     //ref to first
        private Link last;      //ref to last

        public DoublyLinkedList() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void insertFirst(long dd) {      //insert at front of list
            Link link = new Link(dd);           //make new link
            if (isEmpty()) {                    //if empty list,
                last = link;                    // newLink <--list
            } else {
                first.previous = link;          //newLink <-- old first
            }
            link.next = first;
            first = link;
        }

        public void insertLast(long dd) {        //insert at end of list
            Link newLink = new Link(dd);        // make new link
            if (isEmpty()) {                     // if empty list,
                first = newLink;                  // first --> newLink
            } else {
                last.next = newLink;            // old last -->newLink
                newLink.previous = last;        // old last <-- newLink
            }
            last = newLink;
        }

        public Link deleteFirst() {              //delete first link
            if (isEmpty()) return null;
            Link temp = first;

            if (first.next == null) {               //if only one item
                last = null;                    //null <-- last
            } else {
                first.next.previous = null;     //null <-- old next
            }
            first = first.next;
            return temp;
        }

        public Link deleteLast() {
            if (isEmpty()) return null;
            Link temp = last;
            if (first.next == null) {
                first = null;
            } else {
                last.previous.next = null;
            }
            last = last.previous;
            return temp;
        }

        public boolean insertAfter(long key, long dd) {   //insert dd just  after key
            Link current = first;
            while (current.dData != key) {      //until match is found
                current = current.next;         // move to next link
                if (current == null) {
                    return false;               //didn't find it
                }
            }
            Link newLink = new Link(dd);        //make new link

            if (current == last) {              // if last link,
                newLink.next = null;            //newLink  --> null
                last = newLink;                 //last --> newLink
            } else {
                newLink.next = current.next;    //newLink --> old next
                current.next.previous = newLink;    //newLink <--old next
            }
            newLink.previous = current;         // old current <-- newLink
            current.next = newLink;             // old current --> newLink
            return true;
        }


        public Link deleteKey(long key) {
            Link current = first;
            while (current.dData != key) {
                current = current.next;
                if (current == null) {
                    return null;
                }
            }
            if (current == first) {
                first = current.next;
            } else {
                current.previous.next = current.next;
            }
            if (current == last) {
                last = current.previous;
            } else {
                current.next.previous = current.previous;
            }
            return current;
        }

        public void displayForward() {
            System.out.print("List(first-->Last):");
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }

        public void displayBackword() {
            System.out.println("Link (last -->first): ");
            Link current = last;
            while (current != null) {
                current.displayLink();
                current = current.previous;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackword();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();
        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);
        theList.displayForward();

    }
}
