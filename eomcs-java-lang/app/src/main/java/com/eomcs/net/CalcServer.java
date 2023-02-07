package com.eomcs.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("서버실행");

    ServerSocket serverSocket = new ServerSocket(8888);

    Socket socket = serverSocket.accept();
    System.out.println("클라이언트와 연결됨!");

    @SuppressWarnings("resource")
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());

    while (true) {
      int message = in.nextInt();
      System.out.println(message);
      char message2 = in.next().charAt(0);
      System.out.println(message2);
      int message3 = in.nextInt();
      System.out.println(message3);

      int result = 0;
      // if (message2 == '+') {
      // result = message + message3;
      // } else if(message2 == '-') {
      // result = message - message3;
      // } else if(message2 == '*') {
      // result = message * message3;
      // } else if(message == '/') {
      // result = message / message3;
      // }
      switch (message2) {
        case '+':
          result = message + message3;
          break;
        case '-':
          result = message - message3;
          break;
        case '*':
          result = message * message3;
          break;
        case '/':
          result = message / message3;
          break;
      }

      out.println(result);
      if (message2 == 'n') {
        socket.close();
        System.out.println("서버종료!");
      }
      serverSocket.close();
      keyScan.close();
    }
  }

}
