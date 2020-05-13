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
 * 服务DTO对象[WFUCPolicyDTO]
 */
@Data
public class WFUCPolicyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFUCPOLICYID]
     *
     */
    @JSONField(name = "wfucpolicyid")
    @JsonProperty("wfucpolicyid")
    private String wfucpolicyid;

    /**
     * 属性 [BEGINTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "begintime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("begintime")
    private Timestamp begintime;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [POLICYSTATE]
     *
     */
    @JSONField(name = "policystate")
    @JsonProperty("policystate")
    private Integer policystate;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

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
     * 属性 [WFUCPOLICYNAME]
     *
     */
    @JSONField(name = "wfucpolicyname")
    @JsonProperty("wfucpolicyname")
    private String wfucpolicyname;

    /**
     * 属性 [MINORWFUSERNAME]
     *
     */
    @JSONField(name = "minorwfusername")
    @JsonProperty("minorwfusername")
    private String minorwfusername;

    /**
     * 属性 [MAJORWFUSERNAME]
     *
     */
    @JSONField(name = "majorwfusername")
    @JsonProperty("majorwfusername")
    private String majorwfusername;

    /**
     * 属性 [MINORWFUSERID]
     *
     */
    @JSONField(name = "minorwfuserid")
    @JsonProperty("minorwfuserid")
    private String minorwfuserid;

    /**
     * 属性 [MAJORWFUSERID]
     *
     */
    @JSONField(name = "majorwfuserid")
    @JsonProperty("majorwfuserid")
    private String majorwfuserid;


    /**
     * 设置 [BEGINTIME]
     */
    public void setBegintime(Timestamp  begintime){
        this.begintime = begintime ;
        this.modify("begintime",begintime);
    }

    /**
     * 设置 [POLICYSTATE]
     */
    public void setPolicystate(Integer  policystate){
        this.policystate = policystate ;
        this.modify("policystate",policystate);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [WFUCPOLICYNAME]
     */
    public void setWfucpolicyname(String  wfucpolicyname){
        this.wfucpolicyname = wfucpolicyname ;
        this.modify("wfucpolicyname",wfucpolicyname);
    }

    /**
     * 设置 [MINORWFUSERID]
     */
    public void setMinorwfuserid(String  minorwfuserid){
        this.minorwfuserid = minorwfuserid ;
        this.modify("minorwfuserid",minorwfuserid);
    }

    /**
     * 设置 [MAJORWFUSERID]
     */
    public void setMajorwfuserid(String  majorwfuserid){
        this.majorwfuserid = majorwfuserid ;
        this.modify("majorwfuserid",majorwfuserid);
    }


}

