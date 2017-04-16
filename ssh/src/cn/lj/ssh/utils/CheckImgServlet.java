package cn.lj.ssh.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * 验证码工具
 * 
 * @author Rabit
 * 
 */
public class CheckImgServlet {
	/**
	 * 生成验证码图片
	 * 
	 * @return：返回的是一张BufferedImage图片
	 * @param HttpSession
	 *            session:获取参数方法：ServletActionContext.getRequest().getSession()
	 * @param HttpServletResponse
	 *            response:获得参数方法：ServletActionContext.getResponse()
	 */
	public void checkImage(HttpSession session, HttpServletResponse response) {
		int width = 120;
		int height = 30;

		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width - 1, height - 1);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setFont(new Font("宋体", Font.BOLD, 18));
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int x = 100;
		for (int i = 0; i < 4; i++) {
			graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			int d = random.nextInt(60) - 30;
			double theat = d * Math.PI / 180;
			int index = random.nextInt(word.length());
			char c = word.charAt(index);
			sb.append(c);
			graphics2d.rotate(theat, x, 20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(theat, x, 20);
			x += 30;
		}
		session.setAttribute("checkcode", sb.toString());
		for (int i = 0; i < 30; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(12);
			int y1 = random.nextInt(height);
			int y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x2, y2);
		}
		graphics.dispose();
		try {
			ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);

	}
}
