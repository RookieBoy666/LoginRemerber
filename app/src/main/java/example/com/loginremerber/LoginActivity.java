package example.com.loginremerber;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在加载布局文件前判断是否登陆过
        sprfMain= PreferenceManager.getDefaultSharedPreferences(this);
        editorMain=sprfMain.edit();
        //.getBoolean("main",false)；当找不到"main"所对应的键值是默认返回false
        if(sprfMain.getBoolean("main",false)){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }
        setContentView(R.layout.login);
        login= (Button) findViewById(R.id.login);
        //这里只是简单用按键模拟登录功能
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                editorMain.putBoolean("main",true);
                editorMain.commit();
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }


}
