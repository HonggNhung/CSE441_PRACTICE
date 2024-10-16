package com.example.ex06;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_hoten, edt_cmnd, edt_bosung;
    RadioGroup rg_bangcap;
    RadioButton rb_daihoc, rb_caodang, rb_trungcap;
    CheckBox cb_docbao, cb_docsach, cb_doccoding;
    Button btn_guitt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_cmnd = findViewById(R.id.edt_cmnd);
        edt_bosung = findViewById(R.id.edt_bosung);
        cb_docbao = findViewById(R.id.cb_docbao);
        cb_docsach = findViewById(R.id.cb_docsach);
        cb_doccoding = findViewById(R.id.cb_doccoding);
        btn_guitt = findViewById(R.id.btn_guitt);
        btn_guitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doShowInformation();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void doShowInformation() {
        String ten = edt_hoten.getText().toString();
        ten = ten.trim();
        if(ten.length() < 3) {
            edt_hoten.requestFocus();
            edt_hoten.selectAll();
            Toast.makeText(this, "Ten phai >= 3 ky tu", Toast.LENGTH_SHORT).show();
            return;
        }
        String cmnd = edt_cmnd.getText().toString();
        cmnd = cmnd.trim();
        if(cmnd.length() != 9) {
            edt_cmnd.requestFocus();
            edt_cmnd.selectAll();
            Toast.makeText(this, "CMND phai co 9 ky tu", Toast.LENGTH_SHORT).show();
            return;
        }
        String bangcap = "";
        rg_bangcap = findViewById(R.id.rg_bangcap);
        int id = rg_bangcap.getCheckedRadioButtonId();
        if(id == -1)
        {
            Toast.makeText(this, "Phai chon bang cap", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rb = findViewById(id);
        bangcap = rb.getText() + "";
        String sothich = "";
        if(cb_docbao.isChecked())
            sothich += cb_docbao.getText()+"\n";
        if(cb_docsach.isChecked())
            sothich += cb_docsach.getText()+"\n";
        if(cb_doccoding.isChecked())
            sothich += cb_doccoding.getText()+"\n";
        String bosung = edt_bosung.getText() + "";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong tin ca nhan");
        builder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bangcap + "\n";
        msg += sothich;
        msg += "\n";
        msg += "Thong tin bo sung: \n";
        msg += bosung+"\n";
        msg += "--------";
        builder.setMessage(msg);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
    }
}