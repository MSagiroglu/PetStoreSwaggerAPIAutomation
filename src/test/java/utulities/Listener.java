package utulities;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import static utulities.ExtentReport.*;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {

        raporOlustur();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testOlustur(result.getMethod().getMethodName());
        test.info("Test başladı.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test başarıyla tamamlandı.");
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
