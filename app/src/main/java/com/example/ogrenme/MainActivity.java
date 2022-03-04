package com.example.ogrenme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sh = null;
    private Animation anim;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startbutton);
        anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.buttonalphaanim);
        start.setAnimation(anim);
        sh = MainActivity.this.getPreferences(MODE_PRIVATE);
        final int gelenSayac = sh.getInt("sayac", 0);

        if (gelenSayac == 1) {
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        } else {
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor;
                    editor = sh.edit();
                    editor.putInt("sayac", 1);
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    finish();
                }
            });
        }
    }
}