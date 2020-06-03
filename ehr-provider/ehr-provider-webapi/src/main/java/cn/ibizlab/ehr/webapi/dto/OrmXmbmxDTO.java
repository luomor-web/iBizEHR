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
 * 服务DTO对象[OrmXmbmxDTO]
 */
@Data
public class OrmXmbmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORMXMBMXNAME]
     *
     */
    @JSONField(name = "ormxmbmxname")
    @JsonProperty("ormxmbmxname")
    private String ormxmbmxname;

    /**
     * 属性 [ORMXMBMXID]
     *
     */
    @JSONField(name = "ormxmbmxid")
    @JsonProperty("ormxmbmxid")
    private String ormxmbmxid;

    /**
     * 属性 [ZSMC]
     *
     */
    @JSONField(name = "zsmc")
    @JsonProperty("zsmc")
    private String zsmc;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ZSBH]
     *
     */
    @JSONField(name = "zsbh")
    @JsonProperty("zsbh")
    private String zsbh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XMRYLX]
     *
     */
    @JSONField(name = "xmrylx")
    @JsonProperty("xmrylx")
    private String xmrylx;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ORMXMBMXNAME]
     */
    public void setOrmxmbmxname(String  ormxmbmxname){
        this.ormxmbmxname = ormxmbmxname ;
        this.modify("ormxmbmxname",ormxmbmxname);
    }

    /**
     * 设置 [ZSMC]
     */
    public void setZsmc(String  zsmc){
        this.zsmc = zsmc ;
        this.modify("zsmc",zsmc);
    }

    /**
     * 设置 [ZSBH]
     */
    public void setZsbh(String  zsbh){
        this.zsbh = zsbh ;
        this.modify("zsbh",zsbh);
    }

    /**
     * 设置 [XMRYLX]
     */
    public void setXmrylx(String  xmrylx){
        this.xmrylx = xmrylx ;
        this.modify("xmrylx",xmrylx);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

