
import java.util.*;

class Node{
        int data;
        Node left;
        Node right;
        Node(int d, Node leftNode, Node rightNode){
            this.data = d;
            this.left = leftNode;
            this.right = rightNode;
        }
        Node(int d){
            this.data = d;
        }
    
    public void setLeftNode(Node node){
        this.left = node;
    }

    public void setRightNode(Node node){
        this.right = node;
    }

    public static int rootElection(int[] sortedArray){
        return sortedArray.length/2;
    }

    public static Node buildTree(int[] sortedArray){
        if(sortedArray.length ==0){
            return null;
        }
        int index = rootElection(sortedArray);
        Node node = new Node(sortedArray[index]);
        
        if(sortedArray.length == 1){
            System.out.println(node.data);
            return node;
        }
        node.setLeftNode(buildTree(Arrays.copyOfRange(sortedArray,0,index)));
        node.setRightNode(buildTree(Arrays.copyOfRange(sortedArray,index+1,sortedArray.length)));
       
        System.out.println(node.data);
        return node;
    }

    public static int getDepthStatic(Node node){
        if (node != null)
            return 1 + Math.max(getDepthStatic(node.left), getDepthStatic(node.right));
        return 0;
    }

    public static void main(String [] argv) {
        int [] sortedArray = {1,2,3,4,5,6,7};
        Node node = Node.buildTree(sortedArray);
        System.out.println("Depth="+Node.getDepthStatic(node));
    }
}