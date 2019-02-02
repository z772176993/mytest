package com.myspring.project.utils;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {

	public static void main(String[] args) {
		/**
		 * 1.全局配置
		 */
		GlobalConfig config= new GlobalConfig();
		config.setActiveRecord(true)//开启AR模式
				.setAuthor("zkj")//作者
				.setOutputDir("E:\\wslg\\Demo\\src")//生成路径
				.setFileOverride(true)//文件覆盖
				.setIdType(IdType.AUTO)//自增主键策略
				.setServiceName("%sService")//设置生成的service接口名字首字母是否为I
				.setBaseResultMap(true)//生成mapper xml基本里面的ResultMap
				.setBaseColumnList(true);//生成mapperxml 里面的基本 SQL片段
		/**
		 * 2.数据源配置
		 */
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.HSQL)//设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://202.5.16.227:3306/myblog")
				.setUsername("root")
				.setPassword("123456");
		/**
		 *3.策咯配置
		 */
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true)//开启全局大写命名
				.setDbColumnUnderline(true)//表名字段是否下划线
				.setNaming(NamingStrategy.underline_to_camel)//数据库表 下划线转驼峰命名法
//		   .setTablePrefix("tbl_")//数据库表名前缀
				.setInclude("user");//生成的表



		/**
		 *4 .包名配置11
		 */
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent("com.myspring.project")//父包
		.setMapper("mapper")//mapper包
		.setService("service")//service包
				.setXml("mapper")//mapper xml包
				.setController("controller")//controller包
				.setEntity("pojo");//实体类包

		/**
		 *5. 整合配置
		 */
		AutoGenerator autoGenerator = new AutoGenerator();
		autoGenerator.setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(packageConfig);
		//执行
		autoGenerator.execute();
	}


}
