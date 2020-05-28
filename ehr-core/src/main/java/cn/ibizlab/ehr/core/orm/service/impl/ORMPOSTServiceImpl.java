package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.ORMPOST;
import cn.ibizlab.ehr.core.orm.filter.ORMPOSTSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMPOSTService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMPOSTMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位集] 服务对象接口实现
 */
@Slf4j
@Service("ORMPOSTServiceImpl")
public class ORMPOSTServiceImpl extends ServiceImpl<ORMPOSTMapper, ORMPOST> implements IORMPOSTService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMBMGWBZService ormbmgwbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPostDetailsService ormpostdetailsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSBDJLService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJZMXService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService pimbyzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(ORMPOST et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMPOST et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMPOST> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMPOST> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ORMPOST et) {
        return (!ObjectUtils.isEmpty(et.getOrmpostid()))&&(!Objects.isNull(this.getById(et.getOrmpostid())));
    }

    @Override
    @Transactional
    public boolean create(ORMPOST et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMPOST> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMPOST get(String key) {
        ORMPOST et = getById(key);
        if(et==null){
            et=new ORMPOST();
            et.setOrmpostid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public ORMPOST setGwJb(ORMPOST et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMPOST et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormpostid",et.getOrmpostid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMPOST> list) {
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
    public ORMPOST getDraft(ORMPOST et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<ORMPOST> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ORMPOST>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 根据选择的组织所属的二级组织来获取岗位(ormorgid)
     */
    @Override
    public Page<ORMPOST> searchEJZZGW(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchEJZZGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 AuthPost
     */
    @Override
    public Page<ORMPOST> searchAuthPost(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchAuthPost(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前操作人的身份选择岗位
     */
    @Override
    public Page<ORMPOST> searchCurOrg(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前组织过滤岗位
     */
    @Override
    public Page<ORMPOST> searchDQGW(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchDQGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前组织过滤岗位(orgid)
     */
    @Override
    public Page<ORMPOST> searchDQORGGW(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchDQORGGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 岗位查询
     */
    @Override
    public Page<ORMPOST> searchGWXH(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchGWXH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMPOST> searchDefault(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部岗位查询
     */
    @Override
    public Page<ORMPOST> searchJZBGWCX(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchJZBGWCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询当前组织所属的二级单位岗位
     */
    @Override
    public Page<ORMPOST> searchCXGW(ORMPOSTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPOST> pages=baseMapper.searchCXGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPOST>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMPOST et){
        //实体关系[DER1N_ORMPOST_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
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
    public List<ORMPOST> getOrmpostByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ORMPOST> getOrmpostByEntities(List<ORMPOST> entities) {
        List ids =new ArrayList();
        for(ORMPOST entity : entities){
            Serializable id=entity.getOrmpostid();
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


