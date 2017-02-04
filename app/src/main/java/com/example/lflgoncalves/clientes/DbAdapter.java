package com.example.lflgoncalves.clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lflgoncalves on 2/4/2017.
 */

public class DbAdapter {
    SQLiteDatabase db = null;
    DbHelper dbHelper = null;

    public DbAdapter(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openConn() {
        if(db == null) {
            db = dbHelper.getWritableDatabase();
        }
    }

    public void closeConn() {
        if(db != null && db.isOpen()) {
            db.close();
            db = null;
        }
    }

    public void execCommand(String sql) {
        openConn();
        db.execSQL(sql);
        closeConn();
    }

    public Cursor execQuery(String sql) {
        openConn();
        return db.rawQuery(sql, null);
    }
}
