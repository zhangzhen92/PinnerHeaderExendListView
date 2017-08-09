package com.example.zz.pinnerheaderexendlistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.zz.pinnerheaderexendlistview.bean.GroupBean;

import java.util.List;

/**
 * 类描述：适配器
 * 创建人：zz
 * 创建时间：2017/8/9 16:55
 */
public class DataAdapter extends  BaseExpandableListAdapter {
    private List<GroupBean> mDatas;
	private Context context;
	private PinnedHeaderExpandableListView listView;
	private LayoutInflater inflater;
	
	
	public DataAdapter(List<GroupBean> datas, Context context){
		this.mDatas = datas;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mDatas.get(groupPosition).getChilds().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View view = null;  
        if (convertView != null) {  
            view = convertView;  
        } else {  
            view = inflater.inflate(R.layout.child, null);
        }
        TextView text = (TextView)view.findViewById(R.id.child_title);
        text.setText(mDatas.get(groupPosition).getChilds().get(childPosition).getChildName());
        return view;    
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if(groupPosition<0)
			return 0;
		return mDatas.get(groupPosition).getChilds().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mDatas.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return mDatas.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View view = null;
		//普通分组
        if (convertView != null&&(Integer)convertView.getTag()==0)  
        {
            view = convertView;  
        } else {  
        	view = inflater.inflate(R.layout.group, null);
        	view.setTag(0);
        }
        TextView text = (TextView)view.findViewById(R.id.group_title);
        if (isExpanded) {
        	text.setText("展开"+mDatas.get(groupPosition).getGroupName());
		}
		else{
			text.setText("合并"+mDatas.get(groupPosition).getGroupName());
		}
        return view;  
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	
}
