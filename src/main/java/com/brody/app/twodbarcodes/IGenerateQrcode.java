package com.brody.app.twodbarcodes;

import java.awt.image.BufferedImage;

public interface IGenerateQrcode {
	
	BufferedImage generateQRCodeImage(String barcodeText) throws Exception;
	BufferedImage generateQRCodeImage2(String barcodeText) throws Exception;

}
