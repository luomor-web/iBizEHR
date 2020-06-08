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
 * 服务DTO对象[OrmUserDTO]
 */
@Data
public class OrmUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UNUSERID]
     *
     */
    @JSONField(name = "unuserid")
    @JsonProperty("unuserid")
    private String unuserid;

    /**
     * 属性 [USERCODE]
     *
     */
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;

    /**
     * 属性 [EMPID]
     *
     */
    @JSONField(name = "empid")
    @JsonProperty("empid")
    private String empid;

    /**
     * 属性 [ORGUSERID]
     *
     */
    @JSONField(name = "orguserid")
    @JsonProperty("orguserid")
    private String orguserid;

    /**
     * 属性 [ORGUSERNAME]
     *
     */
    @JSONField(name = "orgusername")
    @JsonProperty("orgusername")
    private String orgusername;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [ORGSECTORNAME]
     *
     */
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;


    /**
     * 设置 [UNUSERID]
     */
    public void setUnuserid(String  unuserid){
        this.unuserid = unuserid ;
        this.modify("unuserid",unuserid);
    }

    /**
     * 设置 [USERCODE]
     */
    public void setUsercode(String  usercode){
        this.usercode = usercode ;
        this.modify("usercode",usercode);
    }

    /**
     * 设置 [EMPID]
     */
    public void setEmpid(String  empid){
        this.empid = empid ;
        this.modify("empid",empid);
    }

    /**
     * 设置 [ORGUSERNAME]
     */
    public void setOrgusername(String  orgusername){
        this.orgusername = orgusername ;
        this.modify("orgusername",orgusername);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}

