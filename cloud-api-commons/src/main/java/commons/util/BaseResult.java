package commons.util;

public abstract class BaseResult {


    public static final StatusCode CODE_200 = StatusCode.CODE_200;
    public static final StatusCode CODE_404 = StatusCode.CODE_404;
    public static final StatusCode CODE_500 = StatusCode.CODE_500;
    public static final StatusCode CODE_1001 = StatusCode.CODE_1001;
    public static final StatusCode CODE_1002 = StatusCode.CODE_1002;
    public static final StatusCode CODE_1003 = StatusCode.CODE_1003;
    public static final StatusCode CODE_1004 = StatusCode.CODE_1004;
    public static final StatusCode CODE_1005= StatusCode.CODE_1005;
    public static final StatusCode CODE_1006= StatusCode.CODE_1006;



    public ResponseResult result(int code, String message, Object data) {
        return ResponseResult.builder(code,message,data);

    }


    public ResponseResult successful() {
        return successful(null);

    }

    public ResponseResult successful(Object data) {
        return result(CODE_200.getCode(), CODE_200.getMessage(), data);
    }

    public ResponseResult successful(int code, String message) {
        return result(code, message, null);
    }

    public ResponseResult failure() {
        return failure(CODE_500.getMessage());
    }

    public ResponseResult failure(String message) {
        return failure(CODE_500.getCode(), message);
    }

    public ResponseResult failure(int code, String message, Object data) {
        return result(code, message, data);
    }

    public ResponseResult failure(int code, String message) {

        return result(code, message, null);

    }

}



