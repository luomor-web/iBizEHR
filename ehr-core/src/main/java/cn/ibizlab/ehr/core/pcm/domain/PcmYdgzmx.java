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
 * 实体[异动挂职明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMYDGZMX",resultMap = "PcmYdgzmxResultMap")
public class PcmYdgzmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核状态
     */
    @TableField(exist = false)
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 所属组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 外部岗位
     */
    @TableField(value = "wbgw")
    @JSONField(name = "wbgw")
    @JsonProperty("wbgw")
    private String wbgw;
    /**
     * 剩余月份颜色
     */
    @TableField(exist = false)
    @JSONField(name = "syyf_color")
    @JsonProperty("syyf_color")
    private String syyfColor;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 挂职结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 挂职类型
     */
    @TableField(value = "gztype")
    @JSONField(name = "gztype")
    @JsonProperty("gztype")
    private String gztype;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 外部组织机构代码
     */
    @TableField(value = "wwzzid")
    @JSONField(name = "wwzzid")
    @JsonProperty("wwzzid")
    private String wwzzid;
    /**
     * 出生日期
     */
    @TableField(exist = false)
    @JSONField(name = "csrq")
    @JsonProperty("csrq")
    private Timestamp csrq;
    /**
     * 联系电话
     */
    @TableField(exist = false)
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 挂职开始日期
     */
    @TableField(value = "ksrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ksrq" , format="yyyy-MM-dd")
    @JsonProperty("ksrq")
    private Timestamp ksrq;
    /**
     * 异动挂职明细名称
     */
    @TableField(value = "pcmydgzmxname")
    @JSONField(name = "pcmydgzmxname")
    @JsonProperty("pcmydgzmxname")
    private String pcmydgzmxname;
    /**
     * 职级
     */
    @TableField(exist = false)
    @JSONField(name = "yrank")
    @JsonProperty("yrank")
    private String yrank;
    /**
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * 是否到期
     */
    @TableField(exist = false)
    @JSONField(name = "sfdq")
    @JsonProperty("sfdq")
    private String sfdq;
    /**
     * 人员信息标识
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 生效日期
     */
    @TableField(exist = false)
    @JSONField(name = "sxrq")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 所属岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 是否审核
     */
    @TableField(exist = false)
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;
    /**
     * 剩余月份
     */
    @TableField(exist = false)
    @JSONField(name = "syyf")
    @JsonProperty("syyf")
    private Integer syyf;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 异动挂职明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmydgzmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmydgzmxid")
    @JsonProperty("pcmydgzmxid")
    private String pcmydgzmxid;
    /**
     * 分组类型
     */
    @TableField(exist = false)
    @JSONField(name = "pcmydmxtype")
    @JsonProperty("pcmydmxtype")
    private String pcmydmxtype;
    /**
     * 挂职进人员信息id（应聘者信息）
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;
    /**
     * 外部组织
     */
    @TableField(value = "wbzz")
    @JSONField(name = "wbzz")
    @JsonProperty("wbzz")
    private String wbzz;
    /**
     * 外部职务
     */
    @TableField(value = "wbzw")
    @JSONField(name = "wbzw")
    @JsonProperty("wbzw")
    private String wbzw;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 外部部门
     */
    @TableField(value = "wbbm")
    @JSONField(name = "wbbm")
    @JsonProperty("wbbm")
    private String wbbm;
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
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
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
     * 所属职务
     */
    @TableField(exist = false)
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;



    /**
     * 设置 [外部岗位]
     */
    public void setWbgw(String wbgw){
        this.wbgw = wbgw ;
        this.modify("wbgw",wbgw);
    }

    /**
     * 设置 [挂职结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [挂职结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [挂职类型]
     */
    public void setGztype(String gztype){
        this.gztype = gztype ;
        this.modify("gztype",gztype);
    }

    /**
     * 设置 [外部组织机构代码]
     */
    public void setWwzzid(String wwzzid){
        this.wwzzid = wwzzid ;
        this.modify("wwzzid",wwzzid);
    }

    /**
     * 设置 [挂职开始日期]
     */
    public void setKsrq(Timestamp ksrq){
        this.ksrq = ksrq ;
        this.modify("ksrq",ksrq);
    }

    /**
     * 格式化日期 [挂职开始日期]
     */
    public String formatKsrq(){
        if (this.ksrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(ksrq);
    }
    /**
     * 设置 [异动挂职明细名称]
     */
    public void setPcmydgzmxname(String pcmydgzmxname){
        this.pcmydgzmxname = pcmydgzmxname ;
        this.modify("pcmydgzmxname",pcmydgzmxname);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [挂职进人员信息id（应聘者信息）]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }

    /**
     * 设置 [外部组织]
     */
    public void setWbzz(String wbzz){
        this.wbzz = wbzz ;
        this.modify("wbzz",wbzz);
    }

    /**
     * 设置 [外部职务]
     */
    public void setWbzw(String wbzw){
        this.wbzw = wbzw ;
        this.modify("wbzw",wbzw);
    }

    /**
     * 设置 [外部部门]
     */
    public void setWbbm(String wbbm){
        this.wbbm = wbbm ;
        this.modify("wbbm",wbbm);
    }


}


