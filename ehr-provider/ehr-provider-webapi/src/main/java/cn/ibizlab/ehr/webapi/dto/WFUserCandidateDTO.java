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
 * 服务DTO对象[WFUserCandidateDTO]
 */
@Data
public class WFUserCandidateDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WFUSERCANDIDATENAME]
     *
     */
    @JSONField(name = "wfusercandidatename")
    @JsonProperty("wfusercandidatename")
    private String wfusercandidatename;

    /**
     * 属性 [CANDIDATEORDER]
     *
     */
    @JSONField(name = "candidateorder")
    @JsonProperty("candidateorder")
    private Integer candidateorder;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [WFUSERCANDIDATEID]
     *
     */
    @JSONField(name = "wfusercandidateid")
    @JsonProperty("wfusercandidateid")
    private String wfusercandidateid;

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
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFMAJORUSERNAME]
     *
     */
    @JSONField(name = "wfmajorusername")
    @JsonProperty("wfmajorusername")
    private String wfmajorusername;

    /**
     * 属性 [WFMINORUSERNAME]
     *
     */
    @JSONField(name = "wfminorusername")
    @JsonProperty("wfminorusername")
    private String wfminorusername;

    /**
     * 属性 [WFMINORUSERID]
     *
     */
    @JSONField(name = "wfminoruserid")
    @JsonProperty("wfminoruserid")
    private String wfminoruserid;

    /**
     * 属性 [WFMAJORUSERID]
     *
     */
    @JSONField(name = "wfmajoruserid")
    @JsonProperty("wfmajoruserid")
    private String wfmajoruserid;


    /**
     * 设置 [WFUSERCANDIDATENAME]
     */
    public void setWfusercandidatename(String  wfusercandidatename){
        this.wfusercandidatename = wfusercandidatename ;
        this.modify("wfusercandidatename",wfusercandidatename);
    }

    /**
     * 设置 [CANDIDATEORDER]
     */
    public void setCandidateorder(Integer  candidateorder){
        this.candidateorder = candidateorder ;
        this.modify("candidateorder",candidateorder);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [WFMINORUSERID]
     */
    public void setWfminoruserid(String  wfminoruserid){
        this.wfminoruserid = wfminoruserid ;
        this.modify("wfminoruserid",wfminoruserid);
    }

    /**
     * 设置 [WFMAJORUSERID]
     */
    public void setWfmajoruserid(String  wfmajoruserid){
        this.wfmajoruserid = wfmajoruserid ;
        this.modify("wfmajoruserid",wfmajoruserid);
    }


}

