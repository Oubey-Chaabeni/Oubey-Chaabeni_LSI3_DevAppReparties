package serverpackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server {
    public static void main(String[] args) 
    {

        int x;

        try(ServerSocket serverSocket = new ServerSocket(1234))
        {
        System.out.println("Je suis un serveur en attente la connexion d'un client");

        Socket clientSocket = serverSocket.accept();
        System.out.println("un client est connecté"); 

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        x = in.readInt();

        x*=5;

        out.writeInt(x);
        System.out.println("Resulta envoie succefully!");

        clientSocket.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
