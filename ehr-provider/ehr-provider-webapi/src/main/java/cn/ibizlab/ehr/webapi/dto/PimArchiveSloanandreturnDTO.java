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
 * 服务DTO对象[PimArchiveSloanandreturnDTO]
 */
@Data
public class PimArchiveSloanandreturnDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JYR]
     *
     */
    @JSONField(name = "jyr")
    @JsonProperty("jyr")
    private String jyr;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SPDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "spdate" , format="yyyy-MM-dd")
    @JsonProperty("spdate")
    private Timestamp spdate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PIMARCHIVESLOANANDRETURNID]
     *
     */
    @JSONField(name = "pimarchivesloanandreturnid")
    @JsonProperty("pimarchivesloanandreturnid")
    private String pimarchivesloanandreturnid;

    /**
     * 属性 [JYYY]
     *
     */
    @JSONField(name = "jyyy")
    @JsonProperty("jyyy")
    private String jyyy;

    /**
     * 属性 [GHRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ghrq" , format="yyyy-MM-dd")
    @JsonProperty("ghrq")
    private Timestamp ghrq;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [JYQSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jyqssj" , format="yyyy-MM-dd")
    @JsonProperty("jyqssj")
    private Timestamp jyqssj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMARCHIVESLOANANDRETURNNAME]
     *
     */
    @JSONField(name = "pimarchivesloanandreturnname")
    @JsonProperty("pimarchivesloanandreturnname")
    private String pimarchivesloanandreturnname;

    /**
     * 属性 [SPPERSON]
     *
     */
    @JSONField(name = "spperson")
    @JsonProperty("spperson")
    private String spperson;

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
     * 属性 [PIMARCHIVESNAME]
     *
     */
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;

    /**
     * 属性 [PIMPERSONNAME2]
     *
     */
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;

    /**
     * 属性 [PIMPERSONNAME3]
     *
     */
    @JSONField(name = "pimpersonname3")
    @JsonProperty("pimpersonname3")
    private String pimpersonname3;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID3]
     *
     */
    @JSONField(name = "pimpersonid3")
    @JsonProperty("pimpersonid3")
    private String pimpersonid3;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PIMARCHIVESID]
     *
     */
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;

    /**
     * 属性 [PIMPERSONID2]
     *
     */
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;


    /**
     * 设置 [JYR]
     */
    public void setJyr(String  jyr){
        this.jyr = jyr ;
        this.modify("jyr",jyr);
    }

    /**
     * 设置 [SPDATE]
     */
    public void setSpdate(Timestamp  spdate){
        this.spdate = spdate ;
        this.modify("spdate",spdate);
    }

    /**
     * 设置 [JYYY]
     */
    public void setJyyy(String  jyyy){
        this.jyyy = jyyy ;
        this.modify("jyyy",jyyy);
    }

    /**
     * 设置 [GHRQ]
     */
    public void setGhrq(Timestamp  ghrq){
        this.ghrq = ghrq ;
        this.modify("ghrq",ghrq);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [JYQSSJ]
     */
    public void setJyqssj(Timestamp  jyqssj){
        this.jyqssj = jyqssj ;
        this.modify("jyqssj",jyqssj);
    }

    /**
     * 设置 [PIMARCHIVESLOANANDRETURNNAME]
     */
    public void setPimarchivesloanandreturnname(String  pimarchivesloanandreturnname){
        this.pimarchivesloanandreturnname = pimarchivesloanandreturnname ;
        this.modify("pimarchivesloanandreturnname",pimarchivesloanandreturnname);
    }

    /**
     * 设置 [SPPERSON]
     */
    public void setSpperson(String  spperson){
        this.spperson = spperson ;
        this.modify("spperson",spperson);
    }

    /**
     * 设置 [PIMPERSONNAME3]
     */
    public void setPimpersonname3(String  pimpersonname3){
        this.pimpersonname3 = pimpersonname3 ;
        this.modify("pimpersonname3",pimpersonname3);
    }

    /**
     * 设置 [PIMPERSONID3]
     */
    public void setPimpersonid3(String  pimpersonid3){
        this.pimpersonid3 = pimpersonid3 ;
        this.modify("pimpersonid3",pimpersonid3);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PIMARCHIVESID]
     */
    public void setPimarchivesid(String  pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }

    /**
     * 设置 [PIMPERSONID2]
     */
    public void setPimpersonid2(String  pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }


}

