package clientpackage;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) 
    {
        Scanner intScanner = new Scanner(System.in);

        int x;
        try
        {

            System.out.println("Je suis un client pas encore connecté…");  
            
            Socket socket = new Socket("localhost", 1234);
            System.out.println("je suis un client connecté");  

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("Entrer l entier pour l envoyer au serveur : ");
            x = intScanner.nextInt();
            out.writeInt(x);

            x = in.readInt();

            System.out.println("La resulta envoi par le serveur est :"+x+".");

            socket.close();

        }catch(IOException e )
        {
            e.printStackTrace();
        }
        
    }
    
}
