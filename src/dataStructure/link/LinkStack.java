package dataStructure.link;

/**
 * Java 链表实现的栈
 */
public class LinkStack {
    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(long j) {  // put item on top of stack
        theList.insertFirst(j);
    }

    public long pop() {         // take item from top of stack
        return theList.deleteFirst();
    }

    public boolean isEmpty() {  //true if stack is empty
        return theList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
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

    static class LinkList {
        private Link first;         //ref to first item on list

        public LinkList() {
            first = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void insertFirst(long dd) {  //insert at start of list
            Link newLink = new Link(dd);
            newLink.next = first;           // newLink -->old first
            first = newLink;                // first --> newLink
        }

        public long deleteFirst() {         // delete first item
            if (isEmpty()) return 0;
            Link temp = first;              // save reference to link
            first = first.next;             // delete it: first -->old next
            return temp.dData;              // return deleted link
        }


        public void displayList() {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.push(20);
        linkStack.push(40);
        linkStack.displayStack();

        linkStack.push(60);
        linkStack.push(80);

        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();

        linkStack.displayStack();
    }
}
