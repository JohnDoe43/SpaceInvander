package com.dregronprogram.server;

import java.io.*;
import java.net.*;

public class Server
{
    public Server() throws IOException {
        System.out.println("SERVER HAS STARTED");

        // поток для чтения данных
        BufferedReader in = null;
        // поток для отправки данных
        PrintWriter    out= null;

        // серверный сокет
        ServerSocket server = null;
        // сокет для обслуживания клиента
        Socket       client = null;


// создаем серверный сокет
        try {
            server = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println("ERROR binding to port 1234");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for the connection");
            client= server.accept();
            System.out.println("Client has connected");
        } catch (IOException e) {
            System.out.println("Can't connect");
            System.exit(-1);
        }

// создаем потоки для связи с клиентом
        in  = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);
        String input,output;

// цикл ожидания сообщений от клиента
        System.out.println("Waiting for messages");
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit"))
                break;
            out.println("SERVER: "+input);
            System.out.println(input);
        }

        InputStream  into = null;
        OutputStream outo= null;

        into  = client.getInputStream();
        try {
            outo = new FileOutputStream("fromClient.txt");
        } catch(FileNotFoundException ex) {
            System.out.println("ERROR create file!");
            System.exit(-1);
        }

        byte[] data =new byte[1024];
        int count;

        try {
            while ((count = into.read(data)) > 0) {
                outo.write(data, 0, count);
            }
        }
        catch (IOException e) {
            System.out.println("ERROR READ/WRITE DATE");
            System.exit(-1);
        }



        out.close();
        in.close();
        client.close();
        server.close();
    }
}

