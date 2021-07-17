package proyectoparcialestructura;

import CircularLinkedList.CircularLinkedList;
import java.util.ListIterator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static proyectoparcialestructura.ListaNumeros.dobleEliminacion;
import static proyectoparcialestructura.ListaNumeros.moverDerecha;
import static proyectoparcialestructura.ListaNumeros.moverIzquierda;
import static proyectoparcialestructura.ListaNumeros.sumaNumeros;

/**
 *
 * @author HP
 */
public class ProyectoParcial extends Application {

    private CircularLinkedList<Numero> listaNumeros = new CircularLinkedList<>();
    private CircularLinkedList<Numero> listaNumeros2 = new CircularLinkedList<>(); 
    

    @Override
    public void start(Stage primaryStage) {
        ventanaInicio(primaryStage);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void ventanaInicio(Stage primaryStage) {

        VBox root1 = new VBox();
        Label Espacio = new Label();
        Label Espacio1 = new Label();
        Label Espacio4 = new Label("Suma de las Ruletas");
        Label infoGiro = new Label();
        HBox contGiro = new HBox();
        HBox contEliminar = new HBox();
        Label titular = new Label("Ingrese la cantidad de números");
        Label txtIndice = new Label(" <--Por favor seleccione un indice");
        Button btnEmpezar = new Button("Empezar");
        TextField txtCantidad = new TextField();
        Label apuesta = new Label("Ingrese su apuesta:");
        TextField txtApuesta = new TextField();
        HBox kakegurui = new HBox();
        kakegurui.getChildren().addAll(apuesta,txtApuesta,btnEmpezar);
        Button btnContinuar = new Button();
        btnContinuar.setText("Crear");
        Button btnGirarDer = new Button();
        btnGirarDer.setText("Girar ->");
        Button btnGirarIz = new Button();
        btnGirarIz.setText("<- Girar");
        Button btnDelete = new Button();
        btnDelete.setText("Eliminar");
        ObservableList<String> items = FXCollections.observableArrayList();
        ComboBox<String> comboIndices = new ComboBox<>(items);
        Label instruccion = new Label("Seleccione con que opcion desea comenzar el juego");
        TextField txtDelete = new TextField();
        ObservableList<String> items2 = FXCollections.observableArrayList();
        items2.addAll("Ruleta1","Ruleta2");
        ComboBox<String> comb = new ComboBox<>(items2);
        
        Button lookSum = new Button();
        lookSum.setPrefSize(200, 150);
        
        HBox contenedorOpFinales = new HBox();
        Button salir = new Button("Salir");
        Button Again = new Button("Empezar de nuevo");
        contenedorOpFinales.getChildren().addAll(salir,Again);
        contenedorOpFinales.setAlignment(Pos.CENTER);
        
        HBox box1 = new HBox();
        HBox contenedorRuleta = new HBox();
        box1.getChildren().addAll(titular, txtCantidad, btnContinuar);
        Pane ruleta = new Pane();
        contenedorRuleta.getChildren().add(ruleta);
        contenedorRuleta.setAlignment(Pos.CENTER);
        
        contGiro.getChildren().addAll(comb,btnGirarDer,btnGirarIz,infoGiro);
        contEliminar.getChildren().addAll(btnDelete,comboIndices,txtIndice);
                
        txtCantidad.setDisable(true);
        btnContinuar.setDisable(true);
        btnDelete.setDisable(true);
        comboIndices.setDisable(true);
        txtIndice.setVisible(false);
        comb.setDisable(true);
        btnGirarDer.setDisable(true);
        btnGirarIz.setDisable(true);
        comboIndices.setValue("0");
        comb.setValue("Ruleta1");
        
        
        salir.setOnAction((e) -> {
            System.exit(0);
        });
        
        
        Again.setOnAction((e) -> {
            if(listaNumeros.size()==0 && listaNumeros2.size()==0){
                instruccion.setText("Seleccione con que opcion desea comenzar el juego");
                ruleta.getChildren().clear();
                comboIndices.getItems().clear();
                txtApuesta.setDisable(false);
                txtApuesta.clear();
                apuesta.setDisable(false);
                btnEmpezar.setDisable(false);
                txtCantidad.clear();
                lookSum.setText("0");
                comboIndices.setValue("0");
                txtCantidad.setDisable(true);
                btnContinuar.setDisable(true);
                btnDelete.setDisable(true);
                comboIndices.setDisable(true);
                txtIndice.setVisible(false);
                comb.setDisable(true);
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
            }else{
                instruccion.setText("Seleccione con que opcion desea comenzar el juego");
                txtApuesta.setDisable(false);
                txtApuesta.clear();
                apuesta.setDisable(false);
                btnEmpezar.setDisable(false);
                txtCantidad.clear();
                lookSum.setText("0");
                txtCantidad.setDisable(true);
                btnContinuar.setDisable(true);
                btnDelete.setDisable(true);
                comboIndices.setDisable(true);
                txtIndice.setVisible(false);
                comb.setDisable(true);
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
                ruleta.getChildren().clear();
                listaNumeros.clear();
                listaNumeros2.clear();
                comboIndices.getItems().clear();
                comboIndices.setValue("0");
            }
        });
        btnEmpezar.setOnAction((e) -> {
            
            if(txtApuesta.getText().isEmpty()){
                instruccion.setText("Debe ingresar un valor valido en la caja de texto!");
            }else if(isNumeric(txtApuesta.getText())==false){
                System.out.println("si");
                instruccion.setText("Debe ingresar un valor valido en la caja de texto!");
            }else{
                instruccion.setText("Seleccione con que opcion desea comenzar el juego");
                btnEmpezar.setDisable(true);
                txtCantidad.setDisable(false);
                btnContinuar.setDisable(false);
                txtApuesta.setDisable(true);
            }
        });
        btnContinuar.setOnAction((e) -> {
            if(txtCantidad.getText().isEmpty() || isNumeric(txtCantidad.getText())==false){
                instruccion.setText("Debe ingresar un valor valido en la caja de texto!");
            }else{
            instruccion.setText("Seleccione con que opcion desea comenzar el juego");
            btnContinuar.setDisable(true);
            txtCantidad.setDisable(true);
            int cantidad = Integer.parseInt(txtCantidad.getText());
            btnDelete.setDisable(false);
            comboIndices.setDisable(false);
            txtApuesta.setDisable(true);
            txtIndice.setVisible(true);
            comb.setDisable(false);
            btnGirarDer.setDisable(false);
            btnGirarIz.setDisable(false);
            for (int i = 1; i <= cantidad; i++) {
                Numero num = new Numero();
                num.setNumero((int) (Math.random() * 10));
                listaNumeros.addLast(num);
            }
            for (int i = 1; i <= cantidad; i++) {
                Numero num = new Numero();
                num.setNumero((int) (Math.random() * 10));
                listaNumeros2.addLast(num);
            }
            int limite = listaNumeros.size();
            int v=0;
            for (int c=0;c<limite;c++){
                System.out.println(v);
                System.out.println(c);
                items.add(""+v);
                v++;
            }
           
            lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
            posicionarNumeros(ruleta);
            if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                   
                    contenedorOpFinales.setVisible(true);
                    JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!");
                   
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                }
            }
        });
        btnGirarDer.setOnAction((e) -> {
            
            comboIndices.setValue("0");
            instruccion.setText("Ahora debe realizar una operacion de eliminacion");
            if (comb.getValue()=="Ruleta1"){
                listaNumeros=moverDerecha(listaNumeros);
                posicionarNumeros(ruleta);
                infoGiro.setText("-->HAS RESALIZADO UN GIRO A LA DERECHA EN LA 1ERA RULETA");
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
                btnDelete.setDisable(false);
                comboIndices.setDisable(false);
                comb.setDisable(true);
                lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
                if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!!!!!!!!!!!!!!!");
                    
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                }
                
            }else if(comb.getValue()=="Ruleta2"){
                listaNumeros2=moverDerecha(listaNumeros2);
                posicionarNumeros(ruleta);
                infoGiro.setText("-->HAS RESALIZADO UN GIRO A LA DERECHA EN LA 2DA RULETA");
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
                btnDelete.setDisable(false);
                comboIndices.setDisable(false);
                comb.setDisable(true);
                lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
                if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                  
                    JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!!!!!!!!!!!!!!!");
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                }
            }
        });
        btnGirarIz.setOnAction((e) -> {
            comboIndices.setValue("0");
            instruccion.setText("Ahora debe realizar una operacion de eliminacion");
            if(comb.getValue()=="Ruleta1"){
                listaNumeros=moverIzquierda(listaNumeros);
                posicionarNumeros(ruleta);
                infoGiro.setText("<--HAS RESALIZADO UN GIRO A LA IZQUIERDA EN LA 1ERA RULETA");
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
                btnDelete.setDisable(false);
                comboIndices.setDisable(false);
                comb.setDisable(true);
                lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
                if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                   contenedorOpFinales.setVisible(true);
                   
                   JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!!!!!!!!!!!!!!!");
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                    
                }
                
            }
            else if(comb.getValue()=="Ruleta2"){
                listaNumeros2=moverIzquierda(listaNumeros2);
                posicionarNumeros(ruleta);
                infoGiro.setText("<--HAS RESALIZADO UN GIRO A LA IZQUIERDA EN LA 2DA RULETA");
                btnGirarDer.setDisable(true);
                btnGirarIz.setDisable(true);
                btnDelete.setDisable(false);
                comboIndices.setDisable(false);
                comb.setDisable(true);
                lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
                if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!!!!!!!!!!!!!!!");
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                }
                
            }
        });
        btnDelete.setOnAction((e) -> {
            
            instruccion.setText("Ahora debe realizar una operacion de Giro");
                int index = Integer.parseInt(comboIndices.getValue());
                dobleEliminacion(listaNumeros,listaNumeros2,index);
                posicionarNumeros(ruleta);
                btnDelete.setDisable(true);
                txtDelete.setDisable(true);
                comboIndices.setDisable(true);
                btnGirarDer.setDisable(false);
                btnGirarIz.setDisable(false);
                comb.setDisable(false);
                comb.setValue("Ruleta1");
                if(listaNumeros.size()==0 && listaNumeros.size()==0){
                    lookSum.setText("0");
                }else{
                    lookSum.setText("" + (sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2)));
                }
                int limite = listaNumeros.size();
                int v=0;
                items.clear();
                for (int c=0;c<limite;c++){
                    items.add(""+v);
                    v++;
                }
                if(verificarVictoria(txtApuesta)){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "GANASTE EL JUEGO :D!!!!!!!!!!!!!!!!!!!");
                }
                if (verificarDerrota()){
                    txtCantidad.setDisable(true);
                    btnContinuar.setDisable(true);
                    btnDelete.setDisable(true);
                    comboIndices.setDisable(true);
                    txtIndice.setVisible(false);
                    comb.setDisable(true);
                    btnGirarDer.setDisable(true);
                    btnGirarIz.setDisable(true);
                    contenedorOpFinales.setVisible(true);
                   
                    JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO D: !!!!!!!");
                }
        });
        root1.getChildren().addAll(kakegurui,box1,instruccion,contGiro,contEliminar,Espacio,Espacio1,contenedorRuleta,Espacio4,lookSum,contenedorOpFinales);
        Scene scene = new Scene(root1, 1800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //Método que recorre con un iterador la lista de niños y los posiciona de forma circular con un fórmula.
    
    public boolean verificarVictoria(TextField txtapuesta){
        //VBox ventanaVictoria = new VBox();
        //Label lb = new Label("HAS GANADO!!!!");
        
        int apuesta = Integer.parseInt(txtapuesta.getText());
        
        //Label lb1 = new Label("Su apuesta es: "+apuesta+" "+"El valor de los circulos es: "+sumaRuletas);
        //ventanaVictoria.getChildren().addAll(lb,lb1);
        //Scene scene = new Scene(ventanaVictoria,800,100);
        //primaryStage.setScene(scene);
        int sumaRuletas;
        if(listaNumeros.size()!=0 && listaNumeros.size()!=0){
            sumaRuletas = sumaNumeros(listaNumeros)+sumaNumeros(listaNumeros2);
        }else{
            sumaRuletas = 0;
        }
        if((apuesta == sumaRuletas)){
            System.out.println("Ganaste");
            return true;
        }
        return false;
        
    }
    public boolean verificarDerrota(){
        if(listaNumeros.size()==0 && listaNumeros2.size()==0){
            System.out.println("Perdiste");
            return true;
        }else{
            return false;
        }
    }
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
   
    public void posicionarNumeros(Pane panelRuleta) {

        if (!panelRuleta.getChildren().isEmpty()) {
            panelRuleta.getChildren().clear();
        }
        if(listaNumeros.size()!=0 && listaNumeros2.size()!=0){
            ListIterator<Numero> itPart = listaNumeros.ListIterator();
            Numero number = itPart.next();
            int indice=0;
            for (double i = 0; i <= 360; i += 360 / (listaNumeros.getEffectiveSize()) + 1) {
                Double x = 340 + 300 * Math.cos(Math.toRadians(i));
                Double y = 265 + 300 * Math.sin(Math.toRadians(i));

                Label ind = new Label("INDICE: "+indice);
                ind.setRotate(i + 90);
                ind.relocate(x, y);
                panelRuleta.getChildren().add(ind);
                //System.out.println("" + number.getNumero());
                number = itPart.next();
                indice++;
            }

            for (double i = 0; i <= 360; i += 360 / (listaNumeros.getEffectiveSize()) + 1) {
                Double x = 340 + 200 * Math.cos(Math.toRadians(i));
                Double y = 265 + 200 * Math.sin(Math.toRadians(i));

                Button btns = new Button("" + number.getNumero());
                btns.setRotate(i + 90);
                btns.relocate(x, y);
                panelRuleta.getChildren().add(btns);
                //System.out.println("" + number.getNumero());
                number = itPart.next();
            }

            ListIterator<Numero> itPart2 = listaNumeros2.ListIterator();
            Numero number2 = itPart2.next();
            for (double i = 0; i <= 360; i += 360 / (listaNumeros2.getEffectiveSize()) + 1) {
                Double x = 340 + 100 * Math.cos(Math.toRadians(i));
                Double y = 265 + 100 * Math.sin(Math.toRadians(i));

                Button btns = new Button("" + number2.getNumero());
                btns.setRotate(i + 90);
                btns.relocate(x, y);
                panelRuleta.getChildren().add(btns);
                number2 = itPart2.next();
            }
        }
    }
    public void obtenerIndices(){
        int c;
        int limite = listaNumeros.size();
        for (c=0;c<=limite;c++){
            
        }
    }
}
