package testing;

 import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Build Verification Test")
// Insert the class names in the order of execution
@SelectClasses({
        TestCustomerService.class,
        TestWorkshopService.class
})
public class AllTests {
    
}