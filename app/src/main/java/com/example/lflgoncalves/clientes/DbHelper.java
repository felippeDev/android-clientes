package com.example.lflgoncalves.clientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;

/**
 * Created by lflgoncalves on 2/4/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "Banana_Services.db";
    static  final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsers = "CREATE TABLE users(" +
                "id integer primary key autoincrement," +
                "name text not null," +
                "email text not null," +
                "password text not null," +
                "type integer not null);";

        String createServices = "CREATE TABLE services(" +
                "id integer primary key autoincrement," +
                "author_id integer not null" +
                "status integer not null" +
                "description text not null," +
                "location text not null," +
                "date datetime not null," +
                "vehicle text," +
                "tech_id integer not null," +
                "FOREIGN KEY(author_id) REFERENCES users(id)," +
                "FOREIGN KEY(tech_id) REFERENCES users(id));";

        String[] initialCommands = new String[2];
        initialCommands[0] = createUsers;
        initialCommands[1] = createServices;

        for (int i = 0; i < initialCommands.length; i++) {
            db.execSQL(initialCommands[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
