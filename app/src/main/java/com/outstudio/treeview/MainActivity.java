package com.outstudio.treeview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.outstudio.treeview.adapter.SimpleTreeListViewAdapter;
import com.outstudio.treeview.bean.FileBean;
import com.outstudio.treeview.utils.Node;
import com.outstudio.treeview.utils.adapter.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mTree;
    private SimpleTreeListViewAdapter<FileBean> mAdapter;
    private List<FileBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTree = (ListView) findViewById(R.id.id_listView);
        initDatas();
        try {
            //1表示默认展开1级
            mAdapter = new SimpleTreeListViewAdapter<>(mTree,this,mDatas,0);
            mTree.setAdapter(mAdapter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        initEvent();
    }

    private void initEvent(){
        mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                if (node.isLeaf()){
                    Toast.makeText(MainActivity.this,node.getName(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        mTree.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final EditText et = new EditText(MainActivity.this);
                new AlertDialog.Builder(MainActivity.this).setTitle("Add Note")
                        .setView(et)
                        .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (TextUtils.isEmpty(et.getText().toString()))
                                    return;
                                mAdapter.addExtraNode(position,et.getText().toString());
                            }
                        })
                        .setNegativeButton("Cnacel", null).create().show();
                return true;
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        FileBean bean = new FileBean(1, 0, "根目录1");
        mDatas.add(bean);
        bean = new FileBean(2, 0, "根目录2");
        mDatas.add(bean);
        bean = new FileBean(3, 0, "根目录3");
        mDatas.add(bean);
        bean = new FileBean(4, 1, "根目录1-1");
        mDatas.add(bean);
        bean = new FileBean(5, 1, "根目录1-2");
        mDatas.add(bean);
        bean = new FileBean(6, 2, "根目录2-1");
        mDatas.add(bean);
        bean = new FileBean(7, 2, "根目录2-2");
        mDatas.add(bean);
        bean = new FileBean(8, 5, "根目录1-1-1");
        mDatas.add(bean);
        bean = new FileBean(9, 5, "根目录1-1-2");
        mDatas.add(bean);
    }


}
