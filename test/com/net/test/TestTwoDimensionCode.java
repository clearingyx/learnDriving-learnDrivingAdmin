package com.net.test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.junit.Test;

import com.net.util.TwoDimensionCode;

/**
 * @包名 com.itnoob.springmvc
 * @类名 TestTwoDimensionCode
 * @作者 snail
 * @创建时间 2015-4-20
 * @描述 TODO
 */
public class TestTwoDimensionCode {
    @Test
    public void testTwiDimensionCodeDecoderQRCode() throws Exception {
        File file = new File("c://Michael_QRCode.png");
        FileInputStream fis = new FileInputStream(file);
        System.out.println(TwoDimensionCode.decoderQRCode(fis));
        System.out.println(TwoDimensionCode.decoderQRCode("c://Michael_QRCode.png"));
        System.out.println(TwoDimensionCode.decoderQRCode(new URL("http://www.51app1.com/image/case/schoolCircleApp.png")));
    }
}
