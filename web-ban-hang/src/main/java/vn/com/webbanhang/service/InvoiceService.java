package vn.com.webbanhang.service;

import vn.com.webbanhang.request.InvoiceRequest;

public interface InvoiceService {
    void createInvoice(InvoiceRequest invoiceRequest);

    void remove(Long id);
}
