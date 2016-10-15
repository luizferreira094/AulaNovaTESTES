package br.sceweb.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class Convenio {
	
	private String cnpj;
	private DateTime dataInicio;
	private DateTime dataTermino;
	Logger logger = Logger.getLogger(Convenio.class);
	public Convenio(String cnpj, String dataInicio, String dataTermino){
	setCNPJ(cnpj);
	setDataInicio(dataInicio);
	setDataTermino(dataTermino);
	}
	private void setDataTermino(String dataTermino2) {
		// TODO Auto-generated method stub
		
	}
	public void setDataInicio(String dataInicio) throws IllegalArgumentException {
		logger.info("data inicio = " + dataInicio);
		if (validaData(dataInicio)){
		this.dataInicio = new DateTime(Integer.parseInt(dataInicio.substring(6, 10)),
		Integer.parseInt(dataInicio.substring(3, 5)),
		Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
		}
		else{
		throw new IllegalArgumentException("data invalida");
		}
		}
	public void setCNPJ(String cnpj) {
		if (cnpj.length()==14){
		this.cnpj = cnpj;
		}
		else
		throw new IllegalArgumentException("CNPJ inválido!");
		}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public DateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(DateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public DateTime getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(DateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public boolean validaData(String data){
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false); //
		try {
		df.parse (data); // data válida
		return true;
		} catch (ParseException ex) {
		logger.error("Erro na validacao de data - " + ex.getMessage());
		return false;
		}
		}
	

}
