package list;

import java.util.HashMap;

class LinkedList {
    Node head;
    static class Node{
        int data;
        int index;
        String species;
        Node next;
        Node(int d, String animals){data=d; species=animals; next=null;}

        public void delete() {
            if(next == null){
                return;
            }
            this.data = next.data;
            this.species = next.species;
            this.index = next.index;
            this.next = next.next;
        }

        public void setIndex(int index){
            this.index = index;
        }
    }

    public void printLinkedList(){
        Node n = head;
        System.out.println("traversing Linked List ");
        while(n!= null){
            System.out.println(n.data+" is a "+n.species+"index is "+n.index);
            n=n.next;
        }
    }
    public void deleteNode(Node currentNode, Node prevNode){
        prevNode.next = currentNode.next;
        currentNode.next = null;
    }
    public void deleteDuplicates(){
        System.out.println("deleting duplicates");
        Node n = head;
        Node prevNode = null;
        HashMap<Integer,Boolean> hMap = new HashMap<>();
        while(n!=null){
            if(hMap.get(n.data)!=null & prevNode!=null){
                this.deleteNode(n, prevNode);
                n = prevNode.next;
            }else{
                hMap.put(n.data, true);
                prevNode=n;
                n=n.next;
            }
        }
    }
    public void partionAt(int pivot){
        Node curNode = head.next;
        Node prevNode = head;
        Node currentHead = head;
        Node nextNode = curNode.next;
        while(curNode != null){
            if(curNode.data < pivot){
                curNode.next = currentHead;
                prevNode.next = nextNode;
                currentHead = curNode;
                curNode = nextNode;
            } else{
                prevNode = curNode;
                curNode = curNode.next;
            }
            if(curNode!=null){
            nextNode = curNode.next;
            }
        }
        head = currentHead;
    }

    public void findKthElemenet(int k){
        Node pointer1 = head;
        Node pointer2= head;
        for(int i=0;i<k;i++){
            System.out.println("Incrementing the lead pointer "+pointer2.data);
            pointer2=pointer2.next;
        }
        while(pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            System.out.println("Kth element from Lead pointer "+pointer1.data);
            System.out.println("Lead pointer "+pointer2.data);
        }
        System.out.println(k+"th Element is "+pointer1.data);
    }
public static void main(String[] argv){
    LinkedList list = new LinkedList();

    // list.head = new Node(3);
    // Node second = new Node(1);
    // Node third = new Node(8);
    // Node fourth = new Node(5);
    // Node five = new Node(10);
    // Node six = new Node(2);
    // Node seven = new Node(1);
    // list.head.next = second;
    // second.next = third;
    // third.next= fourth;
    // fourth.next = five;
    // five.next = six;
    // six.next = seven;
    
    // //print LinkedList
    // list.printLinkedList();
    
    // list.partionAt(3);
    // // fourth.delete();
    // // list.findKthElemenet(2);
    // // list.deleteDuplicates();

    // //print LinkedList
    // list.printLinkedList();
}
}