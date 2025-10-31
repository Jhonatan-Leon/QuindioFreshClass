package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Service.ClienteService;
import co.edu.uniquindio.SOLID.Model.DTO.ClienteDTO;

import java.util.List;

public class ClientFacade {
    private static ClientFacade Instance;
    private static ClienteService ClientService;

    public static ClientFacade getInstance() {
        if( Instance == null ) {
            Instance = new ClientFacade();
            return Instance;
        }
        return Instance;
    }
    private ClientFacade() {
        ClientService = new ClienteService();
    }

    public static List<ClienteDTO> getAllClients() {
        return ClientService.obtenerTodosLosClientes();
    }

    public static  boolean addClient(ClienteDTO client) {
             return  ClientService.agregarCliente(client);
    }

    public static boolean updateClient(ClienteDTO client) {
        return ClientService.actualizarCliente(client);
    }

    public static boolean deleteClient(String cedula) {
        return ClientService.eliminarCliente(cedula);
    }

    public static boolean existClient(String cedula) {
        return ClientService.existeCliente(cedula);
    }

    public static ClienteDTO searchClient(String cedula) {
        return ClientService.buscarClientePorCedula(cedula);
    }
}
