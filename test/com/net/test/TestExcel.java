package com.net.test;

import java.io.File;

import org.junit.Test;

import com.net.util.ReadWriteExcelUtil;


/**
 * @包名 com.itnoob.springmvc
 * @类名 TestExcel
 * @作者 snail
 * @创建时间 2015-4-20
 * @描述 TODO 
 */
public class TestExcel {
    @Test
    public void testExcel(){
        String fileName = "d:" + File.separator + "test.xls";
        System.out.println(ReadWriteExcelUtil.readExcel(fileName));
        String fileName1 = "d:" + File.separator + "abc.xls";
        ReadWriteExcelUtil.writeExcel(fileName1);
    }
}
