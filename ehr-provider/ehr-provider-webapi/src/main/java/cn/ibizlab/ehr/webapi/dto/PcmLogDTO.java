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
 * 服务DTO对象[PcmLogDTO]
 */
@Data
public class PcmLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [OPTDEID]
     *
     */
    @JSONField(name = "optdeid")
    @JsonProperty("optdeid")
    private String optdeid;

    /**
     * 属性 [TYPE]
     *
     */
    @JSONField(name = "type")
    @JsonProperty("type")
    private String type;

    /**
     * 属性 [OPTDEACTION]
     *
     */
    @JSONField(name = "optdeaction")
    @JsonProperty("optdeaction")
    private String optdeaction;

    /**
     * 属性 [OPTDENAME]
     *
     */
    @JSONField(name = "optdename")
    @JsonProperty("optdename")
    private String optdename;

    /**
     * 属性 [PCMLOGID]
     *
     */
    @JSONField(name = "pcmlogid")
    @JsonProperty("pcmlogid")
    private String pcmlogid;

    /**
     * 属性 [SFSX]
     *
     */
    @JSONField(name = "sfsx")
    @JsonProperty("sfsx")
    private Integer sfsx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMLOGNAME]
     *
     */
    @JSONField(name = "pcmlogname")
    @JsonProperty("pcmlogname")
    private String pcmlogname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

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
     * 属性 [OPTCONTENT]
     *
     */
    @JSONField(name = "optcontent")
    @JsonProperty("optcontent")
    private String optcontent;

    /**
     * 属性 [NEEDOPT]
     *
     */
    @JSONField(name = "needopt")
    @JsonProperty("needopt")
    private Integer needopt;

    /**
     * 属性 [SXRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [OPTDEID]
     */
    public void setOptdeid(String  optdeid){
        this.optdeid = optdeid ;
        this.modify("optdeid",optdeid);
    }

    /**
     * 设置 [TYPE]
     */
    public void setType(String  type){
        this.type = type ;
        this.modify("type",type);
    }

    /**
     * 设置 [OPTDEACTION]
     */
    public void setOptdeaction(String  optdeaction){
        this.optdeaction = optdeaction ;
        this.modify("optdeaction",optdeaction);
    }

    /**
     * 设置 [OPTDENAME]
     */
    public void setOptdename(String  optdename){
        this.optdename = optdename ;
        this.modify("optdename",optdename);
    }

    /**
     * 设置 [SFSX]
     */
    public void setSfsx(Integer  sfsx){
        this.sfsx = sfsx ;
        this.modify("sfsx",sfsx);
    }

    /**
     * 设置 [PCMLOGNAME]
     */
    public void setPcmlogname(String  pcmlogname){
        this.pcmlogname = pcmlogname ;
        this.modify("pcmlogname",pcmlogname);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [OPTCONTENT]
     */
    public void setOptcontent(String  optcontent){
        this.optcontent = optcontent ;
        this.modify("optcontent",optcontent);
    }

    /**
     * 设置 [NEEDOPT]
     */
    public void setNeedopt(Integer  needopt){
        this.needopt = needopt ;
        this.modify("needopt",needopt);
    }

    /**
     * 设置 [SXRQ]
     */
    public void setSxrq(Timestamp  sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

