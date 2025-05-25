import utils.IPrintable;
 
public class WorldMap {
    private Location[][] grid;
 
    public WorldMap(int rows, int cols) {
        grid = new Location[rows][cols];
    }
 
    public void addLocation(Location loc, int row, int col) {
        grid[row][col] = loc;
    }
 
    public Location getLocation(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return null;
        return grid[row][col];
    }
 
    public IPrintable[][] getGrid() {
        return grid;
    }
}