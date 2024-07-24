package com.codegym.registrationform.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class FormDto {
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸửỷỹ\\\\s]{5,45}$",message = "Chưa đúng định dạng")
    @Size(min = 5, max = 45, message = "Độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸửỷỹ\\\\s]{5,45}$",message = "Chưa đúng định dạng")
    @Size(min = 5, max = 45, message = "Độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email chưa đúng")
    private String email;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(\\+84|0)(3|5|7|8|9)\\d{8}$", message = "SĐT chưa đúng")
    private String phone;

    @NotNull(message = "Không được để trống")
    @Min(value = 18, message = "Cấm trẻ em dưới 18 tuổi")
    private Integer age;
}
