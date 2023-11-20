package com.ecommercewebsite.service;

import com.ecommercewebsite.model.request.CreateInvoiceRequest;

public interface InvoiceService {
    void createInvoice(CreateInvoiceRequest invoiceRequest);

    void removeInvoice(Long id);
}
