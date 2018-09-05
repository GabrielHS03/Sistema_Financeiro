package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ClienteAlterarController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> tbCliente;

    @FXML
    private TableColumn<?, ?> tbClienteColumnID;

    @FXML
    private TableColumn<?, ?> tbClienteColumnNome;

    @FXML
    private TableColumn<?, ?> tbClienteColumnCPF;

    @FXML
    private TableColumn<?, ?> tbClienteColumnCNPJ;

    @FXML
    private TableColumn<?, ?> tbClienteColumnEndereco;

    @FXML
    private TableColumn<?, ?> tbClienteColumnTelefone;

    @FXML
    private ImageView imgReturn;

    @FXML
    private Button btnAlterarCliente;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtCPFCNPJ;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblCPFCNPJ;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private Label lblCNPJ;

    @FXML
    private ImageView imgHome;

    @FXML
    private Label lblCidade;

    @FXML
    private Label lblEstado;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtEstado;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField searchBox;
    
    @FXML
    void pesquisarTabela(KeyEvent event) {

    }
}
