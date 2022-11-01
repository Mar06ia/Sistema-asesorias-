package com.sistema.asesoria.cliente;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.lang.reflect.UndeclaredThrowableException;
import com.sistema.asesoria.asesoria.Asesoria;

@Controller
public class ClienteController {

  @Autowired // traemos los repositorios
  private ClienteRepository agro;
  // public String es porque me retorna a un archivo html

  // Lista
  @GetMapping("/clientes") // redireccionar
  public String listarClientes(Model m) {
    List<Cliente> listaClientes = agro.findAll();// mostrar todo lista
    m.addAttribute("listaClientes", listaClientes);
    return "cliente/clientes";// retornar
  }

  // Agregar Cliente
  @GetMapping("/clientes/nuevo")
  public String mostrarFormularioDeNuevoCliente(Model m) {
    m.addAttribute("clientes", new Cliente());
    return "cliente/cliente_formulario";
  }

  // Duplicidad Alerta
  @PostMapping("/clientes/guardar")
  public String guardarCliente(@Valid Cliente cliente, BindingResult res, Model m) {
      Cliente clienteEncontrado = agro.findCorreo(cliente.getCorreo_Cliente());
      if (res.hasErrors()) {
        return "cliente/cliente_formulario";
      }
      if(clienteEncontrado != null){
        if (clienteEncontrado.getCorreo_Cliente().equals(cliente.getCorreo_Cliente())) {
          // System.out.println("\n Duplicado \n"+"--------------------------------------------");
          // m.addAttribute("duplicado", true);
          return "redirect:/clientes/nuevo?duplicado";
        }
      }else{
        agro.save(cliente);
      } 
    return "redirect:/clientes";
  }

  // guardar Cliente
  // @PostMapping("/clientes/guardar")
  // public String guardarCliente(@Valid Cliente cliente) {
  //   System.out.println("\n"+cliente.getCorreo_Cliente()+"\n"+"--------------------------------------------");

  //   agro.save(cliente);
  //   return "redirect:/clientes";
  // }

  // editar Cliente
  @GetMapping("/clientes/editar/{id_Cliente}")
  public String mostrarFormularioModificarCliente(@PathVariable("id_Cliente") Integer id_Cliente, Model modelo) {
    Cliente cliente = agro.findById(id_Cliente).get();
    modelo.addAttribute("clientes", cliente);
    return "cliente/cliente_formulario";
  }

  // Eliminar usuario
  @GetMapping("/clientes/eliminar/{id_Cliente}")
  public String eliminarCliente(@PathVariable("id_Cliente") Integer id_Cliente, Model modelo) {
    agro.deleteById(id_Cliente);
    return "redirect:/clientes";
  }

  // Cambiar estado
  @GetMapping("/clientes/estado/{id_Cliente}")
  public String estadocliente(@PathVariable("id_Cliente") Integer id_Cliente, Model modelo) {
    Optional<Cliente> cliente = agro.findById(id_Cliente);
    if (cliente.get().getEstado() == false) {
      cliente.get().setEstado(true);
    } else {
      cliente.get().setEstado(false);
    }
    agro.save(cliente.get());
    return "redirect:/clientes";
  }
  // [
  // @GetMapping(value="path")
  // public SomeData getMethodName(@RequestParam String param) {
  // return new SomeData();
  // }
  // ]
}
