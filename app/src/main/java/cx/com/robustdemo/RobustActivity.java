package cx.com.robustdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.meituan.robust.patch.annotaion.Add;
import com.meituan.robust.patch.annotaion.Modify;


public class RobustActivity extends AppCompatActivity {


    @Override
    @Modify
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robust);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText("热更了");
        log();
    }

    @Add
    public void log(){
        for(int i = 0;i<10;i++){
            Log.d("tag", "输出的i值是"+i);
        }
    }
}
