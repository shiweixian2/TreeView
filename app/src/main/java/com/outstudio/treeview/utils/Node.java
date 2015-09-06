package com.outstudio.treeview.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiweixian on 2015/9/6.
 */
public class Node {
    private int id;

    public Node() {
    }

    public Node(int id, int pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    /**

     * 根节点的pid=0
     */
    private int pId = 0;
    private String name;
    /**
     * 树的层级
     */
    private int level;
    /**
     * 是否展开
     */
    private boolean isExpand = false;
    private int icon;

    private Node parent;
    private List<Node> children = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getId() {
        return id;
    }

    public int getpId() {
        return pId;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return parent == null ? 0 : parent.getLevel() + 1;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public int getIcon() {
        return icon;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setIsExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if(!isExpand){
            /**
             * 将子节点也收缩
             */
            for (Node node : children){
                node.setIsExpand(false);
            }
        }
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    /**
     * 判断是否定是根节点
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 判断当前父节点的收缩状态
     *
     * @return
     */
    public boolean isParentExpand() {
        if (parent == null) {
            return false;
        }
        return parent.isExpand();
    }

    /**
     * 判断是否是叶子节点
     *
     * @return
     */
    public boolean isLeaf() {
        return children.size() == 0;
    }

}
