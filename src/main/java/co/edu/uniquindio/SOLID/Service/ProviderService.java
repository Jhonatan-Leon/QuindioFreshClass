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

    public Proveedor createProvider(ProveedorDTO newProvider){
        if(searchProvider() == null){
            throw new IllegalArgumentException("Ya existe un proveedor con ese ID");
        }

        Proveedor proveedor = ProveedorMapper.toEntity(newProvider);
        minimercado.agregarProveedor(proveedor);
        return proveedor;
    }

    public Proveedor searchProviderByNit(String nit) {
        if (nit == null || nit.trim().isEmpty()) {
            throw new IllegalArgumentException("El NIT no puede ser nulo ni vacío");
        }

        for (Proveedor p : minimercado.getProveedores()) {
            if (p.getNit().equals(nit)) {
                return p;
            }
        }

        return null;
    }

    public Proveedor searchProvider(){
        return minimercado.getProveedores().stream().findFirst().orElse(null);
    }

    public Proveedor updateProvider(Proveedor provider){
        Proveedor p = searchProviderByNit(provider.getNit());

        if(p == null){
            throw new IllegalArgumentException("No existe un proveedor con ese ID");
        }
        ProveedorDTO dto = new ProveedorDTO(provider.getNit(), provider.getNombre(), provider.getContacto(), provider.getEmail(), provider.getTelefono());

        ProveedorMapper.updateEntityFromDTO(p,dto);

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
