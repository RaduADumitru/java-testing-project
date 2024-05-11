package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class CreditGrantingTest {
    @Test
    public void testTheCasesGeneratedByCauseEffectGraph() {
        // valorile de tip boolean de mai jos se presupun ca sunt obtinute prin intermediul unor API-uri interne ale bancii
        boolean isCustomerRetired;
        boolean isCustomerEmployed;
        boolean isCustomerWorkingForAtLeast6Months;
        boolean doesCustomerHaveBadCreditRecords;
        boolean doesLevelOfIndebtednessMatchesBankCriterion;
        boolean doesCustomerReceiveItsIncomeInOurBank;
        CreditGranting.BankResponse expectedBankResponse;
        CreditGranting.BankResponse bankResponse;

        // coloana 1 din tabelul de decizie
        isCustomerRetired = false;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = false;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 2
        isCustomerRetired = true;
        isCustomerEmployed = false;
        isCustomerWorkingForAtLeast6Months = false;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = false;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 3
        isCustomerRetired = true;
        isCustomerEmployed = false;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = false;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 4
        isCustomerRetired = true;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = false;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = false;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 5
        isCustomerRetired = true;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = false;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 6
        isCustomerRetired = false;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = true;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 7
        isCustomerRetired = true;
        isCustomerEmployed = false;
        isCustomerWorkingForAtLeast6Months = false;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = true;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 8
        isCustomerRetired = true;
        isCustomerEmployed = false;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = true;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 9
        isCustomerRetired = true;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = false;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = true;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);

        // coloana 10
        isCustomerRetired = true;
        isCustomerEmployed = true;
        isCustomerWorkingForAtLeast6Months = true;
        doesCustomerHaveBadCreditRecords = false;
        doesLevelOfIndebtednessMatchesBankCriterion = true;
        doesCustomerReceiveItsIncomeInOurBank = true;
        expectedBankResponse = CreditGranting.BankResponse.CREDIT_APPROVED_WITH_REDUCED_INTEREST_RATE;
        bankResponse = CreditGranting.evaluateCustomer(
                isCustomerRetired,
                isCustomerEmployed,
                isCustomerWorkingForAtLeast6Months,
                doesCustomerHaveBadCreditRecords,
                doesLevelOfIndebtednessMatchesBankCriterion,
                doesCustomerReceiveItsIncomeInOurBank);
        assertEquals(expectedBankResponse, bankResponse);
    }
}
