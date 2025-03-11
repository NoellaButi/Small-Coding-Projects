import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Soil {
    private int[][] soilGrid; // 2D array to represent the soil grid
    private int n; // Size of the grid (number of rows/columns)
    private WeightedQuickUnion wqu; // Weighted Quick Union instance

    public Soil(String filePath) {
        readSoilData(filePath); // Read soil data from the file
        n = soilGrid.length; // Determine the size of the grid
        wqu = new WeightedQuickUnion(n * n + 2); // Initialize Weighted Quick Union with virtual top and bottom sites
        buildUnionFind(); // Build the union-find data structure
    }

    // Read soil data from the specified file path
    private void readSoilData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split(" "); // Split the line into values
                if (soilGrid == null) {
                    int columns = values.length;
                    soilGrid = new int[columns][columns]; // Initialize the soil grid based on the number of columns
                }
                // Parse values and populate the soil grid
                for (int col = 0; col < values.length; col++) {
                    soilGrid[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Build the union-find data structure based on the soil grid
    private void buildUnionFind() {
        // Connect top layer to virtual top site, and bottom layer to virtual bottom site
        for (int i = 0; i < n; i++) {
            wqu.union(i, n * n);
            wqu.union(translateIndex(n - 1, i), n * n + 1);
        }

        // Connect adjacent cells in the soil grid if they allow water drainage
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (soilGrid[i][j] == 1) {
                    if (i > 0 && soilGrid[i - 1][j] == 1) wqu.union(translateIndex(i, j), translateIndex(i - 1, j)); // Connect upward cell
                    if (i < n - 1 && soilGrid[i + 1][j] == 1) wqu.union(translateIndex(i, j), translateIndex(i + 1, j)); // Connect downward cell
                    if (j > 0 && soilGrid[i][j - 1] == 1) wqu.union(translateIndex(i, j), translateIndex(i, j - 1)); // Connect left cell
                    if (j < n - 1 && soilGrid[i][j + 1] == 1) wqu.union(translateIndex(i, j), translateIndex(i, j + 1)); // Connect right cell
                }
            }
        }
    }

    // Translate 2D indices to 1D index
    private int translateIndex(int row, int col) {
        return row * n + col;
    }

    // Determine if water drains from the top layer to the bottom layer
    public boolean doesDrain() {
        return wqu.find(n * n) == wqu.find(n * n + 1);
    }
}
