package org.gozer.web;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class GozerServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context0.setContextPath("/gozer");
        context0.addServlet(new ServletHolder(new ConsoleServlet()), "/console");


        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
        resource_handler.setResourceBase("src/main/webapp");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { context0, resource_handler, new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
        server.join();
    }

}
