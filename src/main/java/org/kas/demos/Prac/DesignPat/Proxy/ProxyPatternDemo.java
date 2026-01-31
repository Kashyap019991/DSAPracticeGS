package org.kas.demos.Prac.DesignPat.Proxy;

// Subject Interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk(); // Expensive operation
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage; // Reference to RealImage

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy initialization
        }
        realImage.display();
    }
}

// Client Usage
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg"); // Image not loaded yet
        image1.display(); // Loads and displays photo1.jpg
        image1.display(); // Displays photo1.jpg (already loaded)

        Image image2 = new ProxyImage("photo2.png");
        image2.display(); // Loads and displays photo2.png
    }
}