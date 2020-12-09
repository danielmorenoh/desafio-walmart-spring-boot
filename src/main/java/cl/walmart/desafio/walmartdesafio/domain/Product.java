package cl.walmart.desafio.walmartdesafio.domain;

import java.io.Serializable;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "products")
@JsonPropertyOrder({"id", "brand", "description", "image", "price", "descuento"})

public class Product implements Serializable{

    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @MongoId
    private ObjectId _id;
    
    private int id;

	private String brand;
     
    private String description;
       
    private String image;
       
    private int price;//*/
    
    private int descuento;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}


