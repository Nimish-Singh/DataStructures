package graph.lcStudyPlan.day1;

public class UnionFind {
    public int setCount;
    private int[] parent;

    public UnionFind(char[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        parent = new int[totalRows * totalColumns];

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid[row][column] == '1') {
                    int nodeId = row * totalColumns + column;
                    parent[nodeId] = nodeId;
                    setCount++;
                }
            }
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2) {
        int parentN1 = find(node1);
        int parentN2 = find(node2);

        if (parentN1 != parentN2) {
            parent[parentN1] = parentN2;
            setCount--;
        }
    }
}
