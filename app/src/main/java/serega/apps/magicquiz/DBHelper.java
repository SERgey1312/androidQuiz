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

    public static final int DATABASE_VERSION = 6;
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
        Question q1 = new Question("Получилось?", "ДА", "НЕТ", "Наверное", "Посмотрим", "ДА", "nature");
        insertQuestion(q1);
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

    public ArrayList<Question> getQuestionList(){
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + QUESTION_TABLE, null);
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
