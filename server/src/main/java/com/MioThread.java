package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MioThread extends Thread {

  private Socket s;
  
  public MioThread(Socket socket){
            s = socket;
  }

  public void run(){
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
       // String myString;
        do{
        String myString = in.readLine();
        if(myString.equals("!")){
            break;
        }
        out.println(myString.toUpperCase());
        System.out.println("ecco la frase che hai inserito: " + myString);
    }while(true);
    System.out.println("bye bye");
    s.close();
    
    } catch (Exception e) {
        
    }
    }
  }
    

