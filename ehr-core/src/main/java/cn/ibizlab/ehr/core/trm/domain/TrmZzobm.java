package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[单位/部门]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMZZOBM",resultMap = "TrmZzobmResultMap")
public class TrmZzobm extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 单位/部门名称
     */
    @TableField(value = "trmzzobmname")
    @JSONField(name = "trmzzobmname")
    @JsonProperty("trmzzobmname")
    private String trmzzobmname;
    /**
     * 单位/部门标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmzzobmid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmzzobmid")
    @JsonProperty("trmzzobmid")
    private String trmzzobmid;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 上级单位ID
     */
    @TableField(value = "sjdwid")
    @JSONField(name = "sjdwid")
    @JsonProperty("sjdwid")
    private String sjdwid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 单位
     */
    @TableField(value = "dw")
    @JSONField(name = "dw")
    @JsonProperty("dw")
    private String dw;



    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [单位/部门名称]
     */
    public void setTrmzzobmname(String trmzzobmname){
        this.trmzzobmname = trmzzobmname ;
        this.modify("trmzzobmname",trmzzobmname);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [上级单位ID]
     */
    public void setSjdwid(String sjdwid){
        this.sjdwid = sjdwid ;
        this.modify("sjdwid",sjdwid);
    }

    /**
     * 设置 [单位]
     */
    public void setDw(String dw){
        this.dw = dw ;
        this.modify("dw",dw);
    }


}


