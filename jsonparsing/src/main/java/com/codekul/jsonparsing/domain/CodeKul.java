
package com.codekul.jsonparsing.domain;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CodeKul {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("popularity")
    @Expose
    private Integer popularity;
    @SerializedName("courses")
    @Expose
    private List<String> courses = null;
    @SerializedName("infra")
    @Expose
    private Infra infra;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public Infra getInfra() {
        return infra;
    }

    public void setInfra(Infra infra) {
        this.infra = infra;
    }

}
