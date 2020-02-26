package com.it.ui;


import com.it.dao.IAccountDao;
import com.it.service.IAccountService;
import com.it.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.sql.rowset.spi.XmlReader;

public class Client {

    /**
     * 獲取spring容器的IOC核心容器 並根據ID獲取對象
     *
     * ApplicationContext的常用三個實現類
     *      ClassPathXmlApplicationContext:  加載類路徑下的配置文件 要求配置文件必須在類路徑下 否則加載不了
     *      FileSystemXmlApplicationContext: 加載磁盤任意路徑下的配置文件(必須有訪問權限)
     *      AnnotationConfigApplicationContext: 讀取註解創建容器
     *
     * 核心容器的兩個街口引發出的問題:
     * ApplicationContext:  單例對象適用
     *      構建核心容器時 創建對象採取的是立即加載的方式 也就是說只要一讀完配置文件馬上就創建配置文件中配置的對象
     * BeanFactory:         多例對象適用
     *      構建核心容器時 創建對象採取的是延遲加載的方式 也就是說根據ID獲取對象時才真正創建了對象
     * @param args
     */

    public static void main(String[] args) {
        //1.獲取核心容器對象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\User\\Desktop\\bean.xml");

        //2.根據ID獲取bean對象

        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();


        //----------BeanFactory
//        Resource resource = new Resource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);


    }
}
