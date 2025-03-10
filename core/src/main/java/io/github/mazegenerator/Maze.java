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

        cell_array = generate();
    }

    public MazeCell[][] generate() {
        MazeGenerator mg = new MazeGenerator(width, height);
        mg.recursive_backtrack(new Vector2(1, 1));

        return mg.cell_array;
    }

    public void print() {
        for (MazeCell[] i: cell_array) {
            System.out.print("\n|");
            for (MazeCell j: i) {
                System.out.print((j.south_wall ? "_" : " "));
                System.out.print((j.east_wall ? "|" : " "));
            }
        }
    }



}
