package com.infoshareacademy.homeworks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradeService {

    public String[][] calculateAverage(String[][] data) {
        if (data==null  ||  data.length == 0) {
            return new String[][]{{}};
        }
        else {
            String pattern = "#.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            List<String> names = Arrays.stream(data).map(i -> i[0]).
                    distinct().sorted().collect(Collectors.toList());

            for (String[] singleData: data) {
                System.out.println(Arrays.toString(singleData));

            }

            String[][] result =new String [names.size()][2];

            for (int i=0; i<names.size(); i++) {
                BigDecimal counter = new BigDecimal("0");
                BigDecimal sum = new BigDecimal("0");
                for (String [] singleData: data) {
                    if (names.get(i).equals(singleData[0])) {
                        sum = sum.add(stringToBigDecimal(singleData[1]));
                        counter = counter.add(BigDecimal.ONE);
                    }
                }
                result[i][0]=names.get(i);
                result[i][1]=String.format("%.2f",Double.valueOf(decimalFormat.format(sum.divide(counter, 2, RoundingMode.UP))));
            }


            return result;
        }
    }
    private BigDecimal stringToBigDecimal(String value) {
        try {
            System.out.println(new BigDecimal(value));
            return new BigDecimal(value);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
