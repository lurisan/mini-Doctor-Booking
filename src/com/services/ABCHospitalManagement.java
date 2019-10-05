package com.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.exception.AppointmentNotFoundException;
import com.exception.DoctorAlreadyMappedException;

public class ABCHospitalManagement implements HospitalManagement {

	ArrayList<Appointment> appointments=new ArrayList<Appointment>();
	ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	
	@Override
	public int bookAnAppointment(Doctor doctor, Patient patient) {
		Appointment appointment=new Appointment(doctor.getId(),patient.getId());
		appointments.add(appointment);
		for(Doctor doc:doctors)
			if(doc.getId()==doctor.getId())
				return appointment.getAppointmentId();
		doctors.add(doctor);
		return appointment.getAppointmentId();
	}

	@Override
	public boolean cancelAppointment(int appointmentId) throws AppointmentNotFoundException {
		for(Appointment a:appointments)
			if(a.getAppointmentId()==appointmentId)
				return appointments.remove(a);
		throw new AppointmentNotFoundException("Sorry! Appointment is not there in the system");
	}

	@Override
	public Appointment updateAppointment(int appointmentId, int doctorId) throws DoctorAlreadyMappedException, AppointmentNotFoundException {
		for(Appointment a:appointments)
			if(a.getAppointmentId()==appointmentId)
				if(a.getDoctorId()!=doctorId)
				{
					a.setDoctorId(doctorId);
					return a;
				}
				else
					throw new DoctorAlreadyMappedException("Sorry! That doctor is alread mapped to this appointment");
		throw new AppointmentNotFoundException("Sorry! Appointment is not there in the system");
	}
	

	@Override
	public TreeMap<Integer, Integer> appointmentCountByDoctor() {
		
		TreeMap<Integer,Integer> appointmentCountByDoctor=new TreeMap<Integer,Integer>();
		for(Appointment a:appointments)
			appointmentCountByDoctor.put(a.getDoctorId(), 
					(appointmentCountByDoctor.get(a.getDoctorId())!=null)?(appointmentCountByDoctor.get(a.getDoctorId())+1):1);
		return appointmentCountByDoctor;
	}
	
	
	public HashSet<Doctor> GetUniqueSpecializationDetails(){
		HashSet<Doctor> setOfDoctors=new HashSet<Doctor>();
		HashSet<String> setOfDegree=new HashSet<String>();
		HashSet<String> setOfNonUniqueDegree=new HashSet<String>();
		
		for(Doctor d:doctors)
			if(!setOfDegree.add(d.getSpecialization()))
				setOfNonUniqueDegree.add(d.getSpecialization());
		
		for(Doctor d:doctors)
			if(!setOfNonUniqueDegree.contains(d.getSpecialization()))
				setOfDoctors.add(d);
		
		return setOfDoctors;
	}
}
