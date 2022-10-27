import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleJavaClient {

    public static void main(String[] args) 	{
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            Scanner scanner = new Scanner(System.in);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.print("Insira a equação (operando operador operando): ");
                String input = scanner.nextLine();
                //Envia a equação para o servidor
                dos.writeUTF(input);
                //Armazena a resposa do servidor e mostra ao cliente
                String ans = dis.readUTF();
                System.out.println("Answer=" + ans);
            }
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }

}
