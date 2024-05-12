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

        // condition 1
        boolean employedFor6Months = isCustomerEmployed && isCustomerWorkingForAtLeast6Months;

        // condition 2
        boolean employedOrRetired = employedFor6Months || isCustomerRetired;

        // condition 3
        boolean hasGoodCreditRecord = !doesCustomerHaveBadCreditRecords;

        // condition 4
        boolean meetsDebtCriteria = hasGoodCreditRecord && doesLevelOfIndebtednessMatchesBankCriterion;

        // condition 5
        boolean meetsEmploymentAndDebtCriteria = employedOrRetired && meetsDebtCriteria;

        // condition 6
        boolean reduceInterestRate = meetsEmploymentAndDebtCriteria && doesCustomerReceiveItsIncomeInOurBank;

        if (!meetsEmploymentAndDebtCriteria)
            return BankResponse.CREDIT_NOT_APPROVED;

        if (reduceInterestRate)
            return BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;

        return BankResponse.CREDIT_APPROVED;
    }
}
