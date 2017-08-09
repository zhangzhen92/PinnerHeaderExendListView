package com.example.zz.pinnerheaderexendlistview.bean;

import java.util.List;

/**
 * 类描述：group实体类
 * 创建人：zz
 * 创建时间： 2017/8/9 16:57
 */


public class GroupBean {
    private String groupName;
    private List<ChildBean> childs;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildBean> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildBean> childs) {
        this.childs = childs;
    }
}
