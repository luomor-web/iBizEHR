package cn.ibizlab.ehr.core.wf.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.ehr.core.wf.domain.WFAppSetting;
import cn.ibizlab.ehr.core.wf.filter.WFAppSettingSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFAppSettingService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFAppSettingMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流系统设定] 服务对象接口实现
 */
@Slf4j
@Service("WFAppSettingServiceImpl")
public class WFAppSettingServiceImpl extends ServiceImpl<WFAppSettingMapper, WFAppSetting> implements IWFAppSettingService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IMsgTemplateService msgtemplateService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public boolean update(WFAppSetting et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfappsettingid",et.getWfappsettingid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfappsettingid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFAppSetting> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(WFAppSetting et) {
        return (!ObjectUtils.isEmpty(et.getWfappsettingid()))&&(!Objects.isNull(this.getById(et.getWfappsettingid())));
    }

    @Override
    @Transactional
    public boolean save(WFAppSetting et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFAppSetting et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFAppSetting> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WFAppSetting getDraft(WFAppSetting et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public WFAppSetting get(String key) {
        WFAppSetting et = getById(key);
        if(et==null){
            et=new WFAppSetting();
            et.setWfappsettingid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(WFAppSetting et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfappsettingid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFAppSetting> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<WFAppSetting> selectByRemindmsgtemplid(String msgtemplateid) {
        return baseMapper.selectByRemindmsgtemplid(msgtemplateid);
    }

    @Override
    public void removeByRemindmsgtemplid(String msgtemplateid) {
        this.remove(new QueryWrapper<WFAppSetting>().eq("remindmsgtempid",msgtemplateid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFAppSetting> searchDefault(WFAppSettingSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFAppSetting> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFAppSetting>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFAppSetting et){
        //实体关系[DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID]
        if(!ObjectUtils.isEmpty(et.getRemindmsgtemplid())){
            cn.ibizlab.ehr.core.common.domain.MsgTemplate remindmsgtempl=et.getRemindmsgtempl();
            if(ObjectUtils.isEmpty(remindmsgtempl)){
                cn.ibizlab.ehr.core.common.domain.MsgTemplate majorEntity=msgtemplateService.get(et.getRemindmsgtemplid());
                et.setRemindmsgtempl(majorEntity);
                remindmsgtempl=majorEntity;
            }
            et.setRemindmsgtemplname(remindmsgtempl.getMsgtemplatename());
        }
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

}


