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
 * 服务DTO对象[ParExamCycleDTO]
 */
@Data
public class ParExamCycleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PAREXAMCYCLEID]
     *
     */
    @JSONField(name = "parexamcycleid")
    @JsonProperty("parexamcycleid")
    private String parexamcycleid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PAREXAMCYCLENAME]
     *
     */
    @JSONField(name = "parexamcyclename")
    @JsonProperty("parexamcyclename")
    private String parexamcyclename;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CYCLEID]
     *
     */
    @JSONField(name = "cycleid")
    @JsonProperty("cycleid")
    private String cycleid;


    /**
     * 设置 [PAREXAMCYCLENAME]
     */
    public void setParexamcyclename(String  parexamcyclename){
        this.parexamcyclename = parexamcyclename ;
        this.modify("parexamcyclename",parexamcyclename);
    }

    /**
     * 设置 [CYCLEID]
     */
    public void setCycleid(String  cycleid){
        this.cycleid = cycleid ;
        this.modify("cycleid",cycleid);
    }


}

