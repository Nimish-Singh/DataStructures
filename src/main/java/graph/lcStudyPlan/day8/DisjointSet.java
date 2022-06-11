package graph.lcStudyPlan.day8;

public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int setCounter;

    public DisjointSet(int numberOfNodes) {
        parent = new int[numberOfNodes];
        rank = new int[numberOfNodes];
        for (int index = 0; index < parent.length; index++) {
            parent[index] = index;
            rank[index] = 0;
        }
        setCounter = numberOfNodes;
    }

    private int find(int node) {
        if (parent[node] == node)
            return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent1 != parent2) {
            int parentToJoinFrom, parentToJoinTo;

            if (rank[parent1] > rank[parent2]) {
                parentToJoinTo = parent1;
                parentToJoinFrom = parent2;
            } else {
                parentToJoinTo = parent2;
                parentToJoinFrom = parent1;
            }
            parent[parentToJoinFrom] = parentToJoinTo;

            if (rank[parentToJoinTo] == rank[parentToJoinFrom])
                rank[parentToJoinTo]++;
            setCounter--;
        }
    }

    public int getSetCount() {
        return setCounter;
    }
}
