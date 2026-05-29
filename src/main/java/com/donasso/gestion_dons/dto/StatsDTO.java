
package com.donasso.gestion_dons.dto;

public class StatsDTO {
    private long nombreDons;
    private long nombreAssociations;
    private long nombreUsers;
    private double totalMontants;

    public long getNombreDons() { return nombreDons; }
    public void setNombreDons(long nombreDons) { this.nombreDons = nombreDons; }

    public long getNombreAssociations() { return nombreAssociations; }
    public void setNombreAssociations(long n) { this.nombreAssociations = n; }

    public long getNombreUsers() { return nombreUsers; }
    public void setNombreUsers(long nombreUsers) { this.nombreUsers = nombreUsers; }

    public double getTotalMontants() { return totalMontants; }
    public void setTotalMontants(double t) { this.totalMontants = t; }
}