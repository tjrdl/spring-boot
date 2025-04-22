package com.boot.boot_reply_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	private int commentNo;
	private String commentWriter;
	private String commentContent;
	private int boardNo;
	private Timestamp commentCreatedTime;
}
