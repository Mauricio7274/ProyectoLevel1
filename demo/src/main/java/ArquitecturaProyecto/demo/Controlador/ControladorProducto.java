package ArquitecturaProyecto.demo.Controlador;

import ArquitecturaProyecto.demo.Controlador.Dto.DtoProducto;
import ArquitecturaProyecto.demo.Logica.GestorDeInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    private final GestorDeInventario GestorDeInventario;

    @Autowired
    public ControladorProducto (GestorDeInventario GestorDeInventario) {
        this.GestorDeInventario = GestorDeInventario;
    }

    @GetMapping
    public ResponseEntity<List<DtoProducto>> getAllProductos() {
        List<DtoProducto> productos = GestorDeInventario.getAllproductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoProducto> getProductosById(@PathVariable int id) {
        DtoProducto productos = GestorDeInventario.getproductoById(id);
        if (productos != null) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DtoProducto> createproducto(@RequestBody DtoProducto DtoProducto) {
        DtoProducto createdproducto = GestorDeInventario.createproducto(DtoProducto);
        return new ResponseEntity<>(createdproducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoProducto> updateproducto(@PathVariable int id, @RequestBody DtoProducto updatedDtoProducto) {
        updatedDtoProducto.setId(id);
        DtoProducto updatedproducto = GestorDeInventario.updateProducto(updatedDtoProducto);
        if (updatedproducto != null) {
            return new ResponseEntity<>(updatedproducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteproducto(@PathVariable int id) {
        boolean deleted = GestorDeInventario.deleteproductos(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
