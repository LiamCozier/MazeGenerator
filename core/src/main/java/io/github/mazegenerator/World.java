package io.github.mazegenerator;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class World {

    World() {
    }

    public void draw_screen(ShapeRenderer sr) {
        ScreenUtils.clear(.1f, .1f, .1f, 1f);
    }


}
