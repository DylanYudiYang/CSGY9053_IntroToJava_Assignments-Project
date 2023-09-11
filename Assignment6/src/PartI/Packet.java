package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Packet implements Comparable<Packet> {
    private Byte[] payload;
    private int priority;

    public Packet(Byte[] payload, int priority) {
        this.payload = payload;
        this.priority = priority;
    }

    public Byte[] getPayload() {
        return payload;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Packet other) {
        return other.priority - this.priority;
    }

    @Override
    public String toString() {
        return "Packet(priority=" + priority + ")";
    }

    public static void main(String[] args) {
        PriorityQueue<Packet> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            Byte[] payload = new Byte[256];
            int priority = (int) (Math.random() * 5 + 1);
            Packet p = new Packet(payload, priority);
            pq.add(p);
        }
        while (!pq.isEmpty()) {
            Packet p = pq.remove();
            System.out.println("Got " + p );
        }
    }
}


