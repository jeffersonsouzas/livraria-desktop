package controller;

import dao.AutorDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Autor;

public class AutorFormularioController {

    @FXML private TextField txfNome;
    @FXML private TextField txfEmail;
    @FXML private Button btnSalvar;

    public void salvar(){
        System.out.println("Nome: "+txfNome.getText());
        System.out.println("Email: "+txfEmail.getText());

        Autor autor = new Autor();
        autor.setNome(txfNome.getText());
        autor.setEmail(txfEmail.getText());

        AutorDAO autorDAO = new AutorDAO();
        autorDAO.inserir(autor);

        limparCampos();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Autores");
        alert.setHeaderText("Sucesso!");
        alert.setContentText("Autor cadastrado com sucesso.");
        alert.showAndWait();
    }

    private void limparCampos() {
        txfNome.setText("");
        txfEmail.setText("");
        txfNome.requestFocus();
    }
}
