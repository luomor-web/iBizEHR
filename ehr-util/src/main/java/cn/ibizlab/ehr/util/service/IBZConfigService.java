package cn.ibizlab.ehr.util.service;

import cn.ibizlab.ehr.util.domain.IBZConfig;
import cn.ibizlab.ehr.util.errors.BadRequestAlertException;
import cn.ibizlab.ehr.util.helper.DataObject;
import cn.ibizlab.ehr.util.mapper.IBZConfigMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class IBZConfigService extends ServiceImpl<IBZConfigMapper, IBZConfig> implements IService<IBZConfig> {

    @Value("${ibiz.systemid:ehr}")
	private String systemId;

    @Value("${ibiz.admin.userid:0100}")
    private String adminuserid;

    @Cacheable( value="ehr_configs",key = "'cfgid:'+#p0+'||'+#p1+'||'+#p2")
    public JSONObject getConfig(String cfgType,String targetType,String userId)
    {
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(cfgType)||StringUtils.isEmpty(targetType))
            throw new BadRequestAlertException("获取配置失败，参数缺失","IBZConfig",cfgType);
        IBZConfig config=this.getOne(Wrappers.query(IBZConfig.builder().systemId(systemId).cfgType(cfgType).targetType(targetType).userId(userId).build()),false);
        if(config==null) {
            config=this.getOne(Wrappers.query(IBZConfig.builder().systemId(systemId).cfgType(cfgType).targetType(targetType).userId(adminuserid).build()),false);
            if(config==null) {
                return new JSONObject();
            }
        }
        return JSON.parseObject(config.getCfg());
    }

    @CacheEvict( value="ehr_configs",key = "'cfgid:'+#p0+'||'+#p1+'||'+#p2")
    public boolean saveConfig(String cfgType,String targetType,String userId,JSONObject config)
    {
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(cfgType)||StringUtils.isEmpty(targetType))
            throw new BadRequestAlertException("保存配置失败，参数缺失","IBZConfig",cfgType);
        String cfg="{}";
        if(config!=null)
            cfg=JSONObject.toJSONString(config);
        return this.saveOrUpdate(IBZConfig.builder().systemId(systemId).cfgType(cfgType).targetType(targetType).userId(userId).cfg(cfg).updateDate(DataObject.getNow()).build());
    }

    @CacheEvict( value="ehr_configs",key = "'cfgid:'+#p0+'||'+#p1+'||'+#p2")
    public void resetConfig(String cfgType,String targetType,String userId)
    {
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(cfgType)||StringUtils.isEmpty(targetType))
            throw new BadRequestAlertException("重置配置失败，参数缺失","IBZConfig",cfgType);
        this.remove(Wrappers.query(IBZConfig.builder().systemId(systemId).cfgType(cfgType).targetType(targetType).userId(userId).build()));
    }

}