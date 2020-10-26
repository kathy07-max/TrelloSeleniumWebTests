package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"1DPboard","public"});
        list.add(new Object[]{"1D-Pboard","public"});
        list.add(new Object[]{"12378","public"});
        list.add(new Object[]{"!@#$%&","public"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validBoardsFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Board().setBoardName(split[0]).setBoardVisibility(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
