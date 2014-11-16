package cn.itcast.oa.util;

import java.util.List;

/**
 * Created by lkk on 2014/11/16.
 */
public class PageBean {
    private int pageSize;
    private int pageNum;

    private List recordList;
    private int recordCount;

    private int beginPageIndex;
    private int endPageIndex;
    private int pageCount;

    public PageBean(int pageSize, int pageNum, List recordList, int recordCount) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.recordList = recordList;
        this.recordCount = recordCount;

        //总页数
        pageCount = (recordCount + pageSize - 1) / pageSize;

        //如果总页数小于10
        if (pageCount < 10) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        } else {
            beginPageIndex = pageNum - 4;
            endPageIndex = pageNum + 5;

            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 9;
            }
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public List getRecordList() {
        return recordList;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }
}
