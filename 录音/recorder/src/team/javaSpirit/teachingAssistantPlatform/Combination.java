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
		// jpgsĿ¼����jpgͼƬ,ͼƬ�ļ���Ϊ(1.jpg,2.jpg...)
		String relativelyPath=System.getProperty("user.dir");
		 String  filePath  =  relativelyPath+"//picture//";
		 System.out.println(filePath);
		//final File[] jpgs = new File("E:\\record\\").listFiles();//���е�ͼƬ
		final File[] jpgs = new File(filePath).listFiles();//���е�ͼƬ
		// ���ļ�����������(��ʾ���ٶ��ļ����е�����ԽС,������Ƶ��֡��Խ��ǰ)
		Arrays.sort(jpgs, new Comparator<File>() {//����ӿ�
			@Override
			public int compare(File file1, File file2) {
				String numberName1 = file1.getName().replace(".jpeg", "");//�滻��ȥ����׺
				String numberName2 = file2.getName().replace(".jpeg", "");
				return new Integer(numberName1) - new Integer(numberName2);
			}
		});
		for(File f:jpgs) {
			System.out.println(f.getName());
		}
		//DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///E:/recordAVI/out1.avi");//���������ת��֮����ļ���
		DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("file:///"+relativelyPath+"/pictureToAVI/out1.avi");//���������ת��֮����ļ���
		dmip.setFPS(4); // ����ÿ��֡��,��úͽ�ͼ���ٶ�һ�����Ƚϱ���
		dmip.setNumberOfFrames(jpgs.length); // ��֡��
		dmip.setMWidth(1440);//100
		dmip.setMHeight(860);//200

		new Jim2Mov(new ImageProvider() {
			public byte[] getImage(int frame) {
				try {
					// ����ѹ����
					return MovieUtils.convertImageToJPEG((jpgs[frame]), 1.0f);//1.0
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		}, dmip, null).saveMovie(MovieInfoProvider.TYPE_QUICKTIME_JPEG);//TYPE_AVI_MJPEG
	}
}

