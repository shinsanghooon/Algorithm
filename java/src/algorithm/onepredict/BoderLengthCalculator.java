package algorithm.onepredict;

public class BoderLengthCalculator {
    public static void main(String[] args) {
        int[][] maps = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0}
        };

        int totalBorderLength = calculateTotalBorderLength(maps);

        System.out.println("Total Border Length: " + totalBorderLength);
    }

    private static int calculateTotalBorderLength(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        int totalBorderLength = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (maps[row][col] == 1) {
                    int cellBorderLength = 0;
                    if (row == 0 || maps[row - 1][col] == 0) {
                        cellBorderLength++; // Top border
                    }
                    if (col == 0 || maps[row][col - 1] == 0) {
                        cellBorderLength++; // Left border
                    }
                    if (row == rows - 1 || maps[row + 1][col] == 0) {
                        cellBorderLength++; // Bottom border
                    }
                    if (col == cols - 1 || maps[row][col + 1] == 0) {
                        cellBorderLength++; // Right border
                    }

                    totalBorderLength += cellBorderLength;

                }
            }
        }

        return totalBorderLength;
    }
}




