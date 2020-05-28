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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJZMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJZMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDJZMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动兼职明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDJZMXServiceImpl")
public class PCMYDJZMXServiceImpl extends ServiceImpl<PCMYDJZMXMapper, PCMYDJZMX> implements IPCMYDJZMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;

    private int batchSize = 500;

    @Override
    public PCMYDJZMX getDraft(PCMYDJZMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMYDJZMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDJZMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMYDJZMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMYDJZMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDJZMX rYHG(PCMYDJZMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMYDJZMX get(String key) {
        PCMYDJZMX et = getById(key);
        if(et==null){
            et=new PCMYDJZMX();
            et.setPcmydjzmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDJZMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydjzmxid",et.getPcmydjzmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjzmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDJZMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    @Transactional
    public PCMYDJZMX fillPersonInfo(PCMYDJZMX et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMYDJZMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydjzmxid()))&&(!Objects.isNull(this.getById(et.getPcmydjzmxid())));
    }

    @Override
    @Transactional
    public boolean create(PCMYDJZMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjzmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDJZMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PCMYDJZMX> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PCMYDJZMX>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PCMYDJZMX> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMYDJZMX>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMYDJZMX> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMYDJZMX>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMYDJZMX> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PCMYDJZMX>().eq("ormpostid",ormpostid));
    }


    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PCMYDJZMX> searchGLDS(PCMYDJZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJZMX> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 历史记录查看
     */
    @Override
    public Page<PCMYDJZMX> searchLSJLDS(PCMYDJZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJZMX> pages=baseMapper.searchLSJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDJZMX> searchDefault(PCMYDJZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJZMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMYDJZMX et){
        //实体关系[DER1N_PCMYDJZMX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMYDJZMX_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setJzshortname(ormorgsector.getShortname());
            et.setOrmorgsectorname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_PCMYDJZMX_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getZzdzs());
            et.setJzzzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMYDJZMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
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
    public List<PCMYDJZMX> getPcmydjzmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMYDJZMX> getPcmydjzmxByEntities(List<PCMYDJZMX> entities) {
        List ids =new ArrayList();
        for(PCMYDJZMX entity : entities){
            Serializable id=entity.getPcmydjzmxid();
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


