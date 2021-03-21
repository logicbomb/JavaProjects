package com.rukon.mokito.mokitodemo;

public class SomeBusiness {
    private DataService dataService;

    public SomeBusiness(DataService dataService) {
        this.dataService = dataService;
    }

    int findGAllData(){
        int[] data = dataService.retriveAllData();
        int greatest  = Integer.MIN_VALUE;

        for(int value : data){
            if(value > greatest){
                greatest = value;
            }
        }
        return greatest;
    }
}

interface DataService {
    int[] retriveAllData();
}