package com.config.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.config.entity.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeUtils {

	public static String prettyObj(Object obj)
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String createQRCode(String invoice, int width, int height) throws IOException
	{
		
		try {
	        // Tạo mã QR
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(invoice, BarcodeFormat.QR_CODE, width, height);

	        // Chuyển đổi BitMatrix sang BufferedImage
	        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

	        // Mã hóa ảnh sang Base64
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(image, "png", baos);
	        byte[] imageBytes = baos.toByteArray();
	        String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);

	        return imageBase64;
	    } catch (WriterException | IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
//	public static void main(String[] args) throws IOException {
//		String hihi = "Ai quét thì phai mua cho Dat 1kg bánh tráng";
//		
//		System.out.println(QRCodeUtils.createQRCode(hihi, 100, 200));
//	}
}
