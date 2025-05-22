package com.dsa2025.learn.lld.solid;

// A class should have only one reason to change... -> S single responsibility
// open for extension but close for modification... -> O open closed


class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice {
    // has a relationship
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return marker.price * this.quantity;
    }

    /*public void printInvoice() {
        //
    }

    public void saveToDb() {
        //
    }*/

    // what single responsibility says a class should have one reason to change as we can see
    // here if gst we have to add in price that is one reason to change another is printing logic
    // and saving the data to db logic so here is 3 reason to change but we should have only one reason to change
    // so what we can do here is we can make diff. classes for both print and save to db.
}

class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }
    public void saveToDb() {
        //
    }
    // I got requirement like i have to save to files also
    // so it is following open closed principle?
    // No open for extension but close for modification
    // but if we want capability extra than we can extend not modify
    /*public void saveToFiles() {
        //
    }*/
}

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }
    public void printInvoice() {
        //
    }

}

//--------Open closed Principle---------------
// This is how we are implementing open for extension close for modification
interface InvoiceDAO {
    public void save(Invoice invoice);
}

class DatabaseDAO implements InvoiceDAO {

    @Override
    public void save(Invoice invoice) {

    }
}

class FileInvoiceDAO implements InvoiceDAO {

    @Override
    public void save(Invoice invoice) {

    }
}


