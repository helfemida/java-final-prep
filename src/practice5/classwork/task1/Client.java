package practice5.classwork.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to server.");

            while (true) {
                System.out.print("Enter radius (or type 'exit' to quit): ");
                String input = userInput.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                double radius = Double.parseDouble(input);

                out.println(radius);

                String area = in.readLine();
                System.out.println("Area received from server: " + area);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
