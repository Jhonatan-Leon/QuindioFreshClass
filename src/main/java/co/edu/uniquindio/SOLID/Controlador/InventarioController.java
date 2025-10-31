package co.edu.uniquindio.SOLID.Controlador;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Service.Fachadas.InventoryFacade;
import co.edu.uniquindio.SOLID.Service.Fachadas.ProductFacade;
import co.edu.uniquindio.SOLID.Service.Fachadas.ProviderFacade;
<<<<<<< HEAD
import co.edu.uniquindio.SOLID.Service.ProviderService;
import co.edu.uniquindio.SOLID.utils.Mappers.ProductoMapper;
=======
>>>>>>> c07f64978a64f74153521ac912e7397272c25aff
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarioController implements Initializable {

    @FXML private ComboBox<ProveedorDTO> cmbProveedores;
    @FXML private TitledPane tpCrearProveedor;
    @FXML private TextField txtProvNit;
    @FXML private TextField txtProvNombre;
    @FXML private TextField txtProvContacto;
    @FXML private TextField txtProvEmail;
    @FXML private TextField txtProvTelefono;
    @FXML private ComboBox<ProductoDTO> cmbProductoEntrada;
    @FXML private Spinner<Integer> spnCantidadEntrada;
    @FXML private Label lblResultadoEntrada;
    @FXML private TableView<ProductoDTO> tblProductosInv;
    @FXML private TableColumn<ProductoDTO, String> colInvSku;
    @FXML private TableColumn<ProductoDTO, String> colInvNombre;
    @FXML private TableColumn<ProductoDTO, Number> colInvPrecio;
    @FXML private TableColumn<ProductoDTO, Number> colInvStock;

    private ObservableList<ProveedorDTO> proveedores;
    private ObservableList<ProductoDTO> productos;
    private final ProviderFacade providerFacade = ProviderFacade.getInstance();
    private final ProductFacade productFacade = ProductFacade.getInstance();
    private final InventoryFacade inventory = InventoryFacade.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proveedores = FXCollections.observableArrayList(providerFacade.getAllProviders());
        productos = FXCollections.observableArrayList(productFacade.getAllProducts());
        
        if (cmbProveedores != null) {
            cmbProveedores.setItems(proveedores);
            cmbProveedores.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
                if (seleccionado != null) {
                    if (txtProvNit != null) txtProvNit.setText(seleccionado.getNit());
                    if (txtProvNombre != null) txtProvNombre.setText(seleccionado.getNombre());
                    if (txtProvContacto != null) txtProvContacto.setText(seleccionado.getContacto());
                    if (txtProvEmail != null) txtProvEmail.setText(seleccionado.getEmail());
                    if (txtProvTelefono != null) txtProvTelefono.setText(seleccionado.getTelefono());
                }
            });
        }
        if (cmbProductoEntrada != null) {
            cmbProductoEntrada.setItems(productos);
        }
        if (spnCantidadEntrada != null) {
            spnCantidadEntrada.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 1));
        }
        if (tblProductosInv != null) {
            colInvSku.setCellValueFactory(cd -> new javafx.beans.property.SimpleStringProperty(cd.getValue().getSku()));
            colInvNombre.setCellValueFactory(cd -> new javafx.beans.property.SimpleStringProperty(cd.getValue().getNombre()));
            colInvPrecio.setCellValueFactory(cd -> new javafx.beans.property.SimpleDoubleProperty(cd.getValue().getPrecio()));
            colInvStock.setCellValueFactory(cd -> new javafx.beans.property.SimpleIntegerProperty(Integer.parseInt(cd.getValue().getStock())));
            tblProductosInv.setItems(productos);
        }
        if (tpCrearProveedor != null) tpCrearProveedor.setExpanded(false);
    }

    @FXML
    void mostrarCrearProveedor() {
        if (tpCrearProveedor != null) tpCrearProveedor.setExpanded(!tpCrearProveedor.isExpanded());
    }

    @FXML
    void crearProveedor() {
        String nit = txtProvNit != null ? txtProvNit.getText() : null;
        String nombre = txtProvNombre != null ? txtProvNombre.getText() : null;
        String contacto = txtProvContacto != null ? txtProvContacto.getText() : "";
        String email = txtProvEmail != null ? txtProvEmail.getText() : "";
        String telefono = txtProvTelefono != null ? txtProvTelefono.getText() : "";
        
        // Validaciones de campos
        if (nit == null || nit.trim().isEmpty()) {
            mostrarError("El NIT es obligatorio");
            return;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            mostrarError("El nombre es obligatorio");
            return;
        }
        
        try {
<<<<<<< HEAD
            ProveedorDTO newp = new ProveedorDTO(nit, nombre, contacto, email, telefono);
            Proveedor p = providerFacade.CreateProvider(newp);
            proveedores.add(p);
=======
            ProveedorDTO p = new ProveedorDTO(nit, nombre, contacto, email, telefono);
            providerFacade.CreateProvider(p);
>>>>>>> c07f64978a64f74153521ac912e7397272c25aff
            if (cmbProveedores != null) cmbProveedores.getSelectionModel().select(p);
            if (lblResultadoEntrada != null) lblResultadoEntrada.setText("Proveedor creado: " + nombre);
            if (tpCrearProveedor != null) tpCrearProveedor.setExpanded(false);
            if (txtProvNit != null) txtProvNit.clear();
            if (txtProvNombre != null) txtProvNombre.clear();
            if (txtProvContacto != null) txtProvContacto.clear();
            if (txtProvEmail != null) txtProvEmail.clear();
            if (txtProvTelefono != null) txtProvTelefono.clear();
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    void actualizarProveedor() {
        String nit = txtProvNit != null ? txtProvNit.getText() : null;
        String nombre = txtProvNombre != null ? txtProvNombre.getText() : null;
        String contacto = txtProvContacto != null ? txtProvContacto.getText() : null;
        String email = txtProvEmail != null ? txtProvEmail.getText() : null;
        String telefono = txtProvTelefono != null ? txtProvTelefono.getText() : null;
        if (nit == null || nit.trim().isEmpty()) { mostrarError("El NIT es obligatorio"); return; }
        try {
<<<<<<< HEAD
            ProveedorDTO newp = new ProveedorDTO(nit, nombre, contacto, email, telefono);
            Proveedor proveedorEntity = providerFacade.CreateProvider(newp);
            Proveedor actualizado = providerFacade.updateProvider(proveedorEntity);
            for (int i = 0; i < proveedores.size(); i++) {
                if (proveedores.get(i).getNit().equals(nit)) { proveedores.set(i, actualizado); break; }
            }
=======
            ProveedorDTO actualizado = providerFacade.updateProvider(new ProveedorDTO(nit, nombre, contacto, email, telefono));
            for (int i = 0; i < proveedores.size(); i++)
                if (proveedores.get(i).getNit().equals(nit)) {
                    proveedores.set(i, actualizado);
                    break;
                }
>>>>>>> c07f64978a64f74153521ac912e7397272c25aff
            if (cmbProveedores != null) cmbProveedores.setItems(FXCollections.observableArrayList(proveedores));
        } catch (IllegalArgumentException e) { mostrarError(e.getMessage()); }
    }

    @FXML
    void eliminarProveedor() {
        String nit = txtProvNit != null ? txtProvNit.getText() : null;
        if (nit == null || nit.trim().isEmpty()) { mostrarError("El NIT es obligatorio"); return; }
        try {
            providerFacade.deleteProvider(nit);
            proveedores.removeIf(p -> p.getNit().equals(nit));
            if (cmbProveedores != null) cmbProveedores.setItems(FXCollections.observableArrayList(proveedores));
        } catch (IllegalArgumentException e) { mostrarError(e.getMessage()); }
    }

    @FXML
    void activarProveedor() {
        String nit = txtProvNit != null ? txtProvNit.getText() : null;
        if (nit == null || nit.trim().isEmpty()) { mostrarError("El NIT es obligatorio"); return; }
        try {
            ProveedorDTO actualizado = providerFacade.activateProvider(nit, true);
            for (int i = 0; i < proveedores.size(); i++) { if (proveedores.get(i).getNit().equals(nit)) { proveedores.set(i, actualizado); break; } }
            if (cmbProveedores != null) cmbProveedores.setItems(FXCollections.observableArrayList(proveedores));
        } catch (IllegalArgumentException e) { mostrarError(e.getMessage()); }
    }

    @FXML
    void inactivarProveedor() {
        String nit = txtProvNit != null ? txtProvNit.getText() : null;
        if (nit == null || nit.trim().isEmpty()) { mostrarError("El NIT es obligatorio"); return; }
        try {
            ProveedorDTO actualizado = providerFacade.lockProvider(nit, false);
            for (int i = 0; i < proveedores.size(); i++) { if (proveedores.get(i).getNit().equals(nit)) { proveedores.set(i, actualizado); break; } }
            if (cmbProveedores != null) cmbProveedores.setItems(FXCollections.observableArrayList(proveedores));
        } catch (IllegalArgumentException e) { mostrarError(e.getMessage()); }
    }

    @FXML
    void confirmarEntradaInventario() {
        ProveedorDTO proveedor = cmbProveedores != null ? cmbProveedores.getValue() : null;
        ProductoDTO prod = cmbProductoEntrada != null ? cmbProductoEntrada.getValue() : null;
        int cant = spnCantidadEntrada != null ? spnCantidadEntrada.getValue() : 0;
        
        // Validaciones de campos
        if (proveedor == null) {
            mostrarError("Seleccione un proveedor");
            return;
        }
        if (prod == null) {
            mostrarError("Seleccione un producto");
            return;
        }
        if (cant <= 0) {
            mostrarError("Cantidad inválida");
            return;
        }
        
        try {
<<<<<<< HEAD
            minimercado.registrarEntradaInventario(proveedor, prod, cant);
            Producto prodU = ProductoMapper.toEntity(prod);
            prod.setStock(prod.getStock() + cant);
            if (lblResultadoEntrada != null) lblResultadoEntrada.setText("Entrada confirmada. Stock " + prod.getSku() + ": " + prodU.getStock());
=======
            inventory.registerInventario(proveedor, prod, cant);
            if (lblResultadoEntrada != null) lblResultadoEntrada.setText("Entrada confirmada. Stock " + prod.getSku() + ": " + prod.getStock());
>>>>>>> c07f64978a64f74153521ac912e7397272c25aff
            if (tblProductosInv != null) tblProductosInv.refresh();
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}


