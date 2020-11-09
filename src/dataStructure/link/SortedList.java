package dataStructure.link;

public class SortedList {
    private Link first;     //ref to first item on list

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {      //insert, in order
        Link newLink = new Link(key);   // make new link
        Link previous = null;           // start at first
        Link current = first;

        while (current != null && key > current.dData) {    //or key > current
            previous = current;
            current = current.next;     // go to next item
        }
        if (previous == null) {         // at beginning of list
            first = newLink;            // first --> newLink
        } else {                        // not at beginning
            previous.next = newLink;    // old prev -->newLink
        }
        newLink.next = current;         // newLink --> old current
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
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


    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(20);
        sortedList.insert(40);

        sortedList.displayList();

        sortedList.insert(10);
        sortedList.insert(30);
        sortedList.insert(50);

        sortedList.displayList();

        sortedList.remove();

        sortedList.displayList();
    }
}
