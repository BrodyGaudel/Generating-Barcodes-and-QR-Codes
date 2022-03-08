package com.brody.app.linearbarcodes;

import java.awt.Font;
import java.awt.image.BufferedImage;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

@Service
public class GeneratorEAN13barcode implements IGeneratorEAN13barcode {
	
	private static Font BARCODE_TEXT_FONT= new Font(null);
	
	//Using the Barbecue Library
	public BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
	    Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
	    barcode.setFont(BARCODE_TEXT_FONT);

	    return BarcodeImageHandler.getImage(barcode);
	}
	
	
	//Using the Barcode4j Library
	public BufferedImage generateEAN13BarcodeImage2(String barcodeText) {
	    EAN13Bean barcodeGenerator = new EAN13Bean();
	    BitmapCanvasProvider canvas = 
	      new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

	    barcodeGenerator.generateBarcode(canvas, barcodeText);
	    return canvas.getBufferedImage();
	}
	
	//Using the ZXing Library
	public BufferedImage generateEAN13BarcodeImage3(String barcodeText) throws Exception {
	    EAN13Writer barcodeWriter = new EAN13Writer();
	    BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

}
