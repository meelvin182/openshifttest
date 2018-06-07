package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class TextUpdater {

    private File getText() {
        return text;
    }

    private File text = new File("testFile");

    void writeSendText(String text) throws IOException {
        FileWriter fileWriter = new FileWriter(getText());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf(text);
        printWriter.close();
    }
}
