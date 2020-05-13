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
 * 服务DTO对象[UserRoleDataDTO]
 */
@Data
public class UserRoleDataDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [USERROLEDATAID]
     *
     */
    @JSONField(name = "userroledataid")
    @JsonProperty("userroledataid")
    private String userroledataid;

    /**
     * 属性 [UDVERSION]
     *
     */
    @JSONField(name = "udversion")
    @JsonProperty("udversion")
    private Integer udversion;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [SECDR]
     *
     */
    @JSONField(name = "secdr")
    @JsonProperty("secdr")
    private Integer secdr;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USERROLEDATANAME]
     *
     */
    @JSONField(name = "userroledataname")
    @JsonProperty("userroledataname")
    private String userroledataname;

    /**
     * 属性 [BCDR]
     *
     */
    @JSONField(name = "bcdr")
    @JsonProperty("bcdr")
    private Integer bcdr;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [ORGDR]
     *
     */
    @JSONField(name = "orgdr")
    @JsonProperty("orgdr")
    private Integer orgdr;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERDR]
     *
     */
    @JSONField(name = "userdr")
    @JsonProperty("userdr")
    private Integer userdr;

    /**
     * 属性 [ISALLDATA]
     *
     */
    @JSONField(name = "isalldata")
    @JsonProperty("isalldata")
    private Integer isalldata;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DSTSECBC]
     *
     */
    @JSONField(name = "dstsecbc")
    @JsonProperty("dstsecbc")
    private String dstsecbc;

    /**
     * 属性 [SRFSYSPUB]
     *
     */
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;

    /**
     * 属性 [SRFUSERPUB]
     *
     */
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [DENAME]
     *
     */
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;

    /**
     * 属性 [DSTORGSECTORNAME]
     *
     */
    @JSONField(name = "dstorgsectorname")
    @JsonProperty("dstorgsectorname")
    private String dstorgsectorname;

    /**
     * 属性 [DSTORGNAME]
     *
     */
    @JSONField(name = "dstorgname")
    @JsonProperty("dstorgname")
    private String dstorgname;

    /**
     * 属性 [DSTORGSECTORID]
     *
     */
    @JSONField(name = "dstorgsectorid")
    @JsonProperty("dstorgsectorid")
    private String dstorgsectorid;

    /**
     * 属性 [DSTORGID]
     *
     */
    @JSONField(name = "dstorgid")
    @JsonProperty("dstorgid")
    private String dstorgid;

    /**
     * 属性 [DEID]
     *
     */
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [UDVERSION]
     */
    public void setUdversion(Integer  udversion){
        this.udversion = udversion ;
        this.modify("udversion",udversion);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [SECDR]
     */
    public void setSecdr(Integer  secdr){
        this.secdr = secdr ;
        this.modify("secdr",secdr);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [USERROLEDATANAME]
     */
    public void setUserroledataname(String  userroledataname){
        this.userroledataname = userroledataname ;
        this.modify("userroledataname",userroledataname);
    }

    /**
     * 设置 [BCDR]
     */
    public void setBcdr(Integer  bcdr){
        this.bcdr = bcdr ;
        this.modify("bcdr",bcdr);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [ORGDR]
     */
    public void setOrgdr(Integer  orgdr){
        this.orgdr = orgdr ;
        this.modify("orgdr",orgdr);
    }

    /**
     * 设置 [USERDR]
     */
    public void setUserdr(Integer  userdr){
        this.userdr = userdr ;
        this.modify("userdr",userdr);
    }

    /**
     * 设置 [ISALLDATA]
     */
    public void setIsalldata(Integer  isalldata){
        this.isalldata = isalldata ;
        this.modify("isalldata",isalldata);
    }

    /**
     * 设置 [DSTSECBC]
     */
    public void setDstsecbc(String  dstsecbc){
        this.dstsecbc = dstsecbc ;
        this.modify("dstsecbc",dstsecbc);
    }

    /**
     * 设置 [SRFSYSPUB]
     */
    public void setSrfsyspub(Integer  srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [SRFUSERPUB]
     */
    public void setSrfuserpub(Integer  srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [DSTORGSECTORID]
     */
    public void setDstorgsectorid(String  dstorgsectorid){
        this.dstorgsectorid = dstorgsectorid ;
        this.modify("dstorgsectorid",dstorgsectorid);
    }

    /**
     * 设置 [DSTORGID]
     */
    public void setDstorgid(String  dstorgid){
        this.dstorgid = dstorgid ;
        this.modify("dstorgid",dstorgid);
    }

    /**
     * 设置 [DEID]
     */
    public void setDeid(String  deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }


}

