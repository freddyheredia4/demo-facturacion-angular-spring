import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[] = [];

  clienteSeleccionado: Cliente = new Cliente(0,"","");

  constructor(
    private clienteService: ClienteService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  public findAll(): void
  {
    this.clienteService.findAll()
    .subscribe(resultado => this.clientes = resultado);
  }

  seleccionar(cliente: Cliente):void
  {
    this.clienteSeleccionado = cliente;
  }

  save(cliente: Cliente):void
  {
    this.clienteService.save(cliente)
    .subscribe(resultado => {
      this.findAll();
      this.clienteSeleccionado = new Cliente(0,"","");
    });
  }

  delete(cliente: Cliente):void
  {
    this.clienteService.deleteById(cliente.clienteId)
    .subscribe();
    this.clientes = this.clientes.filter(clienteActual => clienteActual.clienteId != cliente.clienteId );
    this.clienteSeleccionado = new Cliente(0,"","");
  }


}
