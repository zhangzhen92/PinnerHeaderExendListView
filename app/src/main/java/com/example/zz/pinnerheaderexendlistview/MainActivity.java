package com.example.zz.pinnerheaderexendlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.zz.pinnerheaderexendlistview.bean.ChildBean;
import com.example.zz.pinnerheaderexendlistview.bean.GroupBean;

import java.util.ArrayList;
import java.util.List;
/**
 * 类描述：测试类
 * 创建人：zz
 * 创建时间：2017/8/9 17:39
 */
public class MainActivity extends Activity {
    private PinnedHeaderExpandableListView explistview;
    private DataAdapter adapter;
    private View headView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }



    /**
     * 初始化VIEW
     */
    private void initView() {
        explistview = (PinnedHeaderExpandableListView)findViewById(R.id.explistview);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        List<GroupBean> groups = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GroupBean groupBean = new GroupBean();
            groupBean.setGroupName("嘿嘿嘿"+i);
            List<ChildBean> childs = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                ChildBean childBean = new ChildBean();
                childBean.setChildName("哈哈哈"+j);
                childs.add(childBean);
            }
            groupBean.setChilds(childs);
            groups.add(groupBean);
        }
        adapter = new DataAdapter(groups,getApplicationContext());
        explistview.setAdapter(adapter);
        //设置悬浮头部VIEW
        headView = View.inflate(MainActivity.this, R.layout.group,
                null);
        explistview.setHeaderView(headView);
        explistview.setGroupdataListener(new PinnedHeaderExpandableListView.HeaderDataListener() {
            @Override
            public void setData(int groupPosition) {
                if(groupPosition<0)
                    return ;
                String groupData =  ((GroupBean)adapter.getGroup(groupPosition)).getGroupName();
                ((TextView) headView.findViewById(R.id.group_title)).setText("展开"+groupData);
            }
        });
        explistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }

}
