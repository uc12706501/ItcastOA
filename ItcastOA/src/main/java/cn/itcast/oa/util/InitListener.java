package cn.itcast.oa.util;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by lkk on 2014/11/12.
 */
public class InitListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ac= WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        PrivilegeService privilegeService= (PrivilegeService) ac.getBean("privilegeServiceImpl");

        List<Privilege> topPrivilegeList = privilegeService.findTopPrivileges();
        sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
        System.out.print("------------>已经准备数据<-----------");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
