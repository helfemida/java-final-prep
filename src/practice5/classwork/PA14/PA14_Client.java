package practice5.classwork.PA14;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PA14_Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT); //connect to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //print in server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //get from the server
            Scanner scanner = new Scanner(System.in); //get our message

            System.out.println("Connected to server. Start chatting...");

            Thread thread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();

            String userInput;
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


