package com.example.demo.Controller;

import java.time.LocalDateTime;

import com.example.demo.Entity.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
public class DocumentDTO {
	private Long id;
    private String filename;
    private String status;
    private Long userId; // Only return user ID
    private LocalDateTime uploadDate;

    public DocumentDTO(Document document) {
        this.id = document.getId();
        this.filename = document.getFilename();
        this.status = document.getStatus();
        this.userId = document.getUser() != null ? document.getUser().getId() : null;
        this.uploadDate = document.getUploadDate();
    }
}
