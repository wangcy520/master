package com.wm.gameplat.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class QRCodeUtil {

    public static void createQRCode() {
        int width = 300;
        int height = 300;
        String format="png";
        String content = "这是一个Java编写的二维码";


        //定义二维码参数
        HashMap ewm = new HashMap();
        ewm.put(EncodeHintType.CHARACTER_SET,"utf-8");
        ewm.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
        ewm.put(EncodeHintType.MARGIN, 5);

        try {
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,ewm);
            Path file = new File("D:/img.png").toPath();
            try {
                MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (
                WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
