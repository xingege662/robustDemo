package cx.com.robustdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchExecutor;
import com.meituan.robust.RobustCallBack;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE},0);

        findViewById(R.id.loaddPatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new Callback()).start();
            }
        });

        findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RobustActivity.class));
            }
        });

    }

    class Callback implements RobustCallBack {

        @Override
        public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {
            System.out.println(" robust arrived in onPatchListFetched");
        }

        @Override
        public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
            System.out.println(" robust arrived in onPatchFetched");
        }

        @Override
        public void onPatchApplied(boolean result, Patch patch) {
            System.out.println(" robust arrived in onPatchApplied ");

        }

        @Override
        public void logNotify(String log, String where) {
            System.out.println(" robust arrived in logNotify " + where);
        }

        @Override
        public void exceptionNotify(Throwable throwable, String where) {
            throwable.printStackTrace();
            System.out.println(" robust arrived in exceptionNotify " + where);
        }
    }
}
