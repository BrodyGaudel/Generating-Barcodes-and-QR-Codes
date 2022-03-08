package com.brody.app.linearbarcodes;

import java.awt.image.BufferedImage;

public interface IGeneratorEAN13barcode {
	
	BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception;
	BufferedImage generateEAN13BarcodeImage2(String barcodeText) throws Exception;
	BufferedImage generateEAN13BarcodeImage3(String barcodeText) throws Exception;

}
