//package ge.tbc.testautomation.tests;
//
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.LoadState;
//import com.microsoft.playwright.options.ScreenshotType;
//import com.microsoft.playwright.options.WaitUntilState;
//import ge.tbc.testautomation.runners.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//public class ItAcademyVisualTest extends BaseTest {
//
//    @BeforeClass
//    public void initSteps() {
//        page.navigate("https://tbcbank.ge/ka/tbc-education/it-academy");
//
//    }
//
//    @Test
//    public void visualTest() throws IOException {
//        page.waitForLoadState(LoadState.LOAD);
//        page.waitForLoadState(LoadState.NETWORKIDLE);
//
//        // Step 2: Take actual screenshot
//        Path actualPath = Paths.get("screenshots/actual.png");
//        page.screenshot(new Page.ScreenshotOptions()
//                .setPath(actualPath)
//                .setFullPage(true)
//                .setType(ScreenshotType.PNG));
//
//        // Step 3: Load baseline screenshot from file
//        Path baselinePath = Paths.get("screenshots/It-academy-basePage.png");
//
//
//        // Step 4: Compare images
//        byte[] actual = Files.readAllBytes(actualPath);
//        byte[] expected = Files.readAllBytes(baselinePath);
//
//
//        Assert.assertTrue(Arrays.equals(actual, expected),
//                "❌ Visual test failed: screenshots differ!");
//    }
//}
