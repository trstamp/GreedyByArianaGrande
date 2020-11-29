import java.util.LinkedList;
public class Assignment4 {

    LinkedList<Node> list1 = new LinkedList<>();
    LinkedList<Node> list2 = new LinkedList<>();
    LinkedList<Node> list3 = new LinkedList<>();
    LinkedList<Integer> listR = new LinkedList<>();

    private Node head;

    private LinkedList<Node>[] aList = new LinkedList[3]; //array of linked lists

    public void addListToArray(){
        aList[0] = list1;
        aList[1] = list2;
        aList[2] = list3;
    }

    public void addToList() {
        Node L14 = new Node(60,10,0,0,0,null);
        Node L13 = new Node(50,5,0,0,0,L14);
        Node L12 = new Node(40,3,0,0,0,L13);
        Node L11 = new Node(30,2,0,0,0,L12);

        Node L24 = new Node(20,2,0,0,0,null);
        Node L23 = new Node(45,9,0,0,0,L24);
        Node L22 = new Node(55,11,0,0,0,L23);
        Node L21 = new Node(70,7,0,0,0,L22);

        Node L34 = new Node(84,4,0,0,0,null);
        Node L33 = new Node(68,17,0,0,0,L34);
        Node L32 = new Node(88,11,0,0,0,L33);
        Node L31 = new Node(150,3,0,0,0,L32);

        list1.add(L11);
        list1.add(L12);
        list1.add(L13);
        list1.add(L14);

        list2.add(L21);
        list2.add(L22);
        list2.add(L23);
        list2.add(L24);

        list3.add(L31);
        list3.add(L32);
        list3.add(L33);
        list3.add(L34);

    }

    public LinkedList<Integer> algorithm(){
        int i = 0;
        head = aList[i].getFirst();
        while(head.next != null) {
            if(i == 0){
                head.totalCost = head.cost;
                head.totalProb = head.prob;
            }
            if(head != null) {
                head.next.totalCost = head.totalCost + head.next.cost;
                head.next.totalProb = head.totalProb + head.next.prob;
            }
            head.ratio = (head.totalCost / head.totalProb);
            if (i == 0 || head.ratio < listR.peek()) {
                listR.add(head.ratio);
            }
            head = head.next;
        }
        return listR;
    }

    private class Node{
        private int cost;
        private int prob;
        private int totalCost;
        private int totalProb;
        private int ratio;
        private Node next;

        private Node(){
            this.cost = cost;
            this.prob = prob;
            this.totalCost = totalCost;
            this.totalProb = totalProb;
            this.ratio = ratio;
            this.next = next;
        }
        private Node(int cost, int prob, int totalCost, int totalProb, int ratio, Node next)
        {
            this.cost = cost;
            this.prob = prob;
            this.totalCost = totalCost;
            this.totalProb = totalProb;
            this.ratio = ratio;
            this.next = next;
        }
    }
}
