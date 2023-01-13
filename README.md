# Demo QA
### Automate following cases for https://demoqa.com/
- **Forms -> Practice Form** - fill out the entire form with any valid values, click submit and assert the data on Thanks form.
- **Alerts, Frame & Windows -> Browser Windows** - switching to a new tab/window, checking the text there and switching back.
- **Widgets -> Slider** - drag the slider and check that the numbers in the input are changing.

### Requirements:
- JDK 11
- Git

### How to prepare environment:
1. Download and install Git client from https://git-scm.com/
2. Download and install JDk 11
3. Open CMD and execute following command:
   ```
   git clone https://github.com/VadHead/demo-aqa.git
   ```

### How to run test from CMD:
1. Open CMD
    ```
    cd <demo-qa folder path>
    gradlew clean test -Psuite
    ```
2. Separate test can be executed with following commands:
    ```
    gradlew clean test --tests "com.demoqa.BrowserWindowsTest.openTabTest"
    gradlew clean test --tests "com.demoqa.BrowserWindowsTest.openWindowTest"
    gradlew clean test --tests "com.demoqa.BrowserWindowsTest.openWindowMessageTest"
    gradlew clean test --tests "com.demoqa.FormTest.formSubmitTest"
    gradlew clean test --tests "com.demoqa.SliderTest.sliderRangeTest"
    ```
3. Tests result report generated in the following file:
    ```
    <demo-qa folder>build\reports\tests\test\index.html
    ```