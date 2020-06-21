package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[绩效模板]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXKHMB",resultMap = "ParJxkhmbResultMap")
public class ParJxkhmb extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板名称
     */
    @TableField(value = "parjxkhmbname")
    @JSONField(name = "parjxkhmbname")
    @JsonProperty("parjxkhmbname")
    private String parjxkhmbname;
    /**
     * 模板编号
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxkhmbid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxkhmbid")
    @JsonProperty("parjxkhmbid")
    private String parjxkhmbid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 考核对象
     */
    @TableField(value = "khdx")
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 考核内容
     */
    @TableField(value = "khx")
    @JSONField(name = "khx")
    @JsonProperty("khx")
    private String khx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织ID
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [模板名称]
     */
    public void setParjxkhmbname(String parjxkhmbname){
        this.parjxkhmbname = parjxkhmbname ;
        this.modify("parjxkhmbname",parjxkhmbname);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhdx(String khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [考核内容]
     */
    public void setKhx(String khx){
        this.khx = khx ;
        this.modify("khx",khx);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


