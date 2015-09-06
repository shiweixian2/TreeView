package com.outstudio.treeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.outstudio.treeview.adapter.SimpleTreeListViewAdapter;
import com.outstudio.treeview.bean.FileBean;

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
            mAdapter = new SimpleTreeListViewAdapter<>(mTree,this,mDatas,1);
            mTree.setAdapter(mAdapter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
    }


}
