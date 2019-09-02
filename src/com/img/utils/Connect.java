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
             //ʵ����properties�������ڼ��������ļ�
             Properties properties = new Properties();
             //����������������Ķ���
             ClassLoader classLoader = Connect.class.getClassLoader();
             //��ȡsrcĿ¼��aaa�ļ�����������ݿ������ļ�,���ض�ȡָ����Դ��������
             //InputStream inputStream = classLoader.getResourceAsStream("aaa/config.properties");
             // ��ȡsrcĿ¼��������ݿ������ļ�,���ض�ȡָ����Դ��������
             InputStream inputStream = classLoader.getResourceAsStream("config.properties");
             //���������ж�ȡ�����б�
             properties.load(inputStream);
             // �������ӳض���
             DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
             // �����ӳ��л�ȡ����
             conn = dataSource.getConnection();
             return conn;
         } catch (Exception e) {
             return conn;
         }
    }
	 
	 
	/*public static Connection druidTest() {
        Connection conn = null;
        // �������ӳض���
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/student?useUnicode=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        try {
            // �����ӳ��л�ȡ����
            conn = dataSource.getConnection();
            return conn;
        } catch (Exception e) {
            return conn;
        }
   }*/
}
