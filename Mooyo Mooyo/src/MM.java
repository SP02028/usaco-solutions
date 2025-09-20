import java.io.*;
import java.util.*;
public class MM {
	static final int MAX_COLS = 10;
	// Movement directions
	static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static List<int[]> findRegion(char[][] grid, int row, int col) {
		int n = grid.length;          // Number of rows
		char color = grid[row][col];  // Color of the starting cell
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row, col});  // Start BFS from the given cell (row, col)
		List<int[]> cells = new ArrayList<>();  // Stores coordinates of connected cells
		boolean[][] visited = new boolean[n][MAX_COLS];
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int currentRow = cell[0], currentCol = cell[1];
			// Skip if the cell has already been visited
			if (visited[currentRow][currentCol]) { 
				continue; 
				}
			visited[currentRow][currentCol] = true;
			cells.add(cell);  // Add the cell to the connected region
			for (int[] move : MOVES) {
				int nextRow = currentRow + move[0];
				int nextCol = currentCol + move[1];
				// Check if the neighboring cell is within bounds
				if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < MAX_COLS) {
					// If the neighbor (nextRow, nextCol) has the same color
					if (grid[nextRow][nextCol] == color) {
						// Add the neighbor (nextRow, nextCol) to the queue
						queue.add(new int[] {nextRow, nextCol});
					}
				}
			}
		}
		return cells;
	}
	static List<List<int[]>> findRemovableRegions(char[][] grid, int k) {
		int n = grid.length;
		List<List<int[]>> removableRegions = new ArrayList<>();
		boolean[][] visited = new boolean[n][MAX_COLS];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < MAX_COLS; col++) {
				// Skip already visited cells or empty cells ('0')
				if (grid[row][col] == '0' || visited[row][col]) { continue; }
				char color = grid[row][col];
				List<int[]> cells = findRegion(grid, row, col);
				// Mark all cells in the region as visited
				for (int[] cell : cells) { visited[cell[0]][cell[1]] = true; }
				// If the region size meets the threshold, add it to the removable
				// regions
				if (cells.size() >= k) { removableRegions.add(cells); }
			}
		}
		return removableRegions;
	}
	static void applyGravity(char[][] grid) {
		int n = grid.length;
		for (int col = 0; col < MAX_COLS; col++) {
			int emptyRow = n - 1;  // Start from the bottom of the column
			// Move non-empty cells to the lowest available position in the column
			for (int row = n - 1; row >= 0; row--) {
				if (grid[row][col] != '0') {
					char temp = grid[emptyRow][col];
					grid[emptyRow][col] = grid[row][col];
					grid[row][col] = temp;
					emptyRow--;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("mooyomooyo.out"));
		String[] firstLine = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int k = Integer.parseInt(firstLine[1]);
		char[][] grid = new char[n][MAX_COLS];
		for (int row = 0; row < n; row++) { grid[row] = br.readLine().toCharArray(); }
		while (true) {
			// Find all removable regions (regions of size >= k)
			List<List<int[]>> removableRegions = findRemovableRegions(grid, k);
			if (removableRegions.isEmpty()) { break; }
			// Remove all identified regions by setting their cells to '0'
			for (List<int[]> region : removableRegions) {
				for (int[] cell : region) { grid[cell[0]][cell[1]] = '0'; }
			}
			// Apply gravity to the grid
			applyGravity(grid);
		}
		for (char[] row : grid) { 
			pw.println(new String(row)); 
			}
		pw.close();
	}
}