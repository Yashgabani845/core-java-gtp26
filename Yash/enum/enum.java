public class Enum {
    enum Shape {
        CIRCLE {
            @Override
            double area(double value) {
                return Math.PI * value * value;
            }
        },
        SQUARE {
            @Override
            double area(double value) {
                return value * value;
            }
        },
        TRIANGLE {
            @Override
            double area(double value) {
                return (Math.sqrt(3) / 4) * value * value;
            }
        };

        abstract double area(double value);
    }


    public static void main(String[] args) {
        System.out.println("Circle area: " + Shape.CIRCLE.area(5));
        System.out.println("Square area: " + Shape.SQUARE.area(4));
        System.out.println("Triangle area: " + Shape.TRIANGLE.area(6));
    }
}

