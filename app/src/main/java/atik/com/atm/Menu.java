package atik.com.atm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    EditText edt1;
    TextView textViewStatus;
    Double dup=0.0;
    Double balance=0.0;
    Double wid = 0.0;
    Double trans = 0.0;
    String transAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn1 = findViewById(R.id.btnDeposit);
        btn2 = findViewById(R.id.btnBalance);
        btn3 = findViewById(R.id.btnWithdraw);
        edt1 = findViewById(R.id.edtAmount);
        btn4 = findViewById(R.id.btnTransfer);
        textViewStatus = findViewById(R.id.txtVwStatus);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dup = Double.parseDouble(edt1.getText().toString());
                edt1.setText("0.0");
                textViewStatus.setText("You Deposited "+dup.toString()+" Taka");
                balance = balance+dup;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("0.0");
                textViewStatus.setText("Your Balance is Now "+balance.toString()+" Taka");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wid = Double.parseDouble(edt1.getText().toString().trim());
                balance = balance-wid;
                edt1.setText("0.0");
                textViewStatus.setText("You Withdraw "+wid.toString()+" Taka");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder builder;
                View mview;
                final TextView text_view_custom_dialog,text_view_custom_dialog2;
                builder = new android.support.v7.app.AlertDialog.Builder(Menu.this,R.style.CustomDialogTheme);
                mview=getLayoutInflater().inflate(R.layout.custom_alert_dialog,null);
                text_view_custom_dialog=(TextView)mview.findViewById(R.id.text_view_custom_dialog_user_ac);
                text_view_custom_dialog2=(TextView)mview.findViewById(R.id.text_view_custom_user_taka);

                text_view_custom_dialog.setHint("");
                builder.setView(mview);
                builder.setMessage("Account Transfer")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(!text_view_custom_dialog.getText().toString().equals("") && !text_view_custom_dialog2.getText().toString().equals(""))
                                {
                                    trans = Double.parseDouble(text_view_custom_dialog2.getText().toString().trim());
                                    if (trans>balance){
                                        edt1.setError("Not Available Balance");
                                    }
                                    else {
                                        balance = balance - trans;
                                        transAc = text_view_custom_dialog.getText().toString().trim();
                                        textViewStatus.setText(trans + " Taka Transfered To Account Number" + transAc);

                                    }
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        }).show();

            }
        });




    }
}
