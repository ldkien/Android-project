package dk.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import models.UserAccount;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ListViewExample";
    private ListView listView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        // CHOICE_MODE_NONE: Không cho phép lựa chọn (Mặc định).
        // ( listView.setItemChecked(..) không làm việc với CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE: Cho phép một lựa chọn.
        // CHOICE_MODE_MULTIPLE: Cho phép nhiều lựa chọn.
        // CHOICE_MODE_MULTIPLE_MODAL: Cho phép nhiều lựa chọn trên Modal Selection Mode.
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                UserAccount user = (UserAccount) listView.getItemAtPosition(position);
                user.setActive(!currentCheck);
            }
        });
        UserAccount tom = new UserAccount("Tom", "admin");
        UserAccount jerry = new UserAccount("Jerry", "user");
        UserAccount donald = new UserAccount("Donald", "guest", false);
        UserAccount[] users = new UserAccount[]{tom, jerry, donald};

        // android.R.layout.simple_list_item_checked: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một CheckedTextView).

        ArrayAdapter<UserAccount> arrayAdapter
                = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_multiple_choice, users);

        listView.setAdapter(arrayAdapter);
        for (int i = 0; i < users.length; i++) {
            listView.setItemChecked(i, users[i].isActive());
        }
    }

    public void printSelectedItems(View view) {

        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sp.size(); i++) {
            if (sp.valueAt(i) == true) {
                UserAccount user = (UserAccount) listView.getItemAtPosition(i);
                // Or:
                // String s = ((CheckedTextView) listView.getChildAt(i)).getText().toString();
                String s = user.getUserName();
                sb = sb.append(" " + s);
            }
        }
        Toast.makeText(this, "Selected items are: " + sb.toString(), Toast.LENGTH_LONG).show();

    }
}

