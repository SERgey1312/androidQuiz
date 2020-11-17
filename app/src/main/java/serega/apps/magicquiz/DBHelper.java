package serega.apps.magicquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public static final int DATABASE_VERSION = 10;
    public static final String DATABASE_NAME = "magic_quiz";
    public static final String QUESTION_TABLE = "questions";


    public static final String QUESTION_ID = "_ID";
    public static final String QUESTION_BODY = "question_body";
    public static final String QUESTION_THEME = "question_theme";
    public static final String ANS1 = "ans1";
    public static final String ANS2 = "ans2";
    public static final String ANS3 = "ans3";
    public static final String ANS4 = "ans4";
    public static final String TRUE_ANS = "true_ans";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String QUESTIONS = "create table " +
                QUESTION_TABLE + "(" +
                QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QUESTION_BODY + " TEXT, " +
                QUESTION_THEME + " TEXT, " +
                ANS1 + " TEXT, " +
                ANS2 + " TEXT, " +
                ANS3 + " TEXT, " +
                ANS4 + " TEXT, " +
                TRUE_ANS + " TEXT" + ")";
        db.execSQL(QUESTIONS);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + QUESTION_TABLE);
        onCreate(db);
    }

    private void fillQuestionTable() {
        Question q1 = new Question("Самое глубокое озеро в мире?", "Байкал", "Нарочь", "Глубокое", "Неизвестно", "Байкал", "nature");
        insertQuestion(q1);
        Question q2 = new Question("Самое большое по площади озеро в мире?", "Байкал", "Нарочь", "Мёртвое море", "Черное море", "Мёртвое море", "nature");
        insertQuestion(q2);
        Question q3 = new Question("Самое большое млекопитающее?", "Слон", "Синий кит", "Касатка", "Белый медведь", "Синий кит", "nature");
        insertQuestion(q3);
        Question q4 = new Question("Самая маленькая птица в мире?", "Карликовый воробей", "Каллибри", "Голубь", "Карликовая ворона", "Каллибри", "nature");
        insertQuestion(q4);
        Question q5 = new Question("Как называется водная оболочка Земли?", "Гидросфера", "Литосфера", "Ионосфера", "Океан", "Гидросфера", "nature");
        insertQuestion(q5);
        Question q6 = new Question("Самое опасное животное на Земле?", "Тигр", "Лев", "Акула", "Человек", "Человек", "nature");
        insertQuestion(q6);
        Question q7 = new Question("Какое животное вымерло?", "Мамонт", "Лев", "Акула", "Утконос", "Мамонт", "nature");
        insertQuestion(q7);
        Question q8 = new Question("Какое животное несет яйца?", "Кенгуру", "Утконос", "Заяц", "Волк", "Утконос", "nature");
        insertQuestion(q8);
        Question q9 = new Question("Как называется самая высокая гора в мире?", "Эверест", "Бухарест", "Килиманджаро", "Восток", "Эверест", "nature");
        insertQuestion(q9);
        Question q10 = new Question("Что едят ежи?", "Яблоки", "Грибы", "Всеядные", "Только мясо", "Всеядные", "nature");
        insertQuestion(q10);
        Question q11 = new Question("Какой газ производят растения?", "Сернистый", "Водород", "Неон", "Кислород", "Кислород", "nature");
        insertQuestion(q11);
        Question q12 = new Question("Какой газ выдыхают животные?", "Сернистый", "Водород", "Углекислый", "Кислород", "Углекислый", "nature");
        insertQuestion(q12);
        Question q13 = new Question("Какой газ нужен для жизни всем?", "Азотный", "Водород", "Углекислый", "Кислород", "Кислород", "nature");
        insertQuestion(q13);
        Question q14 = new Question("Птица-санитар леса?", "Голубь", "Сова", "Кукушка", "Дятел", "Дятел", "nature");
        insertQuestion(q14);
        Question q15 = new Question("Сколько цветов в радуге?", "5", "10", "7", "6", "7", "nature");
        insertQuestion(q15);
        Question q16 = new Question("Как выглядит ipV4 адрес?", "192.168.0.1", "299.475.888.11", "192..0.0", "256.1.1.1", "192.168.0.1", "technology");
        insertQuestion(q16);
        Question q17 = new Question("Логотипом какого ЯП является слон?", "PHP", "C++", "JS", "C#", "PHP", "technology");
        insertQuestion(q17);
        Question q18 = new Question("Логотипом какого ЯП является кружка кофе?", "PHP", "C++", "Java", "C#", "Java", "technology");
        insertQuestion(q18);
        Question q19 = new Question("Логотипом какого ЯП является змея?", "PHP", "C++", "Java", "Python", "Python", "technology");
        insertQuestion(q19);
        Question q20 = new Question("Какой ЯП является низкоуровневым?", "PHP", "C++", "Java", "Assembler", "Assembler", "technology");
        insertQuestion(q20);
        Question q21 = new Question("Какой формат файла используется при создании сжатого цифрового архива?", "JPEG", "PNG", "ZIP", "PDF", "ZIP", "technology");
        insertQuestion(q21);
        Question q22 = new Question("Благодаря какой технологии возможны телефонные звонки через интернет?", "VoIP", "Bluetooth", "Ethernet", "V8", "VoIP", "technology");
        insertQuestion(q22);
        Question q23 = new Question("Какой ЯП используется наиболее широко?", "PHP", "C#", "JAVA", "Swift", "JAVA", "technology");
        insertQuestion(q23);
        Question q24 = new Question("Какой примерно объем информации существует в цифровом мире на сегодняшний день?", "2,7 мегабайт", "2,7 зеттабайт", "2,7 террабайт", "2,7 гигабайт", "2,7 зеттабайт", "technology");
        insertQuestion(q24);
        Question q25 = new Question("Какой ЯП используется для оживления статичных html-страниц?", "JS", "JAVA", "PHP", "CSS", "JS", "technology");
        insertQuestion(q25);
        Question q26 = new Question("Сколько есть уровней сетевой модели OSI?", "3", "4", "7", "6", "7", "technology");
        insertQuestion(q26);
        Question q27 = new Question("Чем отличается роутер от маршрутизатора?", "Роутер быстрее", "Роутер медленнее", "Ничем", "Много чем", "Ничем", "technology");
        insertQuestion(q27);
        Question q28 = new Question("Сколько типов данных всего есть в PHP?", "5", "6", "10", "3", "10", "technology");
        insertQuestion(q28);
        Question q29 = new Question("Сколько типов данных всего есть в JS?", "8", "3", "5", "7", "8", "technology");
        insertQuestion(q29);
        Question q30 = new Question("Что используется для стилизации веб-страниц?", "HTML4", "PHP", "CSS", "HTML5", "CSS", "technology");
        insertQuestion(q30);
        Question q31 = new Question("Кто в пьесе А. П. Чехова \"Вишнёвый сад\" сказал: «Вся Россия наш сад»?", "Трофимов", "Гаев", "Клюев", "Никто", "Трофимов", "literature");
        insertQuestion(q31);
        Question q32 = new Question("В какой город отправляют служить в армию \"недоросля\" в \"Капитанской дочке\"?", "Москва", "Минск", "Оренбург", "Питер", "Оренбург", "literature");
        insertQuestion(q32);
        Question q33 = new Question("Кому адресует слова «служить бы рад, прислуживаться тошно» Чацкий в \"Горе от ума\"?", "Фамусову", "Хлестову", "Скалозубу", "Молчанину", "Фамусову", "literature");
        insertQuestion(q33);
        Question q34 = new Question("Кто в романе \"Отцы и дети\" характеризует Базарова:  «Он хищный, а мы с вами ручные»?", "Ситников", "Павел Петрович", "Анна Одинцова", "Катя Одинцова", "Катя Одинцова", "literature");
        insertQuestion(q34);
        Question q35 = new Question("Кто убил Пушкина А.С.?", "Дантес", "Шумахер", "Сам себя", "Неизвесно", "Дантес", "literature");
        insertQuestion(q35);
        Question q36 = new Question("Какое имя у главного героя романа \"Детство\" Л. Н. Толстого", "Михаил", "Николай", "Алина", "Виктор", "Николай", "literature");
        insertQuestion(q36);
        Question q37 = new Question("Выбери название, которое не из романа \"Герой нашего времени\".", "Максим Максимыч", "Бэла", "Нигилист", "Княжна Мэри", "Нигилист", "literature");
        insertQuestion(q37);
        Question q38 = new Question("Кто убил Лермонтова?", "Дантес", "Мартынов", "Сам себя", "Неизвесно", "Мартынов", "literature");
        insertQuestion(q38);
        Question q39 = new Question("Кто убил Есенина?", "Дантес", "Мартынов", "Сам себя", "Неизвесно", "Сам себя", "literature");
        insertQuestion(q39);
        Question q40 = new Question("Чем зарабатывал герой повести Александра Грина «Алые паруса» Лонгрен?", "Чинил корабли", "Продавал лодки", "Рисовал", "Изготавливал модели парусников и пароходов", "Изготавливал модели парусников и пароходов", "literature");
        insertQuestion(q40);
        Question q41 = new Question("Назови настоящее имя Аси из одноимённой повести И. С. Тургенева.", "Ася", "Алина", "Настя", "Анна", "Анна", "literature");
        insertQuestion(q41);
        Question q42 = new Question("Родина солдата Тёркина из поэмы «Василий Тёркин» Александра Твардовского — ...?", "Смоленщина", "Подмосковье", "Питер", "Детдом", "Смоленщина", "literature");
        insertQuestion(q42);
        Question q43 = new Question("В каком городе происходят действия поэмы М. Ю. Лермонтова «Мцыри»?", "Смоленск", "Цагери", "Мцхет", "Ушхунб", "Мцхет", "literature");
        insertQuestion(q43);
        Question q44 = new Question("Продолжи слова из повести Н. В. Гоголя «Шинель». «Строгость, строгость и — ...». ", "строгость", "закон", "война", "честность", "строгость", "literature");
        insertQuestion(q44);
        Question q45 = new Question("Кто написал Войну и Мир", "Толстый", "Пушкин", "Народ", "Толстой", "Толстой", "literature");
        insertQuestion(q45);
        Question q46 = new Question("Карибский кризис 1962 года разгорелся между?", "США и СССР", "Кубой и США", "США и Китаем", "Внутри США", "США и СССР", "history");
        insertQuestion(q46);
        Question q47 = new Question("В каком городе подвели итоги Первой мировой войны?", "Вена", "Париж", "Москва", "Берлин", "Париж", "history");
        insertQuestion(q47);
        Question q48 = new Question("Какой японский император правил с конца 1926 и до 1989 года?", "Кацубан", "Муцухито", "Хирохито", "Олкахита", "Муцухито", "history");
        insertQuestion(q48);
        Question q49 = new Question("Пакт Молотова-Риббентропа между СССР и Германией был подписан в ... ?", "1937", "1939", "1941", "1945", "1939", "history");
        insertQuestion(q49);
        Question q50 = new Question("Сколько стран состоит в Содружестве наций?", "39", "22", "52", "47", "52", "history");
        insertQuestion(q50);
        Question q51 = new Question("Кто из этих личностей бывший премьер-министр Великобритании?", "Уинстон Черчиль", "Хио Грант", "Франсуа Кавани", "Аджель Руссо", "Уинстон Черчиль", "history");
        insertQuestion(q51);
        Question q52 = new Question("Первый император России?", "Иван Грозный", "Иван Первый", "Иван Второй", "Пётр Первый", "Пётр Первый", "history");
        insertQuestion(q52);
        Question q53 = new Question("До получения независимости Нидерланды были колонией?", "Португалии", "Англии", "Испании", "Франции", "Испании", "history");
        insertQuestion(q53);
        Question q54 = new Question("На конференции в каком городе было принято решение о создании ООН?", "Женева", "Москва", "Лондон", "Вашингтон", "Женева", "history");
        insertQuestion(q54);
        Question q55 = new Question("Кто сменил на посту генерального секретаря КПСС Леонида Брежнева?", "Андропов", "Хрущев", "Сталин", "Черненко", "Андропов", "history");
        insertQuestion(q55);
        Question q56 = new Question("\"Душой ислама\" называют ...", "Тафсир", "Коран", "Фикх", "Суфизм", "Суфизм", "history");
        insertQuestion(q56);
        Question q57 = new Question("Какие государства, являлись доминионами Великобритании после первой мировой войны?", "Индия, Аргентина", "Австралия, Алжир", "Нигерия, Канада", "Алжир, Нигерия", "Нигерия, Канада", "history");
        insertQuestion(q57);
        Question q58 = new Question("Высшим органом ООН является ...", "Генеральная Ассамблея", "Международный совет", "Совет ООН", "Верховная Рада", "Генеральная Ассамблея", "history");
        insertQuestion(q58);
        Question q59 = new Question("Древнейшая посуда вначале изготовлялась из ...", "Камня", "Металла", "Дерева", "Глины", "Дерева", "history");
        insertQuestion(q59);
        Question q60 = new Question("В какой отрасли производства начался промышленный переворот?", "В тяжелой промышленность", "В сельском хозяйстве", "В лесной промышленности", "В легкой промышленности", "в легкой промышленности", "history");
        insertQuestion(q60);
        Question q61 = new Question("Представьте 48 минут в часах.", "0,8", "0,48", "0,5", "0,96", "0,8", "mathematics");
        insertQuestion(q61);
        Question q62 = new Question("Луч, исходящий из вершины угла и делящий этот угол на два равных угла.", "Медиана", "Высота", "Биссектриса", "Хорда", "Биссектриса", "mathematics");
        insertQuestion(q62);
        Question q63 = new Question("Отрезок, соединяющий вершину треугольника с серединой противоположной стороны.", "Медиана", "Высота", "Биссектриса", "Хорда", "Медиана", "mathematics");
        insertQuestion(q63);
        Question q64 = new Question("Отрезок перпендикуляра, опущенного из вершины геометрической фигуры на её основание или на продолжение основания.", "Медиана", "Высота", "Биссектриса", "Хорда", "Высота", "mathematics");
        insertQuestion(q64);
        Question q65 = new Question("Отрезок, соединяющий две точки данной кривой.", "Медиана", "Высота", "Биссектриса", "Хорда", "Хорда", "mathematics");
        insertQuestion(q65);
        Question q66 = new Question("Синус 90 градусов?", "0", "1", "0,5", "-1", "1", "mathematics");
        insertQuestion(q66);
        Question q67 = new Question("Косинус 90 градусов?", "0", "1", "0,5", "-1", "0", "mathematics");
        insertQuestion(q67);
        Question q68 = new Question("Понятие дифференциального исчисления, характеризующее скорость изменения функции в данной точке.", "Тангенс", "Интеграл", "Логарифм", "Произвлдная", "Производная", "mathematics");
        insertQuestion(q68);
        Question q69 = new Question("24 * 316 (без калькулятора)", "7548", "7684", "7584", "7084", "7584", "mathematics");
        insertQuestion(q69);
        Question q70 = new Question("Как решают квадраное уравнение?", "По теореме Виета", "Через Дискриминант", "Дискриминант, теорема Виета", "Ни один зи вариантов", "Дискриминант, теорема Виета", "mathematics");
        insertQuestion(q70);
        Question q71 = new Question("Сумма квадратов длин катетов равна квадрату длины гипотенузы. Что это?", "Теорема Дарвина", "Теорема Виета", "Теорема Корена", "Теорема Пифагора", "Теорема Пифагора", "mathematics");
        insertQuestion(q71);
        Question q72 = new Question("Квадратный корень из 256?", "16", "12", "18", "26", "16", "mathematics");
        insertQuestion(q72);
        Question q73 = new Question("Формулы, связывающие коэффициенты многочлена и его корни.", "Формулы Виета", "Формулы Пифагора", "Формулы Евклида", "Формулы Энштейна", "Формулы Виета", "mathematics");
        insertQuestion(q73);
        Question q74 = new Question("Одна из основных крупных ветвей математики, являющаяся развитием и обобщением арифметики", "Геометрия", "Алгебра", "Тригонометрия", "Планиметрия", "Алгебра", "mathematics");
        insertQuestion(q74);
        Question q75 = new Question("Раздел математики, изучающий пространственные структуры и отношения между ними.", "Геометрия", "Алгебра", "Тригонометрия", "Арифметика", "Геометрия", "mathematics");
        insertQuestion(q75);
    }

    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QUESTION_BODY, question.getQuestion());
        cv.put(QUESTION_THEME, question.getCategory());
        cv.put(ANS1, question.getAns1());
        cv.put(ANS2, question.getAns2());
        cv.put(ANS3, question.getAns3());
        cv.put(ANS4, question.getAns4());
        cv.put(TRUE_ANS, question.getTrueAns());
        db.insert(QUESTION_TABLE, null, cv);
    }

    public ArrayList<Question> getQuestionList(String category){
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String selection = QUESTION_THEME + "= ?";

        String[] selectionArgs = new String[] {category};

        Cursor cursor = db.query(QUESTION_TABLE,
                null,
                selection,
                selectionArgs,
                null,null,null);
        if (cursor.moveToFirst()){
            do {
                Question question = new Question();
                question.setId(cursor.getInt(cursor.getColumnIndex(QUESTION_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QUESTION_BODY)));
                question.setCategory(cursor.getString(cursor.getColumnIndex(QUESTION_THEME)));
                question.setAns1(cursor.getString(cursor.getColumnIndex(ANS1)));
                question.setAns2(cursor.getString(cursor.getColumnIndex(ANS2)));
                question.setAns3(cursor.getString(cursor.getColumnIndex(ANS3)));
                question.setAns4(cursor.getString(cursor.getColumnIndex(ANS4)));
                question.setTrueAns(cursor.getString(cursor.getColumnIndex(TRUE_ANS)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }
}
