package com.kurs.emailclient.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {
    private String address;
    private String password;
    private Properties properties;
    private Store store;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();

        properties.put("incomingHost", "pop3.o2.pl");
        properties.put("mail.store.protocol", "pop3s");
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.o2.pl");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.o2.pl");
        properties.put("mail.pop3.port", "995");
        properties.put("mail.smtps.port", "465");
        properties.put("mail.pop3.ssl.enable", "true");
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
