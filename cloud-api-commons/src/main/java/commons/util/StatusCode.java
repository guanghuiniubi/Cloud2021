package commons.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {
    CODE_200(200, "success！"),
    CODE_404(404, "not found"),
    CODE_500(500, "server error"),
    CODE_1001(1001, "操作数据库失败！"),
    CODE_1002(1002, "改字段已存在！"),
    CODE_1003(1003, "参数传递错误！"),
    CODE_1004(1004, "用户名密码错误！"),
    CODE_1005(1005, "未启用！"),
    CODE_1006(1006, "存在关联，请删除关联后再删除！");

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private int code;
    private String message;
}

