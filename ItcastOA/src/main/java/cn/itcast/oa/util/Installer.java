package cn.itcast.oa.util;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lkk on 2014/11/11.
 */
@Component
@Transactional
public class Installer {

    @Resource
    SessionFactory sessionFactory;

    public void install() {
        Session session = sessionFactory.getCurrentSession();

        //保存超级管理员
        User user=new User();
        user.setLoginName("admin");
        user.setName("超级管理员");
        user.setPassword(DigestUtils.md5Hex("admin"));
        session.save(user);

        //保存权限数据
        Privilege menu, subMenu1, subMenu2, subMenu3, subMenu4, subMenu5;

        menu = new Privilege("系统管理", null, null);
        subMenu1 = new Privilege("用户管理", "/user_list", menu);
        subMenu2 = new Privilege("部门管理", "/department_list", menu);
        subMenu3 = new Privilege("岗位管理", "/role_list", menu);
        session.save(menu);
        session.save(subMenu1);
        session.save(subMenu2);
        session.save(subMenu3);

        session.save(new Privilege("添加用户", "/user_add", subMenu1));
        session.save(new Privilege("修改用户", "/user_edit", subMenu1));
        session.save(new Privilege("删除用户", "/user_delete", subMenu1));
        session.save(new Privilege("初始化密码", "/user_initPassword", subMenu1));

        session.save(new Privilege("添加部门", "/department_add", subMenu2));
        session.save(new Privilege("修改部门", "/department_edit", subMenu2));
        session.save(new Privilege("删除部门", "/department_delete", subMenu2));

        session.save(new Privilege("添加岗位", "/role_add", subMenu3));
        session.save(new Privilege("修改岗位", "/role_edit", subMenu3));
        session.save(new Privilege("删除岗位", "/role_delete", subMenu3));

        menu = new Privilege("网上交流", null, null);
        subMenu1 = new Privilege("论坛管理", "/forumManage_list", menu);
        subMenu2 = new Privilege("论坛", "/forum_list", menu);
        session.save(menu);
        session.save(subMenu1);
        session.save(subMenu2);

        menu = new Privilege("审批流转", null, null);
        subMenu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
        subMenu2 = new Privilege("申请模板管理", "/template_list", menu);
        subMenu3 = new Privilege("起草申请", "/flow_templateList", menu);
        subMenu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
        subMenu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
        session.save(menu);
        session.save(subMenu1);
        session.save(subMenu2);
        session.save(subMenu3);
        session.save(subMenu4);
        session.save(subMenu5);
    }


    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");

        Installer installer= (Installer) ac.getBean("installer");
        installer.install();
    }
}
