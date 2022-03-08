package com.brody.app.restcontroller;

import java.awt.image.BufferedImage;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brody.app.linearbarcodes.IGeneratorEAN13barcode;
import com.brody.app.twodbarcodes.IGenerateQrcode;

@RestController
@RequestMapping("/codes")
public class BarcodesController {
	
	
	private IGeneratorEAN13barcode iGeneratorEAN13barcode;
	private IGenerateQrcode iGenerateQrcode;
	
	
	
	public BarcodesController(IGeneratorEAN13barcode iGeneratorEAN13barcode, IGenerateQrcode iGenerateQrcode) {
		
		this.iGeneratorEAN13barcode = iGeneratorEAN13barcode;
		this.iGenerateQrcode = iGenerateQrcode;
	}



	/*@GetMapping(value = "/bar/barbecue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
    public BufferedImage barbecueEAN13Barcode(@PathVariable("barcode") String barcode)
    throws Exception {
		BufferedImage bufferedImage = iGeneratorEAN13barcode.generateEAN13BarcodeImage(barcode);
		return bufferedImage;
    }*/
	
	@GetMapping(value = "/bar/barcode4j/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
    public BufferedImage barbecueEAN13Barcode2(@PathVariable("barcode") String barcode)
    throws Exception {
        return iGeneratorEAN13barcode.generateEAN13BarcodeImage2(barcode);
    }
	
	@GetMapping(value = "/bar/zxing/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
    public BufferedImage barbecueEAN13Barcode3(@PathVariable("barcode") String barcode)
    throws Exception {
        return iGeneratorEAN13barcode.generateEAN13BarcodeImage3(barcode);
        //5449000000439 exemple of barcode to test
    }
	
	@GetMapping(value = "/qr/zxing/{qrcode}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public BufferedImage generateQRCodeImage(@PathVariable("qrcode") String qrcodeText) throws Exception {
		
		return iGenerateQrcode.generateQRCodeImage(qrcodeText);
	
	}
	
	@GetMapping(value = "/qr/qrgen/{qrcode}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public BufferedImage generateQRCodeImage2(@PathVariable("qrcode") String qrcodeText) throws Exception {
		return iGenerateQrcode.generateQRCodeImage2(qrcodeText);
		
	}

}
