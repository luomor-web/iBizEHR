package cn.ibizlab.ehr.core.r7rt_dyna.service.impl;

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
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaDashboard;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaDashboardSearchContext;
import cn.ibizlab.ehr.core.r7rt_dyna.service.IDynaDashboardService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import cn.ibizlab.ehr.core.r7rt_dyna.client.DynaDashboardFeignClient;

/**
 * 实体[动态数据看板] 服务对象接口实现
 */
@Slf4j
@Service
public class DynaDashboardServiceImpl implements IDynaDashboardService {

    @Autowired
    DynaDashboardFeignClient dynaDashboardFeignClient;


    @Override
    @Transactional
    public boolean save(DynaDashboard et) {
        if(et.getDynadashboardid()==null) et.setDynadashboardid((String)et.getDefaultKey(true));
        if(!dynaDashboardFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<DynaDashboard> list) {
        dynaDashboardFeignClient.saveBatch(list) ;
    }

    @Override
    public boolean update(DynaDashboard et) {
        DynaDashboard rt = dynaDashboardFeignClient.update(et.getDynadashboardid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<DynaDashboard> list){
        dynaDashboardFeignClient.updateBatch(list) ;
    }

    @Override
    public DynaDashboard get(String dynadashboardid) {
		DynaDashboard et=dynaDashboardFeignClient.get(dynadashboardid);
        if(et==null){
            et=new DynaDashboard();
            et.setDynadashboardid(dynadashboardid);
        }
        else{
        }
        return  et;
    }

    @Override
    public boolean remove(String dynadashboardid) {
        boolean result=dynaDashboardFeignClient.remove(dynadashboardid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        dynaDashboardFeignClient.removeBatch(idList);
    }

    @Override
    public boolean checkKey(DynaDashboard et) {
        return dynaDashboardFeignClient.checkKey(et);
    }
    @Override
    public DynaDashboard getDraft(DynaDashboard et) {
        et=dynaDashboardFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean create(DynaDashboard et) {
        DynaDashboard rt = dynaDashboardFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<DynaDashboard> list){
        dynaDashboardFeignClient.createBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DynaDashboard> searchDefault(DynaDashboardSearchContext context) {
        Page<DynaDashboard> dynaDashboards=dynaDashboardFeignClient.searchDefault(context);
        return dynaDashboards;
    }


}



