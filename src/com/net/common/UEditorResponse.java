package com.net.common;

/**
 * @包名 com.net.common
 * @类名 UEditorResponse
 * @作者 snail
 * @创建时间 2015-10-23
 * @描述 TODO
 */
public class UEditorResponse {

    private String original;

    private String state;

    private String title;

    private String url;

    /**
     * <p>
     * 方法描述:
     * </p>
     */
    public UEditorResponse() {
        super();
    }

    /**
     * <p>
     * 方法描述:
     * </p>
     * @param state
     * @param url
     * @param title
     * @param original
     */
    public UEditorResponse(String state, String url, String title, String original) {
        super();
        this.state = state;
        this.url = url;
        this.title = title;
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UEditorResponse [original=" + original + ", state=" + state + ", title=" + title
                + ", url=" + url + "]";
    }
}
