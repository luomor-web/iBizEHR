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
 * 服务DTO对象[TrmTrainAgencyDTO]
 */
@Data
public class TrmTrainAgencyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [KHHMC]
     *
     */
    @JSONField(name = "khhmc")
    @JsonProperty("khhmc")
    private String khhmc;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [NSRSBH]
     *
     */
    @JSONField(name = "nsrsbh")
    @JsonProperty("nsrsbh")
    private String nsrsbh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXCS]
     *
     */
    @JSONField(name = "pxcs")
    @JsonProperty("pxcs")
    private Integer pxcs;

    /**
     * 属性 [KHH]
     *
     */
    @JSONField(name = "khh")
    @JsonProperty("khh")
    private String khh;

    /**
     * 属性 [JGDJ]
     *
     */
    @JSONField(name = "jgdj")
    @JsonProperty("jgdj")
    private String jgdj;

    /**
     * 属性 [JGLX]
     *
     */
    @JSONField(name = "jglx")
    @JsonProperty("jglx")
    private String jglx;

    /**
     * 属性 [SFFC]
     *
     */
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;

    /**
     * 属性 [SFGX]
     *
     */
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [LXR]
     *
     */
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;

    /**
     * 属性 [JGBM]
     *
     */
    @JSONField(name = "jgbm")
    @JsonProperty("jgbm")
    private String jgbm;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [WZ]
     *
     */
    @JSONField(name = "wz")
    @JsonProperty("wz")
    private String wz;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KPLX]
     *
     */
    @JSONField(name = "kplx")
    @JsonProperty("kplx")
    private String kplx;

    /**
     * 属性 [JGLB]
     *
     */
    @JSONField(name = "jglb")
    @JsonProperty("jglb")
    private String jglb;

    /**
     * 属性 [ZCXX]
     *
     */
    @JSONField(name = "zcxx")
    @JsonProperty("zcxx")
    private String zcxx;

    /**
     * 属性 [KHHZH]
     *
     */
    @JSONField(name = "khhzh")
    @JsonProperty("khhzh")
    private String khhzh;

    /**
     * 属性 [PXZSC]
     *
     */
    @JSONField(name = "pxzsc")
    @JsonProperty("pxzsc")
    private Double pxzsc;

    /**
     * 属性 [KCTXFW]
     *
     */
    @JSONField(name = "kctxfw")
    @JsonProperty("kctxfw")
    private String kctxfw;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [KPRDH]
     *
     */
    @JSONField(name = "kprdh")
    @JsonProperty("kprdh")
    private String kprdh;

    /**
     * 属性 [KPXX]
     *
     */
    @JSONField(name = "kpxx")
    @JsonProperty("kpxx")
    private String kpxx;

    /**
     * 属性 [DZXX]
     *
     */
    @JSONField(name = "dzxx")
    @JsonProperty("dzxx")
    private String dzxx;

    /**
     * 属性 [JJ]
     *
     */
    @JSONField(name = "jj")
    @JsonProperty("jj")
    private String jj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 属性 [KPR]
     *
     */
    @JSONField(name = "kpr")
    @JsonProperty("kpr")
    private String kpr;

    /**
     * 属性 [KPMC]
     *
     */
    @JSONField(name = "kpmc")
    @JsonProperty("kpmc")
    private String kpmc;

    /**
     * 属性 [KPDZ]
     *
     */
    @JSONField(name = "kpdz")
    @JsonProperty("kpdz")
    private String kpdz;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [TRMTRAINAGENCYNAME2]
     *
     */
    @JSONField(name = "trmtrainagencyname2")
    @JsonProperty("trmtrainagencyname2")
    private String trmtrainagencyname2;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMTRAINAGENCYID2]
     *
     */
    @JSONField(name = "trmtrainagencyid2")
    @JsonProperty("trmtrainagencyid2")
    private String trmtrainagencyid2;


    /**
     * 设置 [KHHMC]
     */
    public void setKhhmc(String  khhmc){
        this.khhmc = khhmc ;
        this.modify("khhmc",khhmc);
    }

    /**
     * 设置 [NSRSBH]
     */
    public void setNsrsbh(String  nsrsbh){
        this.nsrsbh = nsrsbh ;
        this.modify("nsrsbh",nsrsbh);
    }

    /**
     * 设置 [PXCS]
     */
    public void setPxcs(Integer  pxcs){
        this.pxcs = pxcs ;
        this.modify("pxcs",pxcs);
    }

    /**
     * 设置 [KHH]
     */
    public void setKhh(String  khh){
        this.khh = khh ;
        this.modify("khh",khh);
    }

    /**
     * 设置 [JGDJ]
     */
    public void setJgdj(String  jgdj){
        this.jgdj = jgdj ;
        this.modify("jgdj",jgdj);
    }

    /**
     * 设置 [JGLX]
     */
    public void setJglx(String  jglx){
        this.jglx = jglx ;
        this.modify("jglx",jglx);
    }

    /**
     * 设置 [SFFC]
     */
    public void setSffc(Integer  sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [SFGX]
     */
    public void setSfgx(Integer  sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [TRMTRAINAGENCYNAME]
     */
    public void setTrmtrainagencyname(String  trmtrainagencyname){
        this.trmtrainagencyname = trmtrainagencyname ;
        this.modify("trmtrainagencyname",trmtrainagencyname);
    }

    /**
     * 设置 [LXR]
     */
    public void setLxr(String  lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [JGBM]
     */
    public void setJgbm(String  jgbm){
        this.jgbm = jgbm ;
        this.modify("jgbm",jgbm);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [WZ]
     */
    public void setWz(String  wz){
        this.wz = wz ;
        this.modify("wz",wz);
    }

    /**
     * 设置 [KPLX]
     */
    public void setKplx(String  kplx){
        this.kplx = kplx ;
        this.modify("kplx",kplx);
    }

    /**
     * 设置 [JGLB]
     */
    public void setJglb(String  jglb){
        this.jglb = jglb ;
        this.modify("jglb",jglb);
    }

    /**
     * 设置 [ZCXX]
     */
    public void setZcxx(String  zcxx){
        this.zcxx = zcxx ;
        this.modify("zcxx",zcxx);
    }

    /**
     * 设置 [KHHZH]
     */
    public void setKhhzh(String  khhzh){
        this.khhzh = khhzh ;
        this.modify("khhzh",khhzh);
    }

    /**
     * 设置 [PXZSC]
     */
    public void setPxzsc(Double  pxzsc){
        this.pxzsc = pxzsc ;
        this.modify("pxzsc",pxzsc);
    }

    /**
     * 设置 [KCTXFW]
     */
    public void setKctxfw(String  kctxfw){
        this.kctxfw = kctxfw ;
        this.modify("kctxfw",kctxfw);
    }

    /**
     * 设置 [KPRDH]
     */
    public void setKprdh(String  kprdh){
        this.kprdh = kprdh ;
        this.modify("kprdh",kprdh);
    }

    /**
     * 设置 [KPXX]
     */
    public void setKpxx(String  kpxx){
        this.kpxx = kpxx ;
        this.modify("kpxx",kpxx);
    }

    /**
     * 设置 [DZXX]
     */
    public void setDzxx(String  dzxx){
        this.dzxx = dzxx ;
        this.modify("dzxx",dzxx);
    }

    /**
     * 设置 [JJ]
     */
    public void setJj(String  jj){
        this.jj = jj ;
        this.modify("jj",jj);
    }

    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [KPR]
     */
    public void setKpr(String  kpr){
        this.kpr = kpr ;
        this.modify("kpr",kpr);
    }

    /**
     * 设置 [KPMC]
     */
    public void setKpmc(String  kpmc){
        this.kpmc = kpmc ;
        this.modify("kpmc",kpmc);
    }

    /**
     * 设置 [KPDZ]
     */
    public void setKpdz(String  kpdz){
        this.kpdz = kpdz ;
        this.modify("kpdz",kpdz);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINAGENCYID2]
     */
    public void setTrmtrainagencyid2(String  trmtrainagencyid2){
        this.trmtrainagencyid2 = trmtrainagencyid2 ;
        this.modify("trmtrainagencyid2",trmtrainagencyid2);
    }


}

