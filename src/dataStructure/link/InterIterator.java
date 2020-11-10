package dataStructure.link;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java 迭代器方法 链表
 */
public class InterIterator {
    private Link current;       //current link
    private Link previous;      // previous link
    private LinkList ourList;   // our linked list

    public InterIterator(LinkList list) {
        ourList = list;
        reset();
    }

    private void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {        // go to next link
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long dd) { //insert after
        Link newLink = new Link(dd);

        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        Link newLink = new Link(dd);

        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }

    static class LinkList {
        private Link first; //ref to link on list

        public LinkList() {
            first = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void insertFirst(long dd) {
            Link newLink = new Link(dd);
            newLink.next = first; //newLink --> old first
            first = newLink;
        }

        public Link getFirst() {
            return first;
        }

        public void setFirst(Link f) {
            first = f;
        }

        public InterIterator getIterator() {
            return new InterIterator(this);
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
    }

    static class Link {
        public long dData;
        public Link next;

        public Link(long dData) {

            this.dData = dData;
        }

        public void displayLink() {
            System.out.print("   " + dData);
        }
    }

    public static void main(String[] args) throws IOException {
        LinkList theList = new LinkList();

        InterIterator inter1 = theList.getIterator();

        long value;

        inter1.insertAfter(20);
        inter1.insertAfter(40);
        inter1.insertAfter(80);
        inter1.insertBefore(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete:  ");
            int choice = getChar();     //get user's option
            switch (choice) {
                case 's': // show
                    if (!theList.isEmpty()) {
                        theList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':   //rest
                    inter1.reset();
                    break;
                case 'n':       //advance to next item
                    if (!theList.isEmpty() && !inter1.atEnd()) {
                        inter1.nextLink();
                    } else {
                        System.out.println("Can't go to next link");
                    }
                    break;
                case 'g':
                    if (!theList.isEmpty()) {
                        value = inter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'b':       // insert before current
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    inter1.insertBefore(value);
                    break;
                case 'a':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    inter1.insertAfter(value);
                    break;
                case 'd':
                    if (!theList.isEmpty()) {
                        value = inter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }


    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
