
package com.codekul.jsonparsing.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Infra {

    @SerializedName("tables")
    @Expose
    private Boolean tables;
    @SerializedName("chair")
    @Expose
    private Integer chair;

    public Boolean getTables() {
        return tables;
    }

    public void setTables(Boolean tables) {
        this.tables = tables;
    }

    public Integer getChair() {
        return chair;
    }

    public void setChair(Integer chair) {
        this.chair = chair;
    }

}
