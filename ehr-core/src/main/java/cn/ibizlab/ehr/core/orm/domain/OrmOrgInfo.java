package cn.ibizlab.ehr.core.orm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[组织信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMORGINFO",resultMap = "OrmOrgInfoResultMap")
public class OrmOrgInfo extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位
     */
    @TableField(value = "postinfo")
    @JSONField(name = "postinfo")
    @JsonProperty("postinfo")
    private String postinfo;
    /**
     * 上级部门ID
     */
    @TableField(value = "porgsectorid")
    @JSONField(name = "porgsectorid")
    @JsonProperty("porgsectorid")
    private String porgsectorid;
    /**
     * 组织排序编号
     */
    @TableField(value = "ordernum")
    @JSONField(name = "ordernum")
    @JsonProperty("ordernum")
    private String ordernum;
    /**
     * 所属OU的组织ID
     */
    @TableField(value = "ouid")
    @JSONField(name = "ouid")
    @JsonProperty("ouid")
    private String ouid;
    /**
     * 组织ID
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormorginfoid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormorginfoid")
    @JsonProperty("ormorginfoid")
    private String ormorginfoid;
    /**
     * 组织简称
     */
    @TableField(value = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 组织编码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 启停标识
     */
    @TableField(value = "startstopsign")
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;
    /**
     * 上级组织ID
     */
    @TableField(value = "porgid")
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;
    /**
     * 组织类型释义
     */
    @TableField(value = "orgtypename")
    @JSONField(name = "orgtypename")
    @JsonProperty("orgtypename")
    private String orgtypename;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 所属区域
     */
    @TableField(value = "belongregion")
    @JSONField(name = "belongregion")
    @JsonProperty("belongregion")
    private String belongregion;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织类型
     */
    @TableField(value = "orgtype")
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;
    /**
     * 补贴标准
     */
    @TableField(value = "substandard")
    @JSONField(name = "substandard")
    @JsonProperty("substandard")
    private String substandard;
    /**
     * 组织名称
     */
    @TableField(value = "ormorginfoname")
    @JSONField(name = "ormorginfoname")
    @JsonProperty("ormorginfoname")
    private String ormorginfoname;



    /**
     * 设置 [岗位]
     */
    public void setPostinfo(String postinfo){
        this.postinfo = postinfo ;
        this.modify("postinfo",postinfo);
    }

    /**
     * 设置 [上级部门ID]
     */
    public void setPorgsectorid(String porgsectorid){
        this.porgsectorid = porgsectorid ;
        this.modify("porgsectorid",porgsectorid);
    }

    /**
     * 设置 [组织排序编号]
     */
    public void setOrdernum(String ordernum){
        this.ordernum = ordernum ;
        this.modify("ordernum",ordernum);
    }

    /**
     * 设置 [所属OU的组织ID]
     */
    public void setOuid(String ouid){
        this.ouid = ouid ;
        this.modify("ouid",ouid);
    }

    /**
     * 设置 [组织简称]
     */
    public void setShortname(String shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [组织编码]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [启停标识]
     */
    public void setStartstopsign(String startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [上级组织ID]
     */
    public void setPorgid(String porgid){
        this.porgid = porgid ;
        this.modify("porgid",porgid);
    }

    /**
     * 设置 [组织类型释义]
     */
    public void setOrgtypename(String orgtypename){
        this.orgtypename = orgtypename ;
        this.modify("orgtypename",orgtypename);
    }

    /**
     * 设置 [所属区域]
     */
    public void setBelongregion(String belongregion){
        this.belongregion = belongregion ;
        this.modify("belongregion",belongregion);
    }

    /**
     * 设置 [组织类型]
     */
    public void setOrgtype(String orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [补贴标准]
     */
    public void setSubstandard(String substandard){
        this.substandard = substandard ;
        this.modify("substandard",substandard);
    }

    /**
     * 设置 [组织名称]
     */
    public void setOrmorginfoname(String ormorginfoname){
        this.ormorginfoname = ormorginfoname ;
        this.modify("ormorginfoname",ormorginfoname);
    }


}


