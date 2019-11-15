package com.wm.gameplat.utils;

import com.github.pagehelper.util.StringUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {

    public static void createQRCode(HttpServletResponse resp,String url)  throws IOException {
        if (StringUtil.isEmpty(url)) return;

        ServletOutputStream stream = null;
        try {
            stream = resp.getOutputStream();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            //编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //边框距
            hints.put(EncodeHintType.MARGIN, 0);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bm = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);
            MatrixToImageWriter.writeToStream(bm, "png", stream);
        } catch (WriterException e) {
            e.getStackTrace();

        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

}
