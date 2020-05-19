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
 * 服务DTO对象[WFTmpStepActorDTO]
 */
@Data
public class WFTmpStepActorDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFTMPSTEPACTORID]
     *
     */
    @JSONField(name = "wftmpstepactorid")
    @JsonProperty("wftmpstepactorid")
    private String wftmpstepactorid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CONNECTION]
     *
     */
    @JSONField(name = "connection")
    @JsonProperty("connection")
    private String connection;

    /**
     * 属性 [PREVPROCESS]
     *
     */
    @JSONField(name = "prevprocess")
    @JsonProperty("prevprocess")
    private String prevprocess;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFTMPSTEPACTORNAME]
     *
     */
    @JSONField(name = "wftmpstepactorname")
    @JsonProperty("wftmpstepactorname")
    private String wftmpstepactorname;

    /**
     * 属性 [WFACTORNAME]
     *
     */
    @JSONField(name = "wfactorname")
    @JsonProperty("wfactorname")
    private String wfactorname;

    /**
     * 属性 [PREVWFSTEPNAME]
     *
     */
    @JSONField(name = "prevwfstepname")
    @JsonProperty("prevwfstepname")
    private String prevwfstepname;

    /**
     * 属性 [PREVWFSTEPID]
     *
     */
    @JSONField(name = "prevwfstepid")
    @JsonProperty("prevwfstepid")
    private String prevwfstepid;

    /**
     * 属性 [WFACTORID]
     *
     */
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [CONNECTION]
     */
    public void setConnection(String  connection){
        this.connection = connection ;
        this.modify("connection",connection);
    }

    /**
     * 设置 [PREVPROCESS]
     */
    public void setPrevprocess(String  prevprocess){
        this.prevprocess = prevprocess ;
        this.modify("prevprocess",prevprocess);
    }

    /**
     * 设置 [WFTMPSTEPACTORNAME]
     */
    public void setWftmpstepactorname(String  wftmpstepactorname){
        this.wftmpstepactorname = wftmpstepactorname ;
        this.modify("wftmpstepactorname",wftmpstepactorname);
    }

    /**
     * 设置 [WFACTORNAME]
     */
    public void setWfactorname(String  wfactorname){
        this.wfactorname = wfactorname ;
        this.modify("wfactorname",wfactorname);
    }

    /**
     * 设置 [PREVWFSTEPNAME]
     */
    public void setPrevwfstepname(String  prevwfstepname){
        this.prevwfstepname = prevwfstepname ;
        this.modify("prevwfstepname",prevwfstepname);
    }

    /**
     * 设置 [PREVWFSTEPID]
     */
    public void setPrevwfstepid(String  prevwfstepid){
        this.prevwfstepid = prevwfstepid ;
        this.modify("prevwfstepid",prevwfstepid);
    }

    /**
     * 设置 [WFACTORID]
     */
    public void setWfactorid(String  wfactorid){
        this.wfactorid = wfactorid ;
        this.modify("wfactorid",wfactorid);
    }


}

