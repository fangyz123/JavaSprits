package team.javaSpirit.teachingAssistantPlatform.upload.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.ShareResource;
import team.javaSpirit.teachingAssistantPlatform.upload.dao.ShareResourceDaoImpl;

/**
 * 
 * <p>
 * Title: ShareResourceServiceImpl
 * </p>
 * <p>
 * Description: 上传文件资源实现的业务逻辑保存到本地和数据库
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月20日
 */
public class ShareResourceServiceImpl {
	/**
	 * 
	 * <p>
	 * Title: saveSelectedFile
	 * </p>
	 * <p>
	 * Description: 将选定的文件上传到指定文章并插入数据库，文件获取失败返回4，文件不存在返回3，读写文件和插入数据失败返回2，成功返回1
	 * </p>
	 * 
	 * @param file
	 * @return
	 */
	public int saveSelectedFile(File file) {
		if (file != null) {// 判断是否获得到了指定文件，避免关闭上传文件框后报错
			if (file.exists()) {
				// 将文件保存到本地
				String oldname = file.getName();
				String sid = Constant.myStudent.getSid();
				Date time = new Date();
				File f = new File("upload");
				File newFile = new File(f.getAbsolutePath() + "/" + sid + "_" + time.getTime()
						+ oldname.substring(oldname.indexOf(".")));
				try {
					newFile.createNewFile();
					InputStream is = new FileInputStream(file);
					OutputStream os = new FileOutputStream(newFile);
					int b;
					while ((b = is.read()) != -1) {
						os.write(b);
					}
					is.close();
					os.close();
					ShareResource sr = new ShareResource();
					sr.setTeacher(null);
					sr.setOldfile(file.getName());
					sr.setNewfile(newFile.getName());
					sr.setUploadtime(time);
					sr.setStu(Constant.myStudent);
					// 将文件保存到数据库
					Object o = ShareResourceDaoImpl.saveUploadResource(sr);
					if (o != null)
						return 1;
					return 2;
				} catch (IOException e) {
					e.printStackTrace();
					return 2;
				}
			} else {
				return 3;
			}
		}
		return 4;
	}

	/**
	 * 
	 * <p>
	 * Title: readResource
	 * </p>
	 * <p>
	 * Description:判断指定资源是否存在，文件不存在返回1，存在返回2
	 * </p>
	 * 
	 * @param sr
	 * @return
	 */
	public String readResource(ShareResource sr) {
		String name = sr.getNewfile();
		File file = new File(new File("upload").getAbsolutePath() + "/" + name);
		if (name == null || name.equals(""))// 文件不存在
			return "1";
		else if (!file.exists()) {
			return "1";// 文件不存在
		} else
			return "2";
	}

	/**
	 * 
	 * <p>
	 * Title: downloadResource
	 * </p>
	 * <p>
	 * Description: 下载文件，文件获取失败返回0，文件不存在返回1，文件读取失败返回2，正常返回3
	 * </p>
	 * 
	 * @param file
	 * @param resource
	 * @return
	 */
	public String downloadResource(File file, ShareResource resource) {
		if (file == null)
			return "0";
		else {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
				return "1";
			}
			if (file.exists()) {
				System.out.println(file.getAbsolutePath());
				try {
					InputStream is = new FileInputStream(
							new File("upload").getAbsolutePath() + "/" + resource.getNewfile());
					OutputStream os = new FileOutputStream(file);
					int b;
					while ((b = is.read()) != -1) {
						os.write(b);
					}
					is.close();
					os.close();
					return "3";
				} catch (IOException e) {
					e.printStackTrace();
					return "2";
				}
			} else
				return "1";
		}
	}
	public List<ShareResource> getResources(){
		List<ShareResource> list=ShareResourceDaoImpl.getAllResources();
		List<ShareResource> resources=new ArrayList();
		for(ShareResource sr:list) {
			if(readResource(sr).equals("2"))
				resources.add(sr);
		}
		return resources;
	}
}
