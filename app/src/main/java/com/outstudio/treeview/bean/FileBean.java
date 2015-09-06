package com.outstudio.treeview.bean;

import com.outstudio.treeview.utils.annotation.TreeNodeId;
import com.outstudio.treeview.utils.annotation.TreeNodeLabel;
import com.outstudio.treeview.utils.annotation.TreeNodePid;

/**
 * Created by shiweixian on 2015/9/6.
 */
public class FileBean {
    @TreeNodeId
    private int id;
    @TreeNodePid
    private int pId;
    @TreeNodeLabel
    private String label;

    public void setId(int id) {
        this.id = id;
    }

    public FileBean(int id, int pId, String label) {
        this.id = id;
        this.pId = pId;
        this.label = label;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public int getId() {
        return id;
    }

    public int getpId() {
        return pId;
    }

    public String getLabel() {
        return label;
    }

    public String getDesc() {
        return desc;
    }
}
