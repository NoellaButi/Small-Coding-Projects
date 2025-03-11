public class WeightedQuickUnion {
    private int[] parent; // Array to store the parent of each element
    private int[] size; // Array to store the size of each tree

    // Constructor to initialize the arrays and set each element as its own parent with size 1
    public WeightedQuickUnion(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find operation with path compression to find the root of the element
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // Path compression
            p = parent[p];
        }
        return p;
    }

    // Union operation to merge two elements into the same tree, balancing by size
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    // Check if two elements are connected by checking if their roots are the same
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
