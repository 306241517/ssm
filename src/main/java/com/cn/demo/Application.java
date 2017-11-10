package com.cn.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("resources")
public class Application {
    private static Logger logger=Logger.getLogger(Application.class);

    //DataSource配置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }


    //提供SqlSession
    @Bean
    public SqlSessionFactory sqlSessionFactory()throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Main start
     */
    public static void main(String [] args) {
        SpringApplication.run(Application.class);
//     int [] arr={3,6,8,2,7,0,1};
//
//
//     System.out.println("排序前的数组为:");
//     for(int num:arr){
//         System.out.print(num+" ");
//     }
//     for(int i=0;i<arr.length-1;i++){
//         for(int j=0;j<arr.length-1-i;j++){
//         if(arr[j]>arr[j+1]){//8 2
//             int temp=arr[j];  //temp=8
//             arr[j]=arr[j+1];
//             arr[j+1]=temp;//j+1=8 --》j=2
//         }
//         }
//     }
//     System.out.print("排序后的数组为：");
//        for(int num:arr){
//            System.out.print(num+" ");
//        }
//    }
//     //   File f=new File("D:\\Test\\1.txt");
//        String s="你好世界";
//        int n=10;
//        FileOutputStream fileOutputStream=null;
//        try {
//            fileOutputStream=new FileOutputStream("D:\\Test\\1.txt");
//            byte[] b1=s.getBytes();
//            byte[] b2="\r\n".getBytes();
//            byte[] b3=String.valueOf(n).getBytes();
//
//                fileOutputStream.write(b1);
//                fileOutputStream.write(b2);
//                fileOutputStream.write(b3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
