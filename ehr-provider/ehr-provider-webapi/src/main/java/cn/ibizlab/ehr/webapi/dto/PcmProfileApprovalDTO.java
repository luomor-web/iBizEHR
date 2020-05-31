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
 * 服务DTO对象[PcmProfileApprovalDTO]
 */
@Data
public class PcmProfileApprovalDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMPROFILEAPPROVALID]
     *
     */
    @JSONField(name = "pcmprofileapprovalid")
    @JsonProperty("pcmprofileapprovalid")
    private String pcmprofileapprovalid;

    /**
     * 属性 [FASTATE]
     *
     */
    @JSONField(name = "fastate")
    @JsonProperty("fastate")
    private String fastate;

    /**
     * 属性 [PASSORREJECT]
     *
     */
    @JSONField(name = "passorreject")
    @JsonProperty("passorreject")
    private String passorreject;

    /**
     * 属性 [APPROVER]
     *
     */
    @JSONField(name = "approver")
    @JsonProperty("approver")
    private String approver;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [APPROVALDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "approvaldate" , format="yyyy-MM-dd")
    @JsonProperty("approvaldate")
    private Timestamp approvaldate;

    /**
     * 属性 [APPROVALOPINION]
     *
     */
    @JSONField(name = "approvalopinion")
    @JsonProperty("approvalopinion")
    private String approvalopinion;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [YJYY]
     *
     */
    @JSONField(name = "yjyy")
    @JsonProperty("yjyy")
    private String yjyy;

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
     * 属性 [APPROVALSTAGE]
     *
     */
    @JSONField(name = "approvalstage")
    @JsonProperty("approvalstage")
    private String approvalstage;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMPROFILEAPPROVALNAME]
     *
     */
    @JSONField(name = "pcmprofileapprovalname")
    @JsonProperty("pcmprofileapprovalname")
    private String pcmprofileapprovalname;

    /**
     * 属性 [PIMBYZZJLMXNAME]
     *
     */
    @JSONField(name = "pimbyzzjlmxname")
    @JsonProperty("pimbyzzjlmxname")
    private String pimbyzzjlmxname;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 属性 [PIMBYZZJLMXID]
     *
     */
    @JSONField(name = "pimbyzzjlmxid")
    @JsonProperty("pimbyzzjlmxid")
    private String pimbyzzjlmxid;


    /**
     * 设置 [FASTATE]
     */
    public void setFastate(String  fastate){
        this.fastate = fastate ;
        this.modify("fastate",fastate);
    }

    /**
     * 设置 [PASSORREJECT]
     */
    public void setPassorreject(String  passorreject){
        this.passorreject = passorreject ;
        this.modify("passorreject",passorreject);
    }

    /**
     * 设置 [APPROVER]
     */
    public void setApprover(String  approver){
        this.approver = approver ;
        this.modify("approver",approver);
    }

    /**
     * 设置 [APPROVALDATE]
     */
    public void setApprovaldate(Timestamp  approvaldate){
        this.approvaldate = approvaldate ;
        this.modify("approvaldate",approvaldate);
    }

    /**
     * 设置 [APPROVALOPINION]
     */
    public void setApprovalopinion(String  approvalopinion){
        this.approvalopinion = approvalopinion ;
        this.modify("approvalopinion",approvalopinion);
    }

    /**
     * 设置 [YJYY]
     */
    public void setYjyy(String  yjyy){
        this.yjyy = yjyy ;
        this.modify("yjyy",yjyy);
    }

    /**
     * 设置 [APPROVALSTAGE]
     */
    public void setApprovalstage(String  approvalstage){
        this.approvalstage = approvalstage ;
        this.modify("approvalstage",approvalstage);
    }

    /**
     * 设置 [PCMPROFILEAPPROVALNAME]
     */
    public void setPcmprofileapprovalname(String  pcmprofileapprovalname){
        this.pcmprofileapprovalname = pcmprofileapprovalname ;
        this.modify("pcmprofileapprovalname",pcmprofileapprovalname);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }

    /**
     * 设置 [PIMBYZZJLMXID]
     */
    public void setPimbyzzjlmxid(String  pimbyzzjlmxid){
        this.pimbyzzjlmxid = pimbyzzjlmxid ;
        this.modify("pimbyzzjlmxid",pimbyzzjlmxid);
    }


}

