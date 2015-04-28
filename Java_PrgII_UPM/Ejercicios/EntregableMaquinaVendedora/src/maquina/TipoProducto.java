package maquina;

/**
 * Tipos de producto reconocidos, con sus precios
 * 
 * @author Manuel Collado
 * @version Octubre 2013
 *
 * @opt nodefillcolor "lightblue"
 */
public enum TipoProducto {
    BIZCOCHO(1), BOMBONES(5), SANDWICH(2), BASURA(-1);
    
    private final int precio; // Precio unitario
    
    // Constructor
    private TipoProducto(int precio) {
        this.precio = precio;
    }
    
    // Getter
    public int getPrecio() {
        return precio;
    }
}
