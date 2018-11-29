package com.infoshareacademy.homeworks;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GradeService {

    public String[][] calculateAverage(String[][] data) {
        if (data==null  ||  data.length == 0) {
            return new String[][]{{}};
        }
        else {
            Arrays.stream(data).map(datum -> datum[0]).
                    distinct().sorted().collect(Collectors.toList());

            System.out.println(Arrays.stream(data).map(datum -> datum[0]).
                    distinct().sorted().collect(Collectors.toList()));

            String pattern = "#.###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(123456789.123);
            System.out.println(format);
            return new String[][]{{"a"}};
        }
    }
}
