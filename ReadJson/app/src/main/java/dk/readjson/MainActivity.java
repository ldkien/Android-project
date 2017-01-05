package dk.readjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView monHoc, noiHoc, website, fanPage;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monHoc = (TextView) findViewById(R.id.textViewMonhoc);
        noiHoc = (TextView) findViewById(R.id.textViewNoihoc);
        website = (TextView) findViewById(R.id.textViewWebsite);
        fanPage = (TextView) findViewById(R.id.textViewFanpage);
        listView = (ListView) findViewById(R.id.lv);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJson().execute("http://khoapham.vn/KhoaPhamTraining/laptrinhios/jSON/demo3.json");
                new ReadJson2().execute("http://khoapham.vn/KhoaPhamTraining/android/json/demo3.json");
            }
        });
    }

    class ReadJson extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            try {
                JSONObject root = new JSONObject(s);
                JSONArray mang = root.getJSONArray("danhsach");

                ArrayList<String> khoaHoc = new ArrayList<String>();

                for (int i=0;i<mang.length();i++){
                    JSONObject son = mang.getJSONObject(i);
                    khoaHoc.add(son.getString("khoahoc"));
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,khoaHoc);
                listView.setAdapter(arrayAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    class ReadJson2 extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            try {
                JSONObject root = new JSONObject(s);
                String mh = root.getString("monhoc");
                monHoc.setText(mh);
                String nh = root.getString("noihoc");
                noiHoc.setText(nh);
                String web = root.getString("website");
                website.setText(web);
                String fan = root.getString("fanpage");
                fanPage.setText(fan);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }


}
