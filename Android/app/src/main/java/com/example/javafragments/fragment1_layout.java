package com.example.javafragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 **/
public class fragment1_layout extends Fragment {

    private EditText editText;
    private Button btnSendMessage;
  //  private ChatClient client;

    private PrintWriter writer;
    private BufferedReader input;
    private TextView textView;
    private Thread t1;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Message> chatText;
    private Message message;
    private Socket socket;




    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1_layout, container, false);

    editText = (EditText) view.findViewById(R.id.textMessage);
    btnSendMessage = (Button)view.findViewById(R.id.btnNavSendMessage);
    //textView = (TextView)view.findViewById(R.id.textChat);
   chatText = new ArrayList<>();
//for (int i = 0; i < 5; i++){
//    chatText.add(new Message(1, "This is a sample text " + i) );
//}

        mRecyclerView = view.findViewById(R.id.recChat) ;
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());

        mAdapter = new CustomAdapter(chatText);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        Log.d("Main Chat Screen", "onCreate: started.");

        try {
            socket = new Socket("192.168.56.1", 5000);

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Getiing connected");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String inMessage = null;
                        try {
                            inMessage = input.readLine();
                            chatText.add(new Message(1, inMessage));

                            new Handler(Looper.getMainLooper()).post(new Runnable(){
                                @Override
                                public void run() {
                                    mAdapter.notifyDataSetChanged();
                                }
                            });

                        } catch (IOException exception) {

                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            exception.printStackTrace();
                            break;
                        }


                      //  textView.setText(textView.getText() + "\n" + inMessage);

                        System.out.println("New Message: " + inMessage);

                    }
                }
            }).start();

        } catch (IOException exception) {
            exception.printStackTrace();
            editText.setText(exception.getMessage());
            System.out.println("Something went wrong");
        }

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                writer.println(editText.getText());

                chatText.add(new Message(2, message));
                System.out.println(socket.isClosed() + " " + socket.isConnected());
                editText.setText("");
                mAdapter.notifyDataSetChanged();
//                mAdapter = new CustomAdapter(chatText);
//
//                mRecyclerView.setLayoutManager(mLayoutManager);
//                mRecyclerView.setAdapter(mAdapter);
//                if(t1.isAlive()==false){
//                    t1.start();
//                }


            }
        });



    return view;
    }
}