package practice5.classwork.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Person {
    private static final String SERVER = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER, PORT); //зарядка

            //то, что я отправляю на сервер
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //то, что я получаю от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner userInput = new Scanner(System.in);

            System.out.println("Connected to server");

            Thread thread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            thread.start();

            String userMessage;
            while (true) {
                userMessage = userInput.nextLine();
                out.println(userMessage);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

