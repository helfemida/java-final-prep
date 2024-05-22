package practice5.classwork.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT); //розетка
            System.out.println("server started");

            while(true){
                try {
                    Socket clientSocket = serverSocket.accept();
                    //отправлять пользователю информацию
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    //принимать от пользователя
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    System.out.println("client qosyldy");

                    double radius = Double.parseDouble(in.readLine());
                    double area = Math.pow(radius, 2) * Math.PI;

                    out.println(area);
                    System.out.println(area);
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
