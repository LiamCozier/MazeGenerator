package io.github.mazegenerator;

public class MazeCell {
    int cell_id;
    boolean south_wall;
    boolean east_wall;

    public MazeCell(boolean s, boolean e, int id) {
        cell_id = id;
        south_wall = s;
        east_wall = e;
    }

    public boolean equals(MazeCell c) {
        return this.cell_id == c.cell_id;
    }



}
