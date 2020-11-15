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

    public static final int DATABASE_VERSION = 8;
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
