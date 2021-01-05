package net.medavante.portal.utilities;

import com.monitorjbl.xlsx.impl.StreamingRow;
import net.medavante.portal.selenium.core.Configuration;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Excel {

    public static int flag = 0;
    public static Random rand = new Random();
    public static Set<String> identifiers = new HashSet<String>();
    public static String env;
    public static String key;
    public static HashMap<String, String> dataObj;

    Excel(){

    }

    public static String locOfInputExcel ;

    public int totalrows(String testDataFileName, String sheetname) throws IOException {
        if(testDataFileName.equalsIgnoreCase("Test_Modules_Selector"))
        {
            locOfInputExcel = Utilities.getPath()+"/TestData/"+testDataFileName+".xlsx";
        }
        FileInputStream fis = new FileInputStream(locOfInputExcel);
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheet(sheetname);

        return s.getLastRowNum();
    }

    public static HashMap<String, String> getEachExcelRowDataIntoHashMapObj(int currentRowNumber, String testDataFileName) {

        HashMap<String, String> eachTestCaseData = new HashMap<String, String>();

        try {
            if (testDataFileName.equalsIgnoreCase("Test_Modules_Selector"))
            {
                locOfInputExcel = Utilities.getPath()+"/TestData/"+testDataFileName+".xlsx";
            }
            FileInputStream fis = new FileInputStream(locOfInputExcel);
            XSSFWorkbook w = new XSSFWorkbook(fis);
            XSSFSheet s = w.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            FormulaEvaluator evaluator = w.getCreationHelper().createFormulaEvaluator();

            XSSFRow rowWithColumnNames = s.getRow(0);

            // Get 4th Column label
            XSSFCell keyCell = w.getSheetAt(0).getRow(0).getCell(3);
            key = keyCell.toString();
            System.out.println("String Value::"+key);

            XSSFRow rowCurrent = s.getRow(currentRowNumber);
            for (int p = 0; p < rowWithColumnNames.getLastCellNum(); p++) {
                //Ignore the columns without any column name in test case excel file
                if (formatter.formatCellValue(rowWithColumnNames.getCell(p)) == "") {
                    continue;
                }
                String RowValue ;
                Cell cell ;

                StreamingRow streamingrow;

                if (rowCurrent==null){
                    streamingrow = new StreamingRow(currentRowNumber,true);
                    RowValue=formatter.formatCellValue(streamingrow.getCell(p)).trim();
                    cell = streamingrow.getCell(p);
                }
                else {
                    RowValue = formatter.formatCellValue((rowCurrent.getCell(p))).trim();
                    cell = rowCurrent.getCell(p);
                }

                if (cell!=null && cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

                    //Cell refrence to evaluate the cell formula

                    CellReference cellReference = new CellReference(rowCurrent.getCell(p).getReference());
                    Cell formulacell = rowCurrent.getCell(cellReference.getCol());
                    CellValue cellValue = evaluator.evaluate(formulacell);

                    switch (cellValue.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            RowValue = cellValue.getStringValue();
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            RowValue = Double.toString(cellValue.getNumberValue());
                            break;
                    }
                }
                eachTestCaseData.put(formatter.formatCellValue((rowWithColumnNames.getCell(p))).trim(), RowValue);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return eachTestCaseData;
    }


    public static String readLanguageData(int rownumber) throws Exception {
        HashMap<String, String> capsdata = new HashMap<>();
        String LanguageWoorkbookName;

        LanguageWoorkbookName = Configuration.readApplicationFile("localeWorkbook");
        try
        {
            capsdata = getEachExcelRowDataIntoHashMapObj(rownumber,LanguageWoorkbookName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return capsdata.get(key);
    }


}
