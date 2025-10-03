package com.arrayHashing;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeDocxFiles {

    // Counter map to track numbering sequence per (listID + level)
    private static Map<String, Integer> counters = new HashMap<>();

    public static void main(String[] args) {
        // Example input
        String inputFiless = "C:\\Users\\user\\Desktop\\Testing\\Sample_ARTCL-000000000000000262.docx";

        String[] inputFiles = {
                inputFiless, inputFiless, inputFiless, inputFiless
        };

        String outputFile = "Combined_Output.docx";

        try (XWPFDocument outputDoc = new XWPFDocument();
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            for (String inputFile : inputFiles) {
                try (FileInputStream fis = new FileInputStream(inputFile);
                     XWPFDocument inputDoc = new XWPFDocument(fis)) {

                    for (XWPFParagraph para : inputDoc.getParagraphs()) {
                        XWPFParagraph newPara = outputDoc.createParagraph();

                        // Copy paragraph formatting
                        newPara.setAlignment(para.getAlignment());
                        newPara.setFirstLineIndent(para.getFirstLineIndent());
                        newPara.setIndentationLeft(para.getIndentationLeft());
                        newPara.setIndentationRight(para.getIndentationRight());
                        newPara.setSpacingAfter(para.getSpacingAfter());
                        newPara.setSpacingBefore(para.getSpacingBefore());

                        // ✅ Handle numbering
                        String numbering = getParagraphNumbering(para);
                        if (!numbering.isEmpty()) {
                            XWPFRun numRun = newPara.createRun();
                            numRun.setBold(true); // numbering bold
                            numRun.setText(numbering + " ");
                        }

                        // ✅ Copy text runs (force bold if heading/numbered)
                        for (XWPFRun run : para.getRuns()) {
                            XWPFRun newRun = newPara.createRun();
                            newRun.setText(run.text());

                            if (!numbering.isEmpty()) {
                                // Force bold if it's a heading/numbered paragraph
                                newRun.setBold(true);
                            } else {
                                // Keep original bold setting for normal body text
                                newRun.setBold(run.isBold());
                            }

                            newRun.setItalic(run.isItalic());
                            newRun.setUnderline(run.getUnderline());
                            newRun.setFontSize(run.getFontSize());
                            newRun.setFontFamily(run.getFontFamily());
                        }
                    }

                    // Add a page break between files (optional)
                    if (!inputFile.equals(inputFiles[inputFiles.length - 1])) {
                        outputDoc.createParagraph().createRun().addBreak(BreakType.PAGE);
                    }
                }
            }

            // Write merged output
            outputDoc.write(fos);
            System.out.println("✅ All files merged successfully into: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extract numbering (decimal, upperLetter, lowerLetter, roman, etc.)
     */
    private static String getParagraphNumbering(XWPFParagraph para) {
        if (para.getNumID() != null) {
            XWPFNumbering numbering = para.getDocument().getNumbering();
            if (numbering != null) {
                XWPFNum num = numbering.getNum(para.getNumID());
                if (num != null) {
                    XWPFAbstractNum absNum = numbering.getAbstractNum(num.getCTNum().getAbstractNumId().getVal());
                    if (absNum != null && para.getNumIlvl() != null) {
                        int level = para.getNumIlvl().intValue();
                        String format = absNum.getAbstractNum().getLvlArray(level).getNumFmt().getVal().toString();

                        // Track sequence per (listID + level)
                        String key = para.getNumID().toString() + "-" + level;
                        int counter = counters.compute(key, (k, v) -> v == null ? 1 : v + 1);

                        return formatNumber(counter, format);
                    }
                }
            }
        }
        return "";
    }

    /**
     * Format numbering according to Word style
     */
    private static String formatNumber(int num, String format) {
        switch (format) {
            case "decimal":
                return num + ".";
            case "upperLetter":
                return (char) ('A' + num - 1) + ".";
            case "lowerLetter":
                return (char) ('a' + num - 1) + ".";
            case "upperRoman":
                return toRoman(num).toUpperCase() + ".";
            case "lowerRoman":
                return toRoman(num).toLowerCase() + ".";
            default:
                return num + ".";
        }
    }

    /**
     * Convert int → Roman numeral
     */
    private static String toRoman(int number) {
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values   = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
