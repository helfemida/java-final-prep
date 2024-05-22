package practice5.classwork.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
    private static final int PORT = 12345;
    private static HashSet<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT); //розетка
            System.out.println("server started");

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected " + clientSocket);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private BufferedReader in;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try{
                String message;
                while ((message = in.readLine()) != null){
                    System.out.println("Received: " + message);
                    resend(message);
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            finally {
                try {
                    in.close();
                    clientSocket.close();
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        private static void resend(String message){
            for(PrintWriter client: clients){
                client.println(message);
            }
        }
    }
}



