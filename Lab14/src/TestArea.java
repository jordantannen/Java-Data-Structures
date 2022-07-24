public class TestArea
{
    public static void main( String args[] ) {
        Shape arrayOfShapes[] = new Shape[5];

        arrayOfShapes[0] = new Rectangle(10, 12);
        arrayOfShapes[1] = new Square(5);
        arrayOfShapes[2] = new Rectangle(11, 12);
        arrayOfShapes[3] = new Square(6);
        arrayOfShapes[4] = new Rectangle(12, 12);

        int counts[] = {0, 0};

        // Print table header
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Shape", "Area", "Perimeter",
                "Length", "Width", "Side");

        // Print and format each shape
        for (Shape item : arrayOfShapes){
            if (item instanceof Rectangle){
                System.out.printf("%-15s %-15s %-15s %-15s %-15s \n", item.getName(), item.getArea(),
                        ((Rectangle) item).getPerimeter(), ((Rectangle) item).getLength(), ((Rectangle) item).getWidth());
                counts[0]++;
            } else if (item instanceof Square) {
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", item.getName(), item.getArea(),
                        ((Square) item).getPerimeter(), "", "", ((Square) item).getSide());
                counts[1]++;
            }
        }

        // Print final counts
        System.out.println("\nRectangle shape count: " + counts[0]);
        System.out.println("Square shape count: " + counts[1]);

    } // end main
} // end class TestArea