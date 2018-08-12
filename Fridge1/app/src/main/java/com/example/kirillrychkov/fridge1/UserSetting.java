package com.example.kirillrychkov.fridge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSetting extends AppCompatActivity {
        private final static String FILE_NAME="test.txt";
        final String LOG_TAG = "myLogs";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_usersetting);
            List<String> a=new ArrayList<String>();


            a.add("Мясоед");
            a.add("Вегетарианец");
            a.add("Постящийся");
            a.add("Диета");
            a.add("Еда для беременных");


            ListView lvMain = findViewById(R.id.lvOk2);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,a );
            lvMain.setAdapter(adapter);


            lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                        long id) {
                    Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
                            Toast.LENGTH_SHORT).show();
                }
            });

            lvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    Log.d(LOG_TAG, "scrollState = " + scrollState);
                }

                public void onScroll(AbsListView view, int firstVisibleItem,
                                     int visibleItemCount, int totalItemCount) {
                }
            });
        }


        public String openText(){

            FileInputStream fin = null;
            try {
                fin = openFileInput(FILE_NAME);
                byte[] bytes = new byte[fin.available()];
                fin.read(bytes);
                String text = new String (bytes);
                return text;
            }
            catch(IOException ex) {

                boolean kostil=true;
                return FILE_NAME;
            }
            finally{

                try{
                    if(fin!=null)
                        fin.close();
                }
                catch(IOException ex){

                    boolean kostil=true;
                }
            }
        }
        public void saveText(String obmen){
            FileOutputStream fos = null;
            try {

                String text =obmen;
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());
            }
            catch(IOException ex) {
                boolean kostil=true;
            }
            finally{
                try{
                    if(fos!=null)
                        fos.close();
                }
                catch(IOException ex){
                    boolean kostil=true;
                }
            }
        }

    }

