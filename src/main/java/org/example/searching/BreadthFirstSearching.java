package org.example.searching;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearching {

    public static void main(String[] args) {

    }

    public static class Vertex<T> {
        private final T data;
        private boolean visited;
        private List<Vertex<T>> neighbors = new LinkedList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex<T>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Vertex<T>> neighbors) {
            this.neighbors = neighbors;
        }
    }

    public static <T> void traverse(Vertex<T> startVertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                queue.addAll(current.getNeighbors());
            }
        }
    }

}
