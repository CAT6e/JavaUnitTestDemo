package click.bstudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BankAccountTest {

  private BankAccount account;
  private static int count;

  @org.junit.jupiter.api.BeforeAll
  static void start() {
    System.out.println("Start");
    count = 0;
  }

  @org.junit.jupiter.api.BeforeEach
  void setup() {
    account = new BankAccount("elvin", "XCs", 9000, BankAccount.CHECKING);
    System.out.println("Running unit test...");
  }

  @org.junit.jupiter.api.Test
  void deposit() {
    double balance = account.deposit(200, true);
    assertEquals(9200, balance);
  }

  @org.junit.jupiter.api.Test
  void withdraw_branch() throws Exception {
    double balance = account.withdraw(600, true);
    fail("Should've handle exception");
  }

  @org.junit.jupiter.api.Test
  void withdraw_notBranch() throws Exception {
    double balance = account.withdraw(600, false);
    assertEquals(8400, balance);
  }

  @org.junit.jupiter.api.Test
  void getBalance_deposit() throws Exception {
    account.deposit(200, true);
    assertEquals(1200, account.getBalance(), 0);
  }

  @org.junit.jupiter.api.Test
  void getBalance_withdraw() throws Exception {
    account.deposit(200, true);
    assertEquals(8800, account.getBalance(), 0);
  }

  @org.junit.jupiter.api.Test
  void isChecking_true() {
    assertTrue(account.isChecking(), "The account is not a checking account!");
  }

  @org.junit.jupiter.api.AfterEach
  void afterEach() {
    System.out.println("Count = " + count++);
  }

  @org.junit.jupiter.api.AfterAll
  static void tearDown() {
    System.out.println("End");
  }

}