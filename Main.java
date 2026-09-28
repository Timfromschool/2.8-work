import java.awt.*;

public class Main {
  public static void main(String[] args) {  
    World world = new World(400,400);
    
    // Below is one turtle object, already built for you.
    // Turtle is a class.  yertle is an object reference variable.  It references a Turtle object in memory.  
    // the object itself doesn't have a text name.  It is located at a particular address in memory.  
    // We say that the object refrence variable yertle references the object (though sometimes informally
    // we refer to the object itself as yertle)  More that one object reference variable can reference the same object.
    Turtle yertle = new Turtle(world);

    // Two example method calls.
    yertle.forward(100);
    yertle.turnRight();

    // TODO 1: build a SECOND turtle with its own name.
    //         It needs its own  new  line. Copying the variable is not enough.


    // TODO 2: give your turtles different colours.
    //         Look up how in the documentation - it is not shown here.


    // TODO 3: make each turtle draw something.
    //         Five method calls in total, across both turtles, is the minimum.


    // TODO 4: use at least TWO methods that do not appear anywhere in this file.
    //         Find them in the Turtle documentation, under Unit 1 -> Resources.
    //         Write their names in the comment below so you remember them:
    //
    //         Methods I found in the docs:  ......................


    // TODO 5: then keep going. Make something worth looking at.
    
    world.setVisible(true);
  }
}
