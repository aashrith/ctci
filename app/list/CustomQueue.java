package list;

class CustomQueue extends LinkedList  {
    private int index=0;

    LinkedList catList;
    LinkedList dogList;

    public CustomQueue() {
       this.catList = new LinkedList();
       this.dogList = new LinkedList(); 
    }

    public CustomQueue enqueue(Node node) {
        if(node.species=="cat"){
            this.realEnqueue(this.catList, node);
        }else{
            this.realEnqueue(this.dogList, node);
        }

        return this;
    }

    public CustomQueue realEnqueue(LinkedList list, Node node){
        if (list.head == null) {
            list.head = node;
            list.head.setIndex(this.index);
        } else {
            Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            current.next.setIndex(this.index);
        }
        index+=1;
        return this;
    }

    public void dequeueAny() {
    if(this.catList.head.index<this.dogList.head.index){
        this.catList.head.delete();
    }else{
        this.dogList.head.delete();
    }
    }

    public void dequeueDog() {
        this.dogList.head.delete();
    }

    public void dequeueCat() {
        this.catList.head.delete();
    }

    public void printLinkedList(){
        Node n = catList.head;
        System.out.println("traversing Linked List ");
        while(n!= null){
            System.out.println(n.data+" is a "+n.species+" index is "+n.index);
            n=n.next;
        }

        Node n1 = dogList.head;
        System.out.println("traversing Linked List ");
        while(n1!= null){
            System.out.println(n1.data+" is a "+n1.species+" index is "+n1.index);
            n1=n1.next;
        }
    }

    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue(new Node(1, "cat")).enqueue(new Node(2,"Dog"))
        .enqueue(new Node(3, "cat")).dequeueAny();
        customQueue.printLinkedList();
    }
}