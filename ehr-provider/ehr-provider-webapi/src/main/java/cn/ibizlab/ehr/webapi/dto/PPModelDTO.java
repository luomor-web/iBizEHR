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
 * 服务DTO对象[PPModelDTO]
 */
@Data
public class PPModelDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PPMODEL]
     *
     */
    @JSONField(name = "ppmodel")
    @JsonProperty("ppmodel")
    private String ppmodel;

    /**
     * 属性 [PPMODELNAME]
     *
     */
    @JSONField(name = "ppmodelname")
    @JsonProperty("ppmodelname")
    private String ppmodelname;

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
     * 属性 [PPMODELDETAIL]
     *
     */
    @JSONField(name = "ppmodeldetail")
    @JsonProperty("ppmodeldetail")
    private String ppmodeldetail;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 属性 [PPMVERSION]
     *
     */
    @JSONField(name = "ppmversion")
    @JsonProperty("ppmversion")
    private Integer ppmversion;

    /**
     * 属性 [PPMODELID]
     *
     */
    @JSONField(name = "ppmodelid")
    @JsonProperty("ppmodelid")
    private String ppmodelid;

    /**
     * 属性 [ISSYSTEM]
     *
     */
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;

    /**
     * 属性 [R3PVPARTCTRLID]
     *
     */
    @JSONField(name = "r3pvpartctrlid")
    @JsonProperty("r3pvpartctrlid")
    private String r3pvpartctrlid;

    /**
     * 属性 [R1PVPARTNAME]
     *
     */
    @JSONField(name = "r1pvpartname")
    @JsonProperty("r1pvpartname")
    private String r1pvpartname;

    /**
     * 属性 [C3PVPARTNAME]
     *
     */
    @JSONField(name = "c3pvpartname")
    @JsonProperty("c3pvpartname")
    private String c3pvpartname;

    /**
     * 属性 [C4PVPARTCTRLID]
     *
     */
    @JSONField(name = "c4pvpartctrlid")
    @JsonProperty("c4pvpartctrlid")
    private String c4pvpartctrlid;

    /**
     * 属性 [R2PVPARTCTRLID]
     *
     */
    @JSONField(name = "r2pvpartctrlid")
    @JsonProperty("r2pvpartctrlid")
    private String r2pvpartctrlid;

    /**
     * 属性 [L1PVPARTCTRLID]
     *
     */
    @JSONField(name = "l1pvpartctrlid")
    @JsonProperty("l1pvpartctrlid")
    private String l1pvpartctrlid;

    /**
     * 属性 [C3PVPARTCTRLID]
     *
     */
    @JSONField(name = "c3pvpartctrlid")
    @JsonProperty("c3pvpartctrlid")
    private String c3pvpartctrlid;

    /**
     * 属性 [C2PVPARTCTRLID]
     *
     */
    @JSONField(name = "c2pvpartctrlid")
    @JsonProperty("c2pvpartctrlid")
    private String c2pvpartctrlid;

    /**
     * 属性 [L3PVPARTNAME]
     *
     */
    @JSONField(name = "l3pvpartname")
    @JsonProperty("l3pvpartname")
    private String l3pvpartname;

    /**
     * 属性 [R3PVPARTNAME]
     *
     */
    @JSONField(name = "r3pvpartname")
    @JsonProperty("r3pvpartname")
    private String r3pvpartname;

    /**
     * 属性 [C1PVPARTNAME]
     *
     */
    @JSONField(name = "c1pvpartname")
    @JsonProperty("c1pvpartname")
    private String c1pvpartname;

    /**
     * 属性 [R4PVPARTNAME]
     *
     */
    @JSONField(name = "r4pvpartname")
    @JsonProperty("r4pvpartname")
    private String r4pvpartname;

    /**
     * 属性 [L4PVPARTCTRLID]
     *
     */
    @JSONField(name = "l4pvpartctrlid")
    @JsonProperty("l4pvpartctrlid")
    private String l4pvpartctrlid;

    /**
     * 属性 [R1PVPARTCTRLID]
     *
     */
    @JSONField(name = "r1pvpartctrlid")
    @JsonProperty("r1pvpartctrlid")
    private String r1pvpartctrlid;

    /**
     * 属性 [L2PVPARTNAME]
     *
     */
    @JSONField(name = "l2pvpartname")
    @JsonProperty("l2pvpartname")
    private String l2pvpartname;

    /**
     * 属性 [L4PVPARTNAME]
     *
     */
    @JSONField(name = "l4pvpartname")
    @JsonProperty("l4pvpartname")
    private String l4pvpartname;

    /**
     * 属性 [L2PVPARTCTRLID]
     *
     */
    @JSONField(name = "l2pvpartctrlid")
    @JsonProperty("l2pvpartctrlid")
    private String l2pvpartctrlid;

    /**
     * 属性 [R4PVPARTCTRLID]
     *
     */
    @JSONField(name = "r4pvpartctrlid")
    @JsonProperty("r4pvpartctrlid")
    private String r4pvpartctrlid;

    /**
     * 属性 [L1PVPARTNAME]
     *
     */
    @JSONField(name = "l1pvpartname")
    @JsonProperty("l1pvpartname")
    private String l1pvpartname;

    /**
     * 属性 [PORTALPAGENAME]
     *
     */
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;

    /**
     * 属性 [C4PVPARTNAME]
     *
     */
    @JSONField(name = "c4pvpartname")
    @JsonProperty("c4pvpartname")
    private String c4pvpartname;

    /**
     * 属性 [L3PVPARTCTRLID]
     *
     */
    @JSONField(name = "l3pvpartctrlid")
    @JsonProperty("l3pvpartctrlid")
    private String l3pvpartctrlid;

    /**
     * 属性 [C2PVPARTNAME]
     *
     */
    @JSONField(name = "c2pvpartname")
    @JsonProperty("c2pvpartname")
    private String c2pvpartname;

    /**
     * 属性 [R2PVPARTNAME]
     *
     */
    @JSONField(name = "r2pvpartname")
    @JsonProperty("r2pvpartname")
    private String r2pvpartname;

    /**
     * 属性 [C1PVPARTCTRLID]
     *
     */
    @JSONField(name = "c1pvpartctrlid")
    @JsonProperty("c1pvpartctrlid")
    private String c1pvpartctrlid;

    /**
     * 属性 [R1PVPARTID]
     *
     */
    @JSONField(name = "r1pvpartid")
    @JsonProperty("r1pvpartid")
    private String r1pvpartid;

    /**
     * 属性 [C3PVPARTID]
     *
     */
    @JSONField(name = "c3pvpartid")
    @JsonProperty("c3pvpartid")
    private String c3pvpartid;

    /**
     * 属性 [C1PVPARTID]
     *
     */
    @JSONField(name = "c1pvpartid")
    @JsonProperty("c1pvpartid")
    private String c1pvpartid;

    /**
     * 属性 [L1PVPARTID]
     *
     */
    @JSONField(name = "l1pvpartid")
    @JsonProperty("l1pvpartid")
    private String l1pvpartid;

    /**
     * 属性 [R4PVPARTID]
     *
     */
    @JSONField(name = "r4pvpartid")
    @JsonProperty("r4pvpartid")
    private String r4pvpartid;

    /**
     * 属性 [L4PVPARTID]
     *
     */
    @JSONField(name = "l4pvpartid")
    @JsonProperty("l4pvpartid")
    private String l4pvpartid;

    /**
     * 属性 [L2PVPARTID]
     *
     */
    @JSONField(name = "l2pvpartid")
    @JsonProperty("l2pvpartid")
    private String l2pvpartid;

    /**
     * 属性 [C4PVPARTID]
     *
     */
    @JSONField(name = "c4pvpartid")
    @JsonProperty("c4pvpartid")
    private String c4pvpartid;

    /**
     * 属性 [L3PVPARTID]
     *
     */
    @JSONField(name = "l3pvpartid")
    @JsonProperty("l3pvpartid")
    private String l3pvpartid;

    /**
     * 属性 [PORTALPAGEID]
     *
     */
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;

    /**
     * 属性 [R3PVPARTID]
     *
     */
    @JSONField(name = "r3pvpartid")
    @JsonProperty("r3pvpartid")
    private String r3pvpartid;

    /**
     * 属性 [R2PVPARTID]
     *
     */
    @JSONField(name = "r2pvpartid")
    @JsonProperty("r2pvpartid")
    private String r2pvpartid;

    /**
     * 属性 [C2PVPARTID]
     *
     */
    @JSONField(name = "c2pvpartid")
    @JsonProperty("c2pvpartid")
    private String c2pvpartid;


    /**
     * 设置 [PPMODEL]
     */
    public void setPpmodel(String  ppmodel){
        this.ppmodel = ppmodel ;
        this.modify("ppmodel",ppmodel);
    }

    /**
     * 设置 [PPMODELNAME]
     */
    public void setPpmodelname(String  ppmodelname){
        this.ppmodelname = ppmodelname ;
        this.modify("ppmodelname",ppmodelname);
    }

    /**
     * 设置 [PPMODELDETAIL]
     */
    public void setPpmodeldetail(String  ppmodeldetail){
        this.ppmodeldetail = ppmodeldetail ;
        this.modify("ppmodeldetail",ppmodeldetail);
    }

    /**
     * 设置 [OWNERID]
     */
    public void setOwnerid(String  ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }

    /**
     * 设置 [PPMVERSION]
     */
    public void setPpmversion(Integer  ppmversion){
        this.ppmversion = ppmversion ;
        this.modify("ppmversion",ppmversion);
    }

    /**
     * 设置 [ISSYSTEM]
     */
    public void setIssystem(Integer  issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }

    /**
     * 设置 [R3PVPARTCTRLID]
     */
    public void setR3pvpartctrlid(String  r3pvpartctrlid){
        this.r3pvpartctrlid = r3pvpartctrlid ;
        this.modify("r3pvpartctrlid",r3pvpartctrlid);
    }

    /**
     * 设置 [R1PVPARTNAME]
     */
    public void setR1pvpartname(String  r1pvpartname){
        this.r1pvpartname = r1pvpartname ;
        this.modify("r1pvpartname",r1pvpartname);
    }

    /**
     * 设置 [C3PVPARTNAME]
     */
    public void setC3pvpartname(String  c3pvpartname){
        this.c3pvpartname = c3pvpartname ;
        this.modify("c3pvpartname",c3pvpartname);
    }

    /**
     * 设置 [C4PVPARTCTRLID]
     */
    public void setC4pvpartctrlid(String  c4pvpartctrlid){
        this.c4pvpartctrlid = c4pvpartctrlid ;
        this.modify("c4pvpartctrlid",c4pvpartctrlid);
    }

    /**
     * 设置 [R2PVPARTCTRLID]
     */
    public void setR2pvpartctrlid(String  r2pvpartctrlid){
        this.r2pvpartctrlid = r2pvpartctrlid ;
        this.modify("r2pvpartctrlid",r2pvpartctrlid);
    }

    /**
     * 设置 [L1PVPARTCTRLID]
     */
    public void setL1pvpartctrlid(String  l1pvpartctrlid){
        this.l1pvpartctrlid = l1pvpartctrlid ;
        this.modify("l1pvpartctrlid",l1pvpartctrlid);
    }

    /**
     * 设置 [C3PVPARTCTRLID]
     */
    public void setC3pvpartctrlid(String  c3pvpartctrlid){
        this.c3pvpartctrlid = c3pvpartctrlid ;
        this.modify("c3pvpartctrlid",c3pvpartctrlid);
    }

    /**
     * 设置 [C2PVPARTCTRLID]
     */
    public void setC2pvpartctrlid(String  c2pvpartctrlid){
        this.c2pvpartctrlid = c2pvpartctrlid ;
        this.modify("c2pvpartctrlid",c2pvpartctrlid);
    }

    /**
     * 设置 [L3PVPARTNAME]
     */
    public void setL3pvpartname(String  l3pvpartname){
        this.l3pvpartname = l3pvpartname ;
        this.modify("l3pvpartname",l3pvpartname);
    }

    /**
     * 设置 [R3PVPARTNAME]
     */
    public void setR3pvpartname(String  r3pvpartname){
        this.r3pvpartname = r3pvpartname ;
        this.modify("r3pvpartname",r3pvpartname);
    }

    /**
     * 设置 [C1PVPARTNAME]
     */
    public void setC1pvpartname(String  c1pvpartname){
        this.c1pvpartname = c1pvpartname ;
        this.modify("c1pvpartname",c1pvpartname);
    }

    /**
     * 设置 [R4PVPARTNAME]
     */
    public void setR4pvpartname(String  r4pvpartname){
        this.r4pvpartname = r4pvpartname ;
        this.modify("r4pvpartname",r4pvpartname);
    }

    /**
     * 设置 [L4PVPARTCTRLID]
     */
    public void setL4pvpartctrlid(String  l4pvpartctrlid){
        this.l4pvpartctrlid = l4pvpartctrlid ;
        this.modify("l4pvpartctrlid",l4pvpartctrlid);
    }

    /**
     * 设置 [R1PVPARTCTRLID]
     */
    public void setR1pvpartctrlid(String  r1pvpartctrlid){
        this.r1pvpartctrlid = r1pvpartctrlid ;
        this.modify("r1pvpartctrlid",r1pvpartctrlid);
    }

    /**
     * 设置 [L2PVPARTNAME]
     */
    public void setL2pvpartname(String  l2pvpartname){
        this.l2pvpartname = l2pvpartname ;
        this.modify("l2pvpartname",l2pvpartname);
    }

    /**
     * 设置 [L4PVPARTNAME]
     */
    public void setL4pvpartname(String  l4pvpartname){
        this.l4pvpartname = l4pvpartname ;
        this.modify("l4pvpartname",l4pvpartname);
    }

    /**
     * 设置 [L2PVPARTCTRLID]
     */
    public void setL2pvpartctrlid(String  l2pvpartctrlid){
        this.l2pvpartctrlid = l2pvpartctrlid ;
        this.modify("l2pvpartctrlid",l2pvpartctrlid);
    }

    /**
     * 设置 [R4PVPARTCTRLID]
     */
    public void setR4pvpartctrlid(String  r4pvpartctrlid){
        this.r4pvpartctrlid = r4pvpartctrlid ;
        this.modify("r4pvpartctrlid",r4pvpartctrlid);
    }

    /**
     * 设置 [L1PVPARTNAME]
     */
    public void setL1pvpartname(String  l1pvpartname){
        this.l1pvpartname = l1pvpartname ;
        this.modify("l1pvpartname",l1pvpartname);
    }

    /**
     * 设置 [PORTALPAGENAME]
     */
    public void setPortalpagename(String  portalpagename){
        this.portalpagename = portalpagename ;
        this.modify("portalpagename",portalpagename);
    }

    /**
     * 设置 [C4PVPARTNAME]
     */
    public void setC4pvpartname(String  c4pvpartname){
        this.c4pvpartname = c4pvpartname ;
        this.modify("c4pvpartname",c4pvpartname);
    }

    /**
     * 设置 [L3PVPARTCTRLID]
     */
    public void setL3pvpartctrlid(String  l3pvpartctrlid){
        this.l3pvpartctrlid = l3pvpartctrlid ;
        this.modify("l3pvpartctrlid",l3pvpartctrlid);
    }

    /**
     * 设置 [C2PVPARTNAME]
     */
    public void setC2pvpartname(String  c2pvpartname){
        this.c2pvpartname = c2pvpartname ;
        this.modify("c2pvpartname",c2pvpartname);
    }

    /**
     * 设置 [R2PVPARTNAME]
     */
    public void setR2pvpartname(String  r2pvpartname){
        this.r2pvpartname = r2pvpartname ;
        this.modify("r2pvpartname",r2pvpartname);
    }

    /**
     * 设置 [C1PVPARTCTRLID]
     */
    public void setC1pvpartctrlid(String  c1pvpartctrlid){
        this.c1pvpartctrlid = c1pvpartctrlid ;
        this.modify("c1pvpartctrlid",c1pvpartctrlid);
    }

    /**
     * 设置 [R1PVPARTID]
     */
    public void setR1pvpartid(String  r1pvpartid){
        this.r1pvpartid = r1pvpartid ;
        this.modify("r1pvpartid",r1pvpartid);
    }

    /**
     * 设置 [C3PVPARTID]
     */
    public void setC3pvpartid(String  c3pvpartid){
        this.c3pvpartid = c3pvpartid ;
        this.modify("c3pvpartid",c3pvpartid);
    }

    /**
     * 设置 [C1PVPARTID]
     */
    public void setC1pvpartid(String  c1pvpartid){
        this.c1pvpartid = c1pvpartid ;
        this.modify("c1pvpartid",c1pvpartid);
    }

    /**
     * 设置 [L1PVPARTID]
     */
    public void setL1pvpartid(String  l1pvpartid){
        this.l1pvpartid = l1pvpartid ;
        this.modify("l1pvpartid",l1pvpartid);
    }

    /**
     * 设置 [R4PVPARTID]
     */
    public void setR4pvpartid(String  r4pvpartid){
        this.r4pvpartid = r4pvpartid ;
        this.modify("r4pvpartid",r4pvpartid);
    }

    /**
     * 设置 [L4PVPARTID]
     */
    public void setL4pvpartid(String  l4pvpartid){
        this.l4pvpartid = l4pvpartid ;
        this.modify("l4pvpartid",l4pvpartid);
    }

    /**
     * 设置 [L2PVPARTID]
     */
    public void setL2pvpartid(String  l2pvpartid){
        this.l2pvpartid = l2pvpartid ;
        this.modify("l2pvpartid",l2pvpartid);
    }

    /**
     * 设置 [C4PVPARTID]
     */
    public void setC4pvpartid(String  c4pvpartid){
        this.c4pvpartid = c4pvpartid ;
        this.modify("c4pvpartid",c4pvpartid);
    }

    /**
     * 设置 [L3PVPARTID]
     */
    public void setL3pvpartid(String  l3pvpartid){
        this.l3pvpartid = l3pvpartid ;
        this.modify("l3pvpartid",l3pvpartid);
    }

    /**
     * 设置 [PORTALPAGEID]
     */
    public void setPortalpageid(String  portalpageid){
        this.portalpageid = portalpageid ;
        this.modify("portalpageid",portalpageid);
    }

    /**
     * 设置 [R3PVPARTID]
     */
    public void setR3pvpartid(String  r3pvpartid){
        this.r3pvpartid = r3pvpartid ;
        this.modify("r3pvpartid",r3pvpartid);
    }

    /**
     * 设置 [R2PVPARTID]
     */
    public void setR2pvpartid(String  r2pvpartid){
        this.r2pvpartid = r2pvpartid ;
        this.modify("r2pvpartid",r2pvpartid);
    }

    /**
     * 设置 [C2PVPARTID]
     */
    public void setC2pvpartid(String  c2pvpartid){
        this.c2pvpartid = c2pvpartid ;
        this.modify("c2pvpartid",c2pvpartid);
    }


}

