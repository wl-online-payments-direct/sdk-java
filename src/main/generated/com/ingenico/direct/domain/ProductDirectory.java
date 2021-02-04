/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class ProductDirectory {

	private List<DirectoryEntry> entries = null;

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
}
