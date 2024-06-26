package practice5.classwork.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER, PORT); //зарядка

            //то, что я отправляю на сервер
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //то, что я получаю от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("connected to server");

            while(true) {
                System.out.println("Enter the radius or exit to exit: ");

                String input = userInput.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("byee");
                    System.exit(0);
                }

                out.println(input);

                String serverResponse = in.readLine();
                System.out.println("Area: " + serverResponse);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
