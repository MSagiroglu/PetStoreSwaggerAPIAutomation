package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;

    public static void raporOlustur() {
        if (extent == null) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedNow = now.format(formatter);
            String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Report " + System.currentTimeMillis() + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setDocumentTitle("Pet Store Swagger API Automation Report");
            reporter.config().setReportName(" Pet Store API Tests Report");
            reporter.config().setDocumentTitle("Pet Store API Report");
            reporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("HostName", "Localhost");
            extent.setSystemInfo("OS", "Windows 10");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Mustafa SAĞIROĞLU");
            // Bugünün tarihini ve saatini formatlamak
            extent.setSystemInfo("Test Date/Time", formattedNow);
        }
    }

    public static void testOlustur(String testAdi) {
        if (extent != null) {
            test = extent.createTest(testAdi);
        }
    }

    public static void bilgiNotu(String bilgiNotu) {
        if (test != null) {
            test.info(bilgiNotu);
        }
    }

    public static void raporuKaydet() {
        if (extent != null) {
            extent.flush();
        }
        ;
    }
}

