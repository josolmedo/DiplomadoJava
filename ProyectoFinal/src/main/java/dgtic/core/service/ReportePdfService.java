package dgtic.core.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.model.entity.Usuarios;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportePdfService {

    public byte[] generarReporteCalificaciones(List<Inscripciones> inscripciones, Usuarios usuario) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Reporte de Calificaciones - EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Datos del alumno
            documento.add(new Paragraph("Alumno: " + usuario.getNombre() + " " + usuario.getApellido()));
            documento.add(new Paragraph("Correo: " + usuario.getEmail()));
            documento.add(new Paragraph(" ")); // Espacio

            // Tabla de calificaciones
            PdfPTable tabla = new PdfPTable(3); // 3 columnas
            tabla.setWidthPercentage(100);

            // Encabezados
            String[] encabezados = {"Asignatura", "Grupo", "Calificación"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(200, 200, 200));
                tabla.addCell(celda);
            }

            // Llenar datos
            for (Inscripciones ins : inscripciones) {
                tabla.addCell(ins.getGrupo().getAsignatura().getNombre());
                tabla.addCell(ins.getGrupo().getNombre());
                tabla.addCell(ins.getCalificacion() != null ? ins.getCalificacion().toString() : "Sin calificar");
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    public byte[] generarReporteAsistencias(List<Asistencias> asistencias, Usuarios usuario) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph titulo = new Paragraph("Historial de Asistencias - EscuRed", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Datos del alumno
            documento.add(new Paragraph("Alumno: " + usuario.getNombre() + " " + usuario.getApellido()));
            documento.add(new Paragraph("Correo: " + usuario.getEmail()));
            documento.add(new Paragraph(" ")); // Espacio en blanco

            // Tabla de Asistencias (3 columnas)
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);

            // Encabezados
            String[] encabezados = {"Fecha", "Asignatura", "Grupo"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Phrase(encabezado, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                celda.setBackgroundColor(new java.awt.Color(173, 216, 230)); // Color azul clarito
                tabla.addCell(celda);
            }

            // Llenar datos (si no tiene asistencias, no entra al for)
            for (Asistencias asis : asistencias) {
                tabla.addCell(asis.getFecha().toString());
                tabla.addCell(asis.getGrupo().getAsignatura().getNombre());
                tabla.addCell(asis.getGrupo().getNombre());
            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

}