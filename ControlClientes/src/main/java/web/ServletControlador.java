package web;

import datos.ClienteDAOJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Angel Franco
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  recuperar el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDAOJDBC().buscar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDAOJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //  request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  recuperar los valores del formulario editarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");

        if (saldoString != null && !"".equals(saldoString)) saldo = Double.parseDouble(saldoString);
        

        //  creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //  modificamos el registro en la bd
        new ClienteDAOJDBC().actualizar(cliente);

        //  redirigimos al inicio
        this.accionDefault(request, response);
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  recuperar los valores del formulario para agregar el cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");

        if (saldoString != null && !"".equals(saldoString)) saldo = Double.parseDouble(saldoString);
        

        //  creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        //  insertamos en la bd el nuevo objeto
        new ClienteDAOJDBC().insertar(cliente);

        //  redirigimos al inicio
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  recuperar los valores del formulario editarCliente (idCliente)
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //  creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);

        //  eliminamos el registro en la bd
        new ClienteDAOJDBC().eliminar(cliente);

        //  redirigimos al inicio
        this.accionDefault(request, response);
    }
}
