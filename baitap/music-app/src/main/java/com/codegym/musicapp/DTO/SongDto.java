package com.codegym.musicapp.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {
    private Long id;
    @NotEmpty(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Tên bài hát không được chứa ký tự đặc biệt như @ ; , . = - + , …. ")
    private String name;

    @NotEmpty(message = "Nghệ sĩ thể hiện không được để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Nghệ sĩ thể hiện không được chứa ký tự đặc biệt như @ ; , . = - + , …. ")
    private String artist;

    @NotEmpty(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;:,.=+\\-!\\\"#$%&'()*+/;<=>?@[\\\\]^_`{|}~]*$", message = "Thể loại nhạc chỉ được chứa dấu phẩy và không chứa các ký tự đặc biệt khác")
    private String category;
}
