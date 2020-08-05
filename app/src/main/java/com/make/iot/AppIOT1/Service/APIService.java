package com.make.iot.AppIOT1.Service;

public class APIService {
    private static String base_url = "http://api.openweathermap.org/data/2.5/";

    public static DataService getService() {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
