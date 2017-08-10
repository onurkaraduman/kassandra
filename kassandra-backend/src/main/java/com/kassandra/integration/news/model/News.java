package com.kassandra.integration.news.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class News {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("ContentType")
    private String contentType;
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Files")
    private List<Object> files = new ArrayList<Object>();
    @JsonProperty("ModifiedDate")
    private String modifiedDate;
    @JsonProperty("Path")
    private String path;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("Tags")
    private List<String> tags = new ArrayList<String>();
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("ContentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("ContentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Files")
    public List<Object> getFiles() {
        return files;
    }

    @JsonProperty("Files")
    public void setFiles(List<Object> files) {
        this.files = files;
    }

    @JsonProperty("ModifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("ModifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("Path")
    public String getPath() {
        return path;
    }

    @JsonProperty("Path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("StartDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("StartDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("Tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("Tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("Url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}