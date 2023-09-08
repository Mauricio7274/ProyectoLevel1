package ArquitecturaProyecto.demo.Logica;


       import java.util.List;
       import ArquitecturaProyecto.demo.Controlador.Dto.DtoProducto;
       import org.springframework.stereotype.Service;
        import java.util.ArrayList;

@Service
public class GestorDeInventario {

    private List<DtoProducto> producto;
    private int nextProductoId = 1;

    public GestorDeInventario() {
        producto = new ArrayList<>();
    }

    public DtoProducto createproducto(DtoProducto DtoProducto) {
        DtoProducto.setId(nextProductoId++);
        producto.add(DtoProducto);
        return DtoProducto;
    }

    public DtoProducto getproductoById(int id) {
        for (DtoProducto DtoProducto : producto) {
            if (DtoProducto.getId() == id) {
                return DtoProducto;
            }
        }
        return null;
    }

    public List<DtoProducto> getAllproductos() {
        return producto;
    }

    public DtoProducto updateProducto(DtoProducto updatedDtoProducto) {
        for (int i = 0; i < producto.size(); i++) {
            DtoProducto existingDtoProducto = producto.get(i);
            if (existingDtoProducto.getId() == updatedDtoProducto.getId()) {
                producto.set(i, updatedDtoProducto);
                return updatedDtoProducto;
            }
        }
        return null;
    }

    public boolean deleteproductos(int id) {
        for (DtoProducto DtoProducto : producto) {
            if (DtoProducto.getId() == id) {
                producto.remove(DtoProducto);
                return true;
            }
        }
        return false;
    }
}