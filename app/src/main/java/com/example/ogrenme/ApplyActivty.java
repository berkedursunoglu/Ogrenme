package com.example.ogrenme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ApplyActivty extends AppCompatActivity {
    private EditText ing, tr, ing1, tr1, ing2, tr2, ing3, tr3, ing4, tr4, ing5, tr5, ing6, tr6, ing7, tr7, ing8, tr8, ing9, tr9;
    private Button apply;
    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_activty);
        vt = new Veritabani(getApplicationContext());
        apply = (Button) findViewById(R.id.apply);
        ing = (EditText) findViewById(R.id.ing);
        tr = (EditText) findViewById(R.id.tr);
        ing1 = (EditText) findViewById(R.id.ing1);
        tr1 = (EditText) findViewById(R.id.tr1);
        ing2 = (EditText) findViewById(R.id.ing2);
        tr2 = (EditText) findViewById(R.id.tr2);
        ing3 = (EditText) findViewById(R.id.ing3);
        tr3 = (EditText) findViewById(R.id.tr3);
        ing4 = (EditText) findViewById(R.id.ing4);
        tr4 = (EditText) findViewById(R.id.tr4);
        ing5 = (EditText) findViewById(R.id.ing5);
        tr5 = (EditText) findViewById(R.id.tr5);
        ing6 = (EditText) findViewById(R.id.ing6);
        tr6 = (EditText) findViewById(R.id.tr6);
        ing7 = (EditText) findViewById(R.id.ing7);
        tr7 = (EditText) findViewById(R.id.tr7);
        ing8 = (EditText) findViewById(R.id.ing8);
        tr8 = (EditText) findViewById(R.id.tr8);
        ing9 = (EditText) findViewById(R.id.ing9);
        tr9 = (EditText) findViewById(R.id.tr9);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gelening = ing.getText().toString().trim();
                String gelentr = tr.getText().toString().trim();
                String gelening1 = ing1.getText().toString().trim();
                String gelentr1 = tr1.getText().toString().trim();
                String gelening2 = ing2.getText().toString().trim();
                String gelentr2 = tr2.getText().toString().trim();
                String gelening3 = ing3.getText().toString().trim();
                String gelentr3 = tr3.getText().toString().trim();
                String gelening4 = ing4.getText().toString().trim();
                String gelentr4 = tr4.getText().toString().trim();
                String gelening5 = ing5.getText().toString().trim();
                String gelentr5 = tr5.getText().toString().trim();
                String gelening6 = ing6.getText().toString().trim();
                String gelentr6 = tr6.getText().toString().trim();
                String gelening7 = ing7.getText().toString().trim();
                String gelentr7 = tr7.getText().toString().trim();
                String gelening8 = ing8.getText().toString().trim();
                String gelentr8 = tr8.getText().toString().trim();
                String gelening9 = ing9.getText().toString().trim();
                String gelentr9 = tr9.getText().toString().trim();


                if (gelening.isEmpty() || gelentr.isEmpty() || gelening1.isEmpty() || gelentr1.isEmpty() || gelening2.isEmpty() || gelentr2.isEmpty() ||
                        gelening3.isEmpty() || gelentr3.isEmpty() || gelening4.isEmpty() || gelentr4.isEmpty() || gelening5.isEmpty() || gelentr5.isEmpty() ||
                        gelening6.isEmpty() || gelentr6.isEmpty() || gelening7.isEmpty() || gelentr7.isEmpty() ||
                        gelening8.isEmpty() || gelentr8.isEmpty() || gelening9.isEmpty() || gelentr9.isEmpty()) {
                    Toast.makeText(ApplyActivty.this, "Alanları Boş Bırakamazsınız.", Toast.LENGTH_LONG).show();
                } else {
                    KelimelerDao.kelimeEkle(vt, gelening, gelentr);
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    finish();
                }

            }
        });

    }
}