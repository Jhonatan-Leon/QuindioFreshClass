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

    public List<Proveedor> getAllProviders(){
        return providerService.getAllProvider();
    }

    public Proveedor CreateProvider(ProveedorDTO newProvider){
       Proveedor provider = providerService.createProvider(newProvider);
       return provider;
    }

    public Proveedor searchProvider(){
        return providerService.searchProvider();
    }

    public Proveedor updateProvider(Proveedor provider){
        return providerService.updateProvider(provider);
    }

    public void deleteProvider(String id){
        providerService.deleteProvider(id);
    }

    public Proveedor lockProvider(String nit,boolean state){
        return providerService.lockProvider(nit,state);
    }

    public Proveedor activateProvider(String nit, boolean state){
        return providerService.activateProvider(nit, state);
    }

}
