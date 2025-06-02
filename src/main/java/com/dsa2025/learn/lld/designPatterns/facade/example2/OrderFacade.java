package com.dsa2025.learn.lld.designPatterns.facade.example2;

public class OrderFacade {

    private ProductDAO productDao;
    private Invoice invoice;
    private Payment payment;
    private SendNotification notification;

    public OrderFacade() {
        productDao = new ProductDAO();
        invoice = new Invoice();
        payment = new Payment();
        notification = new SendNotification();
    }

    public void createOrder(int productId) {
        Product product = productDao.getProduct(productId);
        boolean paymentStatus = payment.makePayment();
        if (paymentStatus) {
            invoice.generateInvoice();
            notification.sendNotification();
            System.out.println("Order creation successful.");
        } else {
            System.out.println("Order creation failed due to payment error.");
        }
    }

}
