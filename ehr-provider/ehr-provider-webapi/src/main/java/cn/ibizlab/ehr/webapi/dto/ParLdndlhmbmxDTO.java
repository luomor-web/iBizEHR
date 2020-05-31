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
 * 服务DTO对象[ParLdndlhmbmxDTO]
 */
@Data
public class ParLdndlhmbmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MBLX]
     *
     */
    @JSONField(name = "mblx")
    @JsonProperty("mblx")
    private String mblx;

    /**
     * 属性 [WCQK]
     *
     */
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;

    /**
     * 属性 [PARLDNDLHMBMXNAME]
     *
     */
    @JSONField(name = "parldndlhmbmxname")
    @JsonProperty("parldndlhmbmxname")
    private String parldndlhmbmxname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [XGRZ]
     *
     */
    @JSONField(name = "xgrz")
    @JsonProperty("xgrz")
    private String xgrz;

    /**
     * 属性 [ZPFS]
     *
     */
    @JSONField(name = "zpfs")
    @JsonProperty("zpfs")
    private Double zpfs;

    /**
     * 属性 [KHBF]
     *
     */
    @JSONField(name = "khbf")
    @JsonProperty("khbf")
    private String khbf;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [JZSZPSFS]
     *
     */
    @JSONField(name = "jzszpsfs")
    @JsonProperty("jzszpsfs")
    private Double jzszpsfs;

    /**
     * 属性 [FGLDPF]
     *
     */
    @JSONField(name = "fgldpf")
    @JsonProperty("fgldpf")
    private Double fgldpf;

    /**
     * 属性 [PARLDNDLHMBMXID]
     *
     */
    @JSONField(name = "parldndlhmbmxid")
    @JsonProperty("parldndlhmbmxid")
    private String parldndlhmbmxid;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [SPZT]
     *
     */
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [FZ]
     *
     */
    @JSONField(name = "fz")
    @JsonProperty("fz")
    private Double fz;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZMCL]
     *
     */
    @JSONField(name = "zmcl")
    @JsonProperty("zmcl")
    private String zmcl;

    /**
     * 属性 [MBLHYQ]
     *
     */
    @JSONField(name = "mblhyq")
    @JsonProperty("mblhyq")
    private String mblhyq;

    /**
     * 属性 [PARLDNDLHMBNAME]
     *
     */
    @JSONField(name = "parldndlhmbname")
    @JsonProperty("parldndlhmbname")
    private String parldndlhmbname;

    /**
     * 属性 [PARLDNDLHMBID]
     *
     */
    @JSONField(name = "parldndlhmbid")
    @JsonProperty("parldndlhmbid")
    private String parldndlhmbid;


    /**
     * 设置 [MBLX]
     */
    public void setMblx(String  mblx){
        this.mblx = mblx ;
        this.modify("mblx",mblx);
    }

    /**
     * 设置 [WCQK]
     */
    public void setWcqk(String  wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [PARLDNDLHMBMXNAME]
     */
    public void setParldndlhmbmxname(String  parldndlhmbmxname){
        this.parldndlhmbmxname = parldndlhmbmxname ;
        this.modify("parldndlhmbmxname",parldndlhmbmxname);
    }

    /**
     * 设置 [XGRZ]
     */
    public void setXgrz(String  xgrz){
        this.xgrz = xgrz ;
        this.modify("xgrz",xgrz);
    }

    /**
     * 设置 [ZPFS]
     */
    public void setZpfs(Double  zpfs){
        this.zpfs = zpfs ;
        this.modify("zpfs",zpfs);
    }

    /**
     * 设置 [KHBF]
     */
    public void setKhbf(String  khbf){
        this.khbf = khbf ;
        this.modify("khbf",khbf);
    }

    /**
     * 设置 [JZSZPSFS]
     */
    public void setJzszpsfs(Double  jzszpsfs){
        this.jzszpsfs = jzszpsfs ;
        this.modify("jzszpsfs",jzszpsfs);
    }

    /**
     * 设置 [FGLDPF]
     */
    public void setFgldpf(Double  fgldpf){
        this.fgldpf = fgldpf ;
        this.modify("fgldpf",fgldpf);
    }

    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [SPZT]
     */
    public void setSpzt(String  spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [FZ]
     */
    public void setFz(Double  fz){
        this.fz = fz ;
        this.modify("fz",fz);
    }

    /**
     * 设置 [ZMCL]
     */
    public void setZmcl(String  zmcl){
        this.zmcl = zmcl ;
        this.modify("zmcl",zmcl);
    }

    /**
     * 设置 [MBLHYQ]
     */
    public void setMblhyq(String  mblhyq){
        this.mblhyq = mblhyq ;
        this.modify("mblhyq",mblhyq);
    }

    /**
     * 设置 [PARLDNDLHMBID]
     */
    public void setParldndlhmbid(String  parldndlhmbid){
        this.parldndlhmbid = parldndlhmbid ;
        this.modify("parldndlhmbid",parldndlhmbid);
    }


}

