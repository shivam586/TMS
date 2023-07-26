package com.example.TaskManager.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
public class Task {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column
	    private String title;

	    @Column
	    private String description;
	
	    @Column
	    private String status;
	    
	    private Date dueDate; 

	    @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Date getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Date getUpdatedAt() {
	        return updatedAt;
	    }

	    public void setUpdatedAt(Date updatedAt) {
	        this.updatedAt = updatedAt;
	    }

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		

		public Date getDueDate() {
			return dueDate;
		}
		

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}
}
