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
 * 服务DTO对象[OrmOrgdzDTO]
 */
@Data
public class OrmOrgdzDTO extends DTOBase implements Serializable {

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
     * 属性 [DEFORGADDRESS]
     *
     */
    @JSONField(name = "deforgaddress")
    @JsonProperty("deforgaddress")
    private String deforgaddress;

    /**
     * 属性 [ORMORGDZID]
     *
     */
    @JSONField(name = "ormorgdzid")
    @JsonProperty("ormorgdzid")
    private String ormorgdzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

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
     * 属性 [ORMORGDZNAME]
     *
     */
    @JSONField(name = "ormorgdzname")
    @JsonProperty("ormorgdzname")
    private String ormorgdzname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [DEFORGADDRESS]
     */
    public void setDeforgaddress(String  deforgaddress){
        this.deforgaddress = deforgaddress ;
        this.modify("deforgaddress",deforgaddress);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ORMORGDZNAME]
     */
    public void setOrmorgdzname(String  ormorgdzname){
        this.ormorgdzname = ormorgdzname ;
        this.modify("ormorgdzname",ormorgdzname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

