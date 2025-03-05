package io.github.mazegenerator;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final int width;
    private final int height;
    private MazeCell[][] cell_array;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;

        cell_array = init_cell_array();
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



}
