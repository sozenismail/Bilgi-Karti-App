package com.ismailsozen.bilgilerenteresan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context=this;
    ListView listViewBilgi;
    List<Bilgi> bilgilist;
    SQliteHelper db=new SQliteHelper(context);
    ArrayAdapter<String> arrayAdapter;
    Button buttonDegis,buttonDegisGeri;
    int i;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBilgi=findViewById(R.id.listviewBilgi);
        buttonDegis=findViewById(R.id.buttonDegis);
        buttonDegisGeri=findViewById(R.id.buttonDegisGeri);



        db.onUpgrade(db.getWritableDatabase(),1,2);

        db.BilgiEkle(new Bilgi("Türkiye'de Barış ismini ilk olarak Barış Manço almıştır."));
        db.BilgiEkle(new Bilgi("Dünyanın en çok satan telefonu iPhone değil  Nokia 1100'dur.."));
        db.BilgiEkle(new Bilgi("Japonya'da Tadao Yoshida tarafından 1934'de fermuar üretimi amacıyla kurulmuştur"));
        db.BilgiEkle(new Bilgi("Psikologlara göre yalnızlık hissi, kimse sizi takmadığında değil, ilgisini beklediğiniz kişi sizi hiç takmadığında oluşur."));
        db.BilgiEkle(new Bilgi("Steve Jobs Suriyelidir. Babası Abdulfattah Jandali adlı Suriyeli Arap'tır ve Jobs'u evlatlık vermiştir..."));
        db.BilgiEkle(new Bilgi("Gallium adlı bu metalin erime noktası bir insanın elindeki sıcaklıktan düşük olduğundan elinizle tuttuğunuzda sıvılaşır."));
        db.BilgiEkle(new Bilgi("Kanalizasyon kapağının kare, altıgen vs. değil de, daire şeklinde olmasının sebebi daire şeklindeki kapağın yan dönse de içeri düşmemesidir."));


        bilgilist=db.BilgiGetir();

        final List<String> listOzel = new ArrayList<>();
        listOzel.add(0, bilgilist.get(0).bilgi_yazi);
        arrayAdapter = new ArrayAdapter<String>(context, R.layout.satir_layout, R.id.listMetin, listOzel);
        listViewBilgi.setAdapter(arrayAdapter);

        i=-1;




        buttonDegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // içerde i yi arttırıyoruz bu yüzden i<=1 e kadar deriz yani 0 dan 2 ye kadar demiş oluruz

                if (i>=-1 && i<=bilgilist.size()-2){

                    i++;
                    listOzel.add(0, bilgilist.get(i).bilgi_yazi);

                    arrayAdapter = new ArrayAdapter<String>(context, R.layout.satir_layout, R.id.listMetin, listOzel);
                    listViewBilgi.setAdapter(arrayAdapter);
                }
                else {

                    // do nothing
                }

            }
        });

        buttonDegisGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> listOzel = new ArrayList<>();

                if (i<=0) {

                    // do nothing
                }
                else {
                    i--;
                    listOzel.add(0, bilgilist.get(i).bilgi_yazi);

                    arrayAdapter = new ArrayAdapter<String>(context, R.layout.satir_layout, R.id.listMetin, listOzel);
                    listViewBilgi.setAdapter(arrayAdapter);
                }
            }
        });

















    }
}
