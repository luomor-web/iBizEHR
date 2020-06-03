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
 * 服务DTO对象[ParJgbmpjbzDTO]
 */
@Data
public class ParJgbmpjbzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [BMPJ]
     *
     */
    @JSONField(name = "bmpj")
    @JsonProperty("bmpj")
    private String bmpj;

    /**
     * 属性 [PJBL]
     *
     */
    @JSONField(name = "pjbl")
    @JsonProperty("pjbl")
    private Integer pjbl;

    /**
     * 属性 [PARJGBMPJBZID]
     *
     */
    @JSONField(name = "parjgbmpjbzid")
    @JsonProperty("parjgbmpjbzid")
    private String parjgbmpjbzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [PARJGBMPJBZNAME]
     *
     */
    @JSONField(name = "parjgbmpjbzname")
    @JsonProperty("parjgbmpjbzname")
    private String parjgbmpjbzname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PJBZMC]
     *
     */
    @JSONField(name = "pjbzmc")
    @JsonProperty("pjbzmc")
    private String pjbzmc;

    /**
     * 属性 [PJBZID]
     *
     */
    @JSONField(name = "pjbzid")
    @JsonProperty("pjbzid")
    private String pjbzid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [BMPJ]
     */
    public void setBmpj(String  bmpj){
        this.bmpj = bmpj ;
        this.modify("bmpj",bmpj);
    }

    /**
     * 设置 [PJBL]
     */
    public void setPjbl(Integer  pjbl){
        this.pjbl = pjbl ;
        this.modify("pjbl",pjbl);
    }

    /**
     * 设置 [PARJGBMPJBZNAME]
     */
    public void setParjgbmpjbzname(String  parjgbmpjbzname){
        this.parjgbmpjbzname = parjgbmpjbzname ;
        this.modify("parjgbmpjbzname",parjgbmpjbzname);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [PJBZID]
     */
    public void setPjbzid(String  pjbzid){
        this.pjbzid = pjbzid ;
        this.modify("pjbzid",pjbzid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

