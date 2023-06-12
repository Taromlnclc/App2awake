package com.example.app2awake;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //implementacion de deeccion de ingreso en valor y filtro solo numeros en el input
        TextView textView = findViewById(R.id.resultado);
        EditText editText = findViewById(R.id.valor);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Antes de que el texto cambie
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Durante el cambio del texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText num = findViewById(R.id.valor);
                if (num.length() != 0) {
                    String text = editText.getText().toString();

                    // identifica la bandera y activa
                    TextView textoBandera = findViewById(R.id.bandera);
                    String bandText = textoBandera.getText().toString();
                    TextView numOtro = findViewById(R.id.resultado);
                    String numText = numOtro.getText().toString();
                    if (bandText.length() == 0) {
                        // El TextView no está vacío
                        // Realiza las acciones necesarias

                        if(numText.length() != 0){
                            text = numText + text;
                        }
                        textView.setText(text);
                        textView.setText(text);
                        editText.setText("");
                    }

                }
            }
        });
    }
    public void botonSuma(View view) {
        //activa animacion
        ImageView suma = findViewById(R.id.suma);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        suma.startAnimation(animation);
        //ejecutar operacion
        operacion("+");
    }
    public void botonResta(View view) {
        //activa animacion
        ImageView resta = findViewById(R.id.resta);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        resta.startAnimation(animation);
        //ejecutar operacion
        operacion("-");
    }
    public void botonMulti(View view) {
        //activa animacion
        ImageView multi = findViewById(R.id.multi);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        multi.startAnimation(animation);
        //ejecutar operacion
        operacion("*");
    }
    public void botonDivi(View view) {
        //activa animacion
        ImageView igual = findViewById(R.id.divide);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        igual.startAnimation(animation);
        //ejecutar operacion
        operacion("/");
    }
//opraciones artimeticas
    public void operacion(String oper){
        //activa bandera, verifica valor ingresado para int y calcular
        EditText num = findViewById(R.id.valor);
        TextView textoBandera = findViewById(R.id.bandera);

        if (num.length() != 0) {
            int Val = Integer.parseInt(num.getText().toString());

        // Obtener los números ingresados
        TextView numOtro = findViewById(R.id.resultado);
        String numText = numOtro.getText().toString();

        int num2 = 0;
        if (numText.length() != 0) {
            // El TextView no está vacío
            num2 = Integer.parseInt(numOtro.getText().toString());
        }

        int opera = 0;
            switch (oper) {
                case "+":
                    // Realizar la suma
                    opera = num2 + Val;
                    break;
                case "-":
                    // Realizar la resta
                    opera = num2 - Val;
                    break;
                case "*":
                    // Realizar la multi
                    opera = num2 * Val;
                    break;
                case "/":
                    // Realizar la divi
                    opera = num2 / Val;
                    break;
                default:
                    // No operacion aun.
                    break;
            }
        // Mostrar el resultado en el TextView, limpiar Edittext
        numOtro.setText(String.valueOf(opera));
        num.setText("");
        }else{
            //pasa bandera y veriifca si esta vacio...
            if (textoBandera.length() != 0) {
                mostrarAlerta("Error al ejecutar operador " + oper);
            }
        }
        textoBandera.setText("X");
    }
 //mensajes de alerta
 private void mostrarAlerta(String titulo) {
     AlertDialog.Builder builder = new AlertDialog.Builder(this);
     builder.setTitle(titulo)
             .setMessage("Debe ingresar valor.")
             .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss());

     AlertDialog alert = builder.create();
     alert.show();
 }
}