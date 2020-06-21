package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMGxxkTemp;
import cn.ibizlab.ehr.core.pcm.filter.PCMGxxkTempSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMGxxkTempService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMGxxkTempMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[高校学科中间表] 服务对象接口实现
 */
@Slf4j
@Service("PCMGxxkTempServiceImpl")
public class PCMGxxkTempServiceImpl extends ServiceImpl<PCMGxxkTempMapper, PCMGxxkTemp> implements IPCMGxxkTempService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmGxmlService pcmgxmlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXkmlService pcmxkmlService;

    private int batchSize = 500;

    @Override
    public PCMGxxkTemp getDraft(PCMGxxkTemp et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMGxxkTemp et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmgxxktempid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMGxxkTemp> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

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
    public boolean checkKey(PCMGxxkTemp et) {
        return (!ObjectUtils.isEmpty(et.getPcmgxxktempid()))&&(!Objects.isNull(this.getById(et.getPcmgxxktempid())));
    }
    @Override
    @Transactional
    public boolean save(PCMGxxkTemp et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMGxxkTemp et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMGxxkTemp> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMGxxkTemp> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMGxxkTemp get(String key) {
        PCMGxxkTemp et = getById(key);
        if(et==null){
            et=new PCMGxxkTemp();
            et.setPcmgxxktempid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMGxxkTemp et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmgxxktempid",et.getPcmgxxktempid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmgxxktempid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMGxxkTemp> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PCMGxxkTemp> selectByPcmgxmlid(String pcmgxmlid) {
        return baseMapper.selectByPcmgxmlid(pcmgxmlid);
    }

    @Override
    public void removeByPcmgxmlid(String pcmgxmlid) {
        this.remove(new QueryWrapper<PCMGxxkTemp>().eq("pcmgxmlid",pcmgxmlid));
    }

	@Override
    public List<PCMGxxkTemp> selectByPcmxkmlid(String pcmxkmlid) {
        return baseMapper.selectByPcmxkmlid(pcmxkmlid);
    }

    @Override
    public void removeByPcmxkmlid(String pcmxkmlid) {
        this.remove(new QueryWrapper<PCMGxxkTemp>().eq("pcmxkmlid",pcmxkmlid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMGxxkTemp> searchDefault(PCMGxxkTempSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGxxkTemp> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGxxkTemp>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMGxxkTemp et){
        //实体关系[DER1N_PCMGXXKTEMP_PCMGXML_PCMGXMLID]
        if(!ObjectUtils.isEmpty(et.getPcmgxmlid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmGxml pcmgxml=et.getPcmgxml();
            if(ObjectUtils.isEmpty(pcmgxml)){
                cn.ibizlab.ehr.core.pcm.domain.PcmGxml majorEntity=pcmgxmlService.get(et.getPcmgxmlid());
                et.setPcmgxml(majorEntity);
                pcmgxml=majorEntity;
            }
            et.setNd(pcmgxml.getNd());
            et.setPcmgxmlname(pcmgxml.getPcmgxmlname());
        }
        //实体关系[DER1N_PCMGXXKTEMP_PCMXKML_PCMXKMLID]
        if(!ObjectUtils.isEmpty(et.getPcmxkmlid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmXkml pcmxkml=et.getPcmxkml();
            if(ObjectUtils.isEmpty(pcmxkml)){
                cn.ibizlab.ehr.core.pcm.domain.PcmXkml majorEntity=pcmxkmlService.get(et.getPcmxkmlid());
                et.setPcmxkml(majorEntity);
                pcmxkml=majorEntity;
            }
            et.setNd2(pcmxkml.getNd());
            et.setPcmxkmlname(pcmxkml.getPcmxkmlname());
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

    @Override
    public List<PCMGxxkTemp> getPcmgxxktempByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMGxxkTemp> getPcmgxxktempByEntities(List<PCMGxxkTemp> entities) {
        List ids =new ArrayList();
        for(PCMGxxkTemp entity : entities){
            Serializable id=entity.getPcmgxxktempid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



