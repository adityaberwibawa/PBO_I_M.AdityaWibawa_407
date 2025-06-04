package com.example.tugasmodul6.praktikum.data;

import com.example.tugasmodul6.praktikum.users.*;
import java.util.ArrayList;

public class Data {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Mahasiswa("bowo", "407"));
        userList.add(new Mahasiswa("yossua maling", "391"));

        reportedItems.add(new Item("mamat", "bulat", "Dau city", "Claimed"));
        reportedItems.add((new Item("bata merah", "merrah", "Dau empire", "Claimed")));
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }
}