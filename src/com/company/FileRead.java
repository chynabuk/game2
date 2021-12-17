package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead {
    private File file;

    public FileRead(String filename) {
        file = new File("levels/" + filename);
    }

    private String getContentFile() throws Exception {
        try(FileInputStream in = new FileInputStream(file)) {

            int size = (int) file.length();
            char[] array = new char[size];
            int unicode;
            int index = 0;

            int symbolNumber = 0;

            while ((unicode = in.read()) != -1){
                char symbol = (char) unicode;
                if (('0' <= symbol && symbol <= '4') || (symbol == '\n')){
                    symbolNumber++;
                    array[index++] = symbol;
                }
            }

            array[index++] = '\n';

            return new String(array, 0, index);

        }
        catch (FileNotFoundException fnf){
            throw new Exception("File Not Found Exception: " + fnf);
        }
        catch (IOException ioe) {
            throw new Exception("IOException: " + ioe);
        }

    }
    public int[][] getContentInTwoDimensionArray() throws Exception {
        String line = getContentFile();
        int n = line.length();
        int row = 0;
        for (int i = 0; i < n; i++){
            char symbol = line.charAt(i);
            if (symbol == '\n'){
                row++;
            }
        }

        int[][] twoDimensionArray = new int[row][];

        int column = 0;
        int index = 0;

        for (int i = 0; i < n; i++){
            char symbol = line.charAt(i);
            if (symbol != '\n'){
                column++;
            }
            else if (symbol == '\n'){
                twoDimensionArray[index] = new int[column];
                index++;
                column = 0;
            }
        }

        row = 0;
        column = 0;
        for (int i = 0; i < n; i++){
            char symbol = line.charAt(i);

            if (symbol != '\n'){
                twoDimensionArray[row][column] = Integer.parseInt("" + symbol);
                column++;
            }

            else if (symbol == '\n'){
                row++;
                column = 0;
            }
        }

        return twoDimensionArray;

    }
}
