package com.arrayHashing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.*;

public class DocxReaderWriter {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\user\\Desktop\\Testing\\Sample_ARTCL-000000000000000262.docx"; // input file
        String outputFile = "Output.docx"; // output file

        try (FileInputStream fis = new FileInputStream(inputFile);
             XWPFDocument inputDoc = new XWPFDocument(fis);
             XWPFDocument outputDoc = new XWPFDocument();
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            for (XWPFParagraph para : inputDoc.getParagraphs()) {
                // Create new paragraph in output
                XWPFParagraph newPara = outputDoc.createParagraph();

                // Copy indentation & alignment
                newPara.setAlignment(para.getAlignment());
                newPara.setFirstLineIndent(para.getFirstLineIndent());
                newPara.setIndentationLeft(para.getIndentationLeft());
                newPara.setIndentationRight(para.getIndentationRight());
                newPara.setSpacingAfter(para.getSpacingAfter());
                newPara.setSpacingBefore(para.getSpacingBefore());

                for (XWPFRun run : para.getRuns()) {
                    XWPFRun newRun = newPara.createRun();

                    // Copy text
                    newRun.setText(run.text());

                    // Preserve bold, italic, underline, font size, etc.
                    newRun.setBold(run.isBold());
                    newRun.setItalic(run.isItalic());
                    newRun.setUnderline(run.getUnderline());
                    newRun.setFontSize(run.getFontSize());
                    newRun.setFontFamily(run.getFontFamily());
                }
            }

            // Write output file
            outputDoc.write(fos);
            System.out.println("File written successfully to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
