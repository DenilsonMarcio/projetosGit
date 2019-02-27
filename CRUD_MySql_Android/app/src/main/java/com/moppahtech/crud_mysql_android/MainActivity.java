package com.moppahtech.crud_mysql_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtAviso,txtRodape1;
    EditText editNome, editContato, editEmail, editHistoria, editId;
    Button btnSalvar, btnatualizar, btnPesquisar,btnExcluir;

    public void limpar (View view){

        editId.setText("");
        editNome.setText("");
        editContato.setText("");
        editEmail.setText("");
        editHistoria.setText("");
        txtAviso.setText("Carregando...");
        //editId.findFocus();

    }
    private void limpar() {
        editId.clearFocus();
        editId.setText("");
        editNome.setText("");
        editContato.setText("");
        editEmail.setText("");
        editHistoria.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAviso = findViewById(R.id.txtAviso);
        txtRodape1 = findViewById(R.id.txtRodape1);
        editNome = findViewById(R.id.editName);
        editContato = findViewById(R.id.editContato);
        editEmail = findViewById(R.id.editEmail);
        editHistoria = findViewById(R.id.editHistoria);
        editId = findViewById(R.id.editId);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnatualizar = findViewById(R.id.btnatualizar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnExcluir = findViewById(R.id.btnExcluir);
    }
        public void salvar (View view){


        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            OkHttpClient client = new OkHttpClient();

            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://moppahtech.co.nf/crud_create.php").newBuilder();
            urlBuilder.addQueryParameter("CRUD_Nome", editNome.getText().toString());
            urlBuilder.addQueryParameter("CRUD_Contato", editContato.getText().toString());
            urlBuilder.addQueryParameter("CRUD_Email", editEmail.getText().toString());
            urlBuilder.addQueryParameter("CRUD_Historia", editHistoria.getText().toString());


            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                txtAviso.setText(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }


            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        limpar();

        }



    public void atualizar (View view){

            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                OkHttpClient client = new OkHttpClient();

                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://moppahtech.co.nf/crud_update.php").newBuilder();

                urlBuilder.addQueryParameter("ID_crud",editId.getText().toString());
                urlBuilder.addQueryParameter("CRUD_Nome", editNome.getText().toString());
                urlBuilder.addQueryParameter("CRUD_Contato", editContato.getText().toString());
                urlBuilder.addQueryParameter("CRUD_Email", editEmail.getText().toString());
                urlBuilder.addQueryParameter("CRUD_Historia", editHistoria.getText().toString());


                String url = urlBuilder.build().toString();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                try {
                                    txtAviso.setText(response.body().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                    }


                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            limpar();

        }
        public void pesquisar (View view){

            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                OkHttpClient client = new OkHttpClient();

                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://moppahtech.co.nf/crud_read.php").newBuilder();
                urlBuilder.addQueryParameter("ID_crud", editId.getText().toString());

                String url = urlBuilder.build().toString();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                try {
                                    //txtAviso.setText(response.body().string());

                                    try {
                                        String data = response.body().string();

                                        JSONArray jsonArray = new JSONArray(data);
                                        JSONObject jsonObject;

                                        jsonObject = jsonArray.getJSONObject(0);

                                        editNome.setText(jsonObject.getString("CRUD_Nome"));
                                        editContato.setText(jsonObject.getString("CRUD_Contato"));
                                        editEmail.setText(jsonObject.getString("CRUD_Email"));
                                        editHistoria.setText(jsonObject.getString("CRUD_Historia"));

                                    } catch (JSONException e) {
                                        txtAviso.setText(e.getMessage());
                                    }


                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                    }


                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        public void excluir (View view){

            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                OkHttpClient client = new OkHttpClient();

                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://moppahtech.co.nf/crud_delete.php").newBuilder();
                urlBuilder.addQueryParameter("ID_crud", editId.getText().toString());
                String url = urlBuilder.build().toString();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    txtAviso.setText(response.body().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            limpar();
        }

    }

