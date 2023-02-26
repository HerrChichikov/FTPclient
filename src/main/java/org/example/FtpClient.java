package org.example;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FtpClient {

    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;

    void setServer(String server){
        this.server = server;
    }
    String getServer(){
        return server;
    }

    void setUser(String user){
        this.user = user;
    }
    String getUser(){
        return user;
    }

    void setPort(int port){
        this.port = port;
    }
    int getPort(){
        return port;
    }

    void setPassword(String password){
        this.password = password;
    }
    String getPassword(){
        return password;
    }

    // constructor

    void open() throws IOException {
        ftp = new FTPClient();

        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        ftp.login(user, password);
    }

    void close() throws IOException {
        ftp.disconnect();
    }

    void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
    }

    void putFileToPath(File file, String path) throws IOException {
        ftp.storeFile(path, new FileInputStream(file));
    }

    void enterLocalPassiveMode() {
        ftp.enterLocalPassiveMode();
    }
    void enterLocalActiveMode(){
        ftp.enterLocalActiveMode();
    }


}