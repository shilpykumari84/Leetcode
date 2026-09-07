class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If already the required color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int originalColor, int color) {

        // Boundary + color check
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length ||
            image[r][c] != originalColor) {
            return;
        }

        // Change current pixel
        image[r][c] = color;

        // Up
        dfs(image, r - 1, c, originalColor, color);

        // Down
        dfs(image, r + 1, c, originalColor, color);

        // Left
        dfs(image, r, c - 1, originalColor, color);

        // Right
        dfs(image, r, c + 1, originalColor, color);
    }
}