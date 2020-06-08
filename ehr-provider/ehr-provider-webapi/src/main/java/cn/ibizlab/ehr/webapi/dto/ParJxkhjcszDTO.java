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
 * 服务DTO对象[ParJxkhjcszDTO]
 */
@Data
public class ParJxkhjcszDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;

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
     * 属性 [SZSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "szsj" , format="yyyy-MM-dd")
    @JsonProperty("szsj")
    private Timestamp szsj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PARJXKHJCSZID]
     *
     */
    @JSONField(name = "parjxkhjcszid")
    @JsonProperty("parjxkhjcszid")
    private String parjxkhjcszid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SFQY]
     *
     */
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARJXKHJCSZNAME]
     *
     */
    @JSONField(name = "parjxkhjcszname")
    @JsonProperty("parjxkhjcszname")
    private String parjxkhjcszname;

    /**
     * 属性 [KHND]
     *
     */
    @JSONField(name = "khnd")
    @JsonProperty("khnd")
    private String khnd;

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
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [SZSJ]
     */
    public void setSzsj(Timestamp  szsj){
        this.szsj = szsj ;
        this.modify("szsj",szsj);
    }

    /**
     * 设置 [SFQY]
     */
    public void setSfqy(Integer  sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [PARJXKHJCSZNAME]
     */
    public void setParjxkhjcszname(String  parjxkhjcszname){
        this.parjxkhjcszname = parjxkhjcszname ;
        this.modify("parjxkhjcszname",parjxkhjcszname);
    }

    /**
     * 设置 [KHND]
     */
    public void setKhnd(String  khnd){
        this.khnd = khnd ;
        this.modify("khnd",khnd);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

