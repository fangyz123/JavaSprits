package com.hhx;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Test {

	

	public static void main(String[] args) throws InterruptedException, AWTException {
		// 创建一个机器人对象

		java.awt.Robot robot = new java.awt.Robot();

		//当前屏幕大小

		Toolkit tk = java.awt.Toolkit.getDefaultToolkit();

		java.awt.Dimension dm = tk.getScreenSize();

		//计算屏幕中心点

		int x = (int) dm.getWidth() / 2;

		int y = (int) dm.getHeight() / 2;

		// 将鼠标移动到屏幕中心

		robot.mouseMove(x, y);

		// 按下鼠标左键

		 robot.mousePress(InputEvent.BUTTON1_MASK);

		// 松开鼠标左键

		 robot.mouseRelease(InputEvent.BUTTON1_MASK);

		// 模拟按下回车键

		robot.keyPress(KeyEvent.VK_ENTER);

		// 模拟放松回车键 

		robot.keyRelease(KeyEvent.VK_ENTER);

		// 按下SHIFT键

		robot.keyPress(KeyEvent.VK_SHIFT);

		 for (int i = 0; i < 10; i++) {

		// 在屏幕上打字

		robot.keyPress('A' + i);

		 robot.keyRelease('A' + i);

		 Thread.sleep(500);

		}

		// 松开SHIFT键

		 robot.keyRelease(KeyEvent.VK_SHIFT);

		 for (int i = 0; i < 11; i++) {

			// 删除操作
	
			 robot.keyPress(KeyEvent.VK_BACK_SPACE);
	
			 robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	
			 Thread.sleep(500);
		}
	}
}

	
