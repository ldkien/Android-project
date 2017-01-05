package dk.event_example;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    EditText userName;
    EditText passWord;
    Switch switchLogin;
    Button _login;
    ToggleButton toggleButton;
    View.OnClickListener myOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (userName.getText().toString().equals("kien") && passWord.getText().toString().equals("123")) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                //set title
                alertDialog.setTitle("Response");
                //set message
                alertDialog.setMessage("Susscess")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _login = (Button) findViewById(R.id.btn_login);
        userName = (EditText) findViewById(R.id.edit_username);
        passWord = (EditText) findViewById(R.id.edit_pass);
        switchLogin = (Switch) findViewById(R.id.switchLogin);
        toggleButton = (ToggleButton) findViewById(R.id.togBtn);
        final TextView textView = (TextView) findViewById(R.id.textView);
        /*_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString()=="kien" && passWord.getText().toString()=="123")
                {
                    AlertDialog.Builder alertDialog  = new AlertDialog.Builder(context);
                    //set title
                    alertDialog.setTitle("Response");
                    //set message
                    alertDialog.setMessage("Susscess");
                }
                if (userName.getText().toString().equals("kien") && passWord.getText().toString().equals("123")) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    //set title
                    alertDialog.setTitle("Response");
                    //set message
                    alertDialog.setMessage("Susscess")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });
                    alertDialog.show();
                }
            }
        });*/
        _login.setOnClickListener(myOnClick);
        toggleButton.setChecked(true);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.getText().toString().equals("NO"))
                    toggleButton.setOnClickListener(myOnClick);

            }
        });
    }
}
