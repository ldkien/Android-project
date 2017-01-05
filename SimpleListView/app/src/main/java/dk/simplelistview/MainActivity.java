package dk.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import models.UserAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        UserAccount tom = new UserAccount("Tom", "admin");
        UserAccount jerry = new UserAccount("Jerry", "user");
        UserAccount donald = new UserAccount("Donald", "guest", false);

        UserAccount[] users = new UserAccount[]{tom, jerry, donald};
        // android.R.layout.simple_list_item_1: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một TextView).
        //ArrayAdapter<UserAccount> arrayAdapter
           //     = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_1, users);
        ArrayAdapter<UserAccount> arrayAdapter
             = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_multiple_choice, users);
        listView.setAdapter(arrayAdapter);
        

    }
}
