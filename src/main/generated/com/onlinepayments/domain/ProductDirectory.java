/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class ProductDirectory {

    private List<DirectoryEntry> entries;

    /**
     * List of entries in the directory
     */
    public List<DirectoryEntry> getEntries() {
        return entries;
    }

    /**
     * List of entries in the directory
     */
    public void setEntries(List<DirectoryEntry> value) {
        this.entries = value;
    }

    /**
     * List of entries in the directory
     */
    public ProductDirectory withEntries(List<DirectoryEntry> value) {
        this.entries = value;
        return this;
    }
}
