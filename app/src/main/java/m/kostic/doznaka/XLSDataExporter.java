package m.kostic.doznaka;


import android.app.DownloadManager;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

class XLSDataExporter {

    Database database = Database.getInstance();

    boolean export(){

        File path = Environment.getExternalStorageDirectory();
        File doznaka = new File(path, "Doznaka.xls");

        try {
            WritableWorkbook workbook = Workbook.createWorkbook(doznaka);
            WritableSheet sheet = workbook.createSheet("List1", 0);

            formatCells(sheet);

            workbook.write();
            workbook.close();

            database.setDoznaka(doznaka);
            return true;
        }
        catch (IOException | WriteException e) {
            e.printStackTrace();
        }
        return false;
    }

    void formatCells(WritableSheet sheet){
        try {
            //Dio koji se ne mijenja (prvi stupac):
            addCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 0, "Deb. St.", true, Alignment.CENTRE, VerticalAlignment.CENTRE, 0, 0, 0, 2);
            addCell(sheet, Border.ALL, BorderLineStyle.MEDIUM, 1, 0, "V R S T E   D R V E Ć A", true, Alignment.CENTRE, VerticalAlignment.CENTRE, 1, 0, 24, 0);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 3, "12.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 4, "17.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 5, "22.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 6, "27.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 7, "32.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 8, "37.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 9, "42.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 10, "47.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 11, "52.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 12, "57.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 13, "62.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 14, "67.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 15, "72.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 16, "77.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 17, "82.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 18, "87.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 19, "92.5", true, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, 0, 20, "97.5", true, Alignment.CENTRE);
            addCell(sheet, Border.ALL, BorderLineStyle.MEDIUM, 0, 21, "UKUPNO", true, Alignment.CENTRE);
            addCell(sheet, Border.ALL, BorderLineStyle.MEDIUM, 0, 22, "SVEUKUPNO", true, Alignment.LEFT, VerticalAlignment.CENTRE, 0, 22, 20, 22);

