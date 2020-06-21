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
 * 实体[考核方案]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXKHJCSZ",resultMap = "ParJxkhjcszResultMap")
public class ParJxkhjcsz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核对象
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 设置时间
     */
    @TableField(value = "szsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "szsj" , format="yyyy-MM-dd")
    @JsonProperty("szsj")
    private Timestamp szsj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 考核方案标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxkhjcszid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxkhjcszid")
    @JsonProperty("parjxkhjcszid")
    private String parjxkhjcszid;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 是否启用
     */
    @TableField(value = "sfqy")
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;
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
     * 考核方案
     */
    @TableField(value = "parjxkhjcszname")
    @JSONField(name = "parjxkhjcszname")
    @JsonProperty("parjxkhjcszname")
    private String parjxkhjcszname;
    /**
     * 考核年度
     */
    @TableField(value = "khnd")
    @JSONField(name = "khnd")
    @JsonProperty("khnd")
    private String khnd;
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
     * 设置 [考核对象]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [设置时间]
     */
    public void setSzsj(Timestamp szsj){
        this.szsj = szsj ;
        this.modify("szsj",szsj);
    }

    /**
     * 格式化日期 [设置时间]
     */
    public String formatSzsj(){
        if (this.szsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(szsj);
    }
    /**
     * 设置 [是否启用]
     */
    public void setSfqy(Integer sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [考核方案]
     */
    public void setParjxkhjcszname(String parjxkhjcszname){
        this.parjxkhjcszname = parjxkhjcszname ;
        this.modify("parjxkhjcszname",parjxkhjcszname);
    }

    /**
     * 设置 [考核年度]
     */
    public void setKhnd(String khnd){
        this.khnd = khnd ;
        this.modify("khnd",khnd);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


