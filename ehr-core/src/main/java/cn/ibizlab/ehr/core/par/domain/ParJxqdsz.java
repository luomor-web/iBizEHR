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
 * 实体[绩效启动设置]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXQDSZ",resultMap = "ParJxqdszResultMap")
public class ParJxqdsz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 截止时间
     */
    @TableField(value = "jzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzsj" , format="yyyy-MM-dd")
    @JsonProperty("jzsj")
    private Timestamp jzsj;
    /**
     * 启动类型
     */
    @TableField(value = "qdlx")
    @JSONField(name = "qdlx")
    @JsonProperty("qdlx")
    private String qdlx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 开启时间
     */
    @TableField(value = "kqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqsj" , format="yyyy-MM-dd")
    @JsonProperty("kqsj")
    private Timestamp kqsj;
    /**
     * 标题
     */
    @TableField(value = "parjxqdszname")
    @JSONField(name = "parjxqdszname")
    @JsonProperty("parjxqdszname")
    private String parjxqdszname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 绩效启动设置标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxqdszid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxqdszid")
    @JsonProperty("parjxqdszid")
    private String parjxqdszid;
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
     * 设置 [截止时间]
     */
    public void setJzsj(Timestamp jzsj){
        this.jzsj = jzsj ;
        this.modify("jzsj",jzsj);
    }

    /**
     * 格式化日期 [截止时间]
     */
    public String formatJzsj(){
        if (this.jzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jzsj);
    }
    /**
     * 设置 [启动类型]
     */
    public void setQdlx(String qdlx){
        this.qdlx = qdlx ;
        this.modify("qdlx",qdlx);
    }

    /**
     * 设置 [开启时间]
     */
    public void setKqsj(Timestamp kqsj){
        this.kqsj = kqsj ;
        this.modify("kqsj",kqsj);
    }

    /**
     * 格式化日期 [开启时间]
     */
    public String formatKqsj(){
        if (this.kqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kqsj);
    }
    /**
     * 设置 [标题]
     */
    public void setParjxqdszname(String parjxqdszname){
        this.parjxqdszname = parjxqdszname ;
        this.modify("parjxqdszname",parjxqdszname);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


