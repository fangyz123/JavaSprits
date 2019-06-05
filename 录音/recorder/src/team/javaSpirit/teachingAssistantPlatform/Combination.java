package team.javaSpirit.teachingAssistantPlatform;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.jim2mov.core.DefaultMovieInfoProvider;
import org.jim2mov.core.ImageProvider;
import org.jim2mov.core.Jim2Mov;
import org.jim2mov.core.MovieInfoProvider;
import org.jim2mov.core.MovieSaveException;
import org.jim2mov.utils.MovieUtils;



public class Combination {

	public Combination() {
		// TODO Auto-generated constructor stub
	}

	public static void play() throws MovieSaveException {
		// jpgs目录放置jpg图片,图片文件名为(1.jpg,2.jpg...)
		String relativelyPath=System.getProperty("user.dir");
		 String  filePath  =  relativelyPath+"//picture//";
		 System.out.println(filePath);
		//final File[] jpgs = new File("E:\\record\\").listFiles();//所有的图片
		final File[] jpgs = new File(filePath).listFiles();//所有的图片
		// 对文件名进行排序(本示例假定文件名中的数字越小,生成视频的帧数越靠前)
		Arrays.sort(jpgs, new Comparator<File>() {//排序接口
			@Override
			public int compare(File file1, File file2) {
				String numberName1 = file1.getName().replace(".jpeg", "");//替换，去掉后缀
				String numberName2 = file2.getName().replace(".jpeg", "");
				return new Integer(numberName1) - new Integer(numberName2);
			}
		});
		for(File f:jpgs) {
			System.out.println(f.getName());
		}
		//DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///E:/recordAVI/out1.avi");//后面这个是转储之后的文件名
		DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///"+relativelyPath+"/pictureToAVI/out1.avi");//后面这个是转储之后的文件名
		dmip.setFPS(4); // 设置每秒帧数,最好和截图的速度一样。比较逼真
		dmip.setNumberOfFrames(jpgs.length); // 总帧数
		dmip.setMWidth(1440);//100
		dmip.setMHeight(860);//200

		new Jim2Mov(new ImageProvider() {
			public byte[] getImage(int frame) {
				try {
					// 设置压缩比
					return MovieUtils.convertImageToJPEG((jpgs[frame]), 1.0f);//1.0
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		}, dmip, null).saveMovie(MovieInfoProvider.TYPE_QUICKTIME_JPEG);//TYPE_AVI_MJPEG
	}
}

