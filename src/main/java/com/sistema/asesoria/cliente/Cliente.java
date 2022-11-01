package com.sistema.asesoria.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "correo_Cliente"))
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Cliente;

    @Column(length = 50)
    private String nom_Cliente;

    @Column(length = 50)
    private String ape_Cliente;

    @Column(length = 50)
    private String direccion;

    @Column(length = 50)
    private String detalle_Direccion;

    @Column(length = 50, unique = true)
    private String correo_Cliente;

    @Column(length = 50)
    private String num_Cliente;

    private String tipoDocumentoCliente;

    private String numeroDocumento;

    private Boolean estado=false;

    public Cliente(String correo_Cliente) {
        this.correo_Cliente = correo_Cliente;
    }

    public Cliente(String nom_Cliente, String ape_Cliente, String direccion, String detalle_Direccion,
            String correo_Cliente, String num_Cliente) {
        this.nom_Cliente = nom_Cliente;
        this.ape_Cliente = ape_Cliente;
        this.direccion = direccion;
        this.detalle_Direccion = detalle_Direccion;
        this.correo_Cliente = correo_Cliente;
        this.num_Cliente = num_Cliente;
    }

    public Cliente() {
    }

    public Cliente(int id_Cliente, String nom_Cliente, String ape_Cliente, String direccion, String detalle_Direccion,
            String correo_Cliente, String num_Cliente) {
        this.id_Cliente = id_Cliente;
        this.nom_Cliente = nom_Cliente;
        this.ape_Cliente = ape_Cliente;
        this.direccion = direccion;
        this.detalle_Direccion = detalle_Direccion;
        this.correo_Cliente = correo_Cliente;
        this.num_Cliente = num_Cliente;
    }

    public Cliente(int id_Cliente, String nom_Cliente, String ape_Cliente, String direccion, String detalle_Direccion,
            String correo_Cliente, String num_Cliente, String tipoDocumentoCliente, String numeroDocumento) {
        this.id_Cliente = id_Cliente;
        this.nom_Cliente = nom_Cliente;
        this.ape_Cliente = ape_Cliente;
        this.direccion = direccion;
        this.detalle_Direccion = detalle_Direccion;
        this.correo_Cliente = correo_Cliente;
        this.num_Cliente = num_Cliente;
        this.tipoDocumentoCliente = tipoDocumentoCliente;
        this.numeroDocumento = numeroDocumento;
    }

    public Cliente(int id_Cliente, String nom_Cliente, String ape_Cliente, String direccion, String detalle_Direccion,
            String correo_Cliente, String num_Cliente, String tipoDocumentoCliente, String numeroDocumento,
            Boolean estado) {
        this.id_Cliente = id_Cliente;
        this.nom_Cliente = nom_Cliente;
        this.ape_Cliente = ape_Cliente;
        this.direccion = direccion;
        this.detalle_Direccion = detalle_Direccion;
        this.correo_Cliente = correo_Cliente;
        this.num_Cliente = num_Cliente;
        this.tipoDocumentoCliente = tipoDocumentoCliente;
        this.numeroDocumento = numeroDocumento;
        this.estado = estado;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNom_Cliente() {
        return nom_Cliente;
    }

    public void setNom_Cliente(String nom_Cliente) {
        this.nom_Cliente = nom_Cliente;
    }

    public String getApe_Cliente() {
        return ape_Cliente;
    }

    public void setApe_Cliente(String ape_Cliente) {
        this.ape_Cliente = ape_Cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDetalle_Direccion() {
        return detalle_Direccion;
    }

    public void setDetalle_Direccion(String detalle_Direccion) {
        this.detalle_Direccion = detalle_Direccion;
    }

    public String getCorreo_Cliente() {
        return correo_Cliente;
    }

    public void setCorreo_Cliente(String correo_Cliente) {
        this.correo_Cliente = correo_Cliente;
    }

    public String getNum_Cliente() {
        return num_Cliente;
    }

    public void setNum_Cliente(String num_Cliente) {
        this.num_Cliente = num_Cliente;
    }

    public String getTipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
        this.tipoDocumentoCliente = tipoDocumentoCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
