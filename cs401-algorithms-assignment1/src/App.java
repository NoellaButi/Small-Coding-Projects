public class App {
    public static void main(String[] args) {
        try {
            // Create a Soil object by providing the path to the soil data file
            Soil soil = new Soil("sample1.txt"); // Replace "sample1.txt" with your desired file path

            // Check if water drains through the soil
            if (soil.doesDrain()) {
                System.out.println("Allows water to drain");
            } else {
                System.out.println("Doesn't allow water to drain");
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the process
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
