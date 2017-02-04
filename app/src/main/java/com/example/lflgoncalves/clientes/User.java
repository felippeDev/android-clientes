package com.example.lflgoncalves.clientes;

import java.io.Serializable;

/**
 * Created by lflgoncalves on 2/4/2017.
 */
public class User implements Serializable {
    int id;
    String name;
    String email;
    String password;
    int type;
}
