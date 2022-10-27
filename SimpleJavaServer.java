import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import static java.lang.Float.isNaN;

public class SimpleJavaServer {

    public static void main(String[] args) 	{

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                float num1 = 0f;
                float num2 = 0f;
                String operator;

                //Espera entrada de dados do cliente
                String input = dis.readUTF();
                if(input.equals("bye")) {
                    break;
                }

                System.out.println("Equação: " + input);

                //StringTokenizer separa operando de operador
                StringTokenizer tokenizer = new StringTokenizer(input);

                do{
                    num1 = Float.parseFloat(tokenizer.nextToken());
                    operator = tokenizer.nextToken();
                    num2 = Float.parseFloat(tokenizer.nextToken());
                    if (!isNaN(num1)){
                        System.out.println("Operando não é um número!");
                        num1 = Float.parseFloat(tokenizer.nextToken());
                        operator = tokenizer.nextToken();
                        num2 = Float.parseFloat(tokenizer.nextToken());
                    }
                } while (isNaN(num1) || isNaN(num2));

                float result = 0f;

                switch (operator) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                    case "**" -> result = (float) Math.pow(num1, num2);
                    case "//" -> result = (float) (num1 * Math.sqrt(num2));
                    case "%" -> result = (num1 / 100) * num2;
                    default -> System.out.println("Operador Inválido!");
                }

                //Envia o resultado da equação para o cliente
                dos.writeUTF(Float.toString(result));
            }
            socket.close();
        }
        catch (Exception err){
            System.out.println(err);
        }
    }

}
