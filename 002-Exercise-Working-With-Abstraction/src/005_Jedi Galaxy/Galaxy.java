package jediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        stars = new Star[rows][cols];
        this.fillStars();
    }

    public int getRows() {
        return stars.length;
    }

    public int getColumns(int row) {
        return stars[row].length;
    }

    private void fillStars() {
        int startValue = 0;
        for (int r = 0; r < stars.length; r++) {
            for (int c = 0; c < stars[r].length; c++) {
                stars[r][c] = new Star(startValue++);
            }
        }
    }

    public void setStar(int row, int col, Star star) {
        if (isInRange(row, col)) {
            stars[row][col] = star;
        }
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < stars.length
               && col >= 0 && col < stars[row].length;
    }

    public int getStarValue(int row, int col) {
        int result = 0;
        if (isInRange(row, col)) {
            result = stars[row][col].getValue();
        }
        return result;
    }
}
