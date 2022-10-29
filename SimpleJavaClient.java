import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

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

                //Separa a entrada do cliente em tokens
                StringTokenizer tokenizer = new StringTokenizer(input);

                //Verifica se a equação possui 3 tokens (operando, operador e operando)
                if (tokenizer.countTokens() != 3){
                    System.out.println("Somente operações entre 2 operandos!");
                    continue;
                }

                //Verifica se a equação segue o formato esperado (operando, operador e operando)
                try{
                    Float.valueOf(tokenizer.nextToken());
                    tokenizer.nextToken();
                    Float.valueOf(tokenizer.nextToken());
                } catch (NumberFormatException e){
                    System.out.println("Operando não é um número!");
                    continue;
                }

                //Envia a equação para o servidor
                dos.writeUTF(input);

                //Armazena a resposta do servidor e mostra ao cliente
                String res = dis.readUTF();
                System.out.println("Resultado= " + res);
            }
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }

}
