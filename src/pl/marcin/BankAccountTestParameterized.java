package pl.marcin;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class BankAccountTestParameterized {
    private BankAccount account;

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Donald","Trump",1000, BankAccount.CHECKING);
        System.out.println("running a test... ");
    }

    public static Stream<Arguments> testConditions(){
        return Stream.of(
                arguments(100.00,true,1100.00),
                arguments(200.00,true,1200.00),
                arguments(325.14,true,1325.14),
                arguments(489.33,true,1489.33),
                arguments(1000.00,true,2000.00)

        );
    }
    @ParameterizedTest
    @MethodSource("testConditions")
    void deposit(double amount,boolean branch, double expected) throws Exception{
        account.deposit(amount,branch);
        assertEquals(expected,account.getBalance(),.01);
    }
}
