/*
Source:
https://leafletjs.com/
https://www.openstreetmap.org/
CSV:
https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv
RAW Data:
https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv
CSV parser MVN
https://mvnrepository.com/artifact/org.apache.commons/commons-csv/1.8

 */

package com.example.springmapofcovid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {

    private Covid19Parse covid19Parse;


    public MapController(Covid19Parse covid19Parse) {
        this.covid19Parse = covid19Parse;
    }

    @GetMapping
    public String getMap(Model model) throws IOException {

        model.addAttribute("points", covid19Parse.getCovidData());


        return "map";

    }


}
