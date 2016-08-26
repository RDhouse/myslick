package com.rdhouse.natureofcode;

/**
 * Created by Sir Royal Air Benny on 26-8-2016.
 */
public class Vector2 {

    public static Vector2 add(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x + v2.x, v1.y + v2.y);
    }

    public static Vector2 sub(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x - v2.x, v1.y - v2.y);
    }

    public static Vector2 div(Vector2 v, float n) {
        return new Vector2(v.x / n, v.y / n);
    }

    public static Vector2 mult(Vector2 v, float n) {
        return new Vector2(v.x * n, v.y * n);
    }

    public float x;
    public float y;

    public Vector2() {

    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 v) {
        x = x + v.x;
        y = y + v.y;
    }

    public void sub(Vector2 v) {
        x = x - v.x;
        y = y - v.y;
    }

    public void mult(float n) {
        x = x * n;
        y = y * n;
    }

    public void div(float n) {
        x = x / n;
        y = y / n;
    }

    public float mag() {
        return (float)Math.sqrt(x*x + y*y);
    }

    public void normalise() {
        float m = mag();
        if (m != 0) {
            div(m);
        }
    }

    public void limit(float max) {
        if (mag() > max) {
            normalise();
            mult(max);
        }
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
