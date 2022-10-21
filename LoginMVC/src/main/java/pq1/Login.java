package pq1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Login extends Application {

	private Alert alertError = new Alert(AlertType.ERROR);
	private Label usuarioLabel = new Label("Usuario:");
	private TextField usuarioText = new TextField();
	private Label contraseniaLabel = new Label("Contraseña");
	private PasswordField contraseniaText = new PasswordField();
	private CheckBox ldapCheck = new CheckBox("Usa LDAP");
	private Button accederButton = new Button("Acceder");
	private Button cancelarButton = new Button("Cancelar");
	private Alert alertInfo = new Alert(AlertType.INFORMATION);
	private Stage primaryStage;
	
	public void start(Stage primaryStage) throws Exception {
			
		usuarioText.setPromptText("Nombre de usuario");
		contraseniaText.setPromptText("Contraseña del usuario");
		
		HBox buttonPane = new HBox();
		buttonPane.getChildren().addAll(accederButton, cancelarButton);
		buttonPane.setSpacing(5);
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(5));
		root.setHgap(5);
		root.setVgap(5);
//		root.setGridLinesVisible(true);
		root.addRow(0, usuarioLabel, usuarioText);
		root.addRow(2, contraseniaLabel, contraseniaText);
		root.addRow(3, new Label(), ldapCheck);
		root.addRow(4, new Label(), buttonPane);
		root.setAlignment(Pos.CENTER);
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Login (MVC)");
		primaryStage.setScene(new Scene(root, 450, 200));
		primaryStage.show();
		
		accederButton.setOnAction(e -> onAccederButtonAction(e));
		accederButton.setDefaultButton(true);
		
		cancelarButton.setOnAction(e -> onCancelarButtonAction(e));
		cancelarButton.setDefaultButton(true);
		
//		Path usersFile = Paths.get(getClass().getResource("/users.csv").toURI());
		
		alertError.setTitle("Iniciar sesión");
		alertError.setHeaderText("Acceso denegado");
		alertError.setContentText("El usuario y/o contraseñas no son válidos.");
//		alertError.showAndWait();

		alertInfo.setTitle("Iniciar sesión");
		alertInfo.setHeaderText("Acceso permitido");
		alertInfo.setContentText("Las credenciales de accesos son válidas.");
//		alertInfo.showAndWait();
		
	}

	public void onCancelarButtonAction(ActionEvent e) {
		primaryStage.close();
	}

	public void onAccederButtonAction(ActionEvent e) {
		
		String usuario = (usuarioText.getText());
		String contrasenia = (contraseniaText.getText());
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
