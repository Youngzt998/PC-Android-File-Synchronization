package com.example.androidtopc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    ServerSocket serverSocket;
    Socket socket;
    private int serverPort;
    private OutputStream outputStream;
    private InputStream inputStream;
    SocketBuildThread socketBuildThread;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startServer();
    }

    public void startServer()
    {
        try {
            serverSocket = new ServerSocket(8001);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "绑定端口失败...", Toast.LENGTH_SHORT).show();
            return;
        }
        socketBuildThread = new SocketBuildThread();
        socketBuildThread.start();
        Toast.makeText(this, "服务开启", Toast.LENGTH_SHORT).show();
    }

    class SocketBuildThread extends Thread
    {
        @Override
        public void run()
        {
            //while (!interrupted())
            {
                try {
                    socket = serverSocket.accept();
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    class SocketReceiveThread extends Thread
    {
        @Override
        public void run()
        {
            try {

                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
