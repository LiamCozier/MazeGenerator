package io.github.mazegenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    private final int width;
    private final int height;
    public MazeCell[][] cell_array;
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

    public void recursive_backtrack(Vector2 pos) {
        System.out.println(pos);
        MazeCell current_cell = cell_array[pos.x][pos.y];
        visited_cell_ids.add(current_cell.cell_id);

        List<Vector2> neighbour_positions = get_neighbours(pos);
        Collections.shuffle(neighbour_positions);
        for (Vector2 v : neighbour_positions) {
            if (!is_valid_neighbour(v)) {
                continue;
            }


            // remove wall
            Vector2 vec_direction = Vector2.sub(v, pos);
            WallDirection wall_to_remove = get_dir(vec_direction);
            remove_wall(pos, wall_to_remove);


            recursive_backtrack(v);
        }
    }

    private List<Vector2> get_neighbours(Vector2 pos) {
        List<Vector2> cell_positions = new ArrayList<>();

        for (Vector2 v: Vector2.CARDINALS) {
            cell_positions.add(Vector2.add(pos, v));
        }

        return cell_positions;
    }

    private boolean is_valid_neighbour(Vector2 pos) {
        // check within bounds
        if (pos.x<0 || pos.x>=width || pos.y<0 || pos.y>=height) {
            return false;
        }
        // check already visited
        MazeCell current_cell = cell_array[pos.x][pos.y];
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

    private WallDirection get_dir(Vector2 v) {
        if (v.equals(Vector2.NORTH)) {
            return WallDirection.NORTH;
        }
        if (v.equals(Vector2.SOUTH)) {
            return WallDirection.SOUTH;
        }
        if (v.equals(Vector2.WEST)) {
            return WallDirection.WEST;
        }
        if (v.equals(Vector2.EAST)) {
            return WallDirection.EAST;
        }
        return WallDirection.NORTH;
    }
}
