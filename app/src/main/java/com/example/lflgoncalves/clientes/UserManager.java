package com.example.lflgoncalves.clientes;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lflgoncalves on 2/4/2017.
 */

public class UserManager {
    private Context context;

    public UserManager(Context context){
        this.context = context;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        DbAdapter dba = new DbAdapter(context);

        String sql_searchAllUsers = "SELECT id,name,email,password,type FROM users";

        Cursor cursor = dba.execQuery(sql_searchAllUsers);

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            int type = cursor.getInt(4);

            User user = new User(id,name,email,password,type);
        }

        dba.closeConn();
        return users;
    }
}
