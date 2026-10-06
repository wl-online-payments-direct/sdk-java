/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Pagination {

    private Integer page;

    private Integer pageSize;

    /**
     * The page number to retrieve (1-based). Default is 1.
     */
    public Integer getPage() {
        return page;
    }

    /**
     * The page number to retrieve (1-based). Default is 1.
     */
    public void setPage(Integer value) {
        this.page = value;
    }

    /**
     * The page number to retrieve (1-based). Default is 1.
     */
    public Pagination withPage(Integer value) {
        this.page = value;
        return this;
    }

    /**
     * Number of results per page. Default is 50, maximum is 1000.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Number of results per page. Default is 50, maximum is 1000.
     */
    public void setPageSize(Integer value) {
        this.pageSize = value;
    }

    /**
     * Number of results per page. Default is 50, maximum is 1000.
     */
    public Pagination withPageSize(Integer value) {
        this.pageSize = value;
        return this;
    }
}
