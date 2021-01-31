package Controlador;


import Modelo.*;
import java.sql.*;
import java.util.ArrayList;

public class GestorBD {
    
    private Connection con;
    
    private void abrirConexion()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ExamenFinal2", "sa", "123456");
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    private void cerrarConexion()
    {
        try
        {
            if(con != null && !con.isClosed())
                con.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    public boolean agregarOrden(Ordenes ordenes)
    {   boolean inserto = false;
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Ordenes (idProducto, cantidad, costoTotal, idResponsable)\n" +
                                                        "VALUES (?, ?, ?, ?)");
            ps.setInt(1, ordenes.getProducto().getId());
            ps.setInt(2, ordenes.getCantidad());
            ps.setDouble(3, ordenes.getCostoTotal());
            ps.setInt(4, ordenes.getResponsable().getId());
            ps.execute();
            
            inserto=true;
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return inserto;
    }
        
    public ArrayList<Productos> obtenerProductos()
    {
        ArrayList<Productos> lista = new ArrayList<Productos>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Productos");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                double precioVenta = rs.getDouble("precioVenta");
                
                Productos prod = new Productos(id, descripcion, precioVenta);
                lista.add(prod);
            }
            rs.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return lista;
    }
    
    
    public ArrayList<Responsables> obtenerResponsables()
    {
        ArrayList<Responsables> lista = new ArrayList<Responsables>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Responsables");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                
                Responsables resp = new Responsables(id, apellido, nombre);
                lista.add(resp);
            }
            rs.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return lista;
    }
    
    public ArrayList<Reporte1> listadoReporte1(){
        ArrayList<Reporte1> listado = new ArrayList<>();
        try
        {
            abrirConexion();
           
            PreparedStatement st = con.prepareStatement("select p.descripcion, p.precioVenta, (o.costoTotal/cantidad) 'promedio costo unitario' \n" +
                                                                "from Productos p\n" +
                                                                "	join Ordenes o on o.idProducto = p.id\n" +
                                                                "	group by p.descripcion, p.precioVenta, o.costoTotal, cantidad");
       
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String descripcion = rs.getString(1);
                double precioVenta = rs.getDouble(2);
                double promedio = rs.getDouble(3);
  
                Reporte1 r = new Reporte1 (descripcion, precioVenta, promedio);         
                
                listado.add(r);
            }
            rs.close();
        } 
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return listado;
    }   

    public Responsables obtenerTipoResponsables(int id) {

        Responsables resultado = null;
        
        try {
            abrirConexion();
            String sql = "select * from Responsables where id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                resultado = new Responsables(id, apellido, nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return resultado;        
    }
    
    public Productos obtenerTipoProductos(int id){
        Productos resultado = null;
        try {
            abrirConexion();
            String sql = "select * from Productos where id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                double precioVenta = rs.getDouble("precioVenta");
                resultado = new Productos(id, descripcion, precioVenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public ArrayList<Ordenes> obtenerOrdenes(){
        ArrayList<Ordenes> lista = new ArrayList<>();
        try{
            abrirConexion();
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Ordenes");
            
            while (rs.next()){
                int id = rs.getInt("id");
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("cantidad");
                double costoTotal = rs.getDouble("costoTotal");
                int idResponsable = rs.getInt("idResponsable");
                
                Productos p = obtenerTipoProductos(idProducto);
                Responsables r = obtenerTipoResponsables(idResponsable);
                
                lista.add(new Ordenes(id, p, cantidad, costoTotal, r));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
}

