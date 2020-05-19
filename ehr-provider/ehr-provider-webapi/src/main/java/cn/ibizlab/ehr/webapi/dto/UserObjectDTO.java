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
 * 服务DTO对象[UserObjectDTO]
 */
@Data
public class UserObjectDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USEROBJECTLEVEL]
     *
     */
    @JSONField(name = "userobjectlevel")
    @JsonProperty("userobjectlevel")
    private Integer userobjectlevel;

    /**
     * 属性 [SUBTYPE]
     *
     */
    @JSONField(name = "subtype")
    @JsonProperty("subtype")
    private String subtype;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USEROBJECTTYPE]
     *
     */
    @JSONField(name = "userobjecttype")
    @JsonProperty("userobjecttype")
    private String userobjecttype;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USEROBJECTID]
     *
     */
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [USEROBJECTNAME]
     *
     */
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;


    /**
     * 设置 [USEROBJECTLEVEL]
     */
    public void setUserobjectlevel(Integer  userobjectlevel){
        this.userobjectlevel = userobjectlevel ;
        this.modify("userobjectlevel",userobjectlevel);
    }

    /**
     * 设置 [SUBTYPE]
     */
    public void setSubtype(String  subtype){
        this.subtype = subtype ;
        this.modify("subtype",subtype);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USEROBJECTTYPE]
     */
    public void setUserobjecttype(String  userobjecttype){
        this.userobjecttype = userobjecttype ;
        this.modify("userobjecttype",userobjecttype);
    }

    /**
     * 设置 [OWNERID]
     */
    public void setOwnerid(String  ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }

    /**
     * 设置 [OWNERTYPE]
     */
    public void setOwnertype(String  ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [USEROBJECTNAME]
     */
    public void setUserobjectname(String  userobjectname){
        this.userobjectname = userobjectname ;
        this.modify("userobjectname",userobjectname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}

