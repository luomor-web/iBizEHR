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
 * 实体[异动离职明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYDLZMX",resultMap = "PcmYdlzmxResultMap")
public class PcmYdlzmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 审核状态
     */
    @TableField(exist = false)
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 是否加入黑名单
     */
    @TableField(value = "sfhmd")
    @JSONField(name = "sfhmd")
    @JsonProperty("sfhmd")
    private Integer sfhmd;
    /**
     * 离职理由
     */
    @TableField(value = "yytype")
    @JSONField(name = "yytype")
    @JsonProperty("yytype")
    private String yytype;
    /**
     * 所属组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 人员信息标识
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
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
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 离职面谈附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 原因详情
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 异动离职明细名称
     */
    @TableField(value = "pcmydlzmxname")
    @JSONField(name = "pcmydlzmxname")
    @JsonProperty("pcmydlzmxname")
    private String pcmydlzmxname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 离职日期
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
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
     * 分组类型
     */
    @TableField(exist = false)
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;
    /**
     * 所属职务
     */
    @TableField(exist = false)
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    @JSONField(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;
    /**
     * 离职去向
     */
    @TableField(value = "lzqx")
    @JSONField(name = "lzqx")
    @JsonProperty("lzqx")
    private String lzqx;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 所属岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
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
     * 异动离职明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmydlzmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmydlzmxid")
    @JsonProperty("pcmydlzmxid")
    private String pcmydlzmxid;
    /**
     * 离职面谈人
     */
    @TableField(value = "lzmtrname")
    @JSONField(name = "lzmtrname")
    @JsonProperty("lzmtrname")
    private String lzmtrname;
    /**
     * 人员信息标识
     */
    @TableField(value = "lzmtrid")
    @JSONField(name = "lzmtrid")
    @JsonProperty("lzmtrid")
    private String lzmtrid;
    /**
     * 是否完成
     */
    @DEField(defaultValue = "0")
    @TableField(value = "isfinished")
    @JSONField(name = "isfinished")
    @JsonProperty("isfinished")
    private String isfinished;

    /**
     * 离职面谈人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson lzmtr;



    /**
     * 设置 [是否加入黑名单]
     */
    public void setSfhmd(Integer sfhmd){
        this.sfhmd = sfhmd ;
        this.modify("sfhmd",sfhmd);
    }

    /**
     * 设置 [离职理由]
     */
    public void setYytype(String yytype){
        this.yytype = yytype ;
        this.modify("yytype",yytype);
    }

    /**
     * 设置 [离职面谈附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [原因详情]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [异动离职明细名称]
     */
    public void setPcmydlzmxname(String pcmydlzmxname){
        this.pcmydlzmxname = pcmydlzmxname ;
        this.modify("pcmydlzmxname",pcmydlzmxname);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [备注]
     */
    public void setRemarks(String remarks){
        this.remarks = remarks ;
        this.modify("remarks",remarks);
    }

    /**
     * 设置 [离职去向]
     */
    public void setLzqx(String lzqx){
        this.lzqx = lzqx ;
        this.modify("lzqx",lzqx);
    }

    /**
     * 设置 [离职面谈人]
     */
    public void setLzmtrname(String lzmtrname){
        this.lzmtrname = lzmtrname ;
        this.modify("lzmtrname",lzmtrname);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setLzmtrid(String lzmtrid){
        this.lzmtrid = lzmtrid ;
        this.modify("lzmtrid",lzmtrid);
    }

    /**
     * 设置 [是否完成]
     */
    public void setIsfinished(String isfinished){
        this.isfinished = isfinished ;
        this.modify("isfinished",isfinished);
    }


}


