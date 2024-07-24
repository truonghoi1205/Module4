package com.codegym.musicapp.controller;

import com.codegym.musicapp.model.DTO.SongDto;
import com.codegym.musicapp.model.Song;
import com.codegym.musicapp.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showAll(Model model) {
        Iterable<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("songDto", songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("noti", "Thêm mới thành công!!");
        return "redirect:/songs";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        songService.deleteById(id);
        redirect.addFlashAttribute("noti", "Xóa thành công!!");
        return "redirect:/songs";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,
                                 @PathVariable Long id) {
        Song song = songService.findById(id);
        if (song.equals(null)) {
            return "redirect:/songs";
        }
        model.addAttribute("song", song);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDto songDto,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {
        model.addAttribute("isSubmitted", true);
        if (result.hasFieldErrors()) {
            model.addAttribute("song", songDto);
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("noti", "Sửa thành công!!");
        return "redirect:/songs";
    }
}
