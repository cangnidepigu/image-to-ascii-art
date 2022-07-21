import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Scanner;

// Best to lower font size in CLI to see the outcomes

public class ASCIIart {
    public static void main(String[] user) {

        String rootDirectory = "C:\\Users\\nokak\\Desktop\\CS\\Semester-III\\" +
                "Universal programming techniques (UTP)\\ASCIIartTempFolder\\ASCIIart";
        Scanner input = new Scanner(System.in);
        BufferedImage img = null;
        File f;
        String asciiCharacters = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

        // read image
        try {
            f = new File( rootDirectory +
                    "\\src\\main\\resources\\pixelamogus.jpg");
            img = ImageIO.read(f);
            System.out.println("Successfully loaded image!");

        } catch(IOException e) {
            e.printStackTrace();
        }

        // get height and width
        assert img != null;
        int height = img.getHeight();
        int width = img.getWidth();

        System.out.println("Image size: " + height + " x " + width);

        System.out.println("1. Average\n2. MinMax\n3. Luminosity");

        try {
            int user1 = input.nextInt();
            System.out.println(user1);
            if (user1 == 1) {
                Average(img, height, width, asciiCharacters);
            } else if (user1 == 2) {
                MinMax(img, height, width, asciiCharacters);
            } else if (user1 == 3) {
                Luminosity(img, height, width, asciiCharacters);
            }
            else {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // function using average value of RGB
    public static void Average(BufferedImage img, int height, int width, String ascii) {
        for (int y = 0; y < height; y ++) {

            for (int x = 0; x < width; x++) {

                int p = img.getRGB(x, y);

                // int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;

                // used in avg function
                double avg = (r+g+b)/3;

                double brightness = (avg/255)*ascii.length();
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
            }
            System.out.println();
        }
    }

    // function using min max
    public static void MinMax(BufferedImage img, int height, int width, String ascii) {
        for (int y = 0; y < height; y ++) {

            for (int x = 0; x < width; x++) {

                int p = img.getRGB(x, y);

                // int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;

                int max = r>g ? (Math.max(r, b)) : (Math.max(g, b));
                int min = r<g ? (Math.min(r, b)) : (Math.min(g, b));
                double min_max = (max+min)/2;

                double brightness = (min_max/255)*ascii.length();
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
            }
            System.out.println();
        }
    }

    // function using luminosity
    public static void Luminosity(BufferedImage img, int height, int width, String ascii) {
        for (int y = 0; y < height; y ++) {

            for (int x = 0; x < width; x++) {

                int p = img.getRGB(x, y);

                // int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;

                double luminosity = 0.21 * r + 0.72 * g + 0.07 * b;

                double brightness = (luminosity/255)*ascii.length();
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
                System.out.print(ascii.charAt((int)brightness));
            }
            System.out.println();
        }
    }
}
