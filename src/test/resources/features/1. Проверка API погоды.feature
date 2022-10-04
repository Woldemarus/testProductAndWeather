# language: ru

    Функция: Провека API подгоды


    Структура сценария:
      Когда выполнен GET запрос на URL "<url>". Полученный ответ сохранен в переменную "Response"
      И из переменной "Response" получить параметр "request", "type" и записать его в переменную "type"
      И из переменной "Response" получить параметр "request", "query" и записать его в переменную "query"
      И из переменной "Response" получить параметр "location", "name" и записать его в переменную "name"
      И из переменной "Response" получить параметр "location", "lat" и записать его в переменную "lat"
      И из переменной "Response" получить параметр "location", "lon" и записать его в переменную "lon"
      И из переменной "Response" получить параметр "current", "observation_time" и записать его в переменную "observation_time"
      И из переменной "Response" получить параметр "current", "wind_speed" и записать его в переменную "wind_speed"
      И из переменной "Response" получить параметр "current", "pressure" и записать его в переменную "pressure"
      Тогда сравнить ответы с эталонами в каталоге "etalon" по ключевой переменной "location", "name"
    Примеры:
      |city|url|
      |Moscow|http://api.weatherstack.com/current?access_key=de342c576ef6189ed57e3af613e7fffe&query=Moscow|
      |Lipetsk|http://api.weatherstack.com/current?access_key=de342c576ef6189ed57e3af613e7fffe&query=Lipetsk|



