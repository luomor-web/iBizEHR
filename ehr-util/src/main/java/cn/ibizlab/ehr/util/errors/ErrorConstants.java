package cn.ibizlab.ehr.util.errors;

import java.net.URI;

public final class ErrorConstants {

    public static final String ERR_CONCURRENCY_FAILURE = "处理请求发生错误";
    public static final String ERR_VALIDATION = "数据校验发生错误";
    public static final String PROBLEM_BASE_URL = "";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");
    public static final URI PARAMETERIZED_TYPE = URI.create(PROBLEM_BASE_URL + "/parameterized");

    private ErrorConstants() {
    }
}
