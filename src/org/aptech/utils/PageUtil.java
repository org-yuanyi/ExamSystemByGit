package org.aptech.utils;

import java.util.List;

/**
 * 分页模型类：用于分页实现
 *
 * @param <T> 数据集合的类型
 * @author 江东
 */
public class PageUtil<T> {
    //当前页-->用户从页面传递
    private int pageNo;
    //每页显示的行数-->用户从页面传递
    private int pageSize;
    //总记录数-->从数据库查询select count(1) from 表名
    private int totalCount;
    //总页数-->总记录数/每页显示的行数=totalCount / pageSize
    private int totalPage;
    //上一页-->当前页数-1=pageNo - 1
    private int prePage;
    //下一页-->当前页数+1=pageNo + 1
    private int nextPage;
    //数据集合-->从数据库中查询
    private List<T> pageList;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (int) Math.ceil(this.totalCount * 1.0 / this.pageSize);
        this.prePage = this.pageNo - 1 > 0 ? this.pageNo - 1 : this.pageNo;
        this.nextPage = this.pageNo + 1 > this.totalPage ? this.pageNo : this.pageNo + 1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

}
