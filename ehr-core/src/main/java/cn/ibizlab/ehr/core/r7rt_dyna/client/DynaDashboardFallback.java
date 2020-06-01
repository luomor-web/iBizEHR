package cn.ibizlab.ehr.core.r7rt_dyna.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaDashboard;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaDashboardSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[DynaDashboard] 服务对象接口
 */
@Component
public class DynaDashboardFallback implements DynaDashboardFeignClient{

    public Page<DynaDashboard> select(){
            return null;
     }

    public Boolean save(DynaDashboard dynadashboard){
            return false;
     }
    public Boolean saveBatch(List<DynaDashboard> dynadashboards){
            return false;
     }

    public DynaDashboard update(String dynadashboardid, DynaDashboard dynadashboard){
            return null;
     }
    public Boolean updateBatch(List<DynaDashboard> dynadashboards){
            return false;
     }


    public DynaDashboard get(String dynadashboardid){
            return null;
     }


    public Boolean remove(String dynadashboardid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public Boolean checkKey(DynaDashboard dynadashboard){
            return false;
     }


    public DynaDashboard getDraft(){
            return null;
    }



    public DynaDashboard create(DynaDashboard dynadashboard){
            return null;
     }
    public Boolean createBatch(List<DynaDashboard> dynadashboards){
            return false;
     }

    public Page<DynaDashboard> searchDefault(DynaDashboardSearchContext context){
            return null;
     }


}
