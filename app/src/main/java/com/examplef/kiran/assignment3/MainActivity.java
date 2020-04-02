package com.examplef.kiran.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText price,tot;
    order ord;
    ImageView image;
    RadioGroup rg;
    SeekBar sk;
    Double total;
    CheckBox ck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.itemSpin);
        price=findViewById(R.id.priceText);
        image=findViewById(R.id.image);
        rg=findViewById(R.id.Tip);
        sk=findViewById(R.id.seekbar);
        tot=findViewById(R.id.totalText);
        ck=findViewById(R.id.check);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item=sp.getSelectedItem().toString();
                switch (item)
                {
                    case "Masala_Dosa":
                        ord.setName("Masala Dosa");
                        ord.setPrice(10.49);
                        price.setText("Price : 10.49)");
                        image.setImageResource(R.drawable.masaladosa);
                        break;
                    case "Plain_Dosa":
                        ord.setName("Plain Dosa");
                        ord.setPrice(7.49);
                        price.setText("Price : 7.49)");
                        image.setImageResource(R.drawable.plaindosa);
                        break;
                    case "Ney_Roast":
                        ord.setName("Ney Roast");
                        ord.setPrice(9.49);
                        price.setText("Price : 9.49)");
                        image.setImageResource(R.drawable.neyroast);
                        break;
                    case "Idli_Sambar":
                        ord.setName("Idli Sambar");
                        ord.setPrice(5.49);
                        price.setText("Price : 5.49)");
                        image.setImageResource(R.drawable.idlidosa);
                        break;
                    case "Puttu_Kadala":
                        ord.setName("Puttu Kadala");
                        ord.setPrice(6.00);
                        price.setText("Price : 6.00)");
                        image.setImageResource(R.drawable.puttukadala);
                        break;
                    case "Veg_Fried_Rice":
                        ord.setName("Veg Fried Rice");
                        ord.setPrice(11.00);
                        price.setText("Price : 11.00)");
                        image.setImageResource(R.drawable.vegfriedrice);
                        break;
                    case "Chicken_Fried_Rice":
                        ord.setName("Chicken Fried Rice");
                        ord.setPrice(13.00);
                        price.setText("Price : 13.00)");
                        image.setImageResource(R.drawable.chickefriedrice);
                        break;
                    case "Kothu_Porotta":
                        ord.setName("Kothu Porotta");
                        ord.setPrice(8.99);
                        price.setText("Price : 8.99)");
                        image.setImageResource(R.drawable.kothuporotta);
                        break;
                    case "Veg_Biriyani":
                        ord.setName("Veg Biriyani");
                        ord.setPrice(11.00);
                        price.setText("Price : 11.00)");
                        image.setImageResource(R.drawable.vegbiriyani);
                        break;
                    case "Chicken_Biriyani":
                        ord.setName("Chicken Biriyani");
                        ord.setPrice(15.00);
                        price.setText("Price : 15.00)");
                        image.setImageResource(R.drawable.chickenbiri);
                        break;
                    default:
                        price.setText("Price :");
                        image.setImageResource(R.drawable.meals);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                ord.setQuantity(progress);

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked)
                {
                    String radio=checkedRadioButton.getText().toString();
                    switch (radio)
                    {
                        case "10 per":
                            ord.setTip(10);
                            total=ord.getPrice()*ord.getQuantity()*1.1*1.13;
                            tot.setText("Total : "+total);
                            break;
                        case "15 per":
                            ord.setTip(15);
                            total=ord.getPrice()*ord.getQuantity()*1.15*1.13;
                            tot.setText("Total : "+total);
                            break;
                        case "20 per":
                            ord.setTip(20);
                            total=ord.getPrice()*ord.getQuantity()*1.2*1.13;
                            tot.setText("Total : "+total);
                            break;
                    }
                }
            }
        });

    }

    public void order(View view)
    {
        if(ck.isChecked())
        {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("order", (Serializable) ord);
            startActivity(intent);

        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Check Box Not Checked!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