            //repetitivni dio kod svake vrste(tekst)
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 1, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 2, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 3, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 4, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 5, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 6, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 7, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 8, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 9, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 10, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 11, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 12, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 13, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 14, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 15, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 16, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 17, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 18, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 19, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 20, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 21, 2, "Ukupno", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 22, 2, "Tarifa", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 23, 2, "N", false, Alignment.CENTRE);
            addCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 24, 2, "Ukupno", false, Alignment.CENTRE);


            int column = 1; //ide po +3 za svaku vrstu

            //glavna polja(unosi)
            for (int i = 0; i < 8; i++) {
                if (database.getTarifa(i) > 0) {
                    for (int j = 0; j < 18; j++) {
                        if (j == 17) {
                            addNumberCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, column, 3 + j, database.getTarifaFromTable(i+1, j), false, Alignment.CENTRE);
                            addNumberCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, column + 1, 3 + j, database.getSumaVrstaInputCount(i, j), false, Alignment.CENTRE);
                        } else {
                            addNumberCell(sheet, Border.ALL, BorderLineStyle.THIN, column, 3 + j, database.getTarifaFromTable(i+1, j), false, Alignment.CENTRE);
                            addNumberCell(sheet, Border.ALL, BorderLineStyle.THIN, column + 1, 3 + j, database.getSumaVrstaInputCount(i ,j), false, Alignment.CENTRE);

                        }
                    }

                } else { //prazna polja
                    for (int j = 0; j < 18; j++) {
                        if (j == 17) {
                            addNumberCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, column, 3 + j, 0, false, Alignment.CENTRE);
                            addNumberCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, column + 1, 3 + j, 0, false, Alignment.CENTRE);

                        } else {
                            addNumberCell(sheet, Border.ALL, BorderLineStyle.THIN, column, 3 + j, 0, false, Alignment.CENTRE);
                            addNumberCell(sheet, Border.ALL, BorderLineStyle.THIN, column + 1, 3 + j, 0, false, Alignment.CENTRE);

                        }
                    }
                }

                //string ime svake vrste
                if (database.getVrsta(i) != "") {
                    addCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, column, 1, database.getVrsta(i).toUpperCase(), true, Alignment.CENTRE, VerticalAlignment.CENTRE, column, 1, column + 2, 1);
                } else {
                    addCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.MEDIUM, column, 1, "VRSTA", true, Alignment.CENTRE, VerticalAlignment.CENTRE, column, 1, column + 2, 1);
                }

                //inkrement svake vrste u novi dio
                column += 3;
                if (column > 23)
                    column = 1;

            }

            //UKUPNO volumen sa ASCII za slova  u excelu
            int ukupnoColumn = 3;
            for (int i = 0; i < 24; i += 3) {
                for (int j = 0; j < 18; j++) {
                    addFormulaCell(sheet, Border.TOP, BorderLineStyle.THIN, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.THIN, Border.LEFT, BorderLineStyle.THIN, ukupnoColumn, 3 + j, String.format("%c%d*%c%d", 66 + i, 4 + j, 67 + i, 4 + j), false, Alignment.CENTRE);
                }

                ukupnoColumn += 3;
                if (ukupnoColumn > 25)
                    ukupnoColumn = 3;
            }
            //SUM polja UKUPNO
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 3, 21, "D4+D5+D6+D7+D8+D9+D10+D11+D12+D13+D14+D15+D16+D17+D18+D19+D20+D21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 6, 21, "G4+G5+G6+G7+G8+G9+G10+G11+G12+G13+G14+G15+G16+G17+G18+G19+G20+G21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 9, 21, "J4+J5+J6+J7+J8+J9+J10+J11+J12+J13+J14+J15+J16+J17+J18+J19+J20+J21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 12, 21, "M4+M5+M6+M7+M8+M9+M10+M11+M12+M13+M14+M15+M16+M17+M18+M19+M20+M21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 15, 21, "P4+P5+P6+P7+P8+P9+P10+P11+P12+P13+P14+P15+P16+P17+P18+P19+P20+P21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 18, 21, "S4+S5+S6+S7+S8+S9+S10+S11+S12+S13+S14+S15+S16+S17+S18+S19+S20+S21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 21, 21, "V4+V5+V6+V7+V8+V9+V10+V11+V12+V13+V14+V15+V16+V17+V18+V19+V20+V21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.MEDIUM, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 24, 21, "Y4+Y5+Y6+Y7+Y8+Y9+Y10+Y11+Y12+Y13+Y14+Y15+Y16+Y17+Y18+Y19+Y20+Y21", false, Alignment.CENTRE);


            //SUM polja VRSTA (N)
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 2, 21, "C4+C5+C6+C7+C8+C9+C10+C11+C12+C13+C14+C15+C16+C17+C18+C19+C20+C21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 5, 21, "F4+F5+F6+F7+F8+F9+F10+F11+F12+F13+F14+F15+F16+F17+F18+F19+F20+F21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 8, 21, "I4+I5+I6+I7+I8+I9+I10+I11+I12+I13+I14+I15+I16+I17+I18+I19+I20+I21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 11, 21, "L4+L5+L6+L7+L8+L9+L10+L11+L12+L13+L14+L15+L16+L17+L18+L19+L20+L21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 14, 21, "O4+O5+O6+O7+O8+O9+O10+O11+O12+O13+O14+O15+O16+O17+O18+O19+O20+O21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 17, 21, "R4+R5+R6+R7+R8+R9+R10+R11+R12+R13+R14+R15+R16+R17+R18+R19+R20+R21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 20, 21, "U4+U5+U6+U7+U8+U9+U10+U11+U12+U13+U14+U15+U16+U17+U18+U19+U20+U21", false, Alignment.CENTRE);
            addFormulaCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.THIN, 23, 21, "X4+X5+X6+X7+X8+X9+X10+X11+X12+X13+X14+X15+X16+X17+X18+X19+X20+X21", false, Alignment.CENTRE);


            //polje W22 koje petlja ne popuni (praznina)
            addCell(sheet, Border.TOP, BorderLineStyle.MEDIUM, Border.RIGHT, BorderLineStyle.THIN, Border.BOTTOM, BorderLineStyle.MEDIUM, Border.LEFT, BorderLineStyle.MEDIUM, 22, 21, "", false, Alignment.CENTRE);

            //SUM Sveukupno
            addFormulaCell(sheet, Border.ALL, BorderLineStyle.MEDIUM, 21, 22, "C22+F22+I22+L22+O22+R22+U22+X22", true, Alignment.CENTRE, VerticalAlignment.CENTRE, 21, 22, 22, 22);
            addFormulaCell(sheet, Border.ALL, BorderLineStyle.MEDIUM, 23, 22, "D22+G22+J22+M22+P22+S22+V22+Y22", true, Alignment.CENTRE, VerticalAlignment.CENTRE, 23, 22, 24, 22);
        } catch (WriteException | NullPointerException e) {
            e.printStackTrace();
        }


    }



    void addFormulaCell(WritableSheet sheet, Border border, BorderLineStyle borderLineStyle, int col, int row, String form , boolean bold, Alignment alignment, VerticalAlignment verticalAlignment, int mergeX1,int mergeY1, int mergeX2, int mergeY2) throws WriteException {
        if (bold) {
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Formula formula = new Formula(col, row, form, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(formula);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Formula formula = new Formula(col, row, form, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(formula);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    void addFormulaCell(WritableSheet sheet, Border borderTop, BorderLineStyle borderLineStyleTop, Border borderRight, BorderLineStyle borderLineStyleRight, Border borderBottom, BorderLineStyle borderLineStyleBottom, Border borderLeft, BorderLineStyle borderLineStyleLeft, int col, int row,String form, boolean bold, Alignment alignment) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Formula formula = new Formula(col, row, form, cellFormat);
                sheet.addCell(formula);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Formula formula = new Formula(col, row, form, cellFormat);
                sheet.addCell(formula);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    void addNumberCell(WritableSheet sheet, Border border, BorderLineStyle borderLineStyle, int col, int row, double value, boolean bold, Alignment alignment) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                Number number = new Number(col, row, value, cellFormat);
                sheet.addCell(number);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                Number number = new Number(col, row, value, cellFormat);
                sheet.addCell(number);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    void addNumberCell(WritableSheet sheet, Border borderTop, BorderLineStyle borderLineStyleTop, Border borderRight, BorderLineStyle borderLineStyleRight, Border borderBottom, BorderLineStyle borderLineStyleBottom, Border borderLeft, BorderLineStyle borderLineStyleLeft, int col, int row,double value, boolean bold, Alignment alignment) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Number number = new Number(col, row, value, cellFormat);
                sheet.addCell(number);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Number number = new Number(col, row, value, cellFormat);
                sheet.addCell(number);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }

    }

    void addCell(WritableSheet sheet, Border borderTop, BorderLineStyle borderLineStyleTop, Border borderRight, BorderLineStyle borderLineStyleRight, Border borderBottom, BorderLineStyle borderLineStyleBottom, Border borderLeft, BorderLineStyle borderLineStyleLeft, int col, int row, String desc, boolean bold, Alignment alignment, VerticalAlignment verticalAlignment, int mergeX1,int mergeY1, int mergeX2, int mergeY2) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else {
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(label);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    void addCell(WritableSheet sheet, Border border, BorderLineStyle borderLineStyle, int col, int row, String desc, boolean bold, Alignment alignment, VerticalAlignment verticalAlignment, int mergeX1,int mergeY1, int mergeX2, int mergeY2) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else {
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                cellFormat.setVerticalAlignment(verticalAlignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.mergeCells(mergeX1, mergeY1, mergeX2, mergeY2);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    void addCell(WritableSheet sheet, Border borderTop, BorderLineStyle borderLineStyleTop, Border borderRight, BorderLineStyle borderLineStyleRight, Border borderBottom, BorderLineStyle borderLineStyleBottom, Border borderLeft, BorderLineStyle borderLineStyleLeft, int col, int row, String desc, boolean bold, Alignment alignment) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else {
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(borderTop, borderLineStyleTop);
                cellFormat.setBorder(borderRight, borderLineStyleRight);
                cellFormat.setBorder(borderBottom, borderLineStyleBottom);
                cellFormat.setBorder(borderLeft, borderLineStyleLeft);
                cellFormat.setAlignment(alignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    void addCell(WritableSheet sheet, Border border, BorderLineStyle borderLineStyle, int col, int row, String desc, boolean bold, Alignment alignment) throws WriteException{
        if(bold){
            try {
                WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
                cellFont.setBoldStyle(WritableFont.BOLD);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBorder(border, borderLineStyle);
                cellFormat.setAlignment(alignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
        else {
            try {
                WritableCellFormat cellFormat = new WritableCellFormat();
                cellFormat.setBorder(border, borderLineStyle);

                cellFormat.setAlignment(alignment);
                Label label = new Label(col, row, desc, cellFormat);
                sheet.addCell(label);
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}
