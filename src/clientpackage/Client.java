package clientpackage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) 
    {
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        String op= "", forma = "-?\\d+\\s*[+\\-*/]\\s*-?\\d+";

        int r;

        boolean conti = true ,opt = true,numt = true;


        try
        {
            InetAddress serverIP = InetAddress.getLocalHost();

            System.out.println("Je suis un client pas encore connecté…");  
            
            Socket socket = new Socket(serverIP, 1234);
            System.out.println("je suis un client connecté");  

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            

            while(conti)
            {
                while(opt)
                {
                    System.out.print("Entrer une opération (number * number) ou 'exit' pour quitter : ");
                    op = strScanner.nextLine().trim();
                    if(op.matches("-?\\d+\\s*[+\\-*/]\\s*-?\\d+"))
                    {
                        opt = false;
                    }
                }
                out.println(op);
                opt=true;
                r = in.read();
                System.out.println("La resulta envoi par le serveur est :"+r+".");
                out.flush();
            }
            socket.close();
            System.out.println("connexion ferme .");

        }catch(IOException e )
        {
            e.printStackTrace();
        }
        
    }
    
}
