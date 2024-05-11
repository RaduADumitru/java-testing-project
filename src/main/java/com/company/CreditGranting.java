package com.company;

public class CreditGranting {
    public enum BankResponse {
        CREDIT_APPROVED,
        CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE,
        CREDIT_NOT_APPROVED,
    }

    public static BankResponse evaluateCustomer(boolean isCustomerRetired,
                                                boolean isCustomerEmployed,
                                                boolean isCustomerWorkingForAtLeast6Months,
                                                boolean doesCustomerHaveBadCreditRecords,
                                                boolean doesLevelOfIndebtednessMatchesBankCriterion,
                                                boolean doesCustomerReceiveItsIncomeInOurBank) {
        // mai jos sunt utilizate simbolurile de pe graf pentru a fi mai usor de urmarit codul
        boolean condition1 = isCustomerEmployed && isCustomerWorkingForAtLeast6Months;
        boolean condition2 = condition1 || isCustomerRetired;
        boolean condition3 = !doesCustomerHaveBadCreditRecords;
        boolean condition4 = condition3 && doesLevelOfIndebtednessMatchesBankCriterion;
        boolean condition5 = condition2 && condition4;
        boolean condition6 = condition5 && doesCustomerReceiveItsIncomeInOurBank;

        if (!condition5)
            return BankResponse.CREDIT_NOT_APPROVED;

        if (condition6)
            return BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;

        return BankResponse.CREDIT_APPROVED;
    }
}
