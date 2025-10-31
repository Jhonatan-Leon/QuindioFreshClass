package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import co.edu.uniquindio.SOLID.utils.Mappers.ProveedorMapper;

import java.util.List;

public class ProviderService {
    private static ProviderService Instance;
    private final Minimercado minimercado;

    public static ProviderService getInstance() {
        if(Instance == null){
            Instance = new ProviderService();
        }
        return Instance;
    }

    private ProviderService(){
        this.minimercado = Minimercado.getInstancia();
    }

    public Proveedor createProvider(Proveedor newProvider){
        if(searchProvider() == null){
            throw new IllegalArgumentException("Ya existe un proveedor con ese ID");
        }

        //Proveedor proveedor = ProveedorMapper.toDTO(newProvider);
        minimercado.agregarProveedor(newProvider);
        return newProvider;
    }

    public Proveedor searchProvider(){
        return minimercado.getProveedores().stream().findFirst().orElse(null);
    }

    public Proveedor updateProvider(ProveedorDTO provider){
        Proveedor p = searchProvider();

        if(p == null){
            throw new IllegalArgumentException("No existe un proveedor con ese ID");
        }

        if(provider.getNombre() != null) p.setNombre(provider.getNombre());
        if(provider.getContacto() != null) p.setContacto(provider.getContacto());
        if(provider.getEmail() != null) p.setEmail(provider.getEmail());
        if(provider.getTelefono() != null) p.setTelefono(provider.getTelefono());
        if(false) {if (p.isActivo()) p.activar();else p.inactivar();}
        return p;
    }

    public void deleteProvider(String id){
        Proveedor p = searchProvider();
        if(p == null){
            throw new IllegalArgumentException("No existe un proveedor con ese ID");
        }
        minimercado.eliminarProveedor(p);
    }

    public List<Proveedor> getAllProvider(){
        return minimercado.getProveedores();
    }

    public Proveedor lockProvider(String nit,boolean state){
        Proveedor p = searchProvider();
        if(p == null){
            throw new IllegalArgumentException("No existe un proveedor con ese ID");
        }
        if(p.getNit().equals(nit)){
            if(state){
                p.activar();
            }else{
                p.inactivar();
            }
        }
        return p;
    }

    public Proveedor activateProvider(String nit, boolean state){
        Proveedor p = searchProvider();
        if(p == null){
            throw new IllegalArgumentException("No existe un proveedor con ese ID");
        }
        if(p.getNit().equals(nit)){
            if(state){
                p.inactivar();
            }else{
                p.activar();
            }
        }
        return p;
    }

}
