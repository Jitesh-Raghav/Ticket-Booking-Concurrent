package com.example.ticketbookingconcurrent.Entity;

import com.example.ticketbookingconcurrent.enums.PaymentMode;
import com.example.ticketbookingconcurrent.enums.PaymentProvider;
import com.example.ticketbookingconcurrent.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity(name="payments")
public class Payment extends BaseModel{
    private String referenceNumber;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
