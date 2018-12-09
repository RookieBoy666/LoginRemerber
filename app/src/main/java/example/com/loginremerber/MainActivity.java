package example.com.loginremerber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;

    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exit= (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击注销按键后调用LoginActivity提供的resetSprfMain()方法执行editorMain.putBoolean("main",false);，即将"main"对应的值修改为false
                resetSprfMain();
                Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }

    public void resetSprfMain(){
        sprfMain= PreferenceManager.getDefaultSharedPreferences(this);
        editorMain=sprfMain.edit();
        editorMain.putBoolean("main",false);
        editorMain.commit();
    }

}
