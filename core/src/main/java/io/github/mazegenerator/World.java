package io.github.mazegenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class World {

    Maze maze;

    World() {
        maze = new Maze(10 ,10);
    }

    public void draw_screen(ShapeRenderer sr) {
        ScreenUtils.clear(.1f, .1f, .1f, 1f);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        MazeCell[][] cells = maze.get_cell_array();
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                sr.setColor(Color.WHITE);
                sr.rect(50*i, 50*j, 50, 50);

                sr.setColor(Color.BLACK);
                if(cells[i][j].east_wall) {
                    sr.rect(50*i+40, 50*j, 10, 50);
                }
                if(cells[i][j].south_wall) {
                    sr.rect(50*i, 50*j, 50, 10);
                }
            }
        }
        sr.end();
    }


}
