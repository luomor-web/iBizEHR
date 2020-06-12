package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[ParExamContentDTO]
 */
@Data
public class ParExamContentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PAREXAMCONTENTID]
     *
     */
    @JSONField(name = "parexamcontentid")
    @JsonProperty("parexamcontentid")
    private String parexamcontentid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PAREXAMCONTENTNAME]
     *
     */
    @JSONField(name = "parexamcontentname")
    @JsonProperty("parexamcontentname")
    private String parexamcontentname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CONTENTCODE]
     *
     */
    @JSONField(name = "contentcode")
    @JsonProperty("contentcode")
    private String contentcode;


    /**
     * 设置 [PAREXAMCONTENTNAME]
     */
    public void setParexamcontentname(String  parexamcontentname){
        this.parexamcontentname = parexamcontentname ;
        this.modify("parexamcontentname",parexamcontentname);
    }

    /**
     * 设置 [CONTENTCODE]
     */
    public void setContentcode(String  contentcode){
        this.contentcode = contentcode ;
        this.modify("contentcode",contentcode);
    }


}

