package utilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static utilities.ExtentReport.*;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {

        raporOlustur();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testOlustur(result.getMethod().getMethodName().toUpperCase());
        test.assignCategory(result.getTestClass().getName().substring(result.getTestClass().getName().lastIndexOf(".") + 1));
        test.info(result.getMethod().getMethodName().toUpperCase() +" Testi başladı.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getMethod().getMethodName().toUpperCase() +" Testi başarıyla tamamlandı.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test atlandı: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Hata mesajı
        test.fail("Test başarısız oldu. Çünkü: " + result.getThrowable().getMessage());

    }

    @Override
    public void onFinish(ITestContext context) {
        raporuKaydet();
    }
}
