package com.bean;

public class Appointment {
	private static int uniqueId=0;
	private int appointmentId;
	private int doctorId;
	private int patientId;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Appointment(int doctorId, int patientId) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.appointmentId=++uniqueId;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctorId="
				+ doctorId + ", patientId=" + patientId + "]";
	}
}
