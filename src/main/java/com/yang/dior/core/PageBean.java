package com.yang.dior.core;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-05 16:56
 *
 ***/

public class PageBean<T> {
    // 当前页
    private Integer page = 1;
    // 每页显示的总条数
    private Integer limit = 10;
    // 总条数
    private Integer total;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    public PageBean() {
        super();
    }

    public PageBean(Integer page, Integer limit, Integer total) {
        super();
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.totalPage = (this.total + this.limit - 1) / this.limit;
        this.startIndex = (this.page - 1) * this.limit;
        this.isMore = this.page >= this.totalPage ? 0 : 1;
    }

    public Integer getpage() {
        return page;
    }

    public void setpage(Integer page) {
        this.page = page;
    }

    public Integer getlimit() {
        return limit;
    }

    public void setlimit(Integer limit) {
        this.limit = limit;
    }

    public Integer gettotal() {
        return total;
    }

    public void settotal(Integer total) {
        this.total = total;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
