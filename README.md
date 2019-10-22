# android-project-template

### Оценка официальной документации

| Библиотека | Документация (по 10-бальной шкале) |
|------------|------------------------------------|
| Fresco     | 7                                  |
| Glide      | 10                                 |
| Picasso    | 1 (Очень скудная документация)     |

### Тестирование зыгрузки 25 изображений
Кэширование включено. Устройство Samsung A20, API Level 28

Тестирование проводилось на layout с RecyclerView, в который были помещены 25 [изображений](https://github.com/Hiraev/pic-loaders-benchmark). Открывалось view, скроллилось несколько раз, пока все изображения не подгрузятся, закрывалось и снова открывалось. В таблицу записывался пиковый показатель потребления памяти.

Большие изображения

| Библиотека | PNG     | JPEG | WEBP |
|------------|---------|------|------|
| Fresco     | -       | <320 | <250 |
| Glide      | -       | <274 | <165 |
| Picasso    | -       | <212 | <140 |

Маленькие изображения

| Библиотека | PNG       | JPEG | WEBP |
|------------|-----------|------|------|
| Fresco     | <137      | <135 | <130 |
| Glide      | <138      | <127 | <130 |
| Picasso    | <122      | <126 | <118 |

#### Заключение 

_Picasso_ потребляет меньше всех оперативной памяти, однако имеет очень плохую документацию и в каких-то случаях продолжает загрузку изображений на view, которое уже закрыто (на экране с RecyclerView). _Fresco_ очень гибкая библиотека, требует использования SimpleDraweeView для изображений, тогда как другие позволяют работать со стандартным ImageView. Из всех представленных в данном тесте библиотек _Fresco_ потребляет больше всех памяти.

### Тестирование в RecyclerView c большим количеством изображений
Тестирование проводилось на экране со списком, состоящем из изображений. Пролистывание проводилось медленно, ожидаю загрузки изображения в каждый из элеметнов списка. Кэширование было выключено.

Пиковое потребеление памяти:

| Библиотека |Память (Мб)| Относительный показатель |
|------------|-----------|--------------------------|
| Fresco     | 146       |  1.5                     |
| Glide      | 97        |  1                       |
| Picasso    | 139       |  1.43                    |
| Coil       | 108       |  1.11                    |


Средняя скорость биндинга (вместе с загрузкой) одного изображения. Показатель взять после биндинга 500 элементов.

| Библиотека | (ms) | (ms) | (ms) | Avrg(ms) |Относительный показатель    |
|------------|------|------|------|----------|----|
| Fresco     | 1023 | 827  | 805  | 885      |1.92|  
| Glide      | 490  | 412  | 483  | 462      |1   |
| Picasso    | 643  | 644  | 676  | 654      |1.41|
| Coil       | 470  | 449  | 640  | 519      |1.12|

Из последней таблицы можно не учитывать последний результат полученный для библиотеки `Coil`, потому что он сильно отличается от двух предыдущих. В таком случае `Coil` вместе с `Glide` выполняют биндинг быстрее всех.
