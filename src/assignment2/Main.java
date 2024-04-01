package assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Number> queue1 = new MyQueue<Number>();
        MyQueue<Number> queue2 = new MyQueue<Number>();

        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);


        System.out.println(queue1.equals(queue2));
    }
}