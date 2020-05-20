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
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[DynaDashboard] 服务对象接口
 */
@FeignClient(value = "r7rt-dyna", contextId = "DynaDashboard", fallback = DynaDashboardFallback.class)
public interface DynaDashboardFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/select")
    Page<DynaDashboard> select();


    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/save")
    Boolean save(@RequestBody DynaDashboard dynadashboard);

    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/save")
    Boolean saveBatch(@RequestBody List<DynaDashboard> dynadashboards);


    @RequestMapping(method = RequestMethod.PUT, value = "/dynadashboards/{dynadashboardid}")
    DynaDashboard update(@PathVariable("dynadashboardid") String dynadashboardid,@RequestBody DynaDashboard dynadashboard);

    @RequestMapping(method = RequestMethod.PUT, value = "/dynadashboards/batch")
    Boolean updateBatch(@RequestBody List<DynaDashboard> dynadashboards);


    @RequestMapping(method = RequestMethod.GET, value = "/dynadashboards/{dynadashboardid}")
    DynaDashboard get(@PathVariable("dynadashboardid") String dynadashboardid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/dynadashboards/{dynadashboardid}")
    Boolean remove(@PathVariable("dynadashboardid") String dynadashboardid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/dynadashboards/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/checkkey")
    Boolean checkKey(@RequestBody DynaDashboard dynadashboard);


    @RequestMapping(method = RequestMethod.GET, value = "/dynadashboards/getdraft")
    DynaDashboard getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards")
    DynaDashboard create(@RequestBody DynaDashboard dynadashboard);

    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/batch")
    Boolean createBatch(@RequestBody List<DynaDashboard> dynadashboards);



    @RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/searchdefault")
    Page<DynaDashboard> searchDefault(@RequestBody DynaDashboardSearchContext context);


}
