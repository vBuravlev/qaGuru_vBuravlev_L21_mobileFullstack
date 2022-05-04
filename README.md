# Мобильная автоматизация тестирования Java+Appium

### Запуск тестов на эмуляторе

```bash
./gradlew clean selenide_android_test -Ddevice=emulation
```
### Конфигурационный файл emulation.properties

> <code>url</code> – адрес Allure Serve на локальной машине с портом (_например - <code>http://localhost:4723/wd/hub</code>_).
>
> <code>appFileName</code> - название дистрибутива приложения (_например - <code>app-alpha-universal-release.apk</code>_).
>
> <code>app</code> - адрес расположения дистрибутива приложения для скачивания (_например - <code>https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk?raw=true</code>_).
>
> <code>deviceName</code> – название устройства на котором будут запускаться тесты (_например - <code>Pixel_4_API_30</code>_).
>
> <code>platformVersion</code> - версия, используемой платформы (_например - <code>11.0</code>_).
>
> <code>platformName</code> - название, используемой платформы (_например - <code>Android</code>_).
>
> <code>appPackage</code> - название пакета (_например - <code>org.wikipedia.alpha</code>_).
>
> <code>appActivity</code> - название "активности" (_например - <code>org.wikipedia.main.MainActivity</code>_).
>
> <code>locale</code> - используемый язык на локали (_например - <code>en</code>_).
>
><code>language</code> - язык для приложения (_наприме - <code>en</code>_).


### Запуск тестов на Browserstack

```bash
./gradlew clean selenide_android_test -Ddevice=browserstack
```

### Конфигурационный файл browserstack.properties

> <code>userName</code> – уникальное имя пользователя на BrowserStack (_например - <code>testtesttesttest_TajXhK</code>_).
>
> <code>accessKey</code> – ключ доступа пользователя (_например - <code>91v3WYYFHiexisvhqgR7</code>_).
>
> <code>url</code> – адрес среды запусков тестов BrowserStack (_например - <code>http://hub.browserstack.com/wd/hub</code>_).
>
> <code>appiumVersion</code> - используемая версия Appium (_например - <code>1.22.0</code>_).
>
> <code>deviceName</code> – название устройства на котором будут запускаться тесты (_например - <code>Google Pixel 3</code>_).
>
> <code>platformVersion</code> - версия, используемой платформы (_например - <code>9.0</code>_).
>
> <code>app</code> - уникальный адрес, загруженного приложения на BrowserStack (_например - <code>bs://2b384e7ff3f580c12db89e28227ac1a2c458b97c</code>_).
>
> <code>projectName</code> - наименование вашего проекта (_например - <code>Project BrowserStack</code>_).
>
> <code>buildName</code> - наименовае билда (_например - <code>Build 1</code>_).
>
><code>testName</code> - наименование теста (_наприме - <code>Test 1</code>_).


### Запуск тестов на реальном девайсе


```bash
./gradlew clean selenide_android_test -Ddevice=real
```

### Запуск тестов через Selenoid
Стенд в процессе доработки



## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/catalog.cft.ru_test_jenkins/)
*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="center">
  <img src="images/screens/Jenkins.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появятся
значки <img width="2%" title="Allure Report" src="images/logo/Allure.svg"><code><strong>*Allure
Report*</strong></code> и <img width="2%" title="Allure TestOps" src="images/logo/Allure_TO.svg"><code><strong>*Allure
TestOps*</strong></code>, кликнув по которым, откроется страница с сформированным html-отчетом.*

<p align="center">
  <img src="images/screens/Jenkins2.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/catalog.cft.ru_test_jenkins/allure/)

## <img width="4%" title="Allure Report" src="images/logo/Allure_TO.svg"> Отчет о результатах тестирования в [Allure TestOps](https://allure.autotests.cloud/project/1059/dashboards)

### :pushpin: Общая информация по отчетам о тестировании

*Главная страница Allure-отчета с:*

>- [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество выполненных кейсов, а также диаграмму с указанием процентного отношения и количества успешных, упавших и сломавшихся тестов к общему количеству
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/screens/AllureReport.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1059/dashboards)

### :pushpin: Основной дашборд

<p align="center">
  <img src="images/screens/Allure_TO.png" alt="dashboards" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="images/screens/Allure_TO2.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о пройденных тестах.

<p align="center">
<img title="Telegram Notifications" src="images/screens/Telegram.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="images/gif/Video-Test.gif">
</p>




