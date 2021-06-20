package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="gallary")
public class Gallary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id ;
	
	
	
	@Lob
	@Column(name="photo")
	 private byte[]  photo;
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name="description")
	String description;
	
	@Column(name="name")
	String name;
	
	@Column(name="light")
	String light;
	
	@Column(name="watered")
	String watered;
	
	@Column(name="weater")
	String weather;
	
	@Column(name="indoor_Or_Outdoor")
	String indoorOrOutdoor;
	
	@Column(name="toxic")
	String toxic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getWatered() {
		return watered;
	}

	public void setWatered(String watered) {
		this.watered = watered;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getIndoorOrOutdoor() {
		return indoorOrOutdoor;
	}

	public void setIndoorOrOutdoor(String indoorOrOutdoor) {
		this.indoorOrOutdoor = indoorOrOutdoor;
	}

	public String getToxic() {
		return toxic;
	}

	public void setToxic(String toxic) {
		this.toxic = toxic;
	}



	public Gallary(byte[] photo, String description, String name, String light, String watered, String weather,
			String indoorOrOutdoor, String toxic) {
		this.photo = photo;
		this.description = description;
		this.name = name;
		this.light = light;
		this.watered = watered;
		this.weather = weather;
		this.indoorOrOutdoor = indoorOrOutdoor;
		this.toxic = toxic;
	}

	public Gallary() {
		super();
	}

	@Override
	public String toString() {
		return "Gallary [id=" + id + ", photo=" + photo + ", description=" + description + ", name=" + name + ", light="
				+ light + ", watered=" + watered + ", weather=" + weather + ", indoorOrOutdoor=" + indoorOrOutdoor
				+ ", toxic=" + toxic + "]";
	}
	
	
}
