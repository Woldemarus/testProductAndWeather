/**
 * Copyright 2017 Alfa Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Авторизация")
public class AuthPage extends AkitaPage {

    @FindBy(css = "#login")
    @Name("Логин")
    public SelenideElement loginInputField;

    @FindBy(css = "#password")
    @Name("Пароль")
    public SelenideElement passwordInputField;

    @FindBy(xpath = "//span[text() = 'Войти']//parent::button")
    @Name("Войти")
    public SelenideElement buttonEnter;

    @Optional
    @FindBy(xpath = "//div[text() = 'Ошибка авторизации. Не верные логин/пароль']")
    @Name("Ошибка авторизации")
    public SelenideElement errorAuthorize;

    @Optional
    @FindBy(xpath = "//div[text() = 'Пожалуйста, введите пароль']")
    @Name("Ошибка пустой пароль")
    public SelenideElement errorEmptyPassword;

    @Optional
    @FindBy(xpath = "//div[text() = 'Пожалуйста, введите логин']")
    @Name("Ошибка пустой логин")
    public SelenideElement errorEmptyLogin;


}
