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
 * 服务DTO对象[OrmZwdqgzDTO]
 */
@Data
public class OrmZwdqgzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORMZWDQGZID]
     *
     */
    @JSONField(name = "ormzwdqgzid")
    @JsonProperty("ormzwdqgzid")
    private String ormzwdqgzid;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ZWLX]
     *
     */
    @JSONField(name = "zwlx")
    @JsonProperty("zwlx")
    private String zwlx;

    /**
     * 属性 [ORMZWDQGZNAME]
     *
     */
    @JSONField(name = "ormzwdqgzname")
    @JsonProperty("ormzwdqgzname")
    private String ormzwdqgzname;

    /**
     * 属性 [SFMRDQNL]
     *
     */
    @JSONField(name = "sfmrdqnl")
    @JsonProperty("sfmrdqnl")
    private Integer sfmrdqnl;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [NL]
     *
     */
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;

    /**
     * 属性 [ORMRANKNAME]
     *
     */
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ZWBM]
     *
     */
    @JSONField(name = "zwbm")
    @JsonProperty("zwbm")
    private String zwbm;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMRANKID]
     *
     */
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;


    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [ZWLX]
     */
    public void setZwlx(String  zwlx){
        this.zwlx = zwlx ;
        this.modify("zwlx",zwlx);
    }

    /**
     * 设置 [ORMZWDQGZNAME]
     */
    public void setOrmzwdqgzname(String  ormzwdqgzname){
        this.ormzwdqgzname = ormzwdqgzname ;
        this.modify("ormzwdqgzname",ormzwdqgzname);
    }

    /**
     * 设置 [SFMRDQNL]
     */
    public void setSfmrdqnl(Integer  sfmrdqnl){
        this.sfmrdqnl = sfmrdqnl ;
        this.modify("sfmrdqnl",sfmrdqnl);
    }

    /**
     * 设置 [NL]
     */
    public void setNl(Integer  nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [ZWBM]
     */
    public void setZwbm(String  zwbm){
        this.zwbm = zwbm ;
        this.modify("zwbm",zwbm);
    }

    /**
     * 设置 [ORMRANKID]
     */
    public void setOrmrankid(String  ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}

