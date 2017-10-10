package com.colorfulword.smallbluewhale.domain;

/**
 * Created by jiajun.jiang on 2017/8/8.
 */
public class TruthOrDare {
    private Integer truthOrDareId;
    private String type;
    private String content;

    public Integer getTruthOrDareId() {
        return truthOrDareId;
    }

    public void setTruthOrDareId(Integer truthOrDareId) {
        this.truthOrDareId = truthOrDareId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
