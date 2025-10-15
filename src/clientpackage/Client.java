package clientpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) 
    {
        Scanner intScanner = new Scanner(System.in);

        int x;

        boolean conti = true;


        try
        {
            InetAddress serverIP = InetAddress.getLocalHost();

            System.out.println("Je suis un client pas encore connecté…");  
            
            Socket socket = new Socket(serverIP, 1234);
            System.out.println("je suis un client connecté");  

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("Entrer l entier pour l envoyer au serveur : ");

            while(conti)
            {
                x = intScanner.nextInt();
                out.writeInt(x);
                if(x==0)
                {
                    conti = false;
                }
                x = in.readInt();

                System.out.println("La resulta envoi par le serveur est :"+x+".");
            }
            socket.close();
            System.out.println("connexion ferme .");

        }catch(IOException e )
        {
            e.printStackTrace();
        }
        
    }
    
}
