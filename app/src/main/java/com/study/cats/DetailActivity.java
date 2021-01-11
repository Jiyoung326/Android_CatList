package com.study.cats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView txtNick;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView_detail);
        txtNick = findViewById(R.id.txt_nick_detail);
        txtName = findViewById(R.id.txt_name_detail);

        Intent intent = getIntent();

        String nick = intent.getStringExtra("nick");
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image",0);

        txtNick.setText(nick);
        txtName.setText(name);
        imageView.setImageResource(image);

    }
}