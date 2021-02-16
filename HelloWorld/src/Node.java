public class Node<T> {

    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        Node<Integer[]> x = new Node<Integer[]> (a, null);
        Node<Integer> y = new Node<Integer>(2, x);
        Node<Integer> z = new Node<Integer>(3, y);

        Node curr;
        while (x != null) {
            System.out.println(x.getData());
            curr= x.getNext();
        }



        System.out.println(y.getData());
        System.out.println(y.getNext().getData());
    }

        private T data;
        private Node next;

    public Node( T d, Node nx){
            data = d;
            next = nx;
        }

        public T getData () {
            return data;
        }
        public Node getNext () {
            return next;
        }
        public void setData ( T d){
            data = d;
        }
        public void setNext (Node n){
            next = n;
        }
    }

