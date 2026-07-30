/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CursorPaginationInfo {

    private Boolean hasMore;

    private String nextCursor;

    /**
     * Indicates whether more results are available
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * Indicates whether more results are available
     */
    public void setHasMore(Boolean value) {
        this.hasMore = value;
    }

    /**
     * Indicates whether more results are available
     */
    public CursorPaginationInfo withHasMore(Boolean value) {
        this.hasMore = value;
        return this;
    }

    /**
     * Opaque cursor for retrieving the next page. Null if no more results available.
     */
    public String getNextCursor() {
        return nextCursor;
    }

    /**
     * Opaque cursor for retrieving the next page. Null if no more results available.
     */
    public void setNextCursor(String value) {
        this.nextCursor = value;
    }

    /**
     * Opaque cursor for retrieving the next page. Null if no more results available.
     */
    public CursorPaginationInfo withNextCursor(String value) {
        this.nextCursor = value;
        return this;
    }
}
