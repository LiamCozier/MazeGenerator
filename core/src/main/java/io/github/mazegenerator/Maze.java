package io.github.mazegenerator;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public final int width;
    public final int height;
    private MazeCell[][] cell_array;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;

        cell_array = generate();
    }

    public MazeCell[][] generate() {
        MazeGenerator mg = new MazeGenerator(width, height);
        mg.recursive_backtrack(new Vector2(1, 1));

        return mg.cell_array;
    }

    public MazeCell[][] get_cell_array() {
        return this.cell_array;
    }

    public void print() {
        for (MazeCell[] i: cell_array) {
            for (MazeCell j: i) {
                System.out.printf("<%b, %b> ", j.east_wall, j.south_wall);
            }
            System.out.println();
        }
    }



}
