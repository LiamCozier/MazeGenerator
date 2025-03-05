package io.github.mazegenerator;

import java.util.ArrayList;
import java.util.List;

public class MazeGenerator {
    private final int width;
    private final int height;
    private MazeCell[][] cell_array;
    List<Integer> visited_cell_ids;


    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        cell_array = init_cell_array();
        visited_cell_ids = new ArrayList<Integer>();
    }

    private MazeCell[][] init_cell_array() {
        cell_array = new MazeCell[width][height];
        int id = 1;
        int i, j;
        for (i=0; i<width; i++) {
            for (j=0; j<height; j++) {
                cell_array[i][j] = new MazeCell(true, true, id);
                id++;
            }
        }
        return cell_array;
    }

    private void recursive_backtrack(Vector2 pos) {
        MazeCell current_cell = cell_array[pos.x][pos.y];
        visited_cell_ids.add(current_cell.cell_id);

        List<Vector2> neighbour_positions = get_valid_neighbours(pos);
        for (Vector2 v : neighbour_positions) {
            if (!is_valid_neighbour(v)) {
                continue;
            }
            // remove wall between
            recursive_backtrack(v);
        }
    }

    private List<Vector2> get_valid_neighbours(Vector2 pos) {
        MazeCell current_cell = cell_array[pos.x][pos.y];
        List<Vector2> cell_positions = new ArrayList<>();

        int i, j;
        for (i=-1; i<=2; i+=2) {
            for (j=-1; j<=2; j+=2) {
                if (!is_valid_neighbour(pos)) {
                    continue;
                }
                cell_positions.add(new Vector2(i, j));
            }
        }

        return cell_positions;
    }

    private boolean is_valid_neighbour(Vector2 pos) {
        MazeCell current_cell = cell_array[pos.x][pos.y];
        // check within bounds
        if (pos.x<0 || pos.x>width || pos.y<0 || pos.y>height) {
            return false;
        }
        // check already visited
        if (visited_cell_ids.contains(current_cell.cell_id)) {
            return false;
        }
        return true;
    }

    private void remove_wall(Vector2 pos, WallDirection direction) {
        switch (direction) {
            case EAST:
                cell_array[pos.x][pos.y].east_wall = false;
                break;
            case SOUTH:
                cell_array[pos.x][pos.y].south_wall = false;
                break;
            case NORTH:
                cell_array[pos.x][pos.y+1].south_wall = false;
                break;
            case WEST:
                cell_array[pos.x-1][pos.y].east_wall = false;
                break;
        }
    }
}
