import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static testeOlx.core.DriverFactory.quitNavegador;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\testeOlx\\feature\\",
        glue = {"testeOlx.steps"},
        tags = {"@olx", "not @no"},
        //plugin = {"pretty", "html:target/report-html"},
        dryRun = false,
        strict = false,
        monochrome = true)

public class ExecucaoTestesOlx {

    @BeforeClass
    public static void tearUp() {
    }

    /*TEST*/


    @AfterClass
    public static void finalizar() {
        quitNavegador();
    }

}
