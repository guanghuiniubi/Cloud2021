package commons.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        /*    */
    }
    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }


    public String getMessage() {
        return this.message;
    }


    public T getData() {
        return (T) this.data;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ResponseResult)) return false;
        ResponseResult<?> other = (ResponseResult) o;
        if (!other.canEqual(this)) return false;
        if (getCode() != other.getCode()) return false;
        Object this$message = getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        Object this$data = getData();
        Object other$data = other.getData();
        return this$data == null ? other$data == null : this$data.equals(other$data);
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseResult;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + getCode();
        Object $message = getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseResult(code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ")";
    }
    public static <T> ResponseResult builder(int code, String message, Object data) {
        return new ResponseResult(code,message,data);
    }
}
