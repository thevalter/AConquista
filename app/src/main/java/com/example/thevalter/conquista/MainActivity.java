package com.example.thevalter.conquista;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int addPoints = 0;
    boolean choiceItemOne = true;
    boolean choiceItemTwo = true;
    boolean choiceItemThree = true;
    boolean congratulations = true;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + position, Toast.LENGTH_LONG).show();
        displayArticle(position);
        displayCongratulations();
    }

    public void onNothingSelected(AdapterView<?> arg0) {}

    /*
    * Imprimi as dicas no textview de acordo com a opção selecionada.
    * */
    public void displayArticle(int position){
        TextView tvArticle = (TextView) findViewById(R.id.texto_principal);

        if(position == 0){
            tvArticle.setText("");
        }

        if(position == 1){
            displayPoints(position);
            tvArticle.setText(R.string.TresSegundos);
        }

        if(position == 2){
            displayPoints(position);
            tvArticle.setText(R.string.Abordagem);
        }

        if(position == 3){
            displayPoints(position);
            tvArticle.setText(R.string.abertura);
        }
    }

    /*
    * Imprimi os pontos no textview de acordo com a opção selecionada.
    * choiceItem[One][Two][Three] serve para limitar o numero de pontuaçães recebidas pelo usuario.
    * */
    public void displayPoints(int position){
        TextView tvPoints = (TextView) findViewById(R.id.points);

        if(choiceItemOne && position == 1){
            addPoints += 10;
            choiceItemOne = false;
            tvPoints.setText(addPoints + "xp");
        }

        if(choiceItemTwo && position == 2){
            addPoints += 10;
            choiceItemTwo = false;
            tvPoints.setText(addPoints + "xp");
        }

        if(choiceItemThree && position == 3){
            addPoints += 10;
            choiceItemThree = false;
            tvPoints.setText(addPoints + "xp");
        }
    }

    /*
    * Quando o usuário atinge 30 pontos esse metodo é chamado.
    * congratulations serve para controlar o toast de parabenização.
    * */
    public void displayCongratulations(){
        if(addPoints == 30 && congratulations){
            Toast toast = Toast.makeText(this, R.string.congratulations,Toast.LENGTH_SHORT);
            toast.show();
            congratulations = false;
        }
    }
}


