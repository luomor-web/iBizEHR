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
 * 服务DTO对象[VacSynjcxDTO]
 */
@Data
public class VacSynjcxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [VACSYNJCXID]
     *
     */
    @JSONField(name = "vacsynjcxid")
    @JsonProperty("vacsynjcxid")
    private String vacsynjcxid;

    /**
     * 属性 [YYNJ]
     *
     */
    @JSONField(name = "yynj")
    @JsonProperty("yynj")
    private Double yynj;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SYNJTS]
     *
     */
    @JSONField(name = "synjts")
    @JsonProperty("synjts")
    private Double synjts;

    /**
     * 属性 [BNTS]
     *
     */
    @JSONField(name = "bnts")
    @JsonProperty("bnts")
    private Double bnts;

    /**
     * 属性 [KSYXSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksyxsj" , format="yyyy-MM-dd")
    @JsonProperty("ksyxsj")
    private Timestamp ksyxsj;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [VACSYNJCXNAME]
     *
     */
    @JSONField(name = "vacsynjcxname")
    @JsonProperty("vacsynjcxname")
    private String vacsynjcxname;

    /**
     * 属性 [SJBNTS]
     *
     */
    @JSONField(name = "sjbnts")
    @JsonProperty("sjbnts")
    private Double sjbnts;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [JSYXSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsyxsj" , format="yyyy-MM-dd")
    @JsonProperty("jsyxsj")
    private Timestamp jsyxsj;

    /**
     * 属性 [BCTS]
     *
     */
    @JSONField(name = "bcts")
    @JsonProperty("bcts")
    private Double bcts;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [GLY]
     *
     */
    @JSONField(name = "gly")
    @JsonProperty("gly")
    private Integer gly;

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
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [YYNJ]
     */
    public void setYynj(Double  yynj){
        this.yynj = yynj ;
        this.modify("yynj",yynj);
    }

    /**
     * 设置 [SYNJTS]
     */
    public void setSynjts(Double  synjts){
        this.synjts = synjts ;
        this.modify("synjts",synjts);
    }

    /**
     * 设置 [BNTS]
     */
    public void setBnts(Double  bnts){
        this.bnts = bnts ;
        this.modify("bnts",bnts);
    }

    /**
     * 设置 [KSYXSJ]
     */
    public void setKsyxsj(Timestamp  ksyxsj){
        this.ksyxsj = ksyxsj ;
        this.modify("ksyxsj",ksyxsj);
    }

    /**
     * 设置 [VACSYNJCXNAME]
     */
    public void setVacsynjcxname(String  vacsynjcxname){
        this.vacsynjcxname = vacsynjcxname ;
        this.modify("vacsynjcxname",vacsynjcxname);
    }

    /**
     * 设置 [SJBNTS]
     */
    public void setSjbnts(Double  sjbnts){
        this.sjbnts = sjbnts ;
        this.modify("sjbnts",sjbnts);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [JSYXSJ]
     */
    public void setJsyxsj(Timestamp  jsyxsj){
        this.jsyxsj = jsyxsj ;
        this.modify("jsyxsj",jsyxsj);
    }

    /**
     * 设置 [BCTS]
     */
    public void setBcts(Double  bcts){
        this.bcts = bcts ;
        this.modify("bcts",bcts);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

