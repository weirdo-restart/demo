package com.weirdo.demo.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.StringUtils;

/**
 * Mapper接口beanName生成策略<br/>
 * 生成规则：calssname(首字母小写)+postfix<br/>
 * Created by luopeng
 * modified by daiqiang
 * on 2015/9/10.
 */
public class MapperBeanNameGenerator implements BeanNameGenerator {

	/**
	 * beanName后缀添加
	 */
	private String postfix = "";

	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String beanClassName = definition.getBeanClassName();

		String beanName = beanClassName;
		int index = beanClassName.lastIndexOf(".");
		if(index != -1){
			beanName = beanClassName.substring(index+1);
		}
		if (beanName.startsWith("I")) {
			beanName = beanName.substring(1);
		}

		//首字母小写
//		beanName = StringUtils.uncapitalize(beanName);
		beanName = uncapitalize(beanName);
		if (!StringUtils.isEmpty(postfix)) {
			beanName += postfix;
		}
		return beanName;
	}

	/**
	 * 首字母小写
	 * @desc 来源于org.apache.commons.lang3.StringUtils
	 * @param str
	 * @return
	 */
	private String uncapitalize(String str) {
		int strLen;
		return str != null && (strLen = str.length()) != 0?(new StringBuilder(strLen)).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString():str;
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
}
