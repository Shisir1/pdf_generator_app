package com.hubberspot;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Hello World", font);
            Image img = Image.getInstance(Paths.get("MLOasBroker.png").toAbsolutePath().toString());
            document.add(new Paragraph(chunk));
            document.add(img);
        } catch (DocumentException | IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            document.close();
        }

    }
}