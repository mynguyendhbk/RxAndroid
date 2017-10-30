package edu.nguyenmy.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity{
    private TextView mTextView;
    private Observable<String> mObservable;
    private Observer<String> mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.textview);

        //mObservable phat ra gia tri
        mObservable = Observable.just("Hello RxAndroid");
        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            //hien thi gia tri do mObservable phat
            @Override
            public void onNext(String value) {
                mTextView.setText(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

    }
    //thiet lap phuong thuc dang ki quan sat mObservable
   public void subscribe(View view){
       mObservable.subscribe(mObserver);
   }


}
