package org.gozer.web;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/console")
public class ConsoleServlet extends WebSocketServlet {
    private static final long serialVersionUID = -5677827008838868510L;

    public ConsoleServlet() {
        System.out.println("New ConsoleServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<!DOCTYPE html><html><body><h1>Twitter !</h1></body></html>");
    }

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        return new WebSocket.OnTextMessage() {
            private Connection connection;

            @Override
            public void onOpen(Connection connection) {
                this.connection = connection;
                System.out.println("open");
            }

            @Override
            public void onMessage(String message) {
                System.out.println("message : "+message);

                try {
//                    Process proc = Runtime.getRuntime().exec(new String[]{"mvn"}, new String[]{"package", "JAVA_HOME=/home/sebastien/outils/jdk1.6.0_32"}, new File("/home/sebastien/workspaces/websocket"));


                    ProcessBuilder processBuilder = new ProcessBuilder("mvn", "package");

                    Map env = processBuilder.environment();
                    env.put("JAVA_HOME", "/home/sebastien/outils/jdk1.6.0_32");

                    processBuilder.directory(new File("/home/sebastien/workspaces/websocket"));

                    Process proc = processBuilder.start();




                    Scanner scanner = new Scanner(proc.getInputStream());

                    while (scanner.hasNextLine()) {
                        String s = scanner.nextLine();
                        System.out.println(s);
                        connection.sendMessage(s);
                    }

                    proc.waitFor();

                    System.out.println("Exit : "+proc.exitValue());


//                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//
//                    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
//
//                    // read the output from the command
//                    System.out.println("Here is the standard output of the command:\n");
//                    String s;
////                    while ((s = stdInput.readLine()) != null) {
//
//                    while (true) {
//                        s = stdInput.readLine();
//                        System.out.println(s);
////                        connection.sendMessage(s);
//                    }

//                    // read any errors from the attempted command
//                    System.out.println("Here is the standard error of the command (if any):\n");
//                    while ((s = stdError.readLine()) != null) {
//                        System.out.println("Error : "+s);
//                        connection.sendMessage("Error : " + s);
//                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


//                int i=0;
//                while(i<5) {
//                    try {
//                        connection.sendMessage("Hello "+i);
//                        i++;
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
            }

            @Override
            public void onClose(int arg0, String arg1) {
                System.out.println("close");
            }

        };
    }

}