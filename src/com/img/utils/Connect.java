package com.img.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Connect {
	 public static Connection druidTest() {
         Connection conn = null;
         try {
             //实例化properties对象用于加载配置文件
             Properties properties = new Properties();
             //类加载器负责加载类的对象
             ClassLoader classLoader = Connect.class.getClassLoader();
             //读取src目录下aaa文件夹下面的数据库配置文件,返回读取指定资源的输入流
             //InputStream inputStream = classLoader.getResourceAsStream("aaa/config.properties");
             // 读取src目录下面的数据库配置文件,返回读取指定资源的输入流
             InputStream inputStream = classLoader.getResourceAsStream("config.properties");
             //从输入流中读取属性列表
             properties.load(inputStream);
             // 创建连接池对象
             DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
             // 从连接池中获取连接
             conn = dataSource.getConnection();
             return conn;
         } catch (Exception e) {
             return conn;
         }
    }
	 
	 
	/*public static Connection druidTest() {
        Connection conn = null;
        // 创建连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/student?useUnicode=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        try {
            // 从连接池中获取连接
            conn = dataSource.getConnection();
            return conn;
        } catch (Exception e) {
            return conn;
        }
   }*/
}
