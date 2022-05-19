import core.config.TestConfigurationFactory;
import core.config.TestSuiteConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.config.DriverInstance.resetDriver;
import static utils.SeleniumCommands.getCommands;

class Junit5Test {

  private final TestConfigurationFactory testConfig = new TestConfigurationFactory();
  private static final String ENV_URL = TestSuiteConfiguration.getInstance().getEnvironment().getUrl();

  @BeforeEach
  void setupTest() {
    testConfig.setPlatform();
    testConfig.setup();

    getCommands().get(ENV_URL);
  }

  @AfterEach
  void teardown() {
    resetDriver();
  }

  @Test
  void test() {
    // Your test logic here
  }
}