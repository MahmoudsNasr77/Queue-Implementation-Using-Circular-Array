/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courser;

import java.util.Scanner;
import java.util.Stack;

public class Hello {

    public static void main(String[] args) {
        Queue q1 = new Queue(10);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.enqueue(50);
        q1.dequeue();
        q1.enqueue(120);
        System.out.println(q1.search(120));
       

    }

}

class Queue {

    private int rear, front, count,max;
    private int queue[] ;

    public Queue(int m) {
        if (m<0){
            System.out.println("Enter Postive Number Please");
            System.exit(0);;
    }
        else 
        max=m;
        queue=new int [max];
        rear = max - 1;
        front = 0;
        count = 0;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (count == max) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int elelment) {
        if (isFull()) {
            System.out.println("Queue Is OverfLow");
        } else {
            rear = (rear + 1) % max;
            queue[rear] = elelment;
            count++;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queuue Is Underflow");
        } else {
            front = (front + 1) % max;
            --count;
        }
    }

    public int getFront() {
        assert (!isEmpty());//find Error and stop program
        return queue[front];
    }

    public int getRear() {
        assert (!isEmpty());
        return queue[rear];
    }

    public void Display() {
        System.out.print("[");
        for (int i = front; i != rear + 1; i = (i + 1) % max) {
            System.out.print(queue[i] + "  ");
        }
        System.out.print("]");
    }
    public int search(int Element){
        int pos=-1;
        if (isEmpty()){
            System.out.println("Queue is Underflow");
        }else {
            for (int i=front;i!=rear+1;i=(i+1)%max){
                {
                    if (queue[i]==Element){
                        pos=i;
                        break;
                    }if(pos==-1) {
                        if (queue[rear]==Element){
                            pos=rear;
                        }
                    }
                }
            }
            
        }
        return pos;
    }

}
