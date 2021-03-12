package commons.util;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController extends BaseResult {
//    protected HttpServletResponse getResponse() {
//        return ServletContextHandler.getResponse();
//    }
//
//    protected HttpServletRequest getRequest() {
//        return ServletContextHandler.getRequest();
//    }

    protected String getUserName(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        return userName;
    }
}


