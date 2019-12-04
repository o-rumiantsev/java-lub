import com.labs.*;

public class Main {
    public static void main(String[] argv) {
        String labName = argv[0];

        switch (labName) {
            case "Lab1":
                Lab1.main();
                break;
            case "Lab2":
                Lab2.main();
                break;
            default:
                System.out.println("Valid lab name is required");
        }
    }
}
