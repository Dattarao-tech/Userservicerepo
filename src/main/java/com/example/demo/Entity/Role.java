package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="roles")
public class Role {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private boolean enabled = true;
		@Override
		public String toString() {
			 return "Role{" +
			            "id=" + id +
			            ", name='" + name + '\'' +

			            '}';
		}
}
