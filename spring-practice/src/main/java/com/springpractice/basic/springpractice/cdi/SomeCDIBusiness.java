package com.springpractice.basic.springpractice.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {
    @Inject
    SomeCdiDao someCHIDAO;

    public SomeCdiDao getSomeCHIDAO() {
        return someCHIDAO;
    }

    public void setSomeCHIDAO(SomeCdiDao someCHIDAO) {
        this.someCHIDAO = someCHIDAO;
    }
}
