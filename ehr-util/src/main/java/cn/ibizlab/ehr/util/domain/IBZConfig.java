package cn.ibizlab.ehr.util.domain;

import cn.ibizlab.ehr.util.helper.DataObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;

@TableName(value = "IBZCFG")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IBZConfig {

    /**
     * 配置标识
     * 系统+配置类型+引用对象+用户标识联合主键
     */
    @TableId
    private String cfgId;

    /**
     * 系统标识
     */
    private String systemId;

    /**
     * 配置类型
     * 门户配置/表格自定义配置/自定义查询...消费方自定义
     */
    private String cfgType;

    /**
     * 引用对象
     * 门户页标识/具体表格视图标识...消费方具体使用位置的标识
     */
    private String targetType;

    /**
     * 用户标识
     * 默认当前登录者
     */
    private String userId;

    /**
     * 配置
     * JSONObject
     */
    private String cfg;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp updateDate;

    public String getCfgId()
    {
        if(StringUtils.isEmpty(cfgId)&&
                (!(StringUtils.isEmpty(systemId)))&&
                (!(StringUtils.isEmpty(cfgType)))&&
                (!(StringUtils.isEmpty(targetType)))&&
                (!(StringUtils.isEmpty(userId))))
        {
            cfgId= DigestUtils.md5DigestAsHex((systemId+"||"+cfgType+"||"+targetType+"||"+userId).getBytes());
        }
        return cfgId;
    }


}
