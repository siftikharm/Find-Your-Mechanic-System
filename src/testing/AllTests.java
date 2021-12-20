package testing;

 import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("FYM Tests")
@SelectClasses({
        TestCustomerService.class,
        TestWorkshopService.class
})
public class AllTests {
    
}