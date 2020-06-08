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
 * 服务DTO对象[ParJxkhmbDTO]
 */
@Data
public class ParJxkhmbDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PARJXKHMBNAME]
     *
     */
    @JSONField(name = "parjxkhmbname")
    @JsonProperty("parjxkhmbname")
    private String parjxkhmbname;

    /**
     * 属性 [PARJXKHMBID]
     *
     */
    @JSONField(name = "parjxkhmbid")
    @JsonProperty("parjxkhmbid")
    private String parjxkhmbid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [KHDX]
     *
     */
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KHX]
     *
     */
    @JSONField(name = "khx")
    @JsonProperty("khx")
    private String khx;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

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
     * 设置 [PARJXKHMBNAME]
     */
    public void setParjxkhmbname(String  parjxkhmbname){
        this.parjxkhmbname = parjxkhmbname ;
        this.modify("parjxkhmbname",parjxkhmbname);
    }

    /**
     * 设置 [KHDX]
     */
    public void setKhdx(String  khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [KHX]
     */
    public void setKhx(String  khx){
        this.khx = khx ;
        this.modify("khx",khx);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

