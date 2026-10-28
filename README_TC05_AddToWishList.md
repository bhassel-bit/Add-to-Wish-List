# TC05 – Add to Wish List Automation Test

## Overview
This Java Selenium WebDriver test automates adding a product to the wish list on the [Cloudberry Store](https://cloudberrystore.services/). It signs into an account, navigates to the **Laptops & Notebooks** category, opens the **HP LP3065** product, clicks **Add to Wish List**, and checks whether a success alert is displayed.

## Technologies Used
- Java
- Selenium WebDriver
- Google Chrome / ChromeDriver
- XPath locators
- JavaScriptExecutor for scrolling

## Test Scenario
**Test case:** `TC05_AddToWishList`  
**Goal:** Verify that a logged-in user can add the **HP LP3065** product to their wish list and see a success alert.

### Test Steps
1. Launch Google Chrome.
2. Open `https://cloudberrystore.services/`.
3. Maximize the browser window.
4. Select **My Account** and then **Login**.
5. Enter the account email address and password.
6. Click **Login**.
7. Open **Laptops & Notebooks** from the top navigation menu.
8. Click **Show All Laptops & Notebooks**.
9. Scroll to and select **HP LP3065**.
10. Click the **Add to Wish List** heart button.
11. Check whether a success alert is displayed.
12. Close the browser.

## Prerequisites
- Java JDK installed.
- A Java project with Selenium WebDriver dependencies configured.
- Google Chrome installed and a compatible ChromeDriver available (or Selenium Manager configured to manage the driver).
- A valid Cloudberry Store account.

## How to Run
1. Add `TC05_AddToWishList.java` to the `day7` package in your Java project.
2. Configure the Selenium dependency and Chrome browser support.
3. Provide valid test-account credentials in a secure way before running.
4. Run the `main()` method in `TC05_AddToWishList` from your IDE.
5. Review the console output.

## Expected Result
After clicking **Add to Wish List**, the store displays a success alert and the program prints:

```text
Test Passed
```

If the alert element is found but not displayed, the program prints:

```text
Test Failed
```

**Note:** The current implementation checks only whether the success-alert element is displayed; it does **not** check that the alert text contains the word “Success,” even though that is listed in the test-case comments. If Selenium cannot locate the alert, it may throw an exception instead of printing `Test Failed`.

## Selenium Features Demonstrated
- `ChromeDriver` to launch Chrome.
- `implicitlyWait(Duration.ofSeconds(30))` to wait for element lookup.
- `By.xpath(...)` to locate links, inputs, buttons, and alerts.
- `sendKeys(...)` to fill out the login form.
- `JavascriptExecutor` and `scrollIntoView(...)` to bring the product into view.
- `isDisplayed()` to check whether the success alert is visible.
- `driver.quit()` to end the browser session.

## Suggested Improvements
- **Keep credentials out of source code.** Use environment variables or another secure configuration method, and rotate any credentials previously committed to a repository.
- Replace `Thread.sleep(...)` with explicit waits (`WebDriverWait`) for more reliable execution.
- Verify the alert text actually contains **Success**.
- Use assertions in a testing framework such as JUnit or TestNG for automated pass/fail reporting.
- Put `driver.quit()` in a `finally` block so Chrome closes even when a test step fails.

## Source File
`TC05_AddToWishList.java`
