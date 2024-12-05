package com.shinhan.myapp.board;

import com.shinhan.myapp.model.util.UploadFileUtils;
import com.shinhan.myapp.vo.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list.do")
    public String selectAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @GetMapping("/insert.do")
    public String insertGet() {
        return "board/boardInsert";
    }

    @PostMapping("/insert.do")
    public String insertPost(MultipartHttpServletRequest multipart, HttpSession session) {
        MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
        if (member == null) {
            member = MemberDTO.builder()
                    .member_id("guest")
                    .build();
        }
        HttpServletRequest request = (HttpServletRequest) multipart;
        String uploadPath = session.getServletContext().getRealPath("/resources/upload");
        // Ensure directory exists
        new File(uploadPath).mkdirs();

        MultipartFile multipartFile = multipart.getFile("pic");
        String fileName = multipartFile.getOriginalFilename();

        String uuid = "";
        String ymdPath = UploadFileUtils.calcPath(uploadPath);

        try {
            multipartFile.getBytes();
            uuid = UploadFileUtils.fileUpload(uploadPath, fileName, multipartFile.getBytes(), ymdPath);
        } catch (Exception e) {
            return "redirect:insert.do";
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        BoardDTO boardDTO = BoardDTO.builder()
                .title(title)
                .content(content)
                .build();
        boardDTO.setWriter(member.getMember_id());

        boardDTO.setPic(ymdPath + File.separator + uuid);
        log.info(boardDTO.toString());

        boardService.insert(boardDTO);
        return "redirect:list.do";
    }

    @GetMapping("/detail.do")
    public String detailGet(long bno, Model model) {
        BoardDTO boardDTO = boardService.findOne(bno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/boardDetail";
    }

    @PostMapping("/update.do")
    public String updatePost(BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "redirect:list.do";
    }

    @GetMapping("/delete.do")
    public String delete(long bno) {
        boardService.delete(bno);
        return "redirect:list.do";
    }
}
