INSERT INTO categories (category_id, category_name)
VALUES (1001, 'Одежда и обувь'),
       (1002, 'Электроника'),
       (1003, 'Бытовая техника'),
       (1004, 'Строительство и ремонт'),
       (1005, 'Книги');

ALTER SEQUENCE categories_seq RESTART WITH 1006;

INSERT INTO subcategories (subcategory_id, subcategory_name, category_id)
VALUES (1001, 'Рюкзаки и сумки',1001),
       (1002, 'Джинсы',1001),
       (1003, 'Кеды и кроссовки',1001),
       (1004, 'Юбки',1001),
       (1005, 'Брюки',1001),
       (1006, 'Смартфоны',1002),
       (1007, 'Планшеты',1002),
       (1008, 'Ноутбуки',1002),
       (1009, 'Пылесосы',1003),
       (1010, 'Холодильники',1003),
       (1011, 'Стиральные машины',1003),
       (1012, 'Инструменты',1004),
       (1013, 'Отделочные материалы',1004),
       (1014, 'Сауны и бани',1004),
       (1015, 'Художественная литература',1005),
       (1016, 'Бизнес-литература',1005),
       (1017, 'Учебная литература',1005);

ALTER SEQUENCE subcategories_seq RESTART WITH 1018;

INSERT INTO shops (shop_id, shop_name, created_at, updated_at)
VALUES (1001, 'ZARA', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1002, 'Familia', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1003, 'Эльдорадо', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1004, 'Мвидео', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1005, 'Энкор', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1006, 'Леруа Мерлен', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1007, 'Издательство АСТ', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00'),
       (1008, 'Издательство Проспект', '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00');

ALTER SEQUENCE shops_seq RESTART WITH 1009;

INSERT INTO products (product_id, product_name, subcategory_id, shop_id, description, product_price_id, product_discount_id, created_at, updated_at)
VALUES (1001, 'Сумка рюкзак спортивная для зала и тренировок', 1001, 1002, 'Спортивная сумка – идеальный выбор для зала и тренировок. Эта сумка прекрасно подойдет для фитнеса, посещения спортзала или занятий различными видами спорта. Она поможет вам организовать всю необходимую и экипировку для достижения ваших целей. Благодаря своей вместительности, позволит удобно разместить все необходимые вещи для тренировок по футболу. С ремешком через плечо можно легко носить и почувствовать полную свободу движений. Эта спортивная сумка большая идеально подойдет как для детей, так и для женщин и мужчин. Используйте ее для занятий боксом, физкультурой или единоборствами. Также можно использовать эту сумку для посещения бассейна или зала для борьбы, ММА, дзюдо или карате. Высококачественные материалы, из которых сделана сумка, обеспечивают надежность и долговечность изделия. Сумка станет хорошим подарком мужчине на 23 февраля.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1002, 'Сумка женская через плечо черная из экокожи Jils. Женская сумка кросс-боди, маленькая, багет, клатч, на цепочке, на широком ремне, сумочка женская', 1001, 1001, 'Вельветовая сумка-мессенджер Carhartt имеет размеры 23х18 см. Глубина сумки 8 см. Длина регулируемого ремешка от 70 см до 130 см. Сумка прямоугольная, линии ровные, имеет правильную форму. Сумка кросс-боди подойдёт мужчинам, женщинам, подросткам и детям. Сумка однотонная выполнена из вельвета. Маленькая компактная сумка имеет 1 внешнее отделение на молнии и 1 внутренний кармашек-сетку. Вельветовая мини сумочка в винтажном стиле, хит летнего сезона. Кросс-боди на плечо с легкостью станет вариантом на каждый день. Вы всегда сможете выбрать понравившейся вам цвет. Миниатюрные размеры сумки, чудесно подойдут маленьким детям. Для стильных и дерзких мальчишек, также найдется свой цвет. Сумка дополнит любой ваш образ, под любой стиль. Стильная вельветовая сумочка для подростка, великолепно впишется в романтический образ и подчеркнет стиль Casual. Сумочку можно носить через плечо, удобно носить на сгибе локтя или просто на запястье. Сумка спортивная подойдет для прогулок, работы, путешествий, используйте ее как ручную кладь, берите в спортзал, фитнес или бассейн - сумка станет Вашим незаменимым аксессуаром. Сумка-мессенджер выглядит достойно и со вкусом. Маленький размер сумки позволяет взять с собой только самое необходимое. Все самое ценное всегда под рукой! Сумка маленькая и компактная, ее можно носить под верхним слоем одежды. Побалуйте себя или ваших близких таким модным и стильным аксессуаром! Сумка на шею', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1003, 'Джинсы AnMin', 1002, 1001, 'Это стильные и модные брюки, которые отлично подойдут для создания современного и яркого образа. Серые джинсы - это отличный выбор для любого мужчины, подростка, парня, мальчика, который хочет выглядеть стильно и комфортно в любой ситуации. Выбирая их, вы получаете модный и удобный элемент гардероба на каждый день. Подростковая одежда и джинсы - это неотъемлемая часть образа любого мужчины. Важно выбирать качественную одежду, которая будет долговечной и удобной и прослужит вам долгое время.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1004, 'Джинсы BAROUZ Палаццо', 1002, 1002, 'Будь в тренде этим сезоном! Женские джинсы клеш от бедра с высокой посадкой - создадут модный образ и станут базовой частью вашего гардероба. Плотная ткань из 98% хлопка приятно ощущается на коже и позволяет ей дышать. Наши женские джинсы клеш пошиты из качественного материала, с добавлением эластана для комфортной носки. Для производства наших изделий мы тщательно выбираем фабрики с большим опытом в пошиве. Высокая посадка для создания красивого силуэта. Перед первой ноской, постирайте джинсы соблюдая простые стандартные рекомендации. Рекомендуем стирать джинсы в вывернутом состоянии при температуре не более 30 градусов, не использовать средства для стирки содержащие отбеливатели или хлор, также можно использовать специальные гели или кондиционеры для темной одежды для поддержания насыщенного цвета. Со временем цвет может стать немного светлее, это вполне нормальное явление. Джинсы подходят на любую фигуру, большой размерный ряд позволяет подобрать подходящий размер для худеньких девушек и для красоток с пышными формами. Клеш трубы идущий от бедра скрывает недостатки фигуры, а высокая талия формирует красивый силуэт. Модные широкие джинсовые брюки подойдут к любому стилю одежды на лето, весну и демисезон. Застежка на поясе на пуговице и молнии не давит на живот. Под них легко подобрать аксессуары и обувь - можно носить с кроссовками, ботинками и моделями на каблуке. Завышенные джинсы с удобной посадкой на талии и широкие от бедра штанины подчеркивают формы и обеспечивают комфорт во время носки, не сковывают движения. Стильные, модные, красивые джинсы плаццо могут носить девочки - подростки, молодые девушки, взрослые женщины и будущие мамы на ранних сроках. Джинсы отлично смотрятся на высоких девушках, но на девушках с невысоким ростом будут также интересно смотреться - как плаццо (клеш в пол). Стильные расклешенные к низу брюки оверсайз можно надеть для похода на работу в офис, школу, прогулку, взять с собой в путешествие в качестве сменной одежды. Качественный материал не дает усадку, не линяет и сохраняет свой первоначальный вид. Свободные джинцы станут идеальным подарком на любой праздник: Международный женский день, день рождения, Новый год, Рождество, день матери. Популярные, трендовые, длинные штаны можно подарить маме, дочери, подруге, сестре, любому близкому человеку или порадовать себя любимую такой красивой повседневной моделью.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1005, 'Кроссовки Nike', 1003, 1001, 'КРОССОВКИ МАЛОМЕРЯТ НА 1 РАЗМЕР Кроссовки идеальный выбор для тех,кто ценит комфорт,стиль и функциональность. Мужские кроссовки-это обувь,в которой летом,осенью,весной и зимой можно составить множество образов.Кроссовки демисезонные кожаные сочетайте с брюками, джинсами, спортивными костюмами. Широкий ассортимент никого не оставит равнодушным. Кроссовки мужские подойдут в качестве спортивной обуви или спортивных кед. Кроссовки подходят для различных видов спорта, включая бег, баскетбол, волейбол, футбол, теннис. Используйте кроссовки на платформе для активного отдыха, прогулок и в повседневной жизни. Кроссовки женские кожаные представлены в разных цветах, чтобы каждый подобрал что-то свое, белые кроссовки, серые, бежевые, красные, темно-серые, черные, зеленые, цвета хаки. Женская мужская обувь выполнена из натуральных материалов и отлично пропускают воздух. Шнуровка обеспечивает идеальную посадку и фиксацию на ноге. Мягкая подошва обеспечивает комфорт при ходьбе и снижает усталость ног. У нас отличный выбор кроссовок в школу для мальчиков и девочек. Подростки могут использовать кроссовки с белой подошвой как сменную обувь в школу ,а так же для занятий физкультурой. Кеды и кроссовки мужские, женские и детские подойдут для любого возраста.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1006, 'Юбка ТВОЕ', 1004, 1001, 'Эта женская мини-юбка в складку от бренда ТВОЕ - идеальный выбор для стильных подростков, которые хотят выглядеть модно и элегантно. Она выполнена в классическом черном цвете, который придает ей универсальность и легкость сочетания с другими предметами гардероба. Юбка короткая и подчеркивает фигуру, придавая образу женственности и сексуальности. Она подходит для различных событий и мероприятий: от офиса и школы до вечерних выходов. Имеет эластичную резинку, что обеспечивает комфортную посадку и легкость в носке. Эта мини также удлиняет ноги, что помогает создать эффектные и привлекательные образы. Она идеально сочетается с различными верхами, такими как рубашка или куртка, позволяя создавать разнообразные стили и ансамбли. Не упустите возможность добавить в свой гардероб эту стильную и классическую мини-юбку от бренда ТВОЕ. Она подойдет как для повседневного образа, так и для особых случаев, добавляя вам уверенности и привлекательности.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1007, 'Брюки Bon Vivant', 1005, 1002, ' В любой период каждый мужчина начинает задумываться о комфортной и легкой одежде. Идеальным вариантом станут мужские брюки-джоггеры. Эти штаны прекрасно подойдут не только для занятий спортом или туризмом, но и для повседневной носки. Их уличная мода уже давно завоевала сердца молодежи, и сейчас они активно входят в гардероб взрослых мужчин. Наши джоггеры отличаются особыми характеристиками. Они сшиты из хлопка, что делает эти брюки легкими и дышащими, идеальными для лета. Имеют узкий, но свободный крой, по бокам обычно располагаются боковые карманы для удобства. К тому же, зауженные к низу, они часто имеют резинку или утяжку, что позволяет придать образу определенный стиль. Особенно популярными стали карго джоггеры, тактического и милитари стиля, которые сочетают в себе элементы военной формы, удобство спортивной одежды и актуальные тренды уличной моды. В наших штанах карго много карманов - всегда есть куда положить вещи. Среди мужских джоггеров большой популярностью пользуются также модели oversize. Модные подростковые штаны с двойной утяжкой подойдут как мальчику-подростку, так и взрослому мужчине. Ведь главное в этих брюках карго - удобство и свобода движения. Благодаря своему дизайну, они выглядят стильно и модно. Широкий ассортимент представленных товаров позволяет каждому найти подходящую модель по доступной цене. Сегодня джоггеры можно найти как в камуфляжном стиле, так и в стиле casual, а также в спортивном или атлетическом стиле. Они подойдут как для парней, так и для юношей, и даже для подростков. Для тех, кто предпочитает активный отдых, рыбалку или охоту, предлагаются специальные походные и туристические модели. Легкие, тонкие, но в то же время устойчивые к внешним воздействиям, они станут вашими незаменимыми помощниками во время похода или охоты. В общем, если вам нужны мужские брюки, подходящие для лета, осени, зимы или весны, комфортные, стильные и модные штаны джоггеры станут отличным выбором. Они доступны в разных размерах, включая большой и самый маленький, и всегда можно найти модель, которая будет идеально сидеть на вас.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1008, 'Брюки InNa concept Basic', 1005, 1001, 'Популярные брюки, которые объединяют в себе классику и моду. Прямые классические брюки являются настоящим маст-хэв в мире стильных аксессуаров. Зауженный крой создает элегантный силуэт, а укороченная длина добавляет неповторимого шарма. Пояс на резинке обеспечивает комфортную посадку и позволяет подчеркнуть талию. Ткань тонкая и легкая, поэтому брюки не сковывают движения и не стесняют. Эти штаны - идеальный вариант для создания различных образов. Сочетайте их с праздничными топами на лето или школьными рубашками для офисного стиля. Яркий акцент в поясе - карманы, которые добавляют функциональность и практичность данной модели. Брюки черные карго широкие, универсальные и легко сочетаются с другими элементами гардероба. Большие размеры позволяют каждой девушке найти идеальную посадку и подчеркнуть свои достоинства. Широкие и свободные, они не сковывают движения и придадут вашим ногам легкость и комфорт. Без начеса. Не упустите возможность приобрести эти популярные бананы-брюки уже сейчас. Они будут отличным дополнением к вашему гардеробу на любое время года особенно в праздничные периоды нового года. Добавьте в свой стиль модных джоггеров и наслаждайтесь ощущением комфорта и безупречного вида. По поясу сзади вставлена эластичная лента (резинка) в запасе дает 4 см на размер. Подходят на рост 168-172 см.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1009, 'Tecno Смартфон Spark 20C 8/128 ГБ, черный', 1006, 1003, 'Корпус модели выполнен в насыщенном цвете с нанесенным рельефным рисунком. Глянцевый блок камер красиво контрастирует с матовым корпусом. Интерактивный вырез под фронтальную камеру Dynamic Port выводит информацию о состоянии батареи и о статусе блокировки. За счет плоских боковых граней смартфон удобно и надежно лежит в руке. Толщина корпуса составляет 8.75 мм. Вес устройства — 189 г. Для быстрой разблокировки предусмотрены сканер отпечатков пальцев и камера с технологией распознавания лица. Выход 3.5 мм позволяет подключить к смартфону проводную гарнитуру. Дисплей и звук Смартфон получил большой 6.56-дюймовый дисплей, изготовленный по технологии IPS. Экран отличается точной цветопередачей и широкими углами обзора. За счет соотношения сторон 20:9 на таком дисплее комфортно смотреть фильмы. Частота обновления экрана составляет 90 Гц, что обеспечивает плавность во время воспроизведения динамичных сцен. Полезная площадь дисплея достигает 90.5%. За воспроизведение звука отвечают стереодинамики DTS. Звучание выделяется насыщенными низкими, чистыми средними и высокими частотами.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1010, 'Apple Смартфон iPhone 13_eSIM+SIM 4/128 ГБ, зеленый', 1006, 1004, 'Смартфон Redmi Note 13. Запечатлите мир с любого ракурса с помощью системы из 3-х камер, в которую входит основная камера высокого разрешения, сверхшироко-угольная камера и камера для макросъемки. Мощный аккумулятор емкостью 5000 мАч гарантирует длительную работу смартфона. В комплекте идет быстрая зарядка на 33 Вт. Дисплей с диагональю экрана 6,67 дюйма и ультратонкой рамкой обеспечивает 100%-ную цветовую гамму DCI-P3 и 8-битную глубину цветопередачи, что обеспечивает захватывающее визуальное восприятие. Смотрите любимые фильмы и видео с насыщенными оттенками черного и яркой цветопередачей. Смартфон поддерживает 3 разных частоты обновления экрана (60 Гц / 90 Гц / 120 Гц). Сверхчувствительный дисплей оснащен сенсорным управлением с 16-кратным разрешением, в то время как в игровом режиме Redmi Note 13 может мгновенно достигать частоты дискретизации до 2160 Гц, точно определяя каждое едва заметное движение и обеспечивая беспрецедентную плавность работы. Созданный на основе флагманского 6-нм техпроцесса, Redmi Note 13 обеспечивает плавную и высокую производительность благодаря мощному процессору Snapdragon 685 от Qualcomm. Redmi Note 13, имеющий класс защиты IP54, хорошо защищен от брызг и пыли и обладает технологией Wet touch. ', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1011, 'Серый - Планшет X-PRIME A15 Max 6/128GB 10.1 дюйм Android 13 + Клавиатура и Чехол', 1007, 1003, 'Планшет X-Prime A15 Max - это современное устройство, которое сочетает в себе функциональность и стиль. Планшет оснащен 10,1-дюймовым IPS экраном с разрешением 3000x1440 пикселей. Это обеспечивает четкое и яркое изображение, что делает просмотр видео и чтение текстов еще более комфортным. Планшет работает на операционной системе Android 13, что гарантирует его быстродействие и совместимость с большинством приложений. Объем встроенной памяти составляет 128 ГБ, а оперативная память - 6 ГБ. Это позволяет хранить большое количество данных и приложений, а также обеспечивает плавную работу системы. Планшет оснащен 13-мегапиксельной основной камерой с автофокусом и вспышкой, что позволяет делать качественные снимки и видео. Фронтальная камера на 5 мегапикселей обеспечивает качественные селфи и видеозвонки. Планшет поддерживает беспроводную связь Bluetooth 5.0 и Wi-Fi, а также имеет модуль сотовой связи Wi-Fi + Cellular. Это позволяет использовать устройство в качестве мобильного телефона и обеспечивает доступ к интернету в любом месте. Планшет X-Prime A15 Max имеет слот для карты памяти, что позволяет расширить объем памяти устройства. Также в комплекте с планшетом идут клавиатура и стилус, что делает его удобным для использования в качестве ноутбука. Планшет имеет аккумулятор, который обеспечивает длительное время работы устройства. В комплекте с планшетом идет чехол, блок питания, кабель, переходник OTG, подставка, мышь, стилус и фонарик. Планшет X-Prime A15 Max - это современное и функциональное устройство, которое станет незаменимым помощником в работе, учебе и развлечениях.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1012, 'Honor MagicBook 15 (DOS) Ноутбук 15.6", AMD Ryzen 5 5500U, RAM 16 ГБ, SSD 512 ГБ, AMD Radeon Graphics, Без системы, (5301AFVQ), серый, Русская раскладка', 1008, 1004, 'Ноутбук для работы, учебы и игр, мощный, ультратонкий, с подсветкой, 512 Гб, DogiFlaps S3 Подбираете идеальный ноутбук для повседневной жизни? Ультратонкий ноутбук DogiFlaps S3 с русской клавиатурой выполнен в стильном корпусе, который подойдет для различных задач - будь то работа, учеба или игры.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1013, 'Пылесос для дома с контейнером бытовой 3л, 3000W, проводной', 1009, 1003, 'Высокая мощность - 3000 ВТ Пылесос является обладателем очень внушительного мотора мощность в 3000 ВТ, что позволяет удалять большое количество грязи и пыли, не теряя в производительности. Тем самым поддерживая отличное качество уборки.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1014, 'Doffler Бытовой пылесос VCB 2009 BG, серый', 1009, 1004, 'Пылесос DOFFLER VCB 2009 BG порадует отличной производительностью и высокой степенью очистки воздуха. Высокая мощность всасывания 450 аВт позволяет справиться с самыми сложными загрязнениями на любой поверхности. Hepa-фильтр на выпуске задержит мельчайшие частицы пыли и не позволит им попасть обратно в помещение. Объем мешка-пылесборника увеличен до 3 литров, благодаря чему дольше сохраняется высокая мощность всасывания. Индикатор на корпусе пылесоса сообщит о необходимости очистки или замены мешка-пылесборника. Мощность регулируется плавным переключателем на корпусе. В этой модели для улучшения производительности используется труба 35 мм.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1015, 'Холодильник Indesit ES 20', 1010, 1003, 'Основные характеристики - Тип: холодильник с морозильником - Тип установка: отдельностоящий - Количество компрессоров: 1 - Количество камер: 2 - Общий полезный объем: 341 л Холодильная камера - Объем холодильной камеры: 233 л - Количество отделений в холодильной камере: 1 - Размораживание холодильной камеры: автоматическое Морозильная камера - Объем морозильной камеры: 108 л - Расположение морозильной камеры: снизу - Размораживание морозильной камеры: ручное - Количество отделений в морозильной камере: 1 - Мощность замораживания: 2 кг/сутки - Хранение продуктов при отключении питания: 19 ч Управление - Тип управления: механическое - Способ управления: поворотный - Расположение панели управления: на корпусе Электропитание - Напряжение: 220-240 B - Класс энергопотребления: B - Энергопотребление: 496.4 кВтч/год - Климатические класс: N - Уровень шума: 39 дБ Освещение - Освещение холодильной камеры: да - Тип освещения: лампа накаливания - Количество ламп освещения: 1 - Мощность одной лампы: 15 Вт Особенности конструкции - Количество дверей: 2 - Открытие дверцы: направо - Перевешиваемые двери: да Контейнеры и полки - Количество полок в холодильной камере: 4 - Регулируемые по высоте полки в холодильной камере: 3 - Количество полок на дверце холодильной камеры: 4 - Количество контейнеров в холодильной камере: 2 - Количество контейнеров в морозильной камере: 4 Цвет и материал - Цвет: белый - Цвет полок: белый, прозрачный - Материал полок: стекло - Материал ящиков: пластик Размеры и вес - Высота: 200 см - Ширина: 60 см - Глубина: 62 см ', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1016, 'Стиральная машина Indesit BWSE 81293X WWV RU', 1011, 1004, 'Всего одно нажатие — стирка и глажка еще никогда не были такими легкими. Стиральная машина Innex с новой технологией Push&Go Сортировка, стирка, сушка, глажка. Стирка — очень длительный процесс, которому приходится уделять время несколько раз в неделю. С этим сталкивается каждая семья, а в семье, как известно, время на вес золота. Поэтому хочется найти простое и практичное решение, которое облегчит процесс стирки и глажки. Именно эти задачи считаются самыми утомительными из всех домашних дел. Домашние хлопоты под силу любому. Новая функция Push&Go. Всего одно нажатие — стирка и глажка еще никогда не были такими легкими. Новая технология Push&Go сделает процесс стирки более быстрым и легким, а инновационная технология Steam Technology сократит время глажки на 30%. Нажатие и удержание специальной кнопки в течение 2 секунд активирует ежедневный цикл стирки продолжительностью менее 1 часа. В последние 15 минут цикла в барабан подается пар, смягчающий ткани и облегчающий глажку. Стирка всего лишь при 30° и при этом отличные производительность и энергосбережение. Полный набор программ стирки самых распространенных тканей при низкой температуре. Длительность циклов не более 100 минут. Усиленное вращение барабана компенсирует снижение температуры, обеспечивая эффективную стирку как при температуре 40°C', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1017, 'P.I.T. Перфоратор 1400 Вт От сети', 1012, 1005, 'Перфоратор P.I.T. PBH26-C3 NEW - обновлённая модель бестселлера прошлых лет. Модель 2023 года комплектуется более мощным и производительным двигателем на 1400Вт. Модернизированные внутренние узлы и ударный механизм подняли силу удара до внушительных 5.5Дж. Модель идеально подходит для бытового и полупрофессионального использования. Качественный, мощный и производительный перфоратор P.I.T. PBH26-C3 предназначен для долбления бетона, бурения отверстий, а также сверления в дереве и металле. Три режима работы обеспечивают отличный результат при работе с различными материалами. Эргономичная рукоятка D-образной формы предотвращает выскальзывание и защищает руки, а система SDS-Plus позволяет менять буры легко и без усилий.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1018, 'Армирующая лента STRAIT-FLEX Roll Patch (для заделки трещин и сколов), ширина 140мм, в рулоне 5 м', 1013, 1006, 'Лента Roll-Patch - специально разработанная и запатентованная композитная лента, которая является ремонтной лентой и применяется при ремонте сложных трещин и объемных повреждений на различных строительных поверхностях. Лента имеет особые армирующие свойства, благодаря запатентованному композитному материалу и имеет огромное преимущество перед сетками, бумажными лентами, флизелиновыми материалами и особенно идеально подходит для армирования стыков при соединении из разнородных материалов. Также идеальна в ремонте и заделки отверстий в гипсокартоне ( отверстия под светильники, под розетки или выключатели ), и другие ремонтные работы. Лента имеет превосходную адгезию со многими строительными материалами, благодаря специальному и запатентованному составу лент Strait-Flex. Все ленты бренда Strait-Flex являются влагостойкими и могут применяться в местах, подверженных воздействию влаги , также ленты Strait-Flex имеют особый состав, который делает их прочными на разрыв, удобными в применении и монтаже. Ширина и толщина ленты: 140 мм / 0,58 мм', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1019, 'Веники банные набор 4пр.1 Березовый, 1 Дубовый, 1 Эвкалиптовый(для ингаляций),1 Фитосбор. В картонной коробке. Волковские Технологии.', 1014, 1006, 'Набор «веники и травы» для бани и сауны : березовый -1 шт., дуб кавказский с травой – 1 шт., травяной веник ( эвкалипт) - 1 шт., фитосбор банный – 1 шт. Инструкция пользования вениками и травами – 1 шт. Набор упакован в прочную картонную коробку. Строительная компания «ВолковПар», «Волковские Технологии» с 1993 года строит элитные парные и банные комплексы. Мы знаем, каким должен быть «Идеальный Веник». Постоянный контроль качества и экологической безопасности на всех этапах производства и хранения. Отличие наших веников от похожих в том, что ВСЕ они изготовлены из молодой поросли деревьев, что делает ветку упругой, тонкой и легкой. Размер самого веника четко выверен. Веник плотный, набитый, но не очень большой - ведь еще очень важно самому парильному " не упасть" и оставаться бодрым. Наш веник вы полюбите «с первого прикосновения». Сама ручка (размер, диаметр, форма) четко выверена, плотно перетянута натуральным материалом типа льна и пеньки из-за чего Вы не сотрете ладони. Плотная перетяжка гарантирует, что веники не рассыпятся. Банных веников хватит на несколько парений (3-5 минимум). Собираются веники в экологически чистых местах. Мы производим их в Ивановской, Рязанской областях, Чувашии, в Краснодарском крае. Время сборки четко выверено. В каждом регионе оно свое. Для каждого типа веников оно тоже свое. Веник берёзовый Помогает при боле, ломоте в мышцах и суставах после упражнений и физических нагрузок. Хорошо очищает кожу при склонности к сыпи и гнойничкам, ускоряет заживление ран и ссадин. Его особое достоинство — сильное расширение в веничном пару мелких бронхов. Это способствует отхождению мокроты и улучшению вентиляции лёгких. Незаменим для астматиков, курильщиков со стажем. В листьях берёзы есть эфирные масла, дубильные вещества, витамин C, провитамин A. После парки кожа будет гладкая, эластичная, приятного цвета. Настой веника в конце бани полезен для кожи головы: укрепляет волосы и уничтожает перхоть. Оказывает успокаивающее действие, улучшает настроение. Веник дубовый кавказский с травой В венике из канадского дуба зафиксировано повышенное содержание эфирных масел, дубильных веществ, аскорбиновой кислоты. Этот веник рекомендован людям с повышенным артериальным давлением, людям, страдающим депрессией, нервными срывами. Эвкалиптовый веник Листья эвкалипта содержат от 1 до 3 процентов эфирного масла, с чем связаны его лечебные свойства. Особенно он хорош при насморке, болях в горле. В парной его прижимают к лицу и дышат 4-5 минут носом. Эвкалипт хорошо запарить в кипятке, а затем разбрызгивать настой по стенам парной и немного на каменку. Внутри коробки инструкции по подготовке, использования и хранения банных веников, травяных веников и фитосбора. Следуя им вы сохраните веник на многие парения. Мы заботимся о вашем здоровье и удовольствии! ', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1020, 'Шапка для бани и сауны Доктор Баня / набор 4 шт. войлок', 1014, 1006, 'Набор из четырех удобных шапок для бани и сауны. Шапки для бани очень давно пользуются заслуженной популярностью у большинства любителей бани и представляют собой чрезвычайно важный элемент при посещении бани. Они призваны защитить голову от теплового удара, поскольку обычно температура в бане на много порядков превышает обыденную и привычную для человека. Также неоспоримым достоинством банных шапок является защита волос на голове от высоких температур. Размер шапок универсальный и подходит всем: папе, брату, мужу, сыну, внуку, дедушке, другу, начальнику, коллеге, директору и так далее. На шапках имеется петелька, с помощью которой их можно повесить на крючок для просушки. Шапки послужат прекрасным подарком для близких людей и друзей на  День Рождения ,новоселье .', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1021, 'Наедине с собой | Антонин Марк Аврелий', 1015, 1007, '"Наедине с собой. Размышления" — сборник афористических мыслей Марка Аврелия, написанный им на греческом языке (койне) в 70-е годы II века во время войны на дунайской границе. Он пользовался несомненным успехом в позднеантичное время,  а в XVI веке  возродился в европейских философских кругах. Эти личные записи отражают упорное стремление императора не только руководствоваться в своем мироощущении учением стоиков, но и развивать его дальше, назвав ведущим началом в человеке не душу, но разум, который нужно привести в согласие с природой целого, достигнув таким образом бесстрастия. ', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1022, 'Опыты | Монтень Мишель', 1015, 1007, 'Мишель Экем де Монтень (1533–1592) – французский писатель и философ эпохи Возрождения, прожил тихую, небогатую событиями жизнь, редко выезжал за пределы родного городка и фамильного имения, был чужд политических и религиозных бурь своего времени – и даже вежливо отверг предложение Генриха IV стать его советником. Главный труд Монтеня – «Опыты», над которыми философ работал 10 лет, – написан в живой и свободной форме, без четкого плана. Государственное управление, отношения между людьми, власть над собственной волей – это и многое другое философ рассматривает с точки зрения собственного опыта и сопровождает остроумными замечаниями и цитатами античных и современных ему авторов. Название глав точно отражает их содержание: «О дружбе», «О страхе», «О пьянстве», «О раскаянии», «О славе» и т.д. «Опыты» – книга, которую цитировал Шекспир, с которой яростно спорили Паскаль и Декарт, и которой восхищался Вольтер. Книга, которая до сих пор входит в программу курса философии всех университетов мира.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1023, 'Детство. В людях. Мои университеты | Горький Максим Алексеевич', 1015, 1008, 'Автобиографическая трилогия Максима Горького "Детство. В людях. Мои университеты", над которой он работал 10 лет - одно из самых значительных произведений русской реалистической литературы ХХ века. Сам писатель называл ее "той правдой, которую необходимо знать до корня, чтобы с корнем же и выдрать ее из памяти, из души человека, из всей жизни нашей, тяжкой и позорной". Перед читателем трилогии буквально оживает провинциальная Россия конца XIX - начала ХХ столетия, с ее купеческими дворами и рабочими предместьями, волжскими портами, чередой колоритных персонажей и бесконечной глубиной понимания самой души русского народа, вечно балансирующей на грани между прекрасным и безобразным, между преступлением и святостью.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1024, 'Большая пайка | Дубов Юлий Анатольевич', 1015, 1008, 'Пять частей романа - это пять трагических судеб; пять историй о дружбе и предательстве, вере и вероломстве, любви и равнодушии, о том, как делаются в современной России Большие Деньги и на что могут пойти люди, когда Большие Деньги становятся Большой Пайкой; это пять почти документальных биографий, за которыми встает история новейшего российского бизнеса. Восемьдесят пять лет назад американский писатель Теодор Драйзер создал знаменитые романы `Финансист` и `Титан` о власти денег. `Большая пайка` - это дебют Юлия Дубова, первый роман о бизнесе, написанный непосредственным участником событий.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1025, 'Финансист. Титан. Стоик (комплект из 3 книг)', 1015, 1007, 'Знаменитые романы «Финансист», «Титан» и «Стоик» образуют «Трилогию желания» — масштабное повествование американского писателя Теодора Драйзера о головокружительной карьере финансиста. В основе эпоса о Фрэнке Каупервуде — биография реального чикагского миллионера Чарлза Йеркса. Большой бизнес, финансовые аферы и махинации, жизнь и нравы олигархов блестяще описаны в трилогии.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1026, 'Маркетинг от А до Я. 80 концепций, которые должен знать каждый менеджер / Книги про бизнес и маркетинг / Филип Котлер | Котлер Филип', 1016, 1007, '80 ключевых концепций эффективного маркетинга, их содержание и значение для современного бизнеса. Автор собрал и переосмыслил основные принципы и лучшие методы эффективного и инновационного маркетинга. Цитата: «Трудно ли научиться маркетингу? Хорошая новость: его можно изучить за один день. Плохая новость: его можно изучать всю жизнь». Особенности книги: • Книга написана гуру маркетинга и стала настольной для миллионов специалистов во всем мире. • Она дает наилучшее представление как о классических инструментах маркетинга, которые прошли испытание временем, так и об инновационных разработках, которые стали использоваться только в последние годы. • В ней в легко усваиваемой форме представлены свежие идеи, оценки и конкретные практические рекомендации, которые побуждают к действию. Книга относится к познавательной и развивающей литературе, подойдёт в качестве подарка. Книги по бизнесу и маркетингу являются популярными бестселлерами для всех возрастов. Работы, написанные специалистами своего дела, учат новым знаниям и навыкам, помогают профессиональному развитию. Это интересное и полезное чтение как для новичков, так и для профессионалов.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1027, 'Экстремальный тайм-менеджмент | Мрочковский Николай Сергеевич, Толкачев Алексей Иванович', 1016, 1008, 'Экстремально действенные секреты тайм-менеджмента, понятные каждому! Перед вами художественная книга об управлении собой, лидерстве и достижении успеха. История обычного парня, который устал плыть по течению и принял решение достичь большего. В данной книге-тренинге вы найдете работающие методики по организации своего времени, карьеры, бизнеса, личной жизни. Вы научитесь: добиваться поставленных целей, невзирая на помехи и лень; планировать свой день; развиваться одновременно во всех направлениях. Читая книгу, вы с интересом будете наблюдать за трансформацией главного героя, выполняя задания и меняясь вместе с ним. Основано на реальных событиях!', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1028, 'Настольная книга лидера / Книги про бизнес и менеджмент | Мэнвилл Брук, Ашкеназ Рональд', 1016, 1008, 'Это не очередной модный фреймворк или список вроде «10 лучших вещей, которые вам нужны, чтобы стать лидером». Только практики лидерства, проверенные временем. Как создавать видение и вдохновлять других следовать ему. Как делать сложные стратегические выборы. Как создавать инновации. Как получать результаты. Сегодня эти фундаментальные навыки становятся еще более важными, поскольку организации и команды становятся все более взаимосвязанными, виртуальными, гибкими и быстро развивающимися. В этом всеобъемлющем руководстве специалисты по стратегиям и изменениям, Рон Ашкенас и Брук Мэнвилл, делятся концепциями лидерства Harvard Business Review, прошедшими проверку на практике. Интервью с руководителями высшего звена и их личный опыт в этой области, поможет молодым лидерам выделиться и получить большое влияние. Особенности Краткие объяснения проверенных концепций лидерства от участников Harvard Business Review, таких как Клейтон М. Кристенсен и Майкл Э. Портер. Углубленные тематические исследования руководителей, таких как Джим Вулфенсон из Всемирного банка, Паула Кергер из PBS, Даррен Уолкер из Фонда Форда и Джим Смит из Thomson Reuters. Пошаговое руководство, которое поможет вам понять и приступить к реализации шести основных практик лидерства: созданию объединяющего видения, разработке стратегии, привлечению лучших кандидатов, сосредоточению внимания на результатах, инновациям для будущего и собственной роли лидера. О серии Справочники HBR предоставляют амбициозным профессионалам основы, советы и инструменты, необходимые для достижения успеха в карьере. Благодаря пошаговым инструкциям, проверенным временем передовым методам, реальным историям и кратким объяснениям исследований, опубликованным в Harvard Business Review, каждый всеобъемлющий том поможет вам стать лучше, независимо от вашей текущей роли.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1029, 'Английский язык. Грамматика. Сборник упражнений 9 издание | Голицынский Юрий Борисович', 1017, 1007, 'Сборник упражнений по всем разделам английской грамматики. Упражнения основаны на несложной лексике. Они содержат достаточно материала для запоминания основных грамматических форм и выработки навыков их применения. Дополнен теоретическим материалом и словарем. Предназначен для учащихся 5-9 классов базовых школ и школ с углубленным изучением английского языка.', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' ),
       (1030, 'Логика. Учебник для средней школы. Репринт издания 1954г.', 1017, 1008, 'Отличием образования элитного и образования людей для обслуживания чужих интересов являются знания о человеке, обществе и базовые навыки мышления. В послевоенном СССР был период, когда такие предметы как психология и логика стали частью общеобразовательной программы. На некоторое время. Представляем советский учебник ЛОГИКИ для средней школы. ЦК ВКП(б) в постановлении «О преподавании логики и психологии в средней школе» от 3 декабря 1946 года признал совершенно ненормальным, что в средних школах не изучается логика и психология, и счел необходимым ввести в течение 4 лет, начиная с 1947/48 учебного года, преподавание этих предметов во всех школах Советского Союза. ', null, null, '2000-01-01 10:00:00.00','2000-01-01 10:00:00.00' );

ALTER SEQUENCE products_seq RESTART WITH 1031;