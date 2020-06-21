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
import cn.ibizlab.ehr.core.orm.domain.OrmPost;
import cn.ibizlab.ehr.core.orm.filter.OrmPostSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmPostService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmPostMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位] 服务对象接口实现
 */
@Slf4j
@Service("OrmPostServiceImpl")
public class OrmPostServiceImpl extends ServiceImpl<OrmPostMapper, OrmPost> implements IOrmPostService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmBmgwbzService ormbmgwbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostDetailsService ormpostdetailsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsbdjlService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimByzzjlmxService pimbyzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(OrmPost et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmPost et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmPost> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmPost> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(OrmPost et) {
        return (!ObjectUtils.isEmpty(et.getOrmpostid()))&&(!Objects.isNull(this.getById(et.getOrmpostid())));
    }
    @Override
    @Transactional
    public boolean create(OrmPost et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmPost> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmPost get(String key) {
        OrmPost et = getById(key);
        if(et==null){
            et=new OrmPost();
            et.setOrmpostid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public OrmPost setGwJb(OrmPost et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmPost et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormpostid",et.getOrmpostid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmPost> list) {
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
    public OrmPost getDraft(OrmPost et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<OrmPost> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<OrmPost>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 根据选择的组织所属的二级组织来获取岗位(ormorgid)
     */
    @Override
    public Page<OrmPost> searchEJZZGW(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchEJZZGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 AuthPost
     */
    @Override
    public Page<OrmPost> searchAuthPost(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchAuthPost(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前操作人的身份选择岗位
     */
    @Override
    public Page<OrmPost> searchCurOrg(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前组织过滤岗位
     */
    @Override
    public Page<OrmPost> searchDQGW(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchDQGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前组织过滤岗位(orgid)
     */
    @Override
    public Page<OrmPost> searchDQORGGW(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchDQORGGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 岗位查询
     */
    @Override
    public Page<OrmPost> searchGWXH(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchGWXH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmPost> searchDefault(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部岗位查询
     */
    @Override
    public Page<OrmPost> searchJZBGWCX(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchJZBGWCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询当前组织所属的二级单位岗位
     */
    @Override
    public Page<OrmPost> searchCXGW(OrmPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPost> pages=baseMapper.searchCXGW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmPost et){
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
    public List<OrmPost> getOrmpostByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmPost> getOrmpostByEntities(List<OrmPost> entities) {
        List ids =new ArrayList();
        for(OrmPost entity : entities){
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



