package com.gil.gilzmovieapp.DataBase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MoviesRepository {

    private MyDao mMyDao;
        private LiveData<List<MyMovie>> allMovies;

    public MoviesRepository(Application application) {
        MyAppDataBase myAppDataBase = MyAppDataBase.getInstance(application);
        mMyDao = myAppDataBase.mMyDao();
        allMovies = mMyDao.getAllNMovies();
    }

    public void insert(MyMovie myMovie) {
        new InsertAsyncTask(mMyDao).execute(myMovie);
    }

    public void update(MyMovie myMovie) {
        new UpdateAsyncTask(mMyDao).execute(myMovie);
    }


    public LiveData<List<MyMovie>> getAllMovies() {
        return allMovies;
    }


    private static class InsertAsyncTask extends AsyncTask<MyMovie, Void, Void> {
        private MyDao mMyDao;

        private InsertAsyncTask(MyDao myDao) {
            this.mMyDao = myDao;
        }

        @Override
        protected Void doInBackground(MyMovie... movies) {
            mMyDao.insert(movies[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<MyMovie, Void, Void> {
        private MyDao mMyDao;

        private UpdateAsyncTask(MyDao myDao) {
            this.mMyDao = myDao;
        }

        @Override
        protected Void doInBackground(MyMovie... movies) {
            mMyDao.update(movies[0]);
            return null;
        }
    }
}
