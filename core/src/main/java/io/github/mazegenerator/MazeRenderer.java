package io.github.mazegenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MazeRenderer {
    int cell_width, cell_height;
    int wall_thickness;

    public MazeRenderer(int cw, int ch, int wt) {
        this.cell_width = cw;
        this.cell_height = ch;
        this.wall_thickness = wt;
    }

    public void render(Maze m, ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        MazeCell[][] cells = m.get_cell_array();
//
        int width_increment = (cell_width+wall_thickness);
        int height_increment = (cell_height+wall_thickness);
//
//        sr.setColor(Color.BLACK);
//        sr.rect(0,0 , width_increment*m.width, height_increment*m.height);
//
//        sr.setColor(Color.WHITE);
//        sr.rect(wall_thickness, wall_thickness, width_increment*m.width-(2*wall_thickness), height_increment*m.height-(2*wall_thickness));
//
//        for (int i=0; i<cells.length; i++) {
//            for (int j=0; j<cells[0].length; j++) {
//                sr.setColor(Color.BLACK);
//                if(cells[i][j].east_wall) {
//                    sr.rect(i*width_increment, j*height_increment, wall_thickness, cell_height);
//                }
//                if(cells[i][j].south_wall) {
//                    sr.rect(i*width_increment, j*height_increment, cell_width, wall_thickness);
//                }
//            }
//        }
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                sr.setColor(Color.WHITE);
                sr.rect(width_increment*i, height_increment*j, 50, 50);

                sr.setColor(Color.BLACK);

                if(cells[i][j].east_wall) {
                    sr.rect(width_increment*i+cell_width-wall_thickness, height_increment*j, wall_thickness, cell_height+(2*wall_thickness));
                }
                if(cells[i][j].south_wall) {
                    sr.rect(width_increment*i-(2*wall_thickness), height_increment*j, cell_width+(2*wall_thickness), wall_thickness);
                }
            }
        }
        sr.end();
    }
}
