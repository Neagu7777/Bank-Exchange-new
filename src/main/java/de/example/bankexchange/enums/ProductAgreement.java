package de.example.bankexchange.enums;

import com.fasterxml.jackson.annotation.JsonSubTypes;

public enum ProductAgreement {

        PERSONAL_LOAN,
        MORTGAGE,
        CAR_LOAN,
        STUDENT_LOAN,
        BUSINESS_LOAN, DEFAULT_VALUE;


        public static JsonSubTypes.Type getDefault() {
            return null;
        }
}
