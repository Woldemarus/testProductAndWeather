package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.gson.*;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.switchTo;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import com.codeborne.selenide.Selenide;
import ru.alfabank.steps.BaseMethods;
import ru.alfabank.steps.RoundUpSteps;

@Slf4j
public class Testovoe1Steps {

    AkitaScenario akitaScenario = AkitaScenario.getInstance();

    BaseMethods baseMethods = new BaseMethods();
    RoundUpSteps roundUpSteps = new RoundUpSteps();

    @BeforeAll
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @Тогда("открыта новая вкладка")
    public void openNewWindow() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        switchTo().window(1);
    }

    @Тогда("выполнано нажати кнопки назад в браузере")
    public void goBack() {
        Selenide.back();
    }


    @Тогда("из переменной \"([^\"]*)\" получить параметр \"([^\"]*)\", \"([^\"]*)\" и записать его в переменную \"([^\"]*)\"")
    public void getParamsWeatherFromVariable(String name, String param1, String param2, String newVar) {
        Object query = akitaScenario.getVar(name);
        Gson gson = new Gson();
        JsonObject coderollsJsonObject = gson.fromJson(query.toString(), JsonObject.class);
        JsonObject addressJsonObject = coderollsJsonObject.get(param1).getAsJsonObject();
        String result = addressJsonObject.get(param2).getAsString();
        akitaScenario.setVar(newVar, result);
    }

    @Тогда("сравнить ответы с эталонами в каталоге \"([^\"]*)\" по ключевой переменной \"([^\"]*)\", \"([^\"]*)\"")
    public void getParamsWeatherFromVariable(String directory, String param1, String param2) throws IOException {
        File dir = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(directory)).getFile());
        File[] files = dir.listFiles();
        assert files != null;
        for (int i =0; i < files.length; i++) {
            String jsonString = FileUtils.readFileToString(files[i], "UTF-8");

            Gson gson = new Gson();
            JsonObject outputJsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonObject firstJsonObject = outputJsonObject.get(param1).getAsJsonObject();
            String result = firstJsonObject.get(param2).getAsString();

            if (result.equals(akitaScenario.getVar("name"))) {
                firstJsonObject = outputJsonObject.get("request").getAsJsonObject();
                String typeResult = firstJsonObject.get("type").getAsString();
                checkValuesAndPrintError("type", typeResult, akitaScenario.getVar("type").toString());

                firstJsonObject = outputJsonObject.get("request").getAsJsonObject();
                String queryResult = firstJsonObject.get("query").getAsString();
                checkValuesAndPrintError("query", queryResult, akitaScenario.getVar("query").toString());

                firstJsonObject = outputJsonObject.get("location").getAsJsonObject();
                String latResult = firstJsonObject.get("lat").getAsString();
                checkValuesAndPrintError("lat", latResult, akitaScenario.getVar("lat").toString());

                firstJsonObject = outputJsonObject.get("location").getAsJsonObject();
                String lonResult = firstJsonObject.get("lon").getAsString();
                checkValuesAndPrintError("lon", lonResult, akitaScenario.getVar("lon").toString());

                firstJsonObject = outputJsonObject.get("current").getAsJsonObject();
                String observationTimeResult = firstJsonObject.get("observation_time").getAsString();
                checkValuesAndPrintError("observation_time", observationTimeResult, akitaScenario.getVar("observation_time").toString());

                firstJsonObject = outputJsonObject.get("current").getAsJsonObject();
                String windSpeedResult = firstJsonObject.get("wind_speed").getAsString();
                checkValuesAndPrintError("wind_speed", windSpeedResult, akitaScenario.getVar("wind_speed").toString());

                firstJsonObject = outputJsonObject.get("current").getAsJsonObject();
                String pressureResult = firstJsonObject.get("pressure").getAsString();
                checkValuesAndPrintError("pressure", pressureResult, akitaScenario.getVar("pressure").toString());
            }
        }
    }

    public void checkValuesAndPrintError(String nameParam, String val1, String val2) {
        if (!val1.equals(val2)) {
            System.out.println("Параметр <" + nameParam + "> не совпали: " + val1 + " != " + val2);
        }
    }



}
