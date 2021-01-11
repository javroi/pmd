package com.example.leadactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//Repositorio para organizar los usuarios de la lista
public class LeadsRepository {
    private static LeadsRepository repository = new LeadsRepository();
    private HashMap<String, Lead> leads = new HashMap<>();

    public static LeadsRepository getInstance() {
        return repository;
    }

    private LeadsRepository() {
        saveLead(new Lead("Alexander Pierrot", "CEO", "Insures S.O.", R.drawable.usuario));
        saveLead(new Lead("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.usuario));
        saveLead(new Lead("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd", R.drawable.usuario));
        saveLead(new Lead("Liliana Clarence", "Diseñadora de Producto", "Creativa App", R.drawable.usuario));
        saveLead(new Lead("Benito Peralta", "Supervisor de Ventas", "Neumáticos Press", R.drawable.usuario));
        saveLead(new Lead("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.usuario));
        saveLead(new Lead("Christian Steps", "CTO", "Cooperativa Verde", R.drawable.usuario));
        saveLead(new Lead("Alexa Giraldo", "Lead Programmer", "Frutisofy", R.drawable.usuario));
        saveLead(new Lead("Linda Murillo", "Directora de Marketing", "Seguros Boliver", R.drawable.usuario));
        saveLead(new Lead("Lizeth Astrada", "CEO", "Concesionario Motolox", R.drawable.usuario));
    }

    private void saveLead(Lead lead) {
        leads.put(lead.getId(), lead);
    }

    public List<Lead> getLeads() {
        return new ArrayList<>(leads.values());
    }
}
