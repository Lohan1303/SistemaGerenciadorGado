/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.gerenciador_gado.Controllers;

import br.edu.fesa.gerenciador_gado.DAO.PasswordHasher;
import br.edu.fesa.gerenciador_gado.Models.LoginModel;
import br.edu.fesa.gerenciador_gado.Models.PerfilUsuarioModel;
import static br.edu.fesa.gerenciador_gado.Validations.ValidatorEmail.validateEmailFields;
import static br.edu.fesa.gerenciador_gado.Validations.ValidatorPassword.validatePasswordFields;
import static br.edu.fesa.gerenciador_gado.Validations.ValidatorFields.ValidateIsEmpty;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lohan
 * @author Rodrigo Puertas
 */
public class TelaCadastroController implements Initializable {

    @FXML
    private Button btnEntrar;

    @FXML
    private ComboBox<PerfilUsuarioModel> cboPerfil;

    @FXML
    private Label lblAlertaEmail;

    @FXML
    private Label lblAlertaNome;

    @FXML
    private Label lblAlertaPerfil;

    @FXML
    private Label lblAlertaRegistro;

    @FXML
    private Label lblAlertaSenha;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRegistro;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtConfirmaEmail;

    @FXML
    void actionCadastrar(ActionEvent event) {
        try {

            lblAlertaNome.setText(ValidateIsEmpty(txtNome));

            lblAlertaPerfil.setText(ValidateIsEmpty(cboPerfil));

            lblAlertaEmail.setText(validateEmailFields(txtEmail.getText(), txtConfirmaEmail.getText()));

            lblAlertaSenha.setText(validatePasswordFields(txtPassword.getText(), txtConfirmPassword.getText()));

            String senhaCriptografada = PasswordHasher.hashPassword(txtPassword.getText());
            LoginModel login = new LoginModel(txtEmail.getText(), senhaCriptografada);

            // Aqui você pode prosseguir com a lógica de login usando o objeto LoginModel
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
