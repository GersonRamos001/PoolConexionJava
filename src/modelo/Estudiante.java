/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

class Estudiante {

    private String id;
    private String apellido;
    private String email;
    private String nombre;

    public Estudiante(String id, String apellido, String email, String nombre) {
        this.id = id;
        this.apellido = apellido;
        this.email = email;
        this.nombre = nombre;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", apellido=" + apellido + ", email=" + email + ", nombre=" + nombre + '}';
    }
   
    
    

}
