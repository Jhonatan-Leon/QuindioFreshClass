package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import co.edu.uniquindio.SOLID.Service.ProviderService;

import java.util.List;

public class ProviderFacade {
    private static ProviderFacade Instance;
    private final ProviderService providerService;

    public static ProviderFacade getInstance(){
        if(Instance == null){
            Instance = new ProviderFacade();
        }
        return Instance;
    }

    private ProviderFacade(){
        this.providerService = ProviderService.getInstance();
    }

    public List<ProveedorDTO> getAllProviders(){
        return providerService.getAllProvider();
    }

    public ProveedorDTO CreateProvider(ProveedorDTO newProvider){
        return providerService.createProvider(newProvider);
    }

    public Proveedor searchProvider(){
        return providerService.searchProvider();
    }

    public ProveedorDTO updateProvider(ProveedorDTO provider){
        return providerService.updateProvider(provider);
    }

    public void deleteProvider(String id){
        providerService.deleteProvider(id);
    }

    public ProveedorDTO lockProvider(String nit,boolean state){
        return providerService.lockProvider(nit,state);
    }

    public ProveedorDTO activateProvider(String nit, boolean state){
        return providerService.activateProvider(nit, state);
    }

}
