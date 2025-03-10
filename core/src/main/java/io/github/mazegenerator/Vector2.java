package io.github.mazegenerator;

public class Vector2 {
    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 NORTH = new Vector2(0, 1);
    public static final Vector2 SOUTH = new Vector2(0, -1);
    public static final Vector2 WEST = new Vector2(-1, 0);
    public static final Vector2 EAST = new Vector2(1, 0);
    public static final Vector2[] CARDINALS = {NORTH, EAST, SOUTH, WEST};

    public int x;
    public int y;

    Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector2 v) {
        return this.x==v.x && this.y==v.y;
    }

    public static Vector2 add(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x+v2.x, v1.y+v2.y);
    }

    public static Vector2 sub(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x-v2.x, v1.y-v2.y);
    }

    public String toString() {
        return String.format("<%d, %d>", this.x, this.y);
    }
}
