package com.example.springmapofcovid;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19Parse {

    private static final String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public List<Point> getCovidData() throws IOException {

        List<Point> points = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String values = restTemplate.getForObject(url, String.class);

        // StringReader takes an input string and changes it into character stream

        StringReader stringReader = new StringReader(values);

        // it will take firs record after geader (header will be ignored)

        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parse){
            double latitude = Double.parseDouble(strings.get("Lat"));
            double longitude = Double.parseDouble(strings.get("Long"));
            String text = strings.get("5/20/20");
            points.add(new Point(latitude, longitude, text));

        }

        return points;


    }
}





