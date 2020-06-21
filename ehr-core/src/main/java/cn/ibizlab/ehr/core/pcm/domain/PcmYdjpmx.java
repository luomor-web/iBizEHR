package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[异动解聘明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYDJPMX",resultMap = "PcmYdjpmxResultMap")
public class PcmYdjpmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分组类型
     */
    @TableField(exist = false)
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;
    /**
     * 结束日期
     */
    @TableField(value = "jsrq")
    @JSONField(name = "jsrq")
    @JsonProperty("jsrq")
    private String jsrq;
    /**
     * 是否加黑名单
     */
    @TableField(value = "sfhmd")
    @JSONField(name = "sfhmd")
    @JsonProperty("sfhmd")
    private Integer sfhmd;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 所属岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 是否有劳动争议
     */
    @TableField(value = "sfldzy")
    @JSONField(name = "sfldzy")
    @JsonProperty("sfldzy")
    private Integer sfldzy;
    /**
     * 所属组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 人员信息标识
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    @JSONField(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;
    /**
     * 补偿金数额（元）
     */
    @TableField(value = "bcjse")
    @JSONField(name = "bcjse")
    @JsonProperty("bcjse")
    private Double bcjse;
    /**
     * 劳动争议类型
     */
    @TableField(value = "ldzytype")
    @JSONField(name = "ldzytype")
    @JsonProperty("ldzytype")
    private String ldzytype;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 异动解聘明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmydjpmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmydjpmxid")
    @JsonProperty("pcmydjpmxid")
    private String pcmydjpmxid;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 赔偿金数额（元）
     */
    @TableField(value = "pcjse")
    @JSONField(name = "pcjse")
    @JsonProperty("pcjse")
    private Double pcjse;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 解聘明细名称
     */
    @TableField(value = "pcmydjpmxname")
    @JSONField(name = "pcmydjpmxname")
    @JsonProperty("pcmydjpmxname")
    private String pcmydjpmxname;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
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
     * 解聘原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
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
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 解聘日期
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 审核状态
     */
    @TableField(exist = false)
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 解除劳动合同附件
     */
    @TableField(value = "jpfj")
    @JSONField(name = "jpfj")
    @JsonProperty("jpfj")
    private String jpfj;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 原因详情
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 所属职务
     */
    @TableField(exist = false)
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 是否支付补偿金
     */
    @TableField(value = "sfzfbcj")
    @JSONField(name = "sfzfbcj")
    @JsonProperty("sfzfbcj")
    private Integer sfzfbcj;
    /**
     * 是否完成
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isfinished")
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;



    /**
     * 设置 [结束日期]
     */
    public void setJsrq(String jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 设置 [是否加黑名单]
     */
    public void setSfhmd(Integer sfhmd){
        this.sfhmd = sfhmd ;
        this.modify("sfhmd",sfhmd);
    }

    /**
     * 设置 [是否有劳动争议]
     */
    public void setSfldzy(Integer sfldzy){
        this.sfldzy = sfldzy ;
        this.modify("sfldzy",sfldzy);
    }

    /**
     * 设置 [备注]
     */
    public void setRemarks(String remarks){
        this.remarks = remarks ;
        this.modify("remarks",remarks);
    }

    /**
     * 设置 [补偿金数额（元）]
     */
    public void setBcjse(Double bcjse){
        this.bcjse = bcjse ;
        this.modify("bcjse",bcjse);
    }

    /**
     * 设置 [劳动争议类型]
     */
    public void setLdzytype(String ldzytype){
        this.ldzytype = ldzytype ;
        this.modify("ldzytype",ldzytype);
    }

    /**
     * 设置 [赔偿金数额（元）]
     */
    public void setPcjse(Double pcjse){
        this.pcjse = pcjse ;
        this.modify("pcjse",pcjse);
    }

    /**
     * 设置 [解聘明细名称]
     */
    public void setPcmydjpmxname(String pcmydjpmxname){
        this.pcmydjpmxname = pcmydjpmxname ;
        this.modify("pcmydjpmxname",pcmydjpmxname);
    }

    /**
     * 设置 [解聘原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [解除劳动合同附件]
     */
    public void setJpfj(String jpfj){
        this.jpfj = jpfj ;
        this.modify("jpfj",jpfj);
    }

    /**
     * 设置 [原因详情]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [是否支付补偿金]
     */
    public void setSfzfbcj(Integer sfzfbcj){
        this.sfzfbcj = sfzfbcj ;
        this.modify("sfzfbcj",sfzfbcj);
    }

    /**
     * 设置 [是否完成]
     */
    public void setIsfinished(String isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}


