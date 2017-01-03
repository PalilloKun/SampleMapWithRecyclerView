package com.palitokun.mapwrecyclerview.Pojo;

import java.util.ArrayList;


public class ConstructorInfoData {

    public ArrayList<Info> obtainData() {


        ArrayList<Info> data = new ArrayList<Info>();

        data.add(new Info("1","Map","Hello!"));
        data.add(new Info("3","Graphic","Im Graphic!"));
        data.add(new Info("3","Information","Im Info!"));

        return data;

    }
}
