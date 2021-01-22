package com.czt.sdgrocord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import com.czt.mp3recorder.Mp3Recorder;
import com.czt.mp3recorder.util.StopAction;

public class MainActivity extends AppCompatActivity {

    private Mp3Recorder mRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void start(View view) {
        mRecorder.start();
    }

    public void pause(View view) {
        mRecorder.pause();
    }

    public void resume(View view) {
        mRecorder.resume();
    }

    public void stop(View view) {
        mRecorder.stop(StopAction.ACTION_STOP_ONLY);
    }

    private void init() {
        String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/003/" + System.currentTimeMillis() + ".mp3";
        Log.i("record -> ","录音文件路径：" + filepath);
        mRecorder = new Mp3Recorder();
        mRecorder.createFileDir(Environment.getExternalStorageDirectory().getAbsolutePath() + "/003/");
        mRecorder.setOutputFile(filepath)
                .setCallback(new Mp3Recorder.Callback() {
                    @Override
                    public void onStart() {
                        Log.i("record -> ","录音开始了");
                    }

                    @Override
                    public void onPause() {
                        Log.i("record -> ","录音暂停了");
                    }

                    @Override
                    public void onResume() {
                        Log.i("record -> ","录音恢复了");
                    }

                    @Override
                    public void onStop(int action) {
                        Log.i("record -> ","录音停止了");
                    }

                    @Override
                    public void onReset() {
                        Log.i("record -> ","录音撤销了");
                    }

                    @Override
                    public void onRecording(double duration, double volume) {
                        Log.i("record -> ","录音时间：" + duration);
                    }

                    @Override
                    public void onMaxDurationReached() {
                    }
                });
    }
}