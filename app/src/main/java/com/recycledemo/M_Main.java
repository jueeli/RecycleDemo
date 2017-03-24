package com.recycledemo;

import java.util.ArrayList;

/**
 * Created by softbunch on 3/24/17.
 */

public class M_Main {
    int type;
    String name;
    String desc;
    ArrayList<M_child> mChildren;

    public ArrayList<M_child> getmChildren() {
        return mChildren;
    }

    public void setmChildren(ArrayList<M_child> mChildren) {
        this.mChildren = mChildren;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
