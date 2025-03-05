package io.github.mazegenerator;

public class Vector2 {
    public static final Vector2 ZERO = new Vector2(0, 0);

    public int x;
    public int y;

    Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 add(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x+v2.x, v1.y+v2.y);
    }
}
