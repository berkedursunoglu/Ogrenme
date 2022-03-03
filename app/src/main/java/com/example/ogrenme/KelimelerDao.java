package com.example.ogrenme;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KelimelerDao {

    public static ArrayList<Kelimeler> kelimeler (Veritabani vt){
        ArrayList<Kelimeler> kelimelerArrayListe = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kelimeler",null);

        while (c.moveToNext()){
            Kelimeler n = new Kelimeler(c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                    ,c.getString(c.getColumnIndexOrThrow("kelime_ing"))
                    ,c.getString(c.getColumnIndexOrThrow("kelime_tr")));
            kelimelerArrayListe.add(n);
        }
        db.close();
        return kelimelerArrayListe;
    }
    public static void kelimeEkle(Veritabani vt,String kelime_ing,String kelime_tr){
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("kelime_ing",kelime_ing);
        val.put("kelime_tr",kelime_tr);
        db.insertOrThrow("kelimeler",null,val);
        db.close();
    }

    public static void kelimeSil(Veritabani vt,int kelime_id){
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("kelimeler","kelime_id=?",new String[] {String.valueOf(kelime_id)});
        db.close();
    }
    public static ArrayList<Kelimeler> kelimeAra(Veritabani vt, String aramaKelime){
        ArrayList<Kelimeler> kelimelerArrayListe = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kelimeler WHERE kelime_ing like '%"+aramaKelime+"%' OR kelime_tr like '%"+aramaKelime+"%'" ,null);

        while (c.moveToNext()){
            Kelimeler n = new Kelimeler(c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                    ,c.getString(c.getColumnIndexOrThrow("kelime_ing"))
                    ,c.getString(c.getColumnIndexOrThrow("kelime_tr")));
            kelimelerArrayListe.add(n);
        }
        return kelimelerArrayListe;
    }


}
