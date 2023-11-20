package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.model.request.CreateInvoiceRequest;
import com.ecommercewebsite.repository.InvoiceRepository;
import com.ecommercewebsite.service.CartService;
import com.ecommercewebsite.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private CartService cartService;
    @Override
    public void createInvoice(CreateInvoiceRequest invoiceRequest) {

    }

    @Override
    public void removeInvoice(Long id) {

    }
}
