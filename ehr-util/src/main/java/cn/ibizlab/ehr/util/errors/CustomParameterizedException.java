package cn.ibizlab.ehr.util.errors;

import org.zalando.problem.AbstractThrowableProblem;

import java.util.HashMap;
import java.util.Map;

import static org.zalando.problem.Status.BAD_REQUEST;


public class CustomParameterizedException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private static final String PARAM = "param";

    public CustomParameterizedException(String message, String... params) {
        this(message, toParamMap(params));
    }

    public CustomParameterizedException(String message, Map<String, Object> paramMap) {
        super(ErrorConstants.PARAMETERIZED_TYPE, "处理发生异常", BAD_REQUEST, null, null, null, toProblemParameters(message, paramMap));
    }

    public static Map<String, Object> toParamMap(String... params) {
        Map<String, Object> paramMap = new HashMap<>();
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                paramMap.put(PARAM + i, params[i]);
            }
        }
        return paramMap;
    }

    public static Map<String, Object> toProblemParameters(String message, Map<String, Object> paramMap) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", message);
        parameters.put("params", paramMap);
        return parameters;
    }
}
