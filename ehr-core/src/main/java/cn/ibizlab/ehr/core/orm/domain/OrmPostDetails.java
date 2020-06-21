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
 * 实体[岗位明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMPOSTDETAILS",resultMap = "OrmPostDetailsResultMap")
public class OrmPostDetails extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 岗位明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormpostdetailsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormpostdetailsid")
    @JsonProperty("ormpostdetailsid")
    private String ormpostdetailsid;
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
     * 岗位明细
     */
    @TableField(value = "ormpostdetailsname")
    @JSONField(name = "ormpostdetailsname")
    @JsonProperty("ormpostdetailsname")
    private String ormpostdetailsname;
    /**
     * 岗位标签
     */
    @TableField(exist = false)
    @JSONField(name = "gwflag")
    @JsonProperty("gwflag")
    private String gwflag;
    /**
     * 建议交流年限
     */
    @TableField(exist = false)
    @JSONField(name = "sugexcyear")
    @JsonProperty("sugexcyear")
    private Integer sugexcyear;
    /**
     * 岗位类型
     */
    @TableField(exist = false)
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;
    /**
     * 岗位性质
     */
    @TableField(exist = false)
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;
    /**
     * 岗位集名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 必须交流年限
     */
    @TableField(exist = false)
    @JSONField(name = "mustexcyear")
    @JsonProperty("mustexcyear")
    private Integer mustexcyear;
    /**
     * 岗位名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostlibname")
    @JsonProperty("ormpostlibname")
    private String ormpostlibname;
    /**
     * 是否保密岗
     */
    @TableField(exist = false)
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;
    /**
     * 岗位集ID
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 岗位ID
     */
    @TableField(value = "ormpostlibid")
    @JSONField(name = "ormpostlibid")
    @JsonProperty("ormpostlibid")
    private String ormpostlibid;

    /**
     * 岗位库
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPostLib ormpostlib;

    /**
     * 岗位集
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;



    /**
     * 设置 [岗位明细]
     */
    public void setOrmpostdetailsname(String ormpostdetailsname){
        this.ormpostdetailsname = ormpostdetailsname ;
        this.modify("ormpostdetailsname",ormpostdetailsname);
    }

    /**
     * 设置 [岗位集ID]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [岗位ID]
     */
    public void setOrmpostlibid(String ormpostlibid){
        this.ormpostlibid = ormpostlibid ;
        this.modify("ormpostlibid",ormpostlibid);
    }


    /**
     * 获取 [岗位明细标识]
     */
    public String getOrmpostdetailsid(){
        if(ObjectUtils.isEmpty(ormpostdetailsid)){
            ormpostdetailsid=(String)getDefaultKey(true);
        }
        return ormpostdetailsid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getOrmpostid()))&&(!ObjectUtils.isEmpty(this.getOrmpostlibid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getOrmpostid(),this.getOrmpostlibid()).getBytes());
        return null;
    }
}


