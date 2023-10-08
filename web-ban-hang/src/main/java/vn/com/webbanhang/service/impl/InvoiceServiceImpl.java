package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Invoice;
import vn.com.webbanhang.exception.InvoiceNotFoundException;
import vn.com.webbanhang.repository.InvoiceRepository;
import vn.com.webbanhang.request.InvoiceRequest;
import vn.com.webbanhang.service.CartService;
import vn.com.webbanhang.service.InvoiceService;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CartService cartService;

    @Override
    public void createInvoice(InvoiceRequest invoiceRequest) {

    }

    @Override
    public void remove(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(()
                -> new InvoiceNotFoundException("Invoice Not found"));
        invoice.setStatus("Canceled");
        invoiceRepository.save(invoice);
    }
}
