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
 * 实体[交通]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAFFIC",resultMap = "TrmTrafficResultMap")
public class TrmTraffic extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交通标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrafficid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrafficid")
    @JsonProperty("trmtrafficid")
    private String trmtrafficid;
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
     * 交通方式
     */
    @TableField(value = "jtfs")
    @JSONField(name = "jtfs")
    @JsonProperty("jtfs")
    private String jtfs;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 站名
     */
    @TableField(value = "zm")
    @JSONField(name = "zm")
    @JsonProperty("zm")
    private String zm;
    /**
     * 交通名称
     */
    @TableField(value = "trmtrafficname")
    @JSONField(name = "trmtrafficname")
    @JsonProperty("trmtrafficname")
    private String trmtrafficname;
    /**
     * 交通线路
     */
    @TableField(value = "xlmc")
    @JSONField(name = "xlmc")
    @JsonProperty("xlmc")
    private String xlmc;
    /**
     * 出口
     */
    @TableField(value = "ck")
    @JSONField(name = "ck")
    @JsonProperty("ck")
    private String ck;
    /**
     * 目的地
     */
    @TableField(value = "mdd")
    @JSONField(name = "mdd")
    @JsonProperty("mdd")
    private String mdd;
    /**
     * 出发地
     */
    @TableField(value = "cfd")
    @JSONField(name = "cfd")
    @JsonProperty("cfd")
    private String cfd;
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
     * 交通
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress;



    /**
     * 设置 [交通方式]
     */
    public void setJtfs(String jtfs){
        this.jtfs = jtfs ;
        this.modify("jtfs",jtfs);
    }

    /**
     * 设置 [站名]
     */
    public void setZm(String zm){
        this.zm = zm ;
        this.modify("zm",zm);
    }

    /**
     * 设置 [交通名称]
     */
    public void setTrmtrafficname(String trmtrafficname){
        this.trmtrafficname = trmtrafficname ;
        this.modify("trmtrafficname",trmtrafficname);
    }

    /**
     * 设置 [交通线路]
     */
    public void setXlmc(String xlmc){
        this.xlmc = xlmc ;
        this.modify("xlmc",xlmc);
    }

    /**
     * 设置 [出口]
     */
    public void setCk(String ck){
        this.ck = ck ;
        this.modify("ck",ck);
    }

    /**
     * 设置 [目的地]
     */
    public void setMdd(String mdd){
        this.mdd = mdd ;
        this.modify("mdd",mdd);
    }

    /**
     * 设置 [出发地]
     */
    public void setCfd(String cfd){
        this.cfd = cfd ;
        this.modify("cfd",cfd);
    }

    /**
     * 设置 [培训地点标识]
     */
    public void setTrmtrainaddressid(String trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}


