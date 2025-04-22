package com.boot.boot_reply_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private int boardNo;
	private String boardName;
	private String boardTitle;
	private String boardContent;
	private Timestamp boardDate;
	private int boardHit;
}
