package br.ulbra.aula15telasplash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText edNome,edFilhos,edSalBruto;

    RadioGroup rgGenero;

    Button btCalcular;

    TextView edINSS,edIR,edVT,edSF,edSalLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edNome = findViewById(R.id.edNome);
        rgGenero = findViewById(R.id.rgGenero);
        edFilhos = findViewById(R.id.edFilhos);
        edSalBruto = findViewById(R.id.edSalBruto);

        btCalcular = findViewById(R.id.btCalcular);

        edINSS = findViewById(R.id.edINSS);
        edIR = findViewById(R.id.edIR);
        edVT = findViewById(R.id.edVT);
        edSF = findViewById(R.id.edSF);
        edSalLiquido = findViewById(R.id.edSalLiquido);

        btCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!edFilhos.getText().toString().isEmpty() || !edSalBruto.getText().toString().isEmpty())
                {
                    int filhos = Integer.parseInt(edFilhos.getText().toString());
                    double salBruto = Double.parseDouble(edSalBruto.getText().toString());

                    double inss, ir, vt, sf, salLiquido;

                    //inss
                    if (salBruto <= 1212.00) {
                        inss = salBruto * 0.075;
                    } else if (salBruto >= 1212.01 && salBruto <= 2427.35) {
                        inss = salBruto * 0.09;
                    } else if (salBruto >= 2427.36 && salBruto <= 3641.03) {
                        inss = salBruto * 0.12;
                    } else {
                        inss = salBruto * 0.14;
                    }

                    //imposto de renda
                    if (salBruto <= 1903.98) {
                        ir = 0;
                    } else if (salBruto >= 1903.99 && salBruto <= 2826.65) {
                        ir = salBruto * 0.075;
                    } else if (salBruto >= 2826.66 && salBruto <= 3751.05) {
                        ir = salBruto * 0.15;
                    } else {
                        ir = salBruto * 0.225;
                    }

                    //vale transporte
                    vt = salBruto * 0.025;

                    //salario familia
                    if (salBruto <= 1212.00) {
                        sf = filhos * 56.47;
                    } else {
                        sf = 0.00;
                    }

                    //salario liquido
                    salLiquido = (salBruto - inss - ir - vt) + sf;

                    //output
                    edINSS.setText("Desconto INSS: -R$ " + inss);
                    edIR.setText("Imposto de renda: -R$ " + ir);
                    edVT.setText("Vale transporte: -R$ " + vt);
                    edSF.setText("Salario familia: +R$ " + sf);
                    edSalLiquido.setText("Salario liquido: R$ " + salLiquido);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Campo em branco",Toast.LENGTH_LONG);
                }
            }
        });
    }
}