package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

// Makes a class implementing the Printable interface.
public class OutputPrinter implements Printable {

    private String printData;

    public OutputPrinter(String printDataIn) {
        this.printData = printDataIn;
    }

    // Writes a constructor that accepts a String parameter and assigns it to the variable printData
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        // Determines whether the requested page is available
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        // Adds page margins for safe printing
        Graphics2D g2d = (Graphics2D) g;
        int x = (int) pf.getImageableX();
        int y = (int) pf.getImageableY();
        g2d.translate(x, y);
        // Styles the font
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        // Calculates the line height
        int lineHeight = metrics.getHeight();
        // Creates a BufferedReader object to read the text to be printed
        BufferedReader br = new BufferedReader(new StringReader(printData));
        // Adds the text to the page
        try {
            String line;
            // Adds 50 pixel margins to the x and y coordinates
            x += 50;
            y += 50;
            while ((line = br.readLine()) != null) {
                y += lineHeight;
                g2d.drawString(line, x, y);
            }
        } catch (IOException e) {
        }
        // Declares that the page exists and that it can be printed
        return PAGE_EXISTS;
    }
}