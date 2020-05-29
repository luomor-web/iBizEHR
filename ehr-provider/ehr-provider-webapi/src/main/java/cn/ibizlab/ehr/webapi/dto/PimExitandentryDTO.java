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
 * 服务DTO对象[PimExitandentryDTO]
 */
@Data
public class PimExitandentryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "cjsj" , format="yyyy-MM-dd")
    @JsonProperty("cjsj")
    private Timestamp cjsj;

    /**
     * 属性 [JLSS]
     *
     */
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [WORKFLOWSTATE]
     *
     */
    @JSONField(name = "workflowstate")
    @JsonProperty("workflowstate")
    private String workflowstate;

    /**
     * 属性 [PIMEXITANDENTRYID]
     *
     */
    @JSONField(name = "pimexitandentryid")
    @JsonProperty("pimexitandentryid")
    private String pimexitandentryid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PIMEXITANDENTRYNAME]
     *
     */
    @JSONField(name = "pimexitandentryname")
    @JsonProperty("pimexitandentryname")
    private String pimexitandentryname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SY]
     *
     */
    @JSONField(name = "sy")
    @JsonProperty("sy")
    private String sy;

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
     * 属性 [RJSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rjsj" , format="yyyy-MM-dd")
    @JsonProperty("rjsj")
    private Timestamp rjsj;

    /**
     * 属性 [QWFHGJ]
     *
     */
    @JSONField(name = "qwfhgj")
    @JsonProperty("qwfhgj")
    private String qwfhgj;

    /**
     * 属性 [WFRESULT]
     *
     */
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [RANK]
     *
     */
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [CJSJ]
     */
    public void setCjsj(Timestamp  cjsj){
        this.cjsj = cjsj ;
        this.modify("cjsj",cjsj);
    }

    /**
     * 设置 [JLSS]
     */
    public void setJlss(String  jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [WORKFLOWSTATE]
     */
    public void setWorkflowstate(String  workflowstate){
        this.workflowstate = workflowstate ;
        this.modify("workflowstate",workflowstate);
    }

    /**
     * 设置 [PIMEXITANDENTRYNAME]
     */
    public void setPimexitandentryname(String  pimexitandentryname){
        this.pimexitandentryname = pimexitandentryname ;
        this.modify("pimexitandentryname",pimexitandentryname);
    }

    /**
     * 设置 [SY]
     */
    public void setSy(String  sy){
        this.sy = sy ;
        this.modify("sy",sy);
    }

    /**
     * 设置 [RJSJ]
     */
    public void setRjsj(Timestamp  rjsj){
        this.rjsj = rjsj ;
        this.modify("rjsj",rjsj);
    }

    /**
     * 设置 [QWFHGJ]
     */
    public void setQwfhgj(String  qwfhgj){
        this.qwfhgj = qwfhgj ;
        this.modify("qwfhgj",qwfhgj);
    }

    /**
     * 设置 [WFRESULT]
     */
    public void setWfresult(String  wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

