package com.praktikum.data;

import com.praktikum.users.*;
import java.util.ArrayList;

public class Data {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Mahasiswa("bowo", "407"));
        userList.add(new Mahasiswa("yossua", "391"));
    }
}