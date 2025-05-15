package servlet;

import dao.OradorDao;
import dao.EquipoDao;
import modelo.Orador;
import modelo.Equipo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/app/*")
public class MiServlet extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {
        // Configuración de Thymeleaf
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(this.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo(); // Ejemplo: /mejoresOradores
        WebContext context = new WebContext(request, response, getServletContext(), request.getLocale());
        OradorDao oradorDao = new OradorDao();
        EquipoDao equipoDao = new EquipoDao();

        try {
            if (path == null || path.equals("/") || path.equals("/index")) {
                templateEngine.process("index", context, response.getWriter());

            } else if (path.equals("/mejoresOradores")) {
                // Listado de mejores oradores (solo 5 primeros)
                List<Orador> oradores = oradorDao.obtenerMejoresOradoresOrdenados();
                context.setVariable("oradores", oradores);
                templateEngine.process("listadoOradores", context, response.getWriter());

            } else if (path.equals("/detalleMejorOrador")) {
                // Detalle del mejor orador (solo el primero de la lista)
                List<Orador> oradores = oradorDao.obtenerMejoresOradoresOrdenados();
                context.setVariable("oradores", oradores); // Usado en el HTML para mostrar solo el primero
                templateEngine.process("detalleOrador", context, response.getWriter());

            } else if (path.equals("/equiposClasificados")) {
                // Listados equipos clasificados por fases
                List<Equipo> equiposFase1 = equipoDao.obtenerEquiposClasificadosPorFase(1);
                List<Equipo> equiposEliminatoria = equipoDao.obtenerEquiposClasificadosPorFase(2);
                List<Equipo> equiposSemifinal = equipoDao.obtenerEquiposClasificadosPorFase(3);
                List<Equipo> equipoGanador = equipoDao.obtenerEquiposClasificadosPorFase(4);

                context.setVariable("equiposFase1", equiposFase1);
                context.setVariable("equiposEliminatoria", equiposEliminatoria);
                context.setVariable("equiposSemifinal", equiposSemifinal);
                context.setVariable("equipoGanador", equipoGanador);

                templateEngine.process("listadoEquiposClasificados", context, response.getWriter());

            } else if (path.equals("/equiposParticipantes")) {
                // Listado equipos participantes por fases
                List<Equipo> equiposFase1 = equipoDao.obtenerEquiposParticipantesPorFase(1);
                List<Equipo> equiposEliminatoria = equipoDao.obtenerEquiposParticipantesPorFase(2);
                List<Equipo> equiposSemifinal = equipoDao.obtenerEquiposParticipantesPorFase(3);
                List<Equipo> equiposFinal = equipoDao.obtenerEquiposParticipantesPorFase(4);

                context.setVariable("equiposFase1", equiposFase1);
                context.setVariable("equiposEliminatoria", equiposEliminatoria);
                context.setVariable("equiposSemifinal", equiposSemifinal);
                context.setVariable("equiposFinal", equiposFinal);

                templateEngine.process("listadoEquiposParticipantes", context, response.getWriter());

            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ruta no encontrada: " + path);
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la base de datos o en los parámetros");
        }
    }
}
