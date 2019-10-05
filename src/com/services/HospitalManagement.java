package com.services;

import com.bean.Doctor;
import com.bean.Appointment;
import com.bean.Patient;
import com.exception.AppointmentNotFoundException;
import com.exception.DoctorAlreadyMappedException;

import java.util.TreeMap;

public interface HospitalManagement {
	int bookAnAppointment(Doctor doctor,Patient patient);
	boolean cancelAppointment(int appointmentId) throws AppointmentNotFoundException;
	Appointment updateAppointment(int appointmentId,int doctorId) throws DoctorAlreadyMappedException, AppointmentNotFoundException;
	TreeMap<Integer, Integer> appointmentCountByDoctor();
}
