package pl.marcin;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;
    private static int count;
    @BeforeAll
    public static void beforeClass(){
        System.out.println("this executes before any test cases...Count = " + count++
        );
    }
    @BeforeEach
    public void setup(){
        account = new BankAccount("Marcin","Gasiorek",1000,BankAccount.CHECKING);
        System.out.println("running a test...");
    }


    @Test
    void deposit() throws Exception{
        double balance = account.deposit(200,true);
        assertEquals(1200,balance,0);

    }
    @Test
    void withdraw_notBranchOldVersiot() throws Exception{
        try{
            account.withdraw(600,false);
            fail("Should have thrownm an illegal arg exc");
        }catch(IllegalArgumentException e){

        }
    }
    @Test()
    void withdraw_notbranchThrows() throws Exception{
        assertThrows(IllegalArgumentException.class,() -> {account.withdraw(600,false);
        });

    }
    @Test()
    void withdraw_notbranch() throws Exception{
        double balance = account.withdraw(400,false);
        assertEquals(600,balance,0);

    }

    @Test
    void getBalance_deposit() throws Exception{
        account.deposit(200,true);
        assertEquals(1200.00,account.getBalance(),0);
    }
    @Test
    void getBalance_withdraw() throws Exception{
        account.withdraw(200,true);
        assertEquals(800.00,account.getBalance(),0);
    }
    @Test
    public void isChecking_true(){
        assertTrue(account.isChecking(), "The account is not a checking account");
    }
    @AfterAll
    public static void afterClass(){
        System.out.println("this executes after all methods are executed count = " + count++);
    }
    @AfterEach
    public void tearDown(){
        System.out.println("count = " + count++);
    }


}