package com.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView messageTextView = findViewById(R.id.messageTextView);
        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        RecyclerView recyclerMessages = findViewById(R.id.recyclerMessages);

        final MessageController messageController = new MessageController();

        messageController.setIncomingLayout(R.layout.incoming_message)
                .setOutgoingLayout(R.layout.outgoing_message)
                .setMessageTextId(R.id.message)
                .setMessageTimeId(R.id.date)
                .setUserNameId(R.id.usernameMessage)
                .appendTo(recyclerMessages,this);

        messageController.addMessage(new MessageController.Message(
                "Привет, мир!",
                "Альберт Салимов",
                false));

        messageController.addMessage(new MessageController.Message(
                "Привет, это тестовое чат-приложение. Здесь я учусь создавать клиент-серверное взаимодействие." +
                        "Позже это все будет работать через интернет. Спасибо",
                "Алмаз Садретдинов",
                true));

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageController.addMessage(new MessageController.Message(
                        messageTextView.getText().toString(),
                        "Алмаз Садретдинов",
                        true));
                messageTextView.setText("");
            }
        });

    }


}
