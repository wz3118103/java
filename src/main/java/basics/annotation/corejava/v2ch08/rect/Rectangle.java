package basics.annotation.corejava.v2ch08.rect;

import corejava.v2ch08.rect.Point;
import sourceAnnotations.ToString;

@ToString
public class Rectangle {
    private corejava.v2ch08.rect.Point topLeft;
    private int width;
    private int height;
    public Rectangle(corejava.v2ch08.rect.Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }
    @ToString(includeName=false) public Point getTopLeft() { return topLeft; }
    @ToString public int getWidth() { return width; }
    @ToString public int getHeight() { return height; }
}
