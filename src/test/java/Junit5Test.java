import core.config.TestConfigurationFactory;
import core.config.TestSuiteConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.config.DriverInstance.resetDriver;
import static utils.SeleniumCommands.getCommands;

class Junit5Test {

  private static final TestConfigurationFactory TEST_CONFIG = new TestConfigurationFactory();
  private static final String ENV_URL = TestSuiteConfiguration.getInstance().getEnvironment().getUrl();

  @BeforeEach
  void setupTest() {
    TEST_CONFIG.setPlatform();
    TEST_CONFIG.setup();

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