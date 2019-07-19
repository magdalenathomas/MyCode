package homework1.reflect;

public class Door implements AutoCloseable {

    private String color;

    public void open() {
        System.out.println("Otwieranie drzwi koloru " + color);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Zamykanie drzwi koloru " + color);
    }
}