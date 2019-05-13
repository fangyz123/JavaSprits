package team.javaSpirit.teachingAssistantPlatform.facematch;

import java.text.SimpleDateFormat;
import java.util.*;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;

/**
 * 人脸对比
 */
public class FaceMatch {

	
	public static int match(String imagesrc) {
		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
		try {
			String sid = Constant.myStudent.getSid();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String d = dateFormat.format(date);
			byte[] bytes1 = FileUtil.readFileByBytes("faceimg\\"+sid+".jpg");
			byte[] bytes2 = FileUtil.readFileByBytes(imagesrc);
			String image1 = Base64Util.encode(bytes1);
			String image2 = Base64Util.encode(bytes2);

			List<Map<String, Object>> images = new ArrayList<>();

			Map<String, Object> map1 = new HashMap<>();
			map1.put("image", image1);
			map1.put("image_type", "BASE64");
			map1.put("face_type", "LIVE");
			map1.put("quality_control", "LOW");
			map1.put("liveness_control", "NORMAL");

			Map<String, Object> map2 = new HashMap<>();
			map2.put("image", image2);
			map2.put("image_type", "BASE64");
			map2.put("face_type", "LIVE");
			map2.put("quality_control", "LOW");
			map2.put("liveness_control", "NORMAL");

			images.add(map1);
			images.add(map2);

			String param = GsonUtils.toJson(images);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = AuthService.getAuth();

			String result = HttpUtil.post(url, accessToken, "application/json", param);
            String result1 =result.toString().split("\\,")[5];
            String result2 = result1.toString().split("\\:")[2];
            int result3=Integer.parseInt(result2.toString().split("\\.")[0]);
            return result3;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
