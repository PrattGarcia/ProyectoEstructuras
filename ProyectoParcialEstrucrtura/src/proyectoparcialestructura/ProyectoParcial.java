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

        Label titular = new Label("Ingrese la cantidad de números");
        Label texto = new Label();
        TextField txtCantidad = new TextField();
        Button btnContinuar = new Button();
        btnContinuar.setText("Crear");
        Button btnGirarDer = new Button();
        btnGirarDer.setText("Girar ->");
        Button btnDelete = new Button();
        btnDelete.setText("Eliminar");
        TextField txtDelete = new TextField();
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("Ruleta1","Ruleta2");
        ComboBox<String> comb = new ComboBox<>(items);
        Label look = new Label();
        Label look2 = new Label();
        Label lookSum = new Label();
        HBox box1 = new HBox();
        HBox contenedorRuleta = new HBox();
        box1.getChildren().addAll(titular, texto, txtCantidad, btnContinuar,btnDelete,txtDelete);
        Pane ruleta = new Pane();
        contenedorRuleta.getChildren().add(ruleta);
        contenedorRuleta.setAlignment(Pos.CENTER);
        
        btnContinuar.setOnAction((e) -> {
            btnContinuar.setDisable(true);
            int cantidad = Integer.parseInt(txtCantidad.getText());

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
            look.setText(listaNumeros.toString());
            look2.setText(listaNumeros2.toString());
            lookSum.setText("" + sumaNumeros(listaNumeros));
            posicionarNumeros(ruleta);
            //listaNumeros.clear();
            //listaNumeros2.clear();
        });
        btnGirarDer.setOnAction((e) -> {
            listaNumeros=moverDerecha(listaNumeros);
            posicionarNumeros(ruleta);
        });
        btnDelete.setOnAction((e) -> {
            int index = Integer.parseInt(txtDelete.getText());
            dobleEliminacion(listaNumeros,listaNumeros2,index);
            posicionarNumeros(ruleta);
        });
        

        root1.getChildren().addAll(box1, look, look2, lookSum, contenedorRuleta,comb,btnGirarDer);
        Scene scene = new Scene(root1, 1800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //Método que recorre con un iterador la lista de niños y los posiciona de forma circular con un fórmula.
   
    public void posicionarNumeros(Pane panelRuleta) {

        if (!panelRuleta.getChildren().isEmpty()) {
            panelRuleta.getChildren().clear();
        }
        ListIterator<Numero> itPart = listaNumeros.ListIterator();
        Numero number = itPart.next();

        for (double i = 0; i <= 360; i += 360 / (listaNumeros.getEffectiveSize()) + 1) {

            Double x = 340 + 300 * Math.cos(Math.toRadians(i));
            Double y = 265 + 300 * Math.sin(Math.toRadians(i));

            Button btns = new Button("" + number.getNumero());
            btns.setRotate(i + 90);
            btns.relocate(x, y);
            panelRuleta.getChildren().add(btns);
            System.out.println("" + number.getNumero());
            number = itPart.next();
        }

        ListIterator<Numero> itPart2 = listaNumeros2.ListIterator();
        Numero number2 = itPart2.next();
        for (double i = 0; i <= 360; i += 360 / (listaNumeros2.getEffectiveSize()) + 1) {

            Double x = 340 + 150 * Math.cos(Math.toRadians(i));
            Double y = 265 + 150 * Math.sin(Math.toRadians(i));

            Button btns = new Button("" + number2.getNumero());
            btns.setRotate(i + 90);
            btns.relocate(x, y);
            panelRuleta.getChildren().add(btns);
            number2 = itPart2.next();
        }
    }
}
