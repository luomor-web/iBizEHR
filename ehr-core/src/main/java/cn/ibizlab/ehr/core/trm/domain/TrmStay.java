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
 * 实体[培训住宿]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMSTAY",resultMap = "TrmStayResultMap")
public class TrmStay extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 联系人
     */
    @TableField(value = "lxr")
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 培训住宿标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmstayid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmstayid")
    @JsonProperty("trmstayid")
    private String trmstayid;
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
     * 名称
     */
    @TableField(value = "trmstayname")
    @JSONField(name = "trmstayname")
    @JsonProperty("trmstayname")
    private String trmstayname;
    /**
     * 房间类型
     */
    @TableField(value = "fjlx")
    @JSONField(name = "fjlx")
    @JsonProperty("fjlx")
    private String fjlx;
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
     * 房间数量
     */
    @TableField(value = "fjsl")
    @JSONField(name = "fjsl")
    @JsonProperty("fjsl")
    private Integer fjsl;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
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
     * 培训地点
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;
    /**
     * 培训地点标识
     */
    @TableField(value = "trmtrainaddressid")
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;

    /**
     * 培训住宿
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress;



    /**
     * 设置 [联系人]
     */
    public void setLxr(String lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [名称]
     */
    public void setTrmstayname(String trmstayname){
        this.trmstayname = trmstayname ;
        this.modify("trmstayname",trmstayname);
    }

    /**
     * 设置 [房间类型]
     */
    public void setFjlx(String fjlx){
        this.fjlx = fjlx ;
        this.modify("fjlx",fjlx);
    }

    /**
     * 设置 [房间数量]
     */
    public void setFjsl(Integer fjsl){
        this.fjsl = fjsl ;
        this.modify("fjsl",fjsl);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [培训地点标识]
     */
    public void setTrmtrainaddressid(String trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}


