package com.moxi.utils.FileUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 20:07
 */
@Component
public class ExcelUtil {
    public Boolean isExcel(String fileName){
        String filetype = fileName.substring(fileName.lastIndexOf("."));
        return filetype.equals(".xls")||filetype.equals(".xlsx");
    }
    public void readExcel(MultipartFile file) {
        try {
            XSSFWorkbook work=new XSSFWorkbook(file.getInputStream());
            for(int i=0;i<work.getNumberOfSheets();i++){
                Sheet sheet=work.getSheetAt(i);
                for(int j=sheet.getFirstRowNum();j<=sheet.getLastRowNum();j++){
                    Row row=sheet.getRow(j);
                    if(row==null)continue;
                    for(int y=row.getFirstCellNum();y<=row.getLastCellNum();y++){
                        System.out.println(row.getCell(y));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
