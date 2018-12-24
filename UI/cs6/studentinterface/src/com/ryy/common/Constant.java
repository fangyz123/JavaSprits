package com.ryy.common;

import java.io.InputStream;

import com.ryy.ui.entity.Students;
/**
 * 
* <p>Title: Constant</p>
* <p>Description: 程序中一些静态量的设置</p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class Constant {
	public static Students myStudent;
	public  InputStream path=this.getClass().getResourceAsStream("/dl.properties");
}
