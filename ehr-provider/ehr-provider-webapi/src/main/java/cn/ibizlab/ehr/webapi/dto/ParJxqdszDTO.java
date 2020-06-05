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
 * 服务DTO对象[ParJxqdszDTO]
 */
@Data
public class ParJxqdszDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzsj" , format="yyyy-MM-dd")
    @JsonProperty("jzsj")
    private Timestamp jzsj;

    /**
     * 属性 [QDLX]
     *
     */
    @JSONField(name = "qdlx")
    @JsonProperty("qdlx")
    private String qdlx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [KQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqsj" , format="yyyy-MM-dd")
    @JsonProperty("kqsj")
    private Timestamp kqsj;

    /**
     * 属性 [PARJXQDSZNAME]
     *
     */
    @JSONField(name = "parjxqdszname")
    @JsonProperty("parjxqdszname")
    private String parjxqdszname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 属性 [PARJXQDSZID]
     *
     */
    @JSONField(name = "parjxqdszid")
    @JsonProperty("parjxqdszid")
    private String parjxqdszid;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [JZSJ]
     */
    public void setJzsj(Timestamp  jzsj){
        this.jzsj = jzsj ;
        this.modify("jzsj",jzsj);
    }

    /**
     * 设置 [QDLX]
     */
    public void setQdlx(String  qdlx){
        this.qdlx = qdlx ;
        this.modify("qdlx",qdlx);
    }

    /**
     * 设置 [KQSJ]
     */
    public void setKqsj(Timestamp  kqsj){
        this.kqsj = kqsj ;
        this.modify("kqsj",kqsj);
    }

    /**
     * 设置 [PARJXQDSZNAME]
     */
    public void setParjxqdszname(String  parjxqdszname){
        this.parjxqdszname = parjxqdszname ;
        this.modify("parjxqdszname",parjxqdszname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

