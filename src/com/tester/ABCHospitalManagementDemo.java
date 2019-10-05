package com.tester;

import java.util.HashSet;
import java.util.TreeMap;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.exception.AppointmentNotFoundException;
import com.exception.DoctorAlreadyMappedException;
import com.services.ABCHospitalManagement;

public class ABCHospitalManagementDemo {

	public static void main(String[] args) {
		Doctor d1=new Doctor(1,"Md Nasirul Haque","MBBS");
		Doctor d2=new Doctor(2,"Mahasheta Kundu","DCH");
		Doctor d3=new Doctor(3,"Niladri Shekhar Podder","MBBS");
		
		Patient p1=new Patient(1,"ABC","Fever");
		Patient p2=new Patient(2,"DEF","Cough");
		Patient p3=new Patient(3,"GHI","Cold");
		
		ABCHospitalManagement abcHospital=new ABCHospitalManagement();
		
		int appointmentPatient1=abcHospital.bookAnAppointment(d1, p1);
		int appointmentPatient2=abcHospital.bookAnAppointment(d2, p2);
		int appointmentPatient3=abcHospital.bookAnAppointment(d3, p3);
		
		try {
			System.out.println(abcHospital.cancelAppointment(appointmentPatient1));
			System.out.println(abcHospital.cancelAppointment(appointmentPatient3));
			
			Appointment updateAppointment=abcHospital.updateAppointment(appointmentPatient2, d1.getId());
			System.out.println(updateAppointment.getDoctorId());
			appointmentPatient1=abcHospital.bookAnAppointment(d1, p1);
			
			TreeMap<Integer,Integer> setOfDoctor=new TreeMap<Integer,Integer>(abcHospital.appointmentCountByDoctor());
			System.out.println(setOfDoctor);
			
			HashSet<Doctor> doctorList=new HashSet<Doctor>(abcHospital.GetUniqueSpecializationDetails());
			System.out.println(doctorList.toString());
		} 
		catch (AppointmentNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DoctorAlreadyMappedException e) {
			System.out.println(e.getMessage());
		}
	}
}
