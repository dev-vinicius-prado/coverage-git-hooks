package br.com.devviniciusprado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(0, "123456789");
    }

    @Test
    void shouldCreateBankAccount() {
        Assertions.assertNotNull(bankAccount);
        Assertions.assertEquals(0, bankAccount.getBalance());
        Assertions.assertEquals("123456789", bankAccount.getAccountNumber());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(100.0);
        Assertions.assertEquals(100.0, bankAccount.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-50.0);
        });
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(200.0);
        bankAccount.withdraw(100.0);
        Assertions.assertEquals(100.0, bankAccount.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-50.0);
        });
    }

    @Test
    void testWithdrawInsufficientFunds() {
        bankAccount.deposit(50.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(100.0);
        });
    }

    @Test
    void testCanAfford() {
        bankAccount.deposit(100.0);
        Assertions.assertTrue(bankAccount.canAfford(50.0));
        Assertions.assertFalse(bankAccount.canAfford(150.0));
        Assertions.assertFalse(bankAccount.canAfford(-10.0));
    }

    @Test
    void testTransfer() {
        BankAccount targetAccount = new BankAccount(0, "987654321");
        bankAccount.deposit(200.0);
        bankAccount.transfer(targetAccount, 100.0);

        Assertions.assertEquals(100.0, bankAccount.getBalance());
        Assertions.assertEquals(100.0, targetAccount.getBalance());
    }
}
