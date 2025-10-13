package serverpackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) 
    {
        //La premiere etape : 

        try(ServerSocket serverSocket = new ServerSocket(1234))
        {
        System.out.println("Je suis un serveur en attente la connexion d'un client");

        //La deuxieme etape : 

        Socket clientSocket = serverSocket.accept();
        System.out.println("un client est connecté"); 

        // La dernière étape : Fermer socket 
        clientSocket.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
