package cn.itsite.suiliao;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_chat);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_play);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_mine);
                    return true;
                default:
                    break;
            }
            return false;
        });
    }

}
