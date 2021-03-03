package com.springpractice.basic.springpractice.xml;

import org.springframework.stereotype.Component;

@Component
public class XMLPersonDao {

    XMLJdbcConnection xmlJdbcConnection;

    public XMLJdbcConnection getXMLJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXMLJdbcConnection(XMLJdbcConnection jdbcConnection) {
        this.xmlJdbcConnection = jdbcConnection;
    }
}
