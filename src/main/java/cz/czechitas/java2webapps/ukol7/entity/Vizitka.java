package cz.czechitas.java2webapps.ukol7.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 100)
    @NotBlank
    private String celeJmeno;

    @Length(max = 100)
    @NotBlank
    private String firma;

    @Length(max = 100)
    @NotBlank
    private String ulice;

    @Length(max = 100)
    @NotBlank
    private String obec;

    @Length(max = 5)
    @NotBlank
    private String psc;

    @Length(max = 100)
    @NotBlank
    @Email
    private String email;

    @Length(max = 20)
    @NotBlank
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    @NotBlank
    private String web;


    public Vizitka(Integer id, @Length(max = 100) @NotBlank String celeJmeno, @Length(max = 100) @NotBlank String firma, @Length(max = 100) @NotBlank String ulice, @Length(max = 100) @NotBlank String obec, @Length(max = 5) @NotBlank String psc, @Length(max = 100) @NotBlank @Email String email, @Length(max = 20) @NotBlank @Pattern(regexp = "\\+?\\d+") String telefon, @Length(max = 100) @NotBlank String web) {
        this.id = id;
        this.celeJmeno = celeJmeno;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public Vizitka() {
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPSC() {
        return psc;
    }

    public void setPSC(String PSC) {
        this.psc = PSC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa() {
        return ulice + obec + psc;
    }

}
