package com.dregronprogram.server;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("CLIENT HAS STARTED");
        Socket server = null;

        //  адрес (имя) сервера должны передаваться как параметр
        if (args.length==0) {
            System.out.println("Using: java Client hostname");
            System.exit(-1);
        }


        System.out.println("Connect to server "+args[0]);

        server = new Socket(args[0],1234);
        BufferedReader in  = new BufferedReader(
                new  InputStreamReader(server.getInputStream()));
        PrintWriter out =
                new PrintWriter(server.getOutputStream(),true);
        BufferedReader inu =
                new BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;


        while ((fuser = inu.readLine())!=null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close"))
                break;
            if (fuser.equalsIgnoreCase("exit"))
                break;
        }

        InputStream into = null;
        OutputStream outo = null;
        File file = null;

        file = new File("score.txt");
        try {
            into = new FileInputStream(file);
            outo = server.getOutputStream();
            byte[] bytes = new byte[1024];
            int count;
            while ((count = into.read(bytes)) > 0) {
                outo.write(bytes, 0, count);
            }
        }
        catch (IOException ex) {
            System.out.println("ERROR IN/OUT");
            System.exit(-1);
        }

        out.close();
        in.close();
        inu.close();
        server.close();
    }
}


