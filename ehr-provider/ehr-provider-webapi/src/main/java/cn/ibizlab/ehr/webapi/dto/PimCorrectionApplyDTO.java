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
 * 服务DTO对象[PimCorrectionApplyDTO]
 */
@Data
public class PimCorrectionApplyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMCORRECTIONAPPLYID]
     *
     */
    @JSONField(name = "pimcorrectionapplyid")
    @JsonProperty("pimcorrectionapplyid")
    private String pimcorrectionapplyid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [PIMCORRECTIONAPPLYNAME]
     *
     */
    @JSONField(name = "pimcorrectionapplyname")
    @JsonProperty("pimcorrectionapplyname")
    private String pimcorrectionapplyname;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZJ]
     *
     */
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [PIMBYYGZZSQNAME]
     *
     */
    @JSONField(name = "pimbyygzzsqname")
    @JsonProperty("pimbyygzzsqname")
    private String pimbyygzzsqname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMBYYGZZSQID]
     *
     */
    @JSONField(name = "pimbyygzzsqid")
    @JsonProperty("pimbyygzzsqid")
    private String pimbyygzzsqid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PIMCORRECTIONAPPLYNAME]
     */
    public void setPimcorrectionapplyname(String  pimcorrectionapplyname){
        this.pimcorrectionapplyname = pimcorrectionapplyname ;
        this.modify("pimcorrectionapplyname",pimcorrectionapplyname);
    }

    /**
     * 设置 [PIMBYYGZZSQID]
     */
    public void setPimbyygzzsqid(String  pimbyygzzsqid){
        this.pimbyygzzsqid = pimbyygzzsqid ;
        this.modify("pimbyygzzsqid",pimbyygzzsqid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

