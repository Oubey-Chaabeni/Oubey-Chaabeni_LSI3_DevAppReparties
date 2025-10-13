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

        boolean conti=true;

        try(ServerSocket serverSocket = new ServerSocket(1234))
        {
        System.out.println("Je suis un serveur en attente la connexion d'un client");

        Socket clientSocket = serverSocket.accept();
        System.out.println("un client est connecté"); 

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        while(conti)
        {
            x = in.readInt();
            if(x==0)
            {
                conti = false;
            }
            x*=5;

            out.writeInt(x);
            System.out.println("Resulta envoie succefully!");
        }
        clientSocket.close();
        System.out.println("connexion ferme .");

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
