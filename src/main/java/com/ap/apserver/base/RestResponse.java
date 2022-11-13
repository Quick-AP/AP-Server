package com.ap.apserver.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 1iin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {
    private T obj;
    private String comment;
    private int status;

    public static <T> RestResponse<T> ok(T obj) {
        return new RestResponse<T>(obj, null, 1);
    }

    public static <T> RestResponse<T> ok(T obj, String comment) {
        return new RestResponse<T>(obj, null, 1);
    }

    public static <T> RestResponse<T> ok() {
        return new RestResponse<T>(null, null, 1);
    }

    public static <T> RestResponse<T> error(T obj) {
        return new RestResponse<T>(obj, null, -1);
    }

    public static <T> RestResponse<T> error(T obj, String comment) {
        return new RestResponse<T>(obj, null, -1);
    }

    public static <T> RestResponse<T> error(String comment) {
        return new RestResponse<T>(null, comment, -1);
    }

    public static <T> RestResponse<T> error() {
        return new RestResponse<T>(null, null, -1);
    }

}
