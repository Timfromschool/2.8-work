import java.awt.*;
import yourpackage.Turtle;
import yourpackage.World;

public class Main {
  public static void main(String[] args) {
    World world = new World(400, 400);

    Turtle yertle = new Turtle(world);
    Turtle myrtle = new Turtle(world);

    yertle.setColor(Color.red);
    myrtle.setColor(Color.blue);

    yertle.forward(100);
    yertle.turnRight();
    yertle.forward(100);
    yertle.turnRight();
    yertle.forward(100);
    yertle.turnRight();
    yertle.forward(100);

    myrtle.turn(120);
    myrtle.forward(80);
    myrtle.turn(120);
    myrtle.forward(80);
    myrtle.turn(120);
    myrtle.forward(80);

    myrtle.penUp();
    myrtle.moveTo(300, 150);
    myrtle.setHeading(0);
    myrtle.penDown();
    myrtle.setPenWidth(3);
    for (int i = 0; i < 5; i++) {
      myrtle.forward(100);
      myrtle.turn(144);
    }

    yertle.penUp();
    yertle.moveTo(80, 320);
    yertle.setHeading(0);
    yertle.penDown();
    for (int i = 1; i <= 20; i++) {
      yertle.forward(i * 4);
      yertle.turn(90);
    }

    world.setVisible(true);
  }
}