package com.performance.presence.util;

import com.performance.presence.constant.HttpStatusCodeRange;

public class HttpStatusCodeRangeUtil {
    private HttpStatusCodeRangeUtil() {
    }

    public static HttpStatusCodeRange getRange(int code) {
        if (code >= 200 && code < 300) {
            return HttpStatusCodeRange.SUCCESS_RANGE;
        } else if (code >= 400 && code < 500) {
            return HttpStatusCodeRange.CLIENT_ERROR_RANGE;
        } else {
            return code >= 500 && code < 600 ? HttpStatusCodeRange.SERVER_ERROR_RANGE : HttpStatusCodeRange.UNKNOWN;
        }
    }
}