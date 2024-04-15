package com.ftc.spring.api.entitys;

import java.io.Serializable;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "juegos", catalog = "games")
public class Juego implements Serializable{

    @Id
    @GeneratedValue
	@Column(name = "ID_Game", unique = true, nullable = false)
	private int id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Developer")
	private String developer;
	@Column(name = "Publisher")
	private String publisher;
	@Column(name = "Europe__PAL")
	private String europePal;
	@Column(name = "Japan")
	private String japan;
	@Column(name = "North_America")
	private String northAmerica;
	@Formula( "CONCAT(Title,Developer,Publisher,Europe__PAL,Japan,North_America)" )
	private String concatFields;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Juego{");
        sb.append("id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", developer=").append(developer);
        sb.append(", publisher=").append(publisher);
        sb.append(", europePal=").append(europePal);
        sb.append(", japan=").append(japan);
        sb.append(", northAmerica=").append(northAmerica);
        sb.append('}');
        return sb.toString();
    }

}
