package com.lquiroz.warehouse;

public class Usuario {
    int Id, Dni, Celular, CodPostal;
    String Nombre;
    String Apellidos;
    String Correo;
    String Usuario;
    String Contraseña;
    String Direccion;

    public Usuario() {
    }

    public Usuario(int dni, int celular, int codPostal, String nombre, String apellidos, String correo, String usuario, String contraseña, String direccion) {
        Dni = dni;
        Celular = celular;
        CodPostal = codPostal;
        Nombre = nombre;
        Apellidos = apellidos;
        Correo = correo;
        Usuario = usuario;
        Contraseña = contraseña;
        Direccion = direccion;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Apellidos.equals("")&&Correo.equals("")&&Usuario.equals("")&&Contraseña.equals("")){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Dni=" + Dni +
                ", Celular=" + Celular +
                ", CodPostal=" + CodPostal +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Contraseña='" + Contraseña + '\'' +  
                ", Direccion='" + Direccion + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        Dni = dni;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int celular) {
        Celular = celular;
    }

    public int getCodPostal() {
        return CodPostal;
    }

    public void setCodPostal(int codPostal) {
        CodPostal = codPostal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
    public String getUsuario(){
        return Usuario;
    }
    public void setUsuario(String usuario){
         Usuario = usuario;
    }
    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
