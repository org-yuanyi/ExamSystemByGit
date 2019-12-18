package org.aptech.utils;

import java.util.List;

/**
 * ��ҳģ���ࣺ���ڷ�ҳʵ��
 *
 * @param <T> ���ݼ��ϵ�����
 * @author ����
 */
public class PageUtil<T> {
    //��ǰҳ-->�û���ҳ�洫��
    private int pageNo;
    //ÿҳ��ʾ������-->�û���ҳ�洫��
    private int pageSize;
    //�ܼ�¼��-->�����ݿ��ѯselect count(1) from ����
    private int totalCount;
    //��ҳ��-->�ܼ�¼��/ÿҳ��ʾ������=totalCount / pageSize
    private int totalPage;
    //��һҳ-->��ǰҳ��-1=pageNo - 1
    private int prePage;
    //��һҳ-->��ǰҳ��+1=pageNo + 1
    private int nextPage;
    //���ݼ���-->�����ݿ��в�ѯ
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
