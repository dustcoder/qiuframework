package org.qiu4j.framework;/*
 *@Author:WuRen
 *@Description:请求转发器
 *@date: 19:44 2018/1/6
 */

import org.qiu4j.framework.bean.Handler;
import org.qiu4j.framework.helper.BeanHelper;
import org.qiu4j.framework.helper.ConfigHelper;
import org.qiu4j.framework.helper.ControllerHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispacherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();
        ServletContext servletContext = servletConfig.getServletContext();
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath());
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if(handler != null){
            //获取controller类及其实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //获取请求参数对象
            Map<String,Object> paraMap = new HashMap<String,Object>();
            Enumeration<String> paraNames = req.getParameterNames();
            while (paraNames.hasMoreElements()){
                String paraName = paraNames.nextElement();
                String paraVale = req.getParameter(paraName);
                paraMap.put(paraName,paraVale);
            }
            String body = CodeUtil.


        }


    }
}
