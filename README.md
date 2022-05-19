## Quick Start

The primary use of [gsauto-core-web](https://github.com/gymshark/gsauto-core-web) is the automation of the driver management to be used within a web based automation framework. For using this feature the dependency relies on a number of configuration files to be accessed from `src/test/resources` within the consuming framework.

-   `configuration.yml` Main configuration file which defines the default test configuration parameters.

```yml
- name: DEFAULT
  defaultEnvironment: PROD
  defaultPlatform: DEFAULT
  defaultScope: DEFAULT
  defaultLocalBrowser: CHROME
  defaultOnPrem: true
  defaultHeadless: false
```

-   `environments.yml` Contains the details for the various environments supported within the framework.

```yml
- name: PROD
  url: https://uk.gymshark.com/
  storeCurrency:
  authKey:
```

-   `platforms.yml` Contains the detail of the various platforms used for testing against on local / remote drivers.

```yml
- name: DEFAULT
  os: OS X
  osVersion: Monterey
  browser: Chrome
  browserVersion: 101.0
  viewport: DESKTOP
  width: 1920
  height: 1080
  scope: DEFAULT
```

## Testing frameworks

### Junit5

```java
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
```
