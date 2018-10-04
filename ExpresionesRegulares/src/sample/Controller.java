package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    @FXML TextField txtExpresion;
    @FXML Label lblResultado;
    @FXML ListView Lista;
    String [] arr={"[a-z]{2,4}",
            "[A-Z]{1}[a-z]+|[a-z]+[A-Z]{1}[a-z]+|[a-z]+[A-Z]{1}"
            ,"[A-Z]{1}[a-z1-9]+",
            "[^db-]\\w+",
            "\\w+[count]",
            "\\w+[ ]\\w+",
            "[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}",//F0:E1:D2:C3:B4:A5
            "[A-Z]+[a-z][A-Z]",
            "[0-1]{8}",
            "[A-F1-9]+",
            "[0-9][+][0-9]|[0-9][*][0-9]|[0-9][-][0-9]|[0-9][/][0-9]",
            "[0-9]{2}[A-Z]{2}[0-9]+",
            //"[A-Z]{4}[0-9]{2}[0-9]{1}[0-2]{1}[0-3]{1}[0-9]{1}[H-M]{1}[A-Z]{5}[0-9]{2}",
            "[A-Z]{4}[0-9]{6}[H-M]{1}[A-Z]{5}[0-9]{2}",
    };
    @FXML protected void initialize(){
        ObservableList<String> datos= FXCollections.observableArrayList();
        datos.add("Mínimo 2 máximo 4");
        datos.add("Mayuscula sin números");
        datos.add("Mayuscula con numero");
        datos.add("palabra que comience con db- ");
        datos.add( "Una palabra termine con count");
        datos.add("Validar que hayan escrito dos nombres ejemplo “pancho villa”");
        datos.add(" Validar una MAC address");
        datos.add("Validar que la palabra comience y termine con mayúscula");
        datos.add("Validar un número binario de 8 dígitos");
        datos.add("Validar que se haya escrito correctamente un número hexadecimal");
        datos.add("Validar que una operación de 1 digito por ejemplo: “1+2”, “2-3”, “5*5” etc.");
        datos.add(" Validar que se ingrese correctamente el número de control del ITSCNG.");
        datos.add("Validar que se ingrese correctamente el número CURP");

        Lista.setItems(datos);

    }
    public void evento(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){

            Pattern patron =Pattern.compile(arr[Lista.getSelectionModel().getSelectedIndex()]);
            Matcher mat=patron.matcher(txtExpresion.getText());

            if(mat.matches()==true){
                lblResultado.setText("Si cumple");
            }else{
                lblResultado.setText("No cumple");
            }//Llave if
           ;
        }//Llave if
    }//La
}
