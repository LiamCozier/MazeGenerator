package io.github.mazegenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class World {
    Maze maze;
    MazeRenderer mr;

    public World() {
        maze = new Maze(10 ,10);
        mr = new MazeRenderer(50, 50, 10);
    }

    public void draw_screen(ShapeRenderer sr) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        mr.render(maze, sr);

    }


}
