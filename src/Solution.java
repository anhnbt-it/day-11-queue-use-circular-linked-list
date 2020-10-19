import javax.management.QueryEval;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/19/2020
 * Time: 3:57 PM
 */
public class Solution {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.front = queue.rear = null;
        enQueue(queue, 14);
        enQueue(queue, 22);
        enQueue(queue, 6);

        displayQueue(queue);
        System.out.println();
        System.out.printf("Deleted value = %d", deQueue(queue));
        System.out.printf("\nDeleted value = %d", deQueue(queue));
        System.out.println();
        displayQueue(queue);
        enQueue(queue, 9);
        enQueue(queue, 20);
        System.out.println();
        displayQueue(queue);

    }

    static void enQueue(Queue queue, int value) {
        // Chen 1 phan tu vao vi tri rear
        Node temp = new Node();
        temp.data = value;
        if (queue.front == null) {
            queue.front = temp;
        } else {
            queue.rear.link = temp;
        }
        queue.rear = temp;
        queue.rear.link = queue.front;
    }

    static int deQueue(Queue queue) {
        // Lay ra 1 phan tu tai vi tri front
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        // If this is the last node to be deleted
        int value; // Value to be dequeued
        if (queue.front == queue.rear) {
            value = queue.front.data;
            queue.front = null;
            queue.rear = null;
        } else { // // There are more than one nodes
            Node temp = queue.front;
            value = temp.data;
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }

        return value;
    }

    static void displayQueue(Queue queue) {
        Node temp = queue.front;
        System.out.println("Elements in Circular Queue are: ");
        while (temp.link != queue.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front; // Phan tu duoc dua vao dau tien
        Node rear; // Phan tu duoc dua vao cuoi cung
    }
}
