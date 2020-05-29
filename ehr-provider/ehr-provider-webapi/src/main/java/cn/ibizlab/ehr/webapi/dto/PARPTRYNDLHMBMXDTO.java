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
 * 服务DTO对象[PARPTRYNDLHMBMXDTO]
 */
@Data
public class PARPTRYNDLHMBMXDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FZQZ]
     *
     */
    @JSONField(name = "fzqz")
    @JsonProperty("fzqz")
    private Double fzqz;

    /**
     * 属性 [SPZT]
     *
     */
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [KHZQ]
     *
     */
    @JSONField(name = "khzq")
    @JsonProperty("khzq")
    private String khzq;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WCQK]
     *
     */
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;

    /**
     * 属性 [ZPFS]
     *
     */
    @JSONField(name = "zpfs")
    @JsonProperty("zpfs")
    private Double zpfs;

    /**
     * 属性 [PARPTRYNDLHMBMXNAME]
     *
     */
    @JSONField(name = "parptryndlhmbmxname")
    @JsonProperty("parptryndlhmbmxname")
    private String parptryndlhmbmxname;

    /**
     * 属性 [ZZYDMS]
     *
     */
    @JSONField(name = "zzydms")
    @JsonProperty("zzydms")
    private String zzydms;

    /**
     * 属性 [PARPTRYNDLHMBMXID]
     *
     */
    @JSONField(name = "parptryndlhmbmxid")
    @JsonProperty("parptryndlhmbmxid")
    private String parptryndlhmbmxid;

    /**
     * 属性 [XGRZ]
     *
     */
    @JSONField(name = "xgrz")
    @JsonProperty("xgrz")
    private String xgrz;

    /**
     * 属性 [ZMCL]
     *
     */
    @JSONField(name = "zmcl")
    @JsonProperty("zmcl")
    private String zmcl;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [KHBZ]
     *
     */
    @JSONField(name = "khbz")
    @JsonProperty("khbz")
    private String khbz;

    /**
     * 属性 [PARPTRYNDLHMBNAME]
     *
     */
    @JSONField(name = "parptryndlhmbname")
    @JsonProperty("parptryndlhmbname")
    private String parptryndlhmbname;

    /**
     * 属性 [PARPTRYNDLHMBID]
     *
     */
    @JSONField(name = "parptryndlhmbid")
    @JsonProperty("parptryndlhmbid")
    private String parptryndlhmbid;


    /**
     * 设置 [FZQZ]
     */
    public void setFzqz(Double  fzqz){
        this.fzqz = fzqz ;
        this.modify("fzqz",fzqz);
    }

    /**
     * 设置 [SPZT]
     */
    public void setSpzt(String  spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [KHZQ]
     */
    public void setKhzq(String  khzq){
        this.khzq = khzq ;
        this.modify("khzq",khzq);
    }

    /**
     * 设置 [WCQK]
     */
    public void setWcqk(String  wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [ZPFS]
     */
    public void setZpfs(Double  zpfs){
        this.zpfs = zpfs ;
        this.modify("zpfs",zpfs);
    }

    /**
     * 设置 [PARPTRYNDLHMBMXNAME]
     */
    public void setParptryndlhmbmxname(String  parptryndlhmbmxname){
        this.parptryndlhmbmxname = parptryndlhmbmxname ;
        this.modify("parptryndlhmbmxname",parptryndlhmbmxname);
    }

    /**
     * 设置 [ZZYDMS]
     */
    public void setZzydms(String  zzydms){
        this.zzydms = zzydms ;
        this.modify("zzydms",zzydms);
    }

    /**
     * 设置 [XGRZ]
     */
    public void setXgrz(String  xgrz){
        this.xgrz = xgrz ;
        this.modify("xgrz",xgrz);
    }

    /**
     * 设置 [ZMCL]
     */
    public void setZmcl(String  zmcl){
        this.zmcl = zmcl ;
        this.modify("zmcl",zmcl);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [KHBZ]
     */
    public void setKhbz(String  khbz){
        this.khbz = khbz ;
        this.modify("khbz",khbz);
    }

    /**
     * 设置 [PARPTRYNDLHMBID]
     */
    public void setParptryndlhmbid(String  parptryndlhmbid){
        this.parptryndlhmbid = parptryndlhmbid ;
        this.modify("parptryndlhmbid",parptryndlhmbid);
    }


}

