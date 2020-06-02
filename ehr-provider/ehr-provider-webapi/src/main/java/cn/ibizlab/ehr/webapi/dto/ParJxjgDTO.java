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
 * 服务DTO对象[ParJxjgDTO]
 */
@Data
public class ParJxjgDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PM]
     *
     */
    @JSONField(name = "pm")
    @JsonProperty("pm")
    private Integer pm;

    /**
     * 属性 [PARJXJGID]
     *
     */
    @JSONField(name = "parjxjgid")
    @JsonProperty("parjxjgid")
    private String parjxjgid;

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
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [KHPGDJ]
     *
     */
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;

    /**
     * 属性 [PARJXJGNAME]
     *
     */
    @JSONField(name = "parjxjgname")
    @JsonProperty("parjxjgname")
    private String parjxjgname;

    /**
     * 属性 [YG]
     *
     */
    @JSONField(name = "yg")
    @JsonProperty("yg")
    private String yg;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [KHLX]
     *
     */
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;

    /**
     * 属性 [YGID]
     *
     */
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;

    /**
     * 属性 [ZF]
     *
     */
    @JSONField(name = "zf")
    @JsonProperty("zf")
    private Double zf;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;


    /**
     * 设置 [PM]
     */
    public void setPm(Integer  pm){
        this.pm = pm ;
        this.modify("pm",pm);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [KHPGDJ]
     */
    public void setKhpgdj(String  khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [PARJXJGNAME]
     */
    public void setParjxjgname(String  parjxjgname){
        this.parjxjgname = parjxjgname ;
        this.modify("parjxjgname",parjxjgname);
    }

    /**
     * 设置 [YG]
     */
    public void setYg(String  yg){
        this.yg = yg ;
        this.modify("yg",yg);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [KHLX]
     */
    public void setKhlx(String  khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [YGID]
     */
    public void setYgid(String  ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [ZF]
     */
    public void setZf(Double  zf){
        this.zf = zf ;
        this.modify("zf",zf);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }


}

