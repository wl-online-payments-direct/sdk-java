/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ProblemDetailsResponse {

    private String detail;

    private String instance;

    private Integer status;

    private String title;

    private String type;

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    public ProblemDetailsResponse withDetail(String value) {
        this.detail = value;
        return this;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem.
     */
    public String getInstance() {
        return instance;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem.
     */
    public void setInstance(String value) {
        this.instance = value;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem.
     */
    public ProblemDetailsResponse withInstance(String value) {
        this.instance = value;
        return this;
    }

    /**
     * The HTTP status code.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * The HTTP status code.
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * The HTTP status code.
     */
    public ProblemDetailsResponse withStatus(Integer value) {
        this.status = value;
        return this;
    }

    /**
     * A short, human-readable summary of the problem type.
     */
    public String getTitle() {
        return title;
    }

    /**
     * A short, human-readable summary of the problem type.
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * A short, human-readable summary of the problem type.
     */
    public ProblemDetailsResponse withTitle(String value) {
        this.title = value;
        return this;
    }

    /**
     * A URI reference that identifies the problem type.
     */
    public String getType() {
        return type;
    }

    /**
     * A URI reference that identifies the problem type.
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * A URI reference that identifies the problem type.
     */
    public ProblemDetailsResponse withType(String value) {
        this.type = value;
        return this;
    }
}
