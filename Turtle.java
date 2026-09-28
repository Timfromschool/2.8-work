package yourpackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Turtle {
  private final World world;
  private double x;
  private double y;
  private double heading = 0;          // degrees; 0 = up, increases clockwise
  private boolean penIsDown = true;
  private Color color = Color.green;
  private int penWidth = 1;
  private boolean visible = true;

  /** Creates a turtle in the center of the world. */
  public Turtle(World world) {
    this(world.getCanvasWidth() / 2, world.getCanvasHeight() / 2, world);
  }

  public Turtle(int x, int y, World world) {
    this.world = world;
    this.x = x;
    this.y = y;
    world.addTurtle(this);
  }

  // ---- Movement ----
  public void forward(int distance) {
    double rad = Math.toRadians(heading);
    double newX = x + distance * Math.sin(rad);
    double newY = y - distance * Math.cos(rad);   // screen y grows downward
    if (penIsDown) {
      world.drawLine(x, y, newX, newY, color, penWidth);
    }
    x = newX;
    y = newY;
    world.repaint();
  }

  public void backward(int distance) {
    forward(-distance);
  }

  public void moveTo(int newX, int newY) {
    if (penIsDown) {
      world.drawLine(x, y, newX, newY, color, penWidth);
    }
    x = newX;
    y = newY;
    world.repaint();
  }

  // ---- Turning ----
  public void turn(double degrees) {
    heading = ((heading + degrees) % 360 + 360) % 360;
    world.repaint();
  }

  public void turnRight() { turn(90); }

  public void turnLeft()  { turn(-90); }

  public void setHeading(double degrees) {
    heading = ((degrees % 360) + 360) % 360;
    world.repaint();
  }

  // ---- Pen ----
  public void penUp()   { penIsDown = false; }

  public void penDown() { penIsDown = true; }

  public void setColor(Color c) { color = c; world.repaint(); }

  public void setPenWidth(int width) { penWidth = Math.max(1, width); }

  // ---- Visibility / getters ----
  public void setVisible(boolean v) { visible = v; world.repaint(); }

  public double getHeading() { return heading; }

  public int getXPos() { return (int) Math.round(x); }

  public int getYPos() { return (int) Math.round(y); }

  // ---- Drawing the turtle itself (a small triangle) ----
  void paint(Graphics2D g) {
    if (!visible) return;
    double rad = Math.toRadians(heading);
    double sin = Math.sin(rad), cos = Math.cos(rad);
    // local points: tip ahead, two corners behind
    double[][] pts = { {0, -10}, {-6, 6}, {6, 6} };
    Polygon p = new Polygon();
    for (double[] pt : pts) {
      p.addPoint((int) Math.round(x + pt[0] * cos - pt[1] * sin),
                 (int) Math.round(y + pt[0] * sin + pt[1] * cos));
    }
    g.setColor(color);
    g.fillPolygon(p);
  }
}