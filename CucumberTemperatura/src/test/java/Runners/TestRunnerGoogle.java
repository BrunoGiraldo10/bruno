package Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//parametrizar la ejecucion
@CucumberOptions(
        //escenario o  escenario que quieras ejecutar
        tags = "@BUSCATEMPERATURA",
        //me reconoce los feateures que estan en esta ruta
        features = "src/test/resources/Features/Temperatura.Feature",
        //especifica el step, el nombre de la carpeta
        glue = {"StepsDefinitions"},
        //se recomienda que este en true
        monochrome = true,
        strict = true,
        //variable de ejecucion
        dryRun = false

)
public class TestRunnerGoogle {
}
