package cn.ibizlab.ehr.util.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Set;

@FeignClient(value = "ibzou-api",fallback = IBZOUFallback.class)
public interface IBZOUFeignClient
{
	/**
	 * 从ou中获取当前上下级组织、部门信息
	 * @param userId
	 * @return
	 */
	@GetMapping("/ibzemployees/{userId}/oumaps")
	Map<String, Set<String>> getOUMapsByUserId(@PathVariable("userId") String userId);

}
