package team.javaSpirit.teachingAssistantPlatform.vediotape.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundersToOne {

	public SoundersToOne() {
		// TODO Auto-generated constructor stub
	}

	public void Sound2One() throws UnsupportedAudioFileException, IOException {
		//String path="E://recordyin";
		String relativelyPath=System.getProperty("user.dir");
		String  path  =  relativelyPath+"//voice//";
		
		File filepath=new File(path);//存放音频的路径
		File[] files = null;//路径中所有的音频
		File indexFile = null;//目标参照音频
		File targetfile=new File(path+"//he.wav");
		int length;
		if(filepath.isDirectory()) {
			
			 files=filepath.listFiles();
		}
		
		if(files.length!=0) {
			
			
			
			
			length=files.length;
			System.out.println(length);
			indexFile=new File(path+"//1.wav");
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(indexFile);
			AudioInputStream ais1 = null;
			List<InputStream> inp = new ArrayList<InputStream>();
			//Vector<InputStream> vector = new Vector<InputStream>();
			long sum = 0;
			for (File f:files) {
				ais1 = AudioSystem.getAudioInputStream(f);
				//vector.addElement(ais1);
				
				//f.delete();
				inp.add(ais1);
				
				sum += ais1.getFrameLength();
			}
			Enumeration<InputStream> e = Collections.enumeration(inp);
			//Enumeration<InputStream> e = vector.elements();
			SequenceInputStream sis = new SequenceInputStream(e);
			ais1.getFrameLength();
			AudioInputStream  stream=new AudioInputStream(sis, aff.getFormat(), sum);
			if (sum != 0) {
				AudioSystem.write(stream, aff.getType(), targetfile);
			}
			/*ais1.close();
			sis.close();
			stream.close();*/
			
			if (ais1 != null) {
				
				ais1.close();
				System.out.println("guanbi1");
			}
				
			if (sis != null) {
				sis.close();
				System.out.println("guanbi2");
			}
			
			if(stream!=null) {
				stream.close();
				System.out.println("guanbi3");
			}
		}
	}
	/*public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
		
		 * File f1=new File("E://recordyin//21.wav"); File f2=new
		 * File("E://recordyin//22.wav"); File f3=new File("E://recordyin//key.wav");
		 * AudioFileFormat aff = AudioSystem.getAudioFileFormat(f1); AudioInputStream
		 * ais1 = AudioSystem.getAudioInputStream(f1); AudioInputStream ais2 =
		 * AudioSystem.getAudioInputStream(f2);
		 * 
		 * SequenceInputStream sis = new SequenceInputStream(ais1, ais2);
		 * 
		 * AudioSystem.write(new AudioInputStream(sis, aff.getFormat(),
		 * ais1.getFrameLength() + ais2.getFrameLength()), aff.getType(), f3);
		 * 
		 * if (ais1 != null) ais1.close(); if (ais2 != null) ais2.close(); if (sis !=
		 * null) sis.close();
		 
		
		
		//正确代码，但是现在不用了，整合之前
		
		String path="E://recordyin";
		File filepath=new File(path);
		File[] files = null;
		File indexFile = null;
		File targetfile=new File("E://recordyin//he1.wav");
		int length;
		if(filepath.isDirectory()) {
			
			 files=filepath.listFiles();
		}
		if(filepath.length()!=0) {
			System.out.println(filepath.length());
			Long l=new Long(filepath.length());
			length=l.intValue();
			System.out.println(length);
			indexFile=new File("E://recordyin//1.wav");
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(indexFile);
			AudioInputStream ais1 = null;
			List<InputStream> inp = new ArrayList<InputStream>();
			Vector<InputStream> vector = new Vector<InputStream>();
			long sum = 0;
			for (File f:files) {
				ais1 = AudioSystem.getAudioInputStream(f);
				vector.addElement(ais1);
				//inp.add(ais1);
				
				sum += ais1.getFrameLength();
			}
			//Enumeration<InputStream> e = Collections.enumeration(inp);
			Enumeration<InputStream> e = vector.elements();
			SequenceInputStream sis = new SequenceInputStream(e);
			ais1.getFrameLength();
			if (sum != 0) {
				AudioSystem.write(new AudioInputStream(sis, aff.getFormat(), sum), aff.getType(), targetfile);
			}
			if (ais1 != null)
				ais1.close();
			if (sis != null)
				sis.close();
		}
		

	}
*/
}
