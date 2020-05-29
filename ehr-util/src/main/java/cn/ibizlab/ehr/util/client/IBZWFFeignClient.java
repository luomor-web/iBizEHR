package cn.ibizlab.ehr.util.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(value = "ibzwf-api",fallback = IBZWFFallback.class)
public interface IBZWFFeignClient
{
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/tasks")
	List<String> getbusinesskeys(@PathVariable("system") String system, @PathVariable("appname") String appname,
														@PathVariable("entity") String entity, @PathVariable("processDefinitionKey") String processDefinitionKey, @PathVariable("taskDefinitionKey") String taskDefinitionKey);


	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/tasks")
	List<String> getbusinesskeysByUserId(@PathVariable("system") String system,@PathVariable("userId") String userId,
																@PathVariable("entity") String entity,@PathVariable("processDefinitionKey") String processDefinitionKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey);
}
