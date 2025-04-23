package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.dto.BoardDTO;
import com.boot.dto.CommentDTO;
import com.boot.service.BoardService;
import com.boot.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");
		
		ArrayList<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/write")
//	public String write(@RequestParam HashMap<String, String> param) {
	public String write(BoardDTO boardDTO) {
		log.info("@# write()");
		if(boardDTO.getAttachList() != null) {
			boardDTO.getAttachList().forEach(attach -> log.info("@# attach => " + attach));
		}
		service.write(boardDTO);
		log.info("@# getAttachList => " + boardDTO.getAttachList());
		if(boardDTO.getAttachList() == null || boardDTO.getAttachList().size() == 0) {
			log.info("@# 첨부파일 없음");
			return "redirect:list";
		}

		boardDTO.getAttachList().forEach(attach -> {
			attach.setBoardNo(boardDTO.getBoardNo());
		});
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view()");
		
		BoardDTO dto = service.contentView(param);
		model.addAttribute("content_view", dto);
		
		// 해당 게시글에 작성된 댓글 리스트를 가져옴
		ArrayList<CommentDTO> commentList = commentService.findAll(param);
		model.addAttribute("commentList", commentList);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param) {
		log.info("@# modify()");
		
		service.modify(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param) {
		log.info("@# delete()");
		
		service.delete(param);
		
		return "redirect:list";
	}
}







