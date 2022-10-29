# java-socket-calculator
Projeto de desenvolvimento de um sistema distribuído de servidores utilizando sockets, tendo como funcionalidade as operações básicas de uma calculadora.

## Explicação
O sistema é composto de um cliente que encaminha as operações via sockets para um servidor. O servidor realiza o cálculo utilizando os operadores e operando informados para a obtenção do resultado, o qual é enviado ao cliente.
### Etapas de Funcionamento
  1. Define-se a porta como 9999 e o servidor espera o estabelecimento de uma conexão.
  ```
  ServerSocket serverSocket = new ServerSocket(9999);
  Socket socket = serverSocket.accept();
  ```
  2. Abre a conexão do soquete do cliente, utilizando o IP de host local e a porta do servidor.
  ```
  Socket socket = new Socket("127.0.0.1", 9999);
  ```
  3. É feita a leitura da entrada da equação pelo cliente.
  ```
  System.out.print("Insira a equação (operando operador operando): ");
  String input = scanner.nextLine();
  ```
  4. Realiza-se o tratamento de erros da entrada do cliente.
  5. O cliente envia a equação para o servidor.
  ```
  dos.writeUTF(input);
  ```
  6. O servidor lê a entrada de dados do cliente.
  ```
  String input = dis.readUTF();
  ```
  7. O servidor realiza as operações com base nos operandos e operador informado.
  8. O servidor envia o resultado da equação para o cliente
  ```
  dos.writeUTF(Float.toString(result));
  ```
  9. O cliente armazena a resposta do servidor e imprime o resultado.
  ```
  String ans = dis.readUTF();
  System.out.println("Resultado= " + res);
  ```

## Protocolo
O protocolo utilizado para a implementação do projeto foi o TCP, Protocolo de Controle de Transmissão (Transmission Control Protocol, abreviado TCP), que é um padrão para troca de dados entre diferentes dispositivos em uma rede de computadores.
O TCP permite que dois terminais em uma rede de computadores compartilhada estabeleçam uma conexão que permite a transmissão de dados de forma bidirecional.  Isso significa que os sistemas de computador que se comunicam por TCP podem enviar e receber dados ao mesmo tempo, semelhante a uma conversa telefônica.
O software TCP é controlado pelos diversos aplicativos de rede, como navegadores ou servidores da Web, por meio de interfaces específicas. Cada conexão deve ser identificada por dois endpoints claramente definidos (cliente e servidor). Tudo o que importa é que o software TCP seja fornecido com um par único e ordenado que consiste em endereço IP e porta (também conhecido como soquete) para cada terminal.
Pré-requisitos para estabelecer uma conexão TCP válida: Ambos os terminais já devem ter um endereço IP exclusivo e ter atribuído e habilitado a porta desejada para transferência de dados. O endereço IP serve como um identificador, enquanto a porta permite que o sistema operacional atribua conexões a aplicativos específicos de cliente e servidor.

## Endereçamento
Um endereço IP é um número de 32 bits. Ele identifica exclusivamente um host (computador ou outro dispositivo, como uma impressora ou roteador) em uma rede TCP/IP. Os endereços IP normalmente são expressos em formato decimal com pontos, com quatro números separados por pontos, como: 127.0.0.1 (Endereço do cliente).

## Portas
Uma "porta" é uma distinção lógica em redes de computadores. As portas são numeradas e usadas como padrões globais para identificar processos específicos ou tipos de serviços de rede.
O protocolo TCP só precisa de uma porta para tráfego bidirecional. Geralmente usa-se números de porta que correspondem aos serviços da implementação TCP correspondente, caso existirem.
A porta usada para a conexão do cliente e servidor é a 9999.

## Referências
https://en.wikipedia.org/wiki/Transmission_Control_Protocol
https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
https://learn.microsoft.com/pt-br/troubleshoot/windows-client/networking/tcpip-addressing-and-subnetting
https://www.ionos.com/digitalguide/server/know-how/introduction-to-tcp/
https://www.hardware.com.br/dicas/tcpip-enderecamento-portas.html
